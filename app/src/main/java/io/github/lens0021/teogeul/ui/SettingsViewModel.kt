package io.github.lens0021.teogeul.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import io.github.lens0021.teogeul.data.SettingsDefaults
import io.github.lens0021.teogeul.data.SettingsKeys
import io.github.lens0021.teogeul.data.SettingsRepository
import io.github.lens0021.teogeul.data.settingsDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SettingsRepository(application.settingsDataStore)

    // Hardware keyboard preferences
    val hardwareHangulLayout: StateFlow<String> =
        repository.hardwareHangulLayout.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareHangulLayout,
        )

    val hardwareAlphabetLayout: StateFlow<String> =
        repository.hardwareAlphabetLayout.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareAlphabetLayout,
        )

    val hardwareUseMoachigi: StateFlow<Boolean> =
        repository.hardwareUseMoachigi.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareUseMoachigi,
        )

    val hardwareFullMoachigi: StateFlow<Boolean> =
        repository.hardwareFullMoachigi.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareFullMoachigi,
        )

    val hardwareFullMoachingiDelay: StateFlow<Int> =
        repository.hardwareFullMoachigiDelay.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareFullMoachigiDelay,
        )

    val hardwareAltDirect: StateFlow<Boolean> =
        repository.hardwareAltDirect.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.hardwareAltDirect,
        )

    // System preferences
    val systemUseStandardJamo: StateFlow<Boolean> =
        repository.systemUseStandardJamo.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.systemUseStandardJamo,
        )

    val systemLangKeyPress: StateFlow<String> =
        repository.systemLangKeyPress.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.systemLangKeyPress,
        )

    val systemLangKeyLongPress: StateFlow<String> =
        repository.systemLangKeyLongPress.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.systemLangKeyLongPress,
        )

    val systemAltKeyLongPress: StateFlow<String> =
        repository.systemAltKeyLongPress.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.systemAltKeyLongPress,
        )

    val systemHardwareLangKeyStroke: StateFlow<String> =
        repository.systemHardwareLangKeyStroke.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            SettingsDefaults.systemHardwareLangKeyStroke,
        )

    fun updatePreference(
        key: String,
        value: Any,
    ) {
        viewModelScope.launch {
            when (value) {
                is Boolean ->
                    when (key) {
                        "hardware_use_moachigi" -> repository.updateBoolean(SettingsKeys.hardwareUseMoachigi, value)
                        "hardware_full_moachigi" -> repository.updateBoolean(SettingsKeys.hardwareFullMoachigi, value)
                        "hardware_alt_direct" -> repository.updateBoolean(SettingsKeys.hardwareAltDirect, value)
                        "system_use_standard_jamo" -> repository.updateBoolean(SettingsKeys.systemUseStandardJamo, value)
                        else -> Unit
                    }
                is String ->
                    when (key) {
                        "hardware_hangul_layout" -> repository.updateString(SettingsKeys.hardwareHangulLayout, value)
                        "hardware_alphabet_layout" -> repository.updateString(SettingsKeys.hardwareAlphabetLayout, value)
                        "system_action_on_lang_key_press" -> repository.updateString(SettingsKeys.systemLangKeyPress, value)
                        "system_action_on_lang_key_long_press" ->
                            repository.updateString(SettingsKeys.systemLangKeyLongPress, value)
                        "system_action_on_alt_key_long_press" ->
                            repository.updateString(SettingsKeys.systemAltKeyLongPress, value)
                        "system_hardware_lang_key_stroke" ->
                            repository.updateString(SettingsKeys.systemHardwareLangKeyStroke, value)
                        else -> Unit
                    }
                is Int ->
                    when (key) {
                        "hardware_full_moachigi_delay" ->
                            repository.updateInt(SettingsKeys.hardwareFullMoachigiDelay, value)
                        else -> Unit
                    }
                else -> Unit
            }
        }
    }
}
