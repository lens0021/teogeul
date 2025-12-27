package io.github.lens0021.teogeul

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.inputmethodservice.InputMethodService
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import io.github.lens0021.teogeul.config.SettingsDefaults
import io.github.lens0021.teogeul.config.SettingsRepository
import io.github.lens0021.teogeul.config.SettingsValues
import io.github.lens0021.teogeul.config.settingsDataStore
import io.github.lens0021.teogeul.input.CommitComposingTextEvent
import io.github.lens0021.teogeul.input.InputEvent
import io.github.lens0021.teogeul.input.InputEventBus
import io.github.lens0021.teogeul.input.InputKeyEvent
import io.github.lens0021.teogeul.input.InputTimeoutEvent
import io.github.lens0021.teogeul.input.KeyEventHandler
import io.github.lens0021.teogeul.input.KeyUpEvent
import io.github.lens0021.teogeul.input.LayoutConverter
import io.github.lens0021.teogeul.korean.EngineMode
import io.github.lens0021.teogeul.korean.HangulEngine
import io.github.lens0021.teogeul.korean.HangulEngine.FinishComposingEvent
import io.github.lens0021.teogeul.korean.HangulEngine.HangulEngineEvent
import io.github.lens0021.teogeul.korean.HangulEngine.HangulEngineListener
import io.github.lens0021.teogeul.korean.HangulEngine.SetComposingEvent
import io.github.lens0021.teogeul.model.KeyStroke
import io.github.lens0021.teogeul.ui.SettingsActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class IMEService() : InputMethodService(), HangulEngineListener {
    companion object {
        private var mSelf: IMEService? = null

        @JvmStatic
        fun getInstance(): IMEService? {
            return mSelf
        }
    }

    protected var mInputConnection: InputConnection? = null
    protected var mDirectInputMode: Boolean = true

    private var mConsumeDownEvent: Boolean = false

    var mQwertyEngine: HangulEngine = HangulEngine()

    lateinit var mCurrentEngineMode: EngineMode
    var mCurrentLanguage: Int = EngineMode.LANG_KO

    var mEnableTimeout: Boolean = false

    var mMoachigi: Boolean = false
    var mHardwareMoachigi: Boolean = false
    var mFullMoachigi: Boolean = true
    var mMoachigiDelay: Int = 0

    var mStandardJamo: Boolean = false

    var mAlphabetLayout: String = "keyboard_alphabet_qwerty"

    var mInput: Boolean = false

    var mTimeOutHandler: Handler? = null

    var mHardLangKey: KeyStroke? = null

    private val layoutConverter = LayoutConverter()
    private val keyEventHandler by lazy {
        KeyEventHandler(
            layoutConverter = layoutConverter,
            inputConnectionProvider = { mInputConnection },
            hangulEngineProvider = { mQwertyEngine },
            directInputModeProvider = { mDirectInputMode },
            alphabetLayoutProvider = { mAlphabetLayout },
            hardLangKeyProvider = { mHardLangKey },
            currentLanguageProvider = { mCurrentLanguage },
            toggleLanguage = { toggleLanguage() },
            resetCharComposition = { resetCharComposition() },
            currentInputEditorInfoProvider = { currentInputEditorInfo },
            sendDefaultEditorAction = { sendDefaultEditorAction(it) },
            markInput = { mInput = true },
        )
    }

    private val eventScope = CoroutineScope(SupervisorJob() + Dispatchers.Unconfined)
    private var eventJob: Job? = null
    private val settingsRepository by lazy { SettingsRepository(applicationContext.settingsDataStore) }

    init {
        mSelf = this

        mQwertyEngine.listener = this
    }

    constructor(context: Context) : this() {
        attachBaseContext(context)
    }

    override fun onCreate() {
        super.onCreate()
        eventJob =
            eventScope.launch {
                InputEventBus.events.collect { event ->
                    when (event) {
                        is InputKeyEvent -> handleInputKey(event)
                        is KeyUpEvent -> handleKeyUp(event)
                        is InputTimeoutEvent -> handleInputTimeout(event)
                        is CommitComposingTextEvent -> handleCommitComposingText(event)
                    }
                }
            }
    }

    override fun onCreateInputView(): View? {
        return super.onCreateInputView()
    }

    override fun onCreateCandidatesView(): View? {
        return super.onCreateCandidatesView()
    }

    override fun onStartInputView(
        attribute: EditorInfo,
        restarting: Boolean,
    ) {
        resetCharComposition()
        super.onStartInputView(attribute, restarting)
        mInputConnection = currentInputConnection
        setCandidatesViewShown(false)
        mDirectInputMode = mInputConnection == null
        applyPreferences(resetLanguage = true)
    }

    override fun onStartInput(
        attribute: EditorInfo,
        restarting: Boolean,
    ) {
        super.onStartInput(attribute, restarting)
        mInputConnection = currentInputConnection
        applyPreferences(resetLanguage = true)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onFinishInput() {
        resetCharComposition()
        super.onFinishInput()
    }

    override fun onEvent(event: HangulEngineEvent) {
        if (event is FinishComposingEvent) {
            mInputConnection?.finishComposingText()
        }
        if (event is SetComposingEvent) {
            mInputConnection?.setComposingText(event.composing, 1)
        }
    }

    private fun handleKeyUp(event: KeyUpEvent) {
        // Shift/Caps key state is now handled by the system
    }

    private fun handleInputTimeout(
        @Suppress("UNUSED_PARAMETER") event: InputTimeoutEvent,
    ) {
        if (mEnableTimeout) {
            resetCharComposition()
        }
    }

    private fun handleInputKey(event: InputKeyEvent) {
        val keyEvent = event.keyEvent
        // Shift/Caps key handling is now delegated to the system
        val ret = keyEventHandler.processKeyEvent(keyEvent)
        event.isCancelled = ret
    }

    private fun handleCommitComposingText(
        @Suppress("UNUSED_PARAMETER") event: CommitComposingTextEvent,
    ) {
        currentInputConnection.finishComposingText()
    }

    private fun applyPreferences(resetLanguage: Boolean = false) {
        val snapshot = runBlocking { settingsRepository.snapshot() }
        mHardwareMoachigi = snapshot.hardwareUseMoachigi
        mFullMoachigi = snapshot.hardwareFullMoachigi
        mMoachigiDelay = snapshot.hardwareFullMoachigiDelay
        mStandardJamo = snapshot.systemUseStandardJamo
        if (resetLanguage) {
            applyStartLanguage(snapshot.systemStartHangulMode)
        }
        mHardLangKey = KeyStroke.parse(snapshot.systemHardwareLangKeyStroke)

        // Use subtype layout when explicitly set; otherwise use app settings.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        val currentSubtype = imm?.currentInputMethodSubtype
        val subtypeLayout =
            currentSubtype?.extraValue?.let { extraValue ->
                Regex("KeyboardLayoutSet=(\\w+)").find(extraValue)?.groupValues?.get(1)
            }
        mAlphabetLayout =
            if (subtypeLayout != null && subtypeLayout != SettingsDefaults.HARDWARE_ALPHABET_LAYOUT) {
                subtypeLayout
            } else {
                snapshot.hardwareAlphabetLayout
            }

        val modeKey =
            if (mCurrentLanguage == EngineMode.LANG_EN) {
                mAlphabetLayout
            } else {
                snapshot.hardwareHangulLayout
            }
        applyEngineMode(EngineMode.get(modeKey))
    }

    private fun applyStartLanguage(mode: String) {
        when (mode) {
            SettingsValues.START_HANGUL_MODE_START_HANGUL ->
                mCurrentLanguage = EngineMode.LANG_KO
            SettingsValues.START_HANGUL_MODE_START_ENGLISH ->
                mCurrentLanguage = EngineMode.LANG_EN
            "new_input",
            "always",
            -> mCurrentLanguage = EngineMode.LANG_KO
        }
    }

    private fun applyEngineMode(mode: EngineMode) {
        mCurrentEngineMode = mode
        if (mode == EngineMode.DIRECT) {
            mDirectInputMode = true
            mEnableTimeout = false
            mFullMoachigi = false
            mQwertyEngine.jamoTable = null
            mQwertyEngine.setCombinationTable(null)
            return
        }

        val prop = mode.properties
        mDirectInputMode = prop.direct
        mEnableTimeout = prop.timeout
        mFullMoachigi = prop.fullMoachigi
        if (mode.jamoset != null) {
            mQwertyEngine.jamoSet = mode.jamoset
        } else {
            mQwertyEngine.jamoTable = mode.layout
        }
        mQwertyEngine.setCombinationTable(mode.combination)
        mQwertyEngine.firstMidEnd = mStandardJamo
        mQwertyEngine.moachigi = mHardwareMoachigi
        mQwertyEngine.fullMoachigi = mFullMoachigi
        if (mFullMoachigi) {
            mEnableTimeout = true
        }
    }

    private fun resetCharComposition() {
        mQwertyEngine.resetComposition()
    }

    private fun toggleLanguage() {
        mCurrentLanguage =
            if (mCurrentLanguage == EngineMode.LANG_EN) {
                EngineMode.LANG_KO
            } else {
                EngineMode.LANG_EN
            }
        applyPreferences()
    }

    override fun hideWindow() {
        super.hideWindow()
        mDirectInputMode = true
        hideStatusIcon()
    }

    override fun onDestroy() {
        super.onDestroy()
        eventJob?.cancel()
        eventScope.cancel()
    }

    override fun onKeyUp(
        keyCode: Int,
        event: KeyEvent,
    ): Boolean {
        var ret = mConsumeDownEvent
        ret =
            if (!ret) {
                super.onKeyUp(keyCode, event)
            } else {
                InputEventBus.emitBlocking(KeyUpEvent(event))
                ret
            }
        return ret
    }

    override fun onKeyDown(
        keyCode: Int,
        event: KeyEvent,
    ): Boolean {
        if (mTimeOutHandler == null) {
            mTimeOutHandler = Handler(Looper.getMainLooper())
            mTimeOutHandler?.postDelayed({
                InputEventBus.emitBlocking(InputTimeoutEvent())
                mTimeOutHandler = null
            }, mMoachigiDelay.toLong())
        }
        val inputKeyEvent = InputKeyEvent(event)
        InputEventBus.emitBlocking(inputKeyEvent)
        mConsumeDownEvent = inputKeyEvent.isCancelled
        if (!mConsumeDownEvent) {
            return super.onKeyDown(keyCode, event)
        }
        return mConsumeDownEvent
    }

    override fun onEvaluateFullscreenMode(): Boolean {
        return false
    }

    override fun onEvaluateInputViewShown(): Boolean {
        super.onEvaluateInputViewShown()
        return true
    }

    override fun requestHideSelf(flag: Int) {
        super.requestHideSelf(flag)
        hideWindow()
    }

    override fun setCandidatesViewShown(shown: Boolean) {
        super.setCandidatesViewShown(shown)
        if (shown) {
            showWindow(true)
        }
    }

    override fun onComputeInsets(outInsets: Insets) {
        super.onComputeInsets(outInsets)
        outInsets.contentTopInsets = outInsets.visibleTopInsets
    }
}
