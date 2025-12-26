package io.github.lens0021.teogeul.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.lens0021.teogeul.data.SettingsDefaults
import io.github.lens0021.teogeul.data.SettingsKeys
import io.github.lens0021.teogeul.data.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
    @Inject
    constructor(
        private val repository: SettingsRepository,
    ) : ViewModel() {
        // Hardware keyboard preferences
        val hardwareHangulLayout: StateFlow<String> =
            repository.hardwareHangulLayout.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.HARDWARE_HANGUL_LAYOUT,
            )

        val hardwareAlphabetLayout: StateFlow<String> =
            repository.hardwareAlphabetLayout.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.HARDWARE_ALPHABET_LAYOUT,
            )

        val hardwareUseMoachigi: StateFlow<Boolean> =
            repository.hardwareUseMoachigi.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.HARDWARE_USE_MOACHIGI,
            )

        val hardwareFullMoachigi: StateFlow<Boolean> =
            repository.hardwareFullMoachigi.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.HARDWARE_FULL_MOACHIGI,
            )

        val hardwareFullMoachingiDelay: StateFlow<Int> =
            repository.hardwareFullMoachigiDelay.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.HARDWARE_FULL_MOACHIGI_DELAY,
            )

        // System preferences
        val systemUseStandardJamo: StateFlow<Boolean> =
            repository.systemUseStandardJamo.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.SYSTEM_USE_STANDARD_JAMO,
            )

        val systemStartHangulMode: StateFlow<String> =
            repository.systemStartHangulMode.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.SYSTEM_START_HANGUL_MODE,
            )

        val systemHardwareLangKeyStroke: StateFlow<String> =
            repository.systemHardwareLangKeyStroke.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                SettingsDefaults.SYSTEM_HARDWARE_LANG_KEY_STROKE,
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
                            "hardware_full_moachigi" ->
                                repository.updateBoolean(
                                    SettingsKeys.hardwareFullMoachigi,
                                    value,
                                )
                            "system_use_standard_jamo" ->
                                repository.updateBoolean(
                                    SettingsKeys.systemUseStandardJamo,
                                    value,
                                )
                            else -> Unit
                        }
                    is String ->
                        when (key) {
                            "hardware_hangul_layout" ->
                                repository.updateString(
                                    SettingsKeys.hardwareHangulLayout,
                                    value,
                                )
                            "system_start_hangul_mode" ->
                                repository.updateString(SettingsKeys.systemStartHangulMode, value)
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
