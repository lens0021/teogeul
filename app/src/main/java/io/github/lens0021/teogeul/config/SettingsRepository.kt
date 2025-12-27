package io.github.lens0021.teogeul.config

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

    val systemKeyMappings: Flow<String> =
        dataStore.data.map {
            it[SettingsKeys.systemKeyMappings] ?: SettingsDefaults.SYSTEM_KEY_MAPPINGS
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
            systemKeyMappings =
                prefs[SettingsKeys.systemKeyMappings]
                    ?: SettingsDefaults.SYSTEM_KEY_MAPPINGS,
        )
    }
}
