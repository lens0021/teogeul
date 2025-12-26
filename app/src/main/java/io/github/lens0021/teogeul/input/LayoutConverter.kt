package io.github.lens0021.teogeul.input

import android.view.KeyEvent

class LayoutConverter {
    private val qwertyToDvorak: Map<Int, Int> =
        hashMapOf<Int, Int>().apply {
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

    private val qwertyToColemak: Map<Int, Int> =
        hashMapOf<Int, Int>().apply {
            put(KeyEvent.KEYCODE_E, KeyEvent.KEYCODE_F)
            put(KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_P)
            put(KeyEvent.KEYCODE_T, KeyEvent.KEYCODE_G)
            put(KeyEvent.KEYCODE_Y, KeyEvent.KEYCODE_J)
            put(KeyEvent.KEYCODE_U, KeyEvent.KEYCODE_L)
            put(KeyEvent.KEYCODE_I, KeyEvent.KEYCODE_U)
            put(KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_Y)
            put(KeyEvent.KEYCODE_P, KeyEvent.KEYCODE_SEMICOLON)

            put(KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_R)
            put(KeyEvent.KEYCODE_D, KeyEvent.KEYCODE_S)
            put(KeyEvent.KEYCODE_F, KeyEvent.KEYCODE_T)
            put(KeyEvent.KEYCODE_G, KeyEvent.KEYCODE_D)
            put(KeyEvent.KEYCODE_J, KeyEvent.KEYCODE_N)
            put(KeyEvent.KEYCODE_K, KeyEvent.KEYCODE_E)
            put(KeyEvent.KEYCODE_L, KeyEvent.KEYCODE_I)
            put(KeyEvent.KEYCODE_SEMICOLON, KeyEvent.KEYCODE_O)

            put(KeyEvent.KEYCODE_N, KeyEvent.KEYCODE_K)
        }

    fun convertQwertyToLayout(
        event: KeyEvent,
        alphabetLayout: String,
    ): KeyEvent? {
        val conversionMap =
            when (alphabetLayout) {
                "keyboard_alphabet_dvorak" -> qwertyToDvorak
                "keyboard_alphabet_colemak" -> qwertyToColemak
                else -> return null // QWERTY or unknown - no conversion needed
            }

        val originalKeyCode = event.keyCode
        val convertedKeyCode = conversionMap[originalKeyCode] ?: return null

        return KeyEvent(
            event.downTime,
            event.eventTime,
            event.action,
            convertedKeyCode,
            event.repeatCount,
            event.metaState,
            event.deviceId,
            event.scanCode,
            event.flags,
            event.source,
        )
    }
}
