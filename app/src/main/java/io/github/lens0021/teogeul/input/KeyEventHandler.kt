package io.github.lens0021.teogeul.input

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import io.github.lens0021.teogeul.korean.EngineMode
import io.github.lens0021.teogeul.korean.HangulEngine
import io.github.lens0021.teogeul.model.KeyStroke

class KeyEventHandler(
    private val layoutConverter: LayoutConverter,
    private val inputConnectionProvider: () -> InputConnection?,
    private val hangulEngineProvider: () -> HangulEngine,
    private val directInputModeProvider: () -> Boolean,
    private val alphabetLayoutProvider: () -> String,
    private val hardLangKeyProvider: () -> KeyStroke?,
    private val currentLanguageProvider: () -> Int,
    private val toggleLanguage: () -> Unit,
    private val resetCharComposition: () -> Unit,
    private val currentInputEditorInfoProvider: () -> EditorInfo?,
    private val sendDefaultEditorAction: (Boolean) -> Unit,
    private val markInput: () -> Unit,
) {
    companion object {
        val SHIFT_CONVERT =
            arrayOf(
                intArrayOf('`'.code, '~'.code),
                intArrayOf('1'.code, '!'.code),
                intArrayOf('2'.code, '@'.code),
                intArrayOf('3'.code, '#'.code),
                intArrayOf('4'.code, '$'.code),
                intArrayOf('5'.code, '%'.code),
                intArrayOf('6'.code, '^'.code),
                intArrayOf('7'.code, '&'.code),
                intArrayOf('8'.code, '*'.code),
                intArrayOf('9'.code, '('.code),
                intArrayOf('0'.code, ')'.code),
                intArrayOf('-'.code, '_'.code),
                intArrayOf('='.code, '+'.code),
                intArrayOf('['.code, '{'.code),
                intArrayOf(']'.code, '}'.code),
                intArrayOf('\\'.code, '|'.code),
                intArrayOf(';'.code, ':'.code),
                intArrayOf('\''.code, '"'.code),
                intArrayOf(','.code, '<'.code),
                intArrayOf('.'.code, '>'.code),
                intArrayOf('/'.code, '?'.code),
            )
    }

    fun processKeyEvent(ev: KeyEvent): Boolean {
        val inputConnection = inputConnectionProvider() ?: return false
        val hangulEngine = hangulEngineProvider()
        val key = ev.keyCode

        // Ctrl key handling (available since API 11, always true for minSdk 26)
        if (ev.isCtrlPressed) {
            inputConnection.sendKeyEvent(ev)
            return true
        }

        if (ev.isAltPressed || ev.isMetaPressed) {
            inputConnection.sendKeyEvent(ev)
            return true
        }

        if (key >= KeyEvent.KEYCODE_NUMPAD_0 && key <= KeyEvent.KEYCODE_NUMPAD_RIGHT_PAREN) {
            resetCharComposition()
            return false
        }

        // Language switch key is not handled by IME - let system handle it
        if (key == KeyEvent.KEYCODE_LANGUAGE_SWITCH) {
            resetCharComposition()
            return false
        }

        // Handle custom language key combination (e.g., user-defined shortcut for toggling language)
        val hardLangKey = hardLangKeyProvider()
        if (hardLangKey != null && key == hardLangKey.keyCode) {
            resetCharComposition()
            toggleLanguage()
            return true
        }

        if (ev.isPrintingKey) {
            val qwertyCharCode = layoutConverter.getQwertyCharCode(ev)
            // Don't apply Alt meta state for character input - Alt is only used for shortcuts/language switching
            val code =
                if (qwertyCharCode != null) {
                    qwertyCharCode
                } else {
                    ev.getUnicodeChar(ev.metaState)
                }
            inputChar(code.toChar(), ev.isShiftPressed)
            markInput()
            return true
        } else if (key == KeyEvent.KEYCODE_SPACE) {
            resetCharComposition()
            inputConnection.commitText(" ", 1)
            return true
        } else if (key == KeyEvent.KEYCODE_DEL) {
            if (!hangulEngine.backspace()) {
                resetCharComposition()
                inputConnection.deleteSurroundingText(1, 0)
            }
            if (hangulEngine.composing == "") {
                resetCharComposition()
            }
            return true
        } else if (key == KeyEvent.KEYCODE_ENTER) {
            resetCharComposition()
            val editorInfo = currentInputEditorInfoProvider()
            return when (editorInfo?.imeOptions?.and(EditorInfo.IME_MASK_ACTION)) {
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

    private fun inputChar(code: Char, isShiftPressed: Boolean) {
        var shift = if (isShiftPressed) 1 else 0
        var mutableCode = code
        var isDirect = false

        if (mutableCode.code == 128) {
            mutableCode = if (shift > 0) ','.code.toChar() else '.'.code.toChar()
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

        val inputConnection = inputConnectionProvider()
        if (directInputModeProvider()) {
            mutableCode = originalCode
            resetCharComposition()
            directInput(mutableCode, shift > 0)
            return
        } else if (isDirect) {
            resetCharComposition()
            inputConnection?.commitText(String(charArrayOf(originalCode)), 1)
            resetCharComposition()
            return
        }

        val hangulEngine = hangulEngineProvider()
        val inputCode = hangulEngine.inputCode(mutableCode.lowercaseChar().code, shift)
        if (inputCode != -1) {
            if (hangulEngine.inputJamo(inputCode) == 0) {
                inputConnection?.commitText(String(charArrayOf(inputCode.toChar())), 1)
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
            inputConnection?.commitText(String(charArrayOf(mutableCode)), 1)
            resetCharComposition()
        }
    }

    private fun directInput(
        code: Char,
        shift: Boolean,
    ) {
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
        inputConnectionProvider()?.commitText(mutableCode.toString(), 1)
    }

}
