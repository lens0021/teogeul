package io.github.lens0021.teogeul.input

import android.view.KeyEvent
import io.github.lens0021.teogeul.layout.LayoutData

class LayoutConverter {
    private val dvorakConversionMap = buildConversionMap(LayoutData.CONVERT_ENGLISH_DVORAK)
    private val colemakConversionMap = buildConversionMap(LayoutData.CONVERT_ENGLISH_COLEMAK)

    private fun buildConversionMap(table: Array<IntArray>): Map<Int, Int> {
        val map = HashMap<Int, Int>(table.size)
        for (entry in table) {
            map[entry[0]] = entry[1]
        }
        return map
    }

    fun getQwertyCharCode(event: KeyEvent): Int? = getQwertyCharCodeFromKeyCode(event.keyCode)

    fun getQwertyCharCodeFromKeyCode(keyCode: Int): Int? =
        when (keyCode) {
            KeyEvent.KEYCODE_A -> 'a'.code
            KeyEvent.KEYCODE_B -> 'b'.code
            KeyEvent.KEYCODE_C -> 'c'.code
            KeyEvent.KEYCODE_D -> 'd'.code
            KeyEvent.KEYCODE_E -> 'e'.code
            KeyEvent.KEYCODE_F -> 'f'.code
            KeyEvent.KEYCODE_G -> 'g'.code
            KeyEvent.KEYCODE_H -> 'h'.code
            KeyEvent.KEYCODE_I -> 'i'.code
            KeyEvent.KEYCODE_J -> 'j'.code
            KeyEvent.KEYCODE_K -> 'k'.code
            KeyEvent.KEYCODE_L -> 'l'.code
            KeyEvent.KEYCODE_M -> 'm'.code
            KeyEvent.KEYCODE_N -> 'n'.code
            KeyEvent.KEYCODE_O -> 'o'.code
            KeyEvent.KEYCODE_P -> 'p'.code
            KeyEvent.KEYCODE_Q -> 'q'.code
            KeyEvent.KEYCODE_R -> 'r'.code
            KeyEvent.KEYCODE_S -> 's'.code
            KeyEvent.KEYCODE_T -> 't'.code
            KeyEvent.KEYCODE_U -> 'u'.code
            KeyEvent.KEYCODE_V -> 'v'.code
            KeyEvent.KEYCODE_W -> 'w'.code
            KeyEvent.KEYCODE_X -> 'x'.code
            KeyEvent.KEYCODE_Y -> 'y'.code
            KeyEvent.KEYCODE_Z -> 'z'.code
            KeyEvent.KEYCODE_0 -> '0'.code
            KeyEvent.KEYCODE_1 -> '1'.code
            KeyEvent.KEYCODE_2 -> '2'.code
            KeyEvent.KEYCODE_3 -> '3'.code
            KeyEvent.KEYCODE_4 -> '4'.code
            KeyEvent.KEYCODE_5 -> '5'.code
            KeyEvent.KEYCODE_6 -> '6'.code
            KeyEvent.KEYCODE_7 -> '7'.code
            KeyEvent.KEYCODE_8 -> '8'.code
            KeyEvent.KEYCODE_9 -> '9'.code
            KeyEvent.KEYCODE_GRAVE -> '`'.code
            KeyEvent.KEYCODE_MINUS -> '-'.code
            KeyEvent.KEYCODE_EQUALS -> '='.code
            KeyEvent.KEYCODE_LEFT_BRACKET -> '['.code
            KeyEvent.KEYCODE_RIGHT_BRACKET -> ']'.code
            KeyEvent.KEYCODE_BACKSLASH -> '\\'.code
            KeyEvent.KEYCODE_SEMICOLON -> ';'.code
            KeyEvent.KEYCODE_APOSTROPHE -> '\''.code
            KeyEvent.KEYCODE_COMMA -> ','.code
            KeyEvent.KEYCODE_PERIOD -> '.'.code
            KeyEvent.KEYCODE_SLASH -> '/'.code
            else -> null
        }

    fun getKeyCodeFromQwertyCharCode(charCode: Int): Int? =
        when (charCode) {
            'a'.code -> KeyEvent.KEYCODE_A
            'b'.code -> KeyEvent.KEYCODE_B
            'c'.code -> KeyEvent.KEYCODE_C
            'd'.code -> KeyEvent.KEYCODE_D
            'e'.code -> KeyEvent.KEYCODE_E
            'f'.code -> KeyEvent.KEYCODE_F
            'g'.code -> KeyEvent.KEYCODE_G
            'h'.code -> KeyEvent.KEYCODE_H
            'i'.code -> KeyEvent.KEYCODE_I
            'j'.code -> KeyEvent.KEYCODE_J
            'k'.code -> KeyEvent.KEYCODE_K
            'l'.code -> KeyEvent.KEYCODE_L
            'm'.code -> KeyEvent.KEYCODE_M
            'n'.code -> KeyEvent.KEYCODE_N
            'o'.code -> KeyEvent.KEYCODE_O
            'p'.code -> KeyEvent.KEYCODE_P
            'q'.code -> KeyEvent.KEYCODE_Q
            'r'.code -> KeyEvent.KEYCODE_R
            's'.code -> KeyEvent.KEYCODE_S
            't'.code -> KeyEvent.KEYCODE_T
            'u'.code -> KeyEvent.KEYCODE_U
            'v'.code -> KeyEvent.KEYCODE_V
            'w'.code -> KeyEvent.KEYCODE_W
            'x'.code -> KeyEvent.KEYCODE_X
            'y'.code -> KeyEvent.KEYCODE_Y
            'z'.code -> KeyEvent.KEYCODE_Z
            '0'.code -> KeyEvent.KEYCODE_0
            '1'.code -> KeyEvent.KEYCODE_1
            '2'.code -> KeyEvent.KEYCODE_2
            '3'.code -> KeyEvent.KEYCODE_3
            '4'.code -> KeyEvent.KEYCODE_4
            '5'.code -> KeyEvent.KEYCODE_5
            '6'.code -> KeyEvent.KEYCODE_6
            '7'.code -> KeyEvent.KEYCODE_7
            '8'.code -> KeyEvent.KEYCODE_8
            '9'.code -> KeyEvent.KEYCODE_9
            '`'.code -> KeyEvent.KEYCODE_GRAVE
            '-'.code -> KeyEvent.KEYCODE_MINUS
            '='.code -> KeyEvent.KEYCODE_EQUALS
            '['.code -> KeyEvent.KEYCODE_LEFT_BRACKET
            ']'.code -> KeyEvent.KEYCODE_RIGHT_BRACKET
            '\\'.code -> KeyEvent.KEYCODE_BACKSLASH
            ';'.code -> KeyEvent.KEYCODE_SEMICOLON
            '\''.code -> KeyEvent.KEYCODE_APOSTROPHE
            ','.code -> KeyEvent.KEYCODE_COMMA
            '.'.code -> KeyEvent.KEYCODE_PERIOD
            '/'.code -> KeyEvent.KEYCODE_SLASH
            else -> null
        }

    fun convertQwertyCharCodeToLayout(
        charCode: Int,
        alphabetLayout: String,
    ): Int? {
        val conversionMap =
            when (alphabetLayout) {
                "keyboard_alphabet_dvorak" -> dvorakConversionMap
                "keyboard_alphabet_colemak" -> colemakConversionMap
                else -> return null // QWERTY or unknown - no conversion needed
            }

        return conversionMap[charCode]
    }

    fun convertKeyEventForShortcut(
        event: KeyEvent,
        alphabetLayout: String,
    ): KeyEvent? {
        val qwertyCharCode = getQwertyCharCodeFromKeyCode(event.keyCode) ?: return null
        val layoutCharCode = convertQwertyCharCodeToLayout(qwertyCharCode, alphabetLayout) ?: return null
        val layoutKeyCode = getKeyCodeFromQwertyCharCode(layoutCharCode) ?: return null
        if (layoutKeyCode == event.keyCode) {
            return null
        }

        return KeyEvent(
            event.downTime,
            event.eventTime,
            event.action,
            layoutKeyCode,
            event.repeatCount,
            event.metaState,
            event.deviceId,
            event.scanCode,
            event.flags,
            event.source,
        )
    }
}
