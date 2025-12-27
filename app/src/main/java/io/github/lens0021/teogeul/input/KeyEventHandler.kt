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
                intArrayOf(0x2f, 0x3f),
            )
    }

    private var selectionMode: Boolean = false
    private var selectionStart: Int = 0
    private var selectionEnd: Int = 0

    fun processKeyEvent(ev: KeyEvent): Boolean {
        val inputConnection = inputConnectionProvider() ?: return false
        val hangulEngine = hangulEngineProvider()
        val key = ev.keyCode

        if (ev.isShiftPressed) {
            when (key) {
                KeyEvent.KEYCODE_DPAD_UP,
                KeyEvent.KEYCODE_DPAD_DOWN,
                KeyEvent.KEYCODE_DPAD_LEFT,
                KeyEvent.KEYCODE_DPAD_RIGHT,
                -> {
                    if (!selectionMode) {
                        val beforeAll = inputConnection.getTextBeforeCursor(Int.MAX_VALUE, 0)
                        selectionEnd = beforeAll?.length ?: 0
                        selectionStart = selectionEnd
                        selectionMode = true
                    } else {
                        if (key == KeyEvent.KEYCODE_DPAD_LEFT) selectionEnd--
                        if (key == KeyEvent.KEYCODE_DPAD_RIGHT) selectionEnd++
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
                                selectionEnd -= beforeAll?.length ?: 0
                            } else {
                                selectionEnd -= i
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
                                selectionEnd += afterAll?.length ?: 0
                            } else {
                                selectionEnd += i
                            }
                        }
                        var start = selectionStart
                        var end = selectionEnd
                        if (selectionStart > selectionEnd) {
                            start = selectionEnd
                            end = selectionStart
                        }
                        inputConnection.setSelection(start, end)
                    }
                    return true
                }

                else -> {
                    selectionMode = false
                }
            }
        } else {
            selectionMode = false
        }

        // Ctrl key handling (available since API 11, always true for minSdk 26)
        if (ev.isCtrlPressed) {
            val convertedEvent = layoutConverter.convertKeyEventForShortcut(ev, alphabetLayoutProvider())
            if (convertedEvent != null) {
                inputConnection.sendKeyEvent(convertedEvent)
                return true
            }
            return false
        }

        // Alt/Meta key is not handled by IME - let system handle it for shortcuts
        if (ev.isAltPressed || ev.isMetaPressed) {
            return false
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
            val isKorean = currentLanguageProvider() == EngineMode.LANG_KO
            // Don't apply Alt meta state for character input - Alt is only used for shortcuts/language switching
            val code =
                if (qwertyCharCode != null) {
                    if (isKorean) {
                        qwertyCharCode
                    } else {
                        layoutConverter.convertQwertyCharCodeToLayout(
                            qwertyCharCode,
                            alphabetLayoutProvider(),
                        ) ?: qwertyCharCode
                    }
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
