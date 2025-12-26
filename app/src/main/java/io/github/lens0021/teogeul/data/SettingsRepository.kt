package io.github.lens0021.teogeul.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object SettingsDefaults {
    const val hardwareHangulLayout = "keyboard_sebul_391"
    const val hardwareAlphabetLayout = "keyboard_alphabet_qwerty"
    const val hardwareUseMoachigi = true
    const val hardwareFullMoachigi = true
    const val hardwareFullMoachigiDelay = 100
    const val hardwareEnableDvorak = true
    const val systemUseStandardJamo = false
    const val systemStartHangulMode = SettingsValues.startHangulModeKeepLast
    const val systemLangKeyPress = "switch_next_method"
    const val systemLangKeyLongPress = "list_methods"
    const val systemAltKeyLongPress = "list_actions"
    const val systemHardwareLangKeyStroke = "----218" // KeyEvent.KEYCODE_KANA (no modifiers)
}

object SettingsValues {
    const val startHangulModeKeepLast = "keep_last"
    const val startHangulModeStartHangul = "start_hangul"
    const val startHangulModeStartEnglish = "start_english"
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
    val systemLangKeyPress = stringPreferencesKey("system_action_on_lang_key_press")
    val systemLangKeyLongPress = stringPreferencesKey("system_action_on_lang_key_long_press")
    val systemAltKeyLongPress = stringPreferencesKey("system_action_on_alt_key_long_press")
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
    val systemLangKeyPress: String,
    val systemLangKeyLongPress: String,
    val systemAltKeyLongPress: String,
    val systemHardwareLangKeyStroke: String,
)

class SettingsRepository(
    private val dataStore: DataStore<Preferences>,
) {
    val hardwareHangulLayout: Flow<String> =
        dataStore.data.map { it[SettingsKeys.hardwareHangulLayout] ?: SettingsDefaults.hardwareHangulLayout }

    val hardwareAlphabetLayout: Flow<String> =
        dataStore.data.map { it[SettingsKeys.hardwareAlphabetLayout] ?: SettingsDefaults.hardwareAlphabetLayout }

    val hardwareUseMoachigi: Flow<Boolean> =
        dataStore.data.map { it[SettingsKeys.hardwareUseMoachigi] ?: SettingsDefaults.hardwareUseMoachigi }

    val hardwareFullMoachigi: Flow<Boolean> =
        dataStore.data.map { it[SettingsKeys.hardwareFullMoachigi] ?: SettingsDefaults.hardwareFullMoachigi }

    val hardwareFullMoachigiDelay: Flow<Int> =
        dataStore.data.map { it[SettingsKeys.hardwareFullMoachigiDelay] ?: SettingsDefaults.hardwareFullMoachigiDelay }

    val hardwareEnableDvorak: Flow<Boolean> =
        dataStore.data.map { it[SettingsKeys.hardwareEnableDvorak] ?: SettingsDefaults.hardwareEnableDvorak }

    val systemUseStandardJamo: Flow<Boolean> =
        dataStore.data.map { it[SettingsKeys.systemUseStandardJamo] ?: SettingsDefaults.systemUseStandardJamo }

    val systemStartHangulMode: Flow<String> =
        dataStore.data.map { it[SettingsKeys.systemStartHangulMode] ?: SettingsDefaults.systemStartHangulMode }

    val systemLangKeyPress: Flow<String> =
        dataStore.data.map { it[SettingsKeys.systemLangKeyPress] ?: SettingsDefaults.systemLangKeyPress }

    val systemLangKeyLongPress: Flow<String> =
        dataStore.data.map { it[SettingsKeys.systemLangKeyLongPress] ?: SettingsDefaults.systemLangKeyLongPress }

    val systemAltKeyLongPress: Flow<String> =
        dataStore.data.map { it[SettingsKeys.systemAltKeyLongPress] ?: SettingsDefaults.systemAltKeyLongPress }

    val systemHardwareLangKeyStroke: Flow<String> =
        dataStore.data.map { it[SettingsKeys.systemHardwareLangKeyStroke] ?: SettingsDefaults.systemHardwareLangKeyStroke }

    suspend fun updateBoolean(
        key: Preferences.Key<Boolean>,
        value: Boolean,
    ) {
        dataStore.edit { it[key] = value }
    }

    suspend fun updateInt(
        key: Preferences.Key<Int>,
        value: Int,
    ) {
        dataStore.edit { it[key] = value }
    }

    suspend fun updateString(
        key: Preferences.Key<String>,
        value: String,
    ) {
        dataStore.edit { it[key] = value }
    }

    suspend fun snapshot(): SettingsSnapshot {
        val prefs = dataStore.data.first()
        return SettingsSnapshot(
            hardwareHangulLayout = prefs[SettingsKeys.hardwareHangulLayout] ?: SettingsDefaults.hardwareHangulLayout,
            hardwareAlphabetLayout = prefs[SettingsKeys.hardwareAlphabetLayout] ?: SettingsDefaults.hardwareAlphabetLayout,
            hardwareUseMoachigi = prefs[SettingsKeys.hardwareUseMoachigi] ?: SettingsDefaults.hardwareUseMoachigi,
            hardwareFullMoachigi = prefs[SettingsKeys.hardwareFullMoachigi] ?: SettingsDefaults.hardwareFullMoachigi,
            hardwareFullMoachigiDelay =
                prefs[SettingsKeys.hardwareFullMoachigiDelay] ?: SettingsDefaults.hardwareFullMoachigiDelay,
            hardwareEnableDvorak = prefs[SettingsKeys.hardwareEnableDvorak] ?: SettingsDefaults.hardwareEnableDvorak,
            systemUseStandardJamo = prefs[SettingsKeys.systemUseStandardJamo] ?: SettingsDefaults.systemUseStandardJamo,
            systemStartHangulMode =
                prefs[SettingsKeys.systemStartHangulMode] ?: SettingsDefaults.systemStartHangulMode,
            systemLangKeyPress = prefs[SettingsKeys.systemLangKeyPress] ?: SettingsDefaults.systemLangKeyPress,
            systemLangKeyLongPress = prefs[SettingsKeys.systemLangKeyLongPress] ?: SettingsDefaults.systemLangKeyLongPress,
            systemAltKeyLongPress = prefs[SettingsKeys.systemAltKeyLongPress] ?: SettingsDefaults.systemAltKeyLongPress,
            systemHardwareLangKeyStroke =
                prefs[SettingsKeys.systemHardwareLangKeyStroke] ?: SettingsDefaults.systemHardwareLangKeyStroke,
        )
    }
}
