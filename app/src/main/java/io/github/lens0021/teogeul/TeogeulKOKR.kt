package io.github.lens0021.teogeul

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.preference.PreferenceManager
import android.text.method.MetaKeyKeyListener
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import io.github.lens0021.teogeul.KOKR.EngineMode
import io.github.lens0021.teogeul.KOKR.HangulEngine
import io.github.lens0021.teogeul.KOKR.HangulEngine.FinishComposingEvent
import io.github.lens0021.teogeul.KOKR.HangulEngine.HangulEngineEvent
import io.github.lens0021.teogeul.KOKR.HangulEngine.HangulEngineListener
import io.github.lens0021.teogeul.KOKR.HangulEngine.SetComposingEvent
import io.github.lens0021.teogeul.KOKR.ListLangKeyActionDialogActivity
import io.github.lens0021.teogeul.KOKR.preference.KeystrokePreference
import io.github.lens0021.teogeul.event.CommitComposingTextEvent
import io.github.lens0021.teogeul.event.InputKeyEvent
import io.github.lens0021.teogeul.event.InputTimeoutEvent
import io.github.lens0021.teogeul.event.KeyUpEvent
import io.github.lens0021.teogeul.event.TeogeulEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class TeogeulKOKR : Teogeul, HangulEngineListener {
    companion object {
        @JvmField
        val SHIFT_CONVERT = arrayOf(
            intArrayOf(0x60, 0x7e),
            intArrayOf(0x31, 0x21),
            intArrayOf(0x32, 0x40),
            intArrayOf(0x33, 0x23),
            intArrayOf(0x34, 0x24),
            intArrayOf(0x35, 0x25),
            intArrayOf(0x36, 0x5e),
            intArrayOf(0x37, 0x26),
            intArrayOf(0x38, 0x2a),
            intArrayOf(0x39, 0x28),
            intArrayOf(0x30, 0x29),
            intArrayOf(0x2d, 0x5f),
            intArrayOf(0x3d, 0x2b),
            intArrayOf(0x5b, 0x7b),
            intArrayOf(0x5d, 0x7d),
            intArrayOf(0x5c, 0x7c),
            intArrayOf(0x3b, 0x3a),
            intArrayOf(0x27, 0x22),
            intArrayOf(0x2c, 0x3c),
            intArrayOf(0x2e, 0x3e),
            intArrayOf(0x2f, 0x3f)
        )

        private val QWERTY_TO_DVORAK: MutableMap<Int, Int> = HashMap<Int, Int>().apply {
            put(KeyEvent.KEYCODE_Q, KeyEvent.KEYCODE_APOSTROPHE)
            put(KeyEvent.KEYCODE_W, KeyEvent.KEYCODE_COMMA)
            put(KeyEvent.KEYCODE_E, KeyEvent.KEYCODE_PERIOD)
            put(KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_P)
            put(KeyEvent.KEYCODE_T, KeyEvent.KEYCODE_Y)
            put(KeyEvent.KEYCODE_Y, KeyEvent.KEYCODE_F)
            put(KeyEvent.KEYCODE_U, KeyEvent.KEYCODE_G)
            put(KeyEvent.KEYCODE_I, KeyEvent.KEYCODE_C)
            put(KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_R)
            put(KeyEvent.KEYCODE_P, KeyEvent.KEYCODE_L)
            put(KeyEvent.KEYCODE_LEFT_BRACKET, KeyEvent.KEYCODE_SLASH)
            put(KeyEvent.KEYCODE_RIGHT_BRACKET, KeyEvent.KEYCODE_EQUALS)

            put(KeyEvent.KEYCODE_A, KeyEvent.KEYCODE_A)
            put(KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_O)
            put(KeyEvent.KEYCODE_D, KeyEvent.KEYCODE_E)
            put(KeyEvent.KEYCODE_F, KeyEvent.KEYCODE_U)
            put(KeyEvent.KEYCODE_G, KeyEvent.KEYCODE_I)
            put(KeyEvent.KEYCODE_H, KeyEvent.KEYCODE_D)
            put(KeyEvent.KEYCODE_J, KeyEvent.KEYCODE_H)
            put(KeyEvent.KEYCODE_K, KeyEvent.KEYCODE_T)
            put(KeyEvent.KEYCODE_L, KeyEvent.KEYCODE_N)
            put(KeyEvent.KEYCODE_SEMICOLON, KeyEvent.KEYCODE_S)
            put(KeyEvent.KEYCODE_APOSTROPHE, KeyEvent.KEYCODE_MINUS)

            put(KeyEvent.KEYCODE_Z, KeyEvent.KEYCODE_SEMICOLON)
            put(KeyEvent.KEYCODE_X, KeyEvent.KEYCODE_Q)
            put(KeyEvent.KEYCODE_C, KeyEvent.KEYCODE_J)
            put(KeyEvent.KEYCODE_V, KeyEvent.KEYCODE_K)
            put(KeyEvent.KEYCODE_B, KeyEvent.KEYCODE_X)
            put(KeyEvent.KEYCODE_N, KeyEvent.KEYCODE_B)
            put(KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_M)
            put(KeyEvent.KEYCODE_COMMA, KeyEvent.KEYCODE_W)
            put(KeyEvent.KEYCODE_PERIOD, KeyEvent.KEYCODE_V)
            put(KeyEvent.KEYCODE_SLASH, KeyEvent.KEYCODE_Z)

            put(KeyEvent.KEYCODE_MINUS, KeyEvent.KEYCODE_LEFT_BRACKET)
            put(KeyEvent.KEYCODE_EQUALS, KeyEvent.KEYCODE_RIGHT_BRACKET)
        }

        const val LANGKEY_LIST_ACTIONS = "list_actions"
        const val LANGKEY_SWITCH_KOR_ENG = "switch_kor_eng"
        const val LANGKEY_SWITCH_NEXT_METHOD = "switch_next_method"
        const val LANGKEY_LIST_METHODS = "list_methods"
        const val LANGKEY_OPEN_SETTINGS = "open_settings"

        private var mSelf: TeogeulKOKR? = null

        @JvmStatic
        fun getInstance(): TeogeulKOKR? {
            return mSelf
        }
    }

    var mHangulEngine: HangulEngine
    var mQwertyEngine: HangulEngine

    var mHardShift: Int = 0
    var mHardAlt: Int = 0
    var mCapsLock: Boolean = false
    var mShiftOnCapsLock: Boolean = false

    var mShiftPressing: Boolean = false
    var mAltPressing: Boolean = false

    lateinit var mCurrentEngineMode: EngineMode
    var mCurrentLanguage: Int = EngineMode.LANG_KO

    private val mShiftKeyToggle = intArrayOf(0, MetaKeyKeyListener.META_SHIFT_ON, MetaKeyKeyListener.META_CAP_LOCKED)
    private val mAltKeyToggle = intArrayOf(0, MetaKeyKeyListener.META_ALT_ON, MetaKeyKeyListener.META_ALT_LOCKED)

    var mEnableTimeout: Boolean = false

    var mMoachigi: Boolean = false
    var mHardwareMoachigi: Boolean = false
    var mFullMoachigi: Boolean = true
    var mMoachigiDelay: Int = 0

    var mStandardJamo: Boolean = false
    var mLangKeyAction: String? = null

    var mEnableDvorakLayout: Boolean = false

    var mAltDirect: Boolean = false

    var mSelectionMode: Boolean = false
    var mSelectionStart: Int = 0
    var mSelectionEnd: Int = 0

    var mInput: Boolean = false

    var mTimeOutHandler: Handler? = null

    var mHardLangKey: KeystrokePreference.KeyStroke? = null

    private val mAltLayout: Array<IntArray> = emptyArray()

    constructor() : super() {
        mSelf = this

        mQwertyEngine = HangulEngine()
        mQwertyEngine.listener = this
        mHangulEngine = mQwertyEngine

        mAutoHideMode = false
    }

    constructor(context: Context) : this() {
        attachBaseContext(context)
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
    }

    override fun onCreateInputView(): View? {
        return super.onCreateInputView()
    }

    override fun onStartInputView(attribute: EditorInfo, restarting: Boolean) {
        resetCharComposition()
        super.onStartInputView(attribute, restarting)
        applyPreferences()
    }

    override fun onStartInput(attribute: EditorInfo, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        applyPreferences()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onFinishInput() {
        resetCharComposition()
        super.onFinishInput()
    }

    override fun onViewClicked(focusChanged: Boolean) {
        resetCharComposition()
        super.onViewClicked(focusChanged)
    }

    override fun onEvent(event: HangulEngineEvent) {
        if (event is FinishComposingEvent) {
            mInputConnection?.finishComposingText()
        }
        if (event is SetComposingEvent) {
            mInputConnection?.setComposingText(event.composing, 1)
        }
    }

    @Subscribe
    fun onKeyUp(event: KeyUpEvent) {
        val key = event.keyEvent.keyCode
        if (!mShiftPressing) {
            if (key == KeyEvent.KEYCODE_SHIFT_LEFT || key == KeyEvent.KEYCODE_SHIFT_RIGHT) {
                mHardShift = 0
                mShiftPressing = true
                if (mShiftOnCapsLock) {
                    mHardShift = 2
                    mShiftPressing = true
                    mShiftOnCapsLock = false
                }
                updateMetaKeyStateDisplay()
            }
        }
        if (!mAltPressing) {
            if (key == KeyEvent.KEYCODE_ALT_LEFT || key == KeyEvent.KEYCODE_ALT_RIGHT) {
                mHardAlt = 0
                mAltPressing = true
                updateMetaKeyStateDisplay()
            }
        }
    }

    @Subscribe
    fun onInputTimeout(event: InputTimeoutEvent) {
        if (mEnableTimeout) {
            resetCharComposition()
        }
    }

    @Subscribe
    fun onInputKey(event: InputKeyEvent) {
        val keyEvent = event.keyEvent
        when (keyEvent.keyCode) {
            KeyEvent.KEYCODE_ALT_LEFT, KeyEvent.KEYCODE_ALT_RIGHT -> {
                if (keyEvent.repeatCount == 0) {
                    if (++mHardAlt > 2) {
                        mHardAlt = 0
                    }
                }
                mAltPressing = true
                updateMetaKeyStateDisplay()
                return
            }

            KeyEvent.KEYCODE_SHIFT_LEFT, KeyEvent.KEYCODE_SHIFT_RIGHT -> {
                if (keyEvent.repeatCount == 0) {
                    if (++mHardShift > 2) {
                        mHardShift = 0
                    }
                }
                mShiftPressing = true
                if (mCapsLock) {
                    mHardShift = 0
                    mShiftPressing = false
                    mShiftOnCapsLock = true
                }
                updateMetaKeyStateDisplay()
                return
            }

            KeyEvent.KEYCODE_CAPS_LOCK -> {
                mCapsLock = !mCapsLock
                if (mCapsLock) {
                    mHardShift = 2
                    mShiftPressing = true
                } else {
                    mHardShift = 0
                    mShiftPressing = false
                }
                updateMetaKeyStateDisplay()
                return
            }
        }
        if (keyEvent.metaState and KeyEvent.META_CAPS_LOCK_ON != 0) {
            if (!mShiftOnCapsLock) {
                mCapsLock = true
                mHardShift = 2
                mShiftPressing = true
                updateMetaKeyStateDisplay()
            }
        } else if (mCapsLock) {
            mCapsLock = false
            mHardShift = 0
            mShiftPressing = false
            updateMetaKeyStateDisplay()
        }
        val ret = processKeyEvent(keyEvent)
        event.isCancelled = ret
        shinShift()
    }

    @Subscribe
    fun onCommitComposingText(event: CommitComposingTextEvent) {
        currentInputConnection.finishComposingText()
    }

    override fun onEvent(ev: TeogeulEvent): Boolean {
        return false
    }

    private fun inputChar(code: Char, direct: Boolean) {
        var shift = mHardShift
        var mutableCode = code
        var isDirect = direct

        if (mutableCode.code == 128) {
            mutableCode = if (shift > 0) 0x2c.toChar() else 0x2e.toChar()
            shift = 0
            isDirect = true
        }

        val originalCode = mutableCode
        for (item in SHIFT_CONVERT) {
            if (mutableCode.code == item[1]) {
                mutableCode = item[0].toChar()
                shift = 1
            }
        }

        if (mDirectInputMode) {
            mutableCode = originalCode
            resetCharComposition()
            directInput(mutableCode, shift > 0)
            return
        } else if (isDirect) {
            resetCharComposition()
            mInputConnection?.commitText(String(charArrayOf(originalCode)), 1)
            resetCharComposition()
            return
        }

        val inputCode = mHangulEngine.inputCode(mutableCode.lowercaseChar().code, shift)
        if (inputCode != -1) {
            if (mHangulEngine.inputJamo(inputCode) == 0) {
                mInputConnection?.commitText(String(charArrayOf(inputCode.toChar())), 1)
                resetCharComposition()
            }
        } else {
            resetCharComposition()
            if (shift > 0) {
                mutableCode = originalCode.uppercaseChar()
                for (item in SHIFT_CONVERT) {
                    if (mutableCode.code == item[0]) {
                        mutableCode = item[1].toChar()
                    }
                }
            }
            mInputConnection?.commitText(String(charArrayOf(mutableCode)), 1)
            resetCharComposition()
        }
    }

    private fun directInput(code: Char, shift: Boolean) {
        var mutableCode = code
        if (shift) {
            mutableCode = mutableCode.uppercaseChar()
            for (item in SHIFT_CONVERT) {
                if (mutableCode.code == item[0]) {
                    mutableCode = item[1].toChar()
                    break
                }
            }
        }
        mInputConnection?.commitText(mutableCode.toString(), 1)
    }

    fun onLangKey(action: String) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        val token: IBinder = requireNotNull(window?.window).attributes.token

        when (action) {
            LANGKEY_LIST_ACTIONS -> {
                val intent = Intent(this, ListLangKeyActionDialogActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

            LANGKEY_SWITCH_KOR_ENG -> {
                toggleLanguage()
            }

            LANGKEY_SWITCH_NEXT_METHOD -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (mInput) {
                        mInput = false
                        imm?.switchToLastInputMethod(token)
                    } else {
                        imm?.switchToNextInputMethod(token, false)
                    }
                }
            }

            LANGKEY_LIST_METHODS -> {
                imm?.showInputMethodPicker()
            }

            LANGKEY_OPEN_SETTINGS -> {
                val intent = Intent(this, TeogeulControlPanelKOKR::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }

    private fun convertQwertyToDvorak(ev: KeyEvent): KeyEvent? {
        if (!mEnableDvorakLayout) {
            return null
        }

        val originalKeyCode = ev.keyCode
        val convertedKeyCode = QWERTY_TO_DVORAK[originalKeyCode] ?: return null

        return KeyEvent(
            ev.downTime,
            ev.eventTime,
            ev.action,
            convertedKeyCode,
            ev.repeatCount,
            ev.metaState,
            ev.deviceId,
            ev.scanCode,
            ev.flags,
            ev.source
        )
    }

    @SuppressLint("NewApi")
    private fun processKeyEvent(ev: KeyEvent): Boolean {
        val inputConnection = mInputConnection ?: return false
        val key = ev.keyCode

        if (ev.isShiftPressed) {
            when (key) {
                KeyEvent.KEYCODE_DPAD_UP,
                KeyEvent.KEYCODE_DPAD_DOWN,
                KeyEvent.KEYCODE_DPAD_LEFT,
                KeyEvent.KEYCODE_DPAD_RIGHT -> {
                    if (!mSelectionMode) {
                        val beforeAll = inputConnection.getTextBeforeCursor(Int.MAX_VALUE, 0)
                        mSelectionEnd = beforeAll?.length ?: 0
                        mSelectionStart = mSelectionEnd
                        mSelectionMode = true
                    } else {
                        if (key == KeyEvent.KEYCODE_DPAD_LEFT) mSelectionEnd--
                        if (key == KeyEvent.KEYCODE_DPAD_RIGHT) mSelectionEnd++
                        if (key == KeyEvent.KEYCODE_DPAD_UP) {
                            var i = 1
                            var text: CharSequence = ""
                            var end: Boolean
                            while (true) {
                                val before = inputConnection.getTextBeforeCursor(i, 0) ?: ""
                                end = before == text
                                text = before
                                if (end || (text.isNotEmpty() && text[0] == '\n')) {
                                    break
                                }
                                i++
                            }
                            if (end) {
                                val beforeAll = inputConnection.getTextBeforeCursor(Int.MAX_VALUE, 0)
                                mSelectionEnd -= beforeAll?.length ?: 0
                            } else {
                                mSelectionEnd -= i
                            }
                        }
                        if (key == KeyEvent.KEYCODE_DPAD_DOWN) {
                            var i = 1
                            var text: CharSequence = ""
                            var end: Boolean
                            while (true) {
                                val after = inputConnection.getTextAfterCursor(i, 0) ?: ""
                                end = after == text
                                text = after
                                if (end || (text.isNotEmpty() && text[text.length - 1] == '\n')) {
                                    break
                                }
                                i++
                            }
                            if (end) {
                                val afterAll = inputConnection.getTextAfterCursor(Char.MAX_VALUE.code, 0)
                                mSelectionEnd += afterAll?.length ?: 0
                            } else {
                                mSelectionEnd += i
                            }
                        }
                        var start = mSelectionStart
                        var end = mSelectionEnd
                        if (mSelectionStart > mSelectionEnd) {
                            start = mSelectionEnd
                            end = mSelectionStart
                        }
                        inputConnection.setSelection(start, end)
                        mHardShift = 0
                        updateMetaKeyStateDisplay()
                        updateMetaKeyStateDisplay()
                    }
                    return true
                }

                else -> {
                    mSelectionMode = false
                }
            }
        } else {
            mSelectionMode = false
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (ev.isCtrlPressed) {
                val convertedEvent = convertQwertyToDvorak(ev)
                if (convertedEvent != null) {
                    inputConnection.sendKeyEvent(convertedEvent)
                    return true
                }
                return false
            }
        }

        if (key >= KeyEvent.KEYCODE_NUMPAD_0 && key <= KeyEvent.KEYCODE_NUMPAD_RIGHT_PAREN) {
            resetCharComposition()
            return false
        }

        // Handle dedicated language switch key (한/영 key)
        if (key == KeyEvent.KEYCODE_LANGUAGE_SWITCH) {
            resetCharComposition()
            toggleLanguage()
            return true
        }

        val hardLangKey = mHardLangKey
        if (hardLangKey != null && key == hardLangKey.keyCode) {
            if ((mHardShift == 1) == hardLangKey.shift &&
                (mHardAlt == 1) == hardLangKey.alt &&
                ev.isCtrlPressed == hardLangKey.control &&
                ev.isMetaPressed == hardLangKey.win) {
                resetCharComposition()
                toggleLanguage()
                mHardShift = 0
                mShiftPressing = false
                mHardAlt = 0
                mAltPressing = false
                updateMetaKeyStateDisplay()
                return true
            }
        }

        if (ev.isPrintingKey) {
            var processedEvent: KeyEvent = ev
            val convertedEvent = convertQwertyToDvorak(ev)
            if (convertedEvent != null) {
                processedEvent = convertedEvent
            }

            val code = processedEvent.getUnicodeChar(mShiftKeyToggle[mHardShift] or mAltKeyToggle[mHardAlt])
            inputChar(code.toChar(), mHardAlt != 0 && mAltDirect)
            mInput = true

            if (mHardShift == 1) {
                mShiftPressing = false
            }
            if (mHardAlt == 1) {
                mAltPressing = false
            }
            if (!ev.isAltPressed) {
                if (mHardAlt == 1) {
                    mHardAlt = 0
                }
            }
            if (!ev.isShiftPressed) {
                if (mHardShift == 1) {
                    mHardShift = 0
                }
            }
            if (!ev.isShiftPressed && !ev.isShiftPressed) {
                updateMetaKeyStateDisplay()
            }

            return true
        } else if (key == KeyEvent.KEYCODE_SPACE) {
            resetCharComposition()
            inputConnection.commitText(" ", 1)
            return true
        } else if (key == KeyEvent.KEYCODE_DEL) {
            if (!mHangulEngine.backspace()) {
                resetCharComposition()
                inputConnection.deleteSurroundingText(1, 0)
            }
            if (mHangulEngine.composing == "") {
                resetCharComposition()
            }
            return true
        } else if (key == KeyEvent.KEYCODE_ENTER) {
            resetCharComposition()
            mHardShift = 0
            mHardAlt = 0
            updateMetaKeyStateDisplay()
            val editorInfo = currentInputEditorInfo
            return when (editorInfo.imeOptions and EditorInfo.IME_MASK_ACTION) {
                EditorInfo.IME_ACTION_SEARCH, EditorInfo.IME_ACTION_GO -> {
                    sendDefaultEditorAction(true)
                    true
                }

                else -> false
            }
        } else {
            resetCharComposition()
        }

        return false
    }

    private fun shinShift() {
        updateMetaKeyStateDisplay()
    }

    fun updateMetaKeyStateDisplay() {
    }

    private fun applyPreferences() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        mHardwareMoachigi = pref.getBoolean("hardware_use_moachigi", mHardwareMoachigi)
        mFullMoachigi = pref.getBoolean("hardware_full_moachigi", mFullMoachigi)
        mMoachigiDelay = pref.getInt("hardware_full_moachigi_delay", 100)
        mStandardJamo = pref.getBoolean("system_use_standard_jamo", mStandardJamo)
        mLangKeyAction = pref.getString("system_action_on_lang_key_press", LANGKEY_SWITCH_KOR_ENG)
        mHardLangKey = KeystrokePreference.parseKeyStroke(
            pref.getString("system_hardware_lang_key_stroke", "---s62") ?: "---s62"
        )
        mAltDirect = pref.getBoolean("hardware_alt_direct", true)
        mEnableDvorakLayout = pref.getBoolean("hardware_enable_dvorak", true)

        val modeKey = if (mCurrentLanguage == EngineMode.LANG_EN) {
            pref.getString("hardware_alphabet_layout", "keyboard_alphabet_qwerty")
        } else {
            pref.getString("hardware_hangul_layout", "keyboard_sebul_391")
        }
        applyEngineMode(EngineMode.get(modeKey ?: ""))
    }

    private fun applyEngineMode(mode: EngineMode) {
        mCurrentEngineMode = mode
        if (mode == EngineMode.DIRECT) {
            mDirectInputMode = true
            mEnableTimeout = false
            mFullMoachigi = false
            mHangulEngine = mQwertyEngine
            mHangulEngine.jamoTable = null
            mHangulEngine.setCombinationTable(null)
            return
        }

        val prop = mode.properties
        mDirectInputMode = prop.direct
        mEnableTimeout = prop.timeout
        mFullMoachigi = prop.fullMoachigi
        mHangulEngine = mQwertyEngine
        if (mode.jamoset != null) {
            mHangulEngine.jamoSet = mode.jamoset
        } else {
            mHangulEngine.jamoTable = mode.layout
        }
        mHangulEngine.setCombinationTable(mode.combination)
        mHangulEngine.firstMidEnd = mStandardJamo
        mHangulEngine.moachigi = mHardwareMoachigi
        mHangulEngine.fullMoachigi = mFullMoachigi
        if (mFullMoachigi) {
            mEnableTimeout = true
        }
    }

    private fun resetCharComposition() {
        mHangulEngine.resetComposition()
    }

    private fun toggleLanguage() {
        mCurrentLanguage = if (mCurrentLanguage == EngineMode.LANG_EN) {
            EngineMode.LANG_KO
        } else {
            EngineMode.LANG_EN
        }
        applyPreferences()
    }

    fun resetHardShift(force: Boolean) {
        if (mHardShift == 2 && !force) {
            return
        }
        mHardShift = 0
        mShiftPressing = false
    }

    override fun hideWindow() {
        super.hideWindow()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (mTimeOutHandler == null) {
            mTimeOutHandler = Handler()
            mTimeOutHandler?.postDelayed({
                EventBus.getDefault().post(InputTimeoutEvent())
                mTimeOutHandler = null
            }, mMoachigiDelay.toLong())
        }
        return super.onKeyDown(keyCode, event)
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

    fun getHangulEngine(): HangulEngine {
        return mHangulEngine
    }

    fun getAltSymbols(): Array<IntArray> {
        return mAltLayout
    }
}
