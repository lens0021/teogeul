package io.github.lens0021.teogeul.model

data class KeyStroke(
    val control: Boolean,
    val alt: Boolean,
    val win: Boolean,
    val shift: Boolean,
    val keyCode: Int,
) {
    fun serialize(): String =
        buildString {
            append(if (control) 'c' else '-')
            append(if (alt) 'a' else '-')
            append(if (win) 'w' else '-')
            append(if (shift) 's' else '-')
            append(keyCode)
        }

    companion object {
        fun parse(keyStrokeStr: String): KeyStroke {
            if (keyStrokeStr.length < 5) return KeyStroke(false, false, false, false, 0)
            val keyCode = keyStrokeStr.substring(4).toIntOrNull() ?: 0
            return KeyStroke(
                control = keyStrokeStr[0] == 'c',
                alt = keyStrokeStr[1] == 'a',
                win = keyStrokeStr[2] == 'w',
                shift = keyStrokeStr[3] == 's',
                keyCode = keyCode,
            )
        }
    }
}
