package io.github.lens0021.teogeul.model

data class KeyStroke(
    val keyCode: Int,
) {
    fun serialize(): String =
        keyCode.toString()

    companion object {
        fun parse(keyStrokeStr: String): KeyStroke {
            val keyCode = keyStrokeStr.toIntOrNull() ?: 0
            return KeyStroke(keyCode)
        }
    }
}
