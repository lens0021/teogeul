package io.github.lens0021.teogeul.config

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object SettingsDefaults {
    const val HARDWARE_HANGUL_LAYOUT = "keyboard_sebul_391"
    const val HARDWARE_ALPHABET_LAYOUT = "keyboard_alphabet_qwerty"
    const val HARDWARE_USE_MOACHIGI = true
    const val HARDWARE_FULL_MOACHIGI = true
    const val HARDWARE_FULL_MOACHIGI_DELAY = 100
    const val HARDWARE_ENABLE_DVORAK = true
    const val SYSTEM_USE_STANDARD_JAMO = false
    const val SYSTEM_START_HANGUL_MODE = SettingsValues.START_HANGUL_MODE_KEEP_LAST
    const val SYSTEM_HARDWARE_LANG_KEY_STROKE = "218" // KeyEvent.KEYCODE_KANA
}

object SettingsValues {
    const val START_HANGUL_MODE_KEEP_LAST = "keep_last"
    const val START_HANGUL_MODE_START_HANGUL = "start_hangul"
    const val START_HANGUL_MODE_START_ENGLISH = "start_english"
}

object SettingsKeys {
    val hardwareHangulLayout = stringPreferencesKey("hardware_hangul_layout")
    val hardwareAlphabetLayout = stringPreferencesKey("hardware_alphabet_layout")
    val hardwareUseMoachigi = booleanPreferencesKey("hardware_use_moachigi")
    val hardwareFullMoachigi = booleanPreferencesKey("hardware_full_moachigi")
    val hardwareFullMoachigiDelay = intPreferencesKey("hardware_full_moachigi_delay")
    val hardwareEnableDvorak = booleanPreferencesKey("hardware_enable_dvorak")
    val systemUseStandardJamo = booleanPreferencesKey("system_use_standard_jamo")
    val systemStartHangulMode = stringPreferencesKey("system_start_hangul_mode")
    val systemHardwareLangKeyStroke = stringPreferencesKey("system_hardware_lang_key_stroke")
}

data class SettingsSnapshot(
    val hardwareHangulLayout: String,
    val hardwareAlphabetLayout: String,
    val hardwareUseMoachigi: Boolean,
    val hardwareFullMoachigi: Boolean,
    val hardwareFullMoachigiDelay: Int,
    val hardwareEnableDvorak: Boolean,
    val systemUseStandardJamo: Boolean,
    val systemStartHangulMode: String,
    val systemHardwareLangKeyStroke: String,
)
