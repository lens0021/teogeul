package io.github.lens0021.teogeul.model

import android.content.Context
import android.view.KeyEvent
import io.github.lens0021.teogeul.R

sealed class VirtualKeyAction {
    object ToggleLanguage : VirtualKeyAction()

    data class SendKeyEvent(
        val keyCode: Int,
    ) : VirtualKeyAction()

    object OpenIMEPicker : VirtualKeyAction()

    fun serialize(): String =
        when (this) {
            is ToggleLanguage -> "toggle_language"
            is SendKeyEvent -> "send_key:$keyCode"
            is OpenIMEPicker -> "open_ime_picker"
        }

    companion object {
        fun parse(serialized: String): VirtualKeyAction? =
            when {
                serialized == "toggle_language" -> ToggleLanguage
                serialized.startsWith("send_key:") -> {
                    val keyCode = serialized.substringAfter("send_key:").toIntOrNull()
                    keyCode?.let { SendKeyEvent(it) }
                }
                serialized == "open_ime_picker" -> OpenIMEPicker
                else -> null
            }

        fun getDisplayName(
            action: VirtualKeyAction,
            context: Context,
        ): String =
            when (action) {
                is ToggleLanguage -> context.getString(R.string.virtual_key_toggle_language)
                is SendKeyEvent -> {
                    if (action.keyCode == KeyEvent.KEYCODE_LANGUAGE_SWITCH) {
                        context.getString(R.string.virtual_key_language_switch)
                    } else {
                        "${context.getString(
                            R.string.virtual_key_send_key,
                        )}: ${KeyEvent.keyCodeToString(action.keyCode)}"
                    }
                }
                is OpenIMEPicker -> context.getString(R.string.virtual_key_open_ime_picker)
            }
    }
}

data class KeyMapping(
    val physicalKey: Int, // KeyEvent.KEYCODE_*
    val virtualAction: VirtualKeyAction,
) {
    fun serialize(): String = "$physicalKey|${virtualAction.serialize()}"

    companion object {
        fun parse(serialized: String): KeyMapping? {
            val parts = serialized.split("|", limit = 2)
            if (parts.size != 2) return null

            val physicalKey = parts[0].toIntOrNull() ?: return null
            val virtualAction = VirtualKeyAction.parse(parts[1]) ?: return null

            return KeyMapping(physicalKey, virtualAction)
        }
    }
}

data class KeyMappings(
    val mappings: List<KeyMapping>,
) {
    fun serialize(): String = mappings.joinToString(";") { it.serialize() }

    companion object {
        fun parse(serialized: String): KeyMappings {
            if (serialized.isEmpty()) return EMPTY

            val mappings =
                serialized
                    .split(";")
                    .mapNotNull { KeyMapping.parse(it) }

            return KeyMappings(mappings)
        }

        val EMPTY = KeyMappings(emptyList())
    }
}
