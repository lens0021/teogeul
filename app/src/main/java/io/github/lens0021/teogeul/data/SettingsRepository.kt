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
    const val HARDWARE_HANGUL_LAYOUT = "keyboard_sebul_391"
    const val HARDWARE_ALPHABET_LAYOUT = "keyboard_alphabet_qwerty"
    const val HARDWARE_USE_MOACHIGI = true
    const val HARDWARE_FULL_MOACHIGI = true
    const val HARDWARE_FULL_MOACHIGI_DELAY = 100
    const val HARDWARE_ENABLE_DVORAK = true
    const val SYSTEM_USE_STANDARD_JAMO = false
    const val SYSTEM_START_HANGUL_MODE = SettingsValues.START_HANGUL_MODE_KEEP_LAST
    const val SYSTEM_HARDWARE_LANG_KEY_STROKE = "----218" // KeyEvent.KEYCODE_KANA
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

class SettingsRepository(
    private val dataStore: DataStore<Preferences>,
) {
    val hardwareHangulLayout: Flow<String> =
        dataStore.data.map {
            it[SettingsKeys.hardwareHangulLayout] ?: SettingsDefaults.HARDWARE_HANGUL_LAYOUT
        }

    val hardwareAlphabetLayout: Flow<String> =
        dataStore.data.map {
            it[SettingsKeys.hardwareAlphabetLayout] ?: SettingsDefaults.HARDWARE_ALPHABET_LAYOUT
        }

    val hardwareUseMoachigi: Flow<Boolean> =
        dataStore.data.map {
            it[SettingsKeys.hardwareUseMoachigi] ?: SettingsDefaults.HARDWARE_USE_MOACHIGI
        }

    val hardwareFullMoachigi: Flow<Boolean> =
        dataStore.data.map {
            it[SettingsKeys.hardwareFullMoachigi] ?: SettingsDefaults.HARDWARE_FULL_MOACHIGI
        }

    val hardwareFullMoachigiDelay: Flow<Int> =
        dataStore.data.map {
            it[SettingsKeys.hardwareFullMoachigiDelay]
                ?: SettingsDefaults.HARDWARE_FULL_MOACHIGI_DELAY
        }

    val hardwareEnableDvorak: Flow<Boolean> =
        dataStore.data.map {
            it[SettingsKeys.hardwareEnableDvorak] ?: SettingsDefaults.HARDWARE_ENABLE_DVORAK
        }

    val systemUseStandardJamo: Flow<Boolean> =
        dataStore.data.map {
            it[SettingsKeys.systemUseStandardJamo] ?: SettingsDefaults.SYSTEM_USE_STANDARD_JAMO
        }

    val systemStartHangulMode: Flow<String> =
        dataStore.data.map {
            it[SettingsKeys.systemStartHangulMode] ?: SettingsDefaults.SYSTEM_START_HANGUL_MODE
        }

    val systemHardwareLangKeyStroke: Flow<String> =
        dataStore.data.map {
            it[SettingsKeys.systemHardwareLangKeyStroke]
                ?: SettingsDefaults.SYSTEM_HARDWARE_LANG_KEY_STROKE
        }

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
            hardwareHangulLayout =
                prefs[SettingsKeys.hardwareHangulLayout]
                    ?: SettingsDefaults.HARDWARE_HANGUL_LAYOUT,
            hardwareAlphabetLayout =
                prefs[SettingsKeys.hardwareAlphabetLayout]
                    ?: SettingsDefaults.HARDWARE_ALPHABET_LAYOUT,
            hardwareUseMoachigi =
                prefs[SettingsKeys.hardwareUseMoachigi]
                    ?: SettingsDefaults.HARDWARE_USE_MOACHIGI,
            hardwareFullMoachigi =
                prefs[SettingsKeys.hardwareFullMoachigi]
                    ?: SettingsDefaults.HARDWARE_FULL_MOACHIGI,
            hardwareFullMoachigiDelay =
                prefs[SettingsKeys.hardwareFullMoachigiDelay]
                    ?: SettingsDefaults.HARDWARE_FULL_MOACHIGI_DELAY,
            hardwareEnableDvorak =
                prefs[SettingsKeys.hardwareEnableDvorak]
                    ?: SettingsDefaults.HARDWARE_ENABLE_DVORAK,
            systemUseStandardJamo =
                prefs[SettingsKeys.systemUseStandardJamo]
                    ?: SettingsDefaults.SYSTEM_USE_STANDARD_JAMO,
            systemStartHangulMode =
                prefs[SettingsKeys.systemStartHangulMode]
                    ?: SettingsDefaults.SYSTEM_START_HANGUL_MODE,
            systemHardwareLangKeyStroke =
                prefs[SettingsKeys.systemHardwareLangKeyStroke]
                    ?: SettingsDefaults.SYSTEM_HARDWARE_LANG_KEY_STROKE,
        )
    }
}
