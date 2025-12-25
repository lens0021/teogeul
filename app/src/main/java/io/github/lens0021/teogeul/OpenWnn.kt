package io.github.lens0021.teogeul

import android.content.SharedPreferences
import android.inputmethodservice.InputMethodService
import android.preference.PreferenceManager
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import org.greenrobot.eventbus.EventBus
import io.github.lens0021.teogeul.event.InputKeyEvent
import io.github.lens0021.teogeul.event.KeyUpEvent
import io.github.lens0021.teogeul.event.OpenWnnEvent

open class OpenWnn : InputMethodService() {
    protected var mPreConverter: LetterConverter? = null
    protected var mComposingText: ComposingText? = null
    protected var mInputConnection: InputConnection? = null
    protected var mAutoHideMode: Boolean = true
    protected var mDirectInputMode: Boolean = true

    private var mConsumeDownEvent: Boolean = false

    override fun onCreate() {
        super.onCreate()
        mComposingText?.clear()
    }

    override fun onCreateCandidatesView(): View? {
        return super.onCreateCandidatesView()
    }

    override fun onCreateInputView(): View? {
        return super.onCreateInputView()
    }

    override fun onDestroy() {
        super.onDestroy()
        close()
    }

    override fun onStartInput(attribute: EditorInfo, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        mInputConnection = currentInputConnection
        if (!restarting) {
            mComposingText?.clear()
        }
    }

    override fun onStartInputView(attribute: EditorInfo, restarting: Boolean) {
        super.onStartInputView(attribute, restarting)
        mInputConnection = currentInputConnection

        setCandidatesViewShown(false)
        mDirectInputMode = mInputConnection == null
        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        mPreConverter?.setPreferences(pref)
    }

    override fun requestHideSelf(flag: Int) {
        super.requestHideSelf(flag)
        hideWindow()
    }

    override fun setCandidatesViewShown(shown: Boolean) {
        super.setCandidatesViewShown(shown)
        if (shown) {
            showWindow(true)
        } else if (mAutoHideMode) {
            hideWindow()
        }
    }

    override fun hideWindow() {
        super.hideWindow()
        mDirectInputMode = true
        hideStatusIcon()
    }

    override fun onComputeInsets(outInsets: Insets) {
        super.onComputeInsets(outInsets)
        outInsets.contentTopInsets = outInsets.visibleTopInsets
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val inputKeyEvent = InputKeyEvent(event)
        EventBus.getDefault().post(inputKeyEvent)
        mConsumeDownEvent = inputKeyEvent.isCancelled
        if (!mConsumeDownEvent) {
            return super.onKeyDown(keyCode, event)
        }
        return mConsumeDownEvent
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        var ret = mConsumeDownEvent
        ret = if (!ret) {
            super.onKeyUp(keyCode, event)
        } else {
            EventBus.getDefault().post(KeyUpEvent(event))
            ret
        }
        return ret
    }

    open fun onEvent(ev: OpenWnnEvent): Boolean {
        return false
    }

    protected fun searchToggleCharacter(prevChar: String, toggleTable: Array<String>, reverse: Boolean): String? {
        for (i in toggleTable.indices) {
            if (prevChar == toggleTable[i]) {
                return if (reverse) {
                    val nextIndex = i - 1
                    if (nextIndex < 0) {
                        toggleTable[toggleTable.size - 1]
                    } else {
                        toggleTable[nextIndex]
                    }
                } else {
                    val nextIndex = i + 1
                    if (nextIndex == toggleTable.size) {
                        toggleTable[0]
                    } else {
                        toggleTable[nextIndex]
                    }
                }
            }
        }
        return null
    }

    protected open fun close() {
    }
}
