package io.github.lens0021.teogeul.model

import android.content.Context
import android.view.KeyEvent
import io.github.lens0021.teogeul.R

/**
 * Represents a virtual key action that can be triggered by a physical key.
 */
sealed class VirtualKeyAction {
    /**
     * Toggle between Korean and English input.
     */
    object ToggleLanguage : VirtualKeyAction()

    /**
     * Send a key event to the system.
     * @param keyCode The key code to send (e.g., KEYCODE_LANGUAGE_SWITCH)
     */
    data class SendKeyEvent(
        val keyCode: Int,
    ) : VirtualKeyAction()

    /**
     * Open the IME picker dialog.
     */
    object OpenIMEPicker : VirtualKeyAction()

    /**
     * Serialize this action to a string for storage.
     */
    fun serialize(): String =
        when (this) {
            is ToggleLanguage -> "toggle_language"
            is SendKeyEvent -> "send_key:$keyCode"
            is OpenIMEPicker -> "open_ime_picker"
        }

    companion object {
        /**
         * Parse a serialized action string back to a VirtualKeyAction.
         * Returns null if the format is invalid.
         */
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

        /**
         * Get a user-friendly display name for the action.
         */
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

/**
 * Represents a single key mapping from a physical key to a virtual action.
 */
data class KeyMapping(
    val physicalKey: Int, // KeyEvent.KEYCODE_*
    val virtualAction: VirtualKeyAction,
) {
    /**
     * Serialize this mapping to a string for storage.
     * Format: "physicalKey|virtualAction"
     */
    fun serialize(): String = "$physicalKey|${virtualAction.serialize()}"

    companion object {
        /**
         * Parse a serialized mapping string back to a KeyMapping.
         * Returns null if the format is invalid.
         */
        fun parse(serialized: String): KeyMapping? {
            val parts = serialized.split("|", limit = 2)
            if (parts.size != 2) return null

            val physicalKey = parts[0].toIntOrNull() ?: return null
            val virtualAction = VirtualKeyAction.parse(parts[1]) ?: return null

            return KeyMapping(physicalKey, virtualAction)
        }
    }
}

/**
 * Container for a list of key mappings.
 */
data class KeyMappings(
    val mappings: List<KeyMapping>,
) {
    /**
     * Serialize all mappings to a string for storage.
     * Format: "mapping1;mapping2;mapping3"
     */
    fun serialize(): String = mappings.joinToString(";") { it.serialize() }

    companion object {
        /**
         * Parse a serialized mappings string back to a KeyMappings object.
         * Invalid mappings are filtered out.
         */
        fun parse(serialized: String): KeyMappings {
            if (serialized.isEmpty()) return EMPTY

            val mappings =
                serialized
                    .split(";")
                    .mapNotNull { KeyMapping.parse(it) }

            return KeyMappings(mappings)
        }

        /**
         * Empty mappings (no key mappings configured).
         */
        val EMPTY = KeyMappings(emptyList())
    }
}
