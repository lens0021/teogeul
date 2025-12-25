package io.github.lens0021.teogeul.ui

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.preference.PreferenceManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

    // Developer settings visibility
    private val _isDeveloperSettingsRevealed = MutableStateFlow(prefs.getBoolean("reveal_dev_settings", false))
    val isDeveloperSettingsRevealed: StateFlow<Boolean> = _isDeveloperSettingsRevealed.asStateFlow()

    // Hardware keyboard preferences
    private val _hardwareHangulLayout = MutableStateFlow(prefs.getString("hardware_hangul_layout", "keyboard_sebul_391") ?: "keyboard_sebul_391")
    val hardwareHangulLayout: StateFlow<String> = _hardwareHangulLayout.asStateFlow()

    private val _hardwareAlphabetLayout = MutableStateFlow(prefs.getString("hardware_alphabet_layout", "keyboard_alphabet_qwerty") ?: "keyboard_alphabet_qwerty")
    val hardwareAlphabetLayout: StateFlow<String> = _hardwareAlphabetLayout.asStateFlow()

    private val _hardwareUseMoachigi = MutableStateFlow(prefs.getBoolean("hardware_use_moachigi", true))
    val hardwareUseMoachigi: StateFlow<Boolean> = _hardwareUseMoachigi.asStateFlow()

    private val _hardwareFullMoachigi = MutableStateFlow(prefs.getBoolean("hardware_full_moachigi", true))
    val hardwareFullMoachigi: StateFlow<Boolean> = _hardwareFullMoachigi.asStateFlow()

    private val _hardwareFullMoachingiDelay = MutableStateFlow(prefs.getInt("hardware_full_moachigi_delay", 100))
    val hardwareFullMoachingiDelay: StateFlow<Int> = _hardwareFullMoachingiDelay.asStateFlow()

    private val _hardwareAltDirect = MutableStateFlow(prefs.getBoolean("hardware_alt_direct", true))
    val hardwareAltDirect: StateFlow<Boolean> = _hardwareAltDirect.asStateFlow()

    // System preferences
    private val _systemUseStandardJamo = MutableStateFlow(prefs.getBoolean("system_use_standard_jamo", false))
    val systemUseStandardJamo: StateFlow<Boolean> = _systemUseStandardJamo.asStateFlow()

    private val _systemLangKeyPress = MutableStateFlow(prefs.getString("system_action_on_lang_key_press", "switch_next_method") ?: "switch_next_method")
    val systemLangKeyPress: StateFlow<String> = _systemLangKeyPress.asStateFlow()

    private val _systemLangKeyLongPress = MutableStateFlow(prefs.getString("system_action_on_lang_key_long_press", "list_methods") ?: "list_methods")
    val systemLangKeyLongPress: StateFlow<String> = _systemLangKeyLongPress.asStateFlow()

    private val _systemAltKeyLongPress = MutableStateFlow(prefs.getString("system_action_on_alt_key_long_press", "list_actions") ?: "list_actions")
    val systemAltKeyLongPress: StateFlow<String> = _systemAltKeyLongPress.asStateFlow()

    private val _systemHardwareLangKeyStroke = MutableStateFlow(prefs.getString("system_hardware_lang_key_stroke", "---s62") ?: "---s62")
    val systemHardwareLangKeyStroke: StateFlow<String> = _systemHardwareLangKeyStroke.asStateFlow()

    // Developer preferences
    private val _devUseHangulHard = MutableStateFlow(prefs.getBoolean("keyboard_dev_use_hangul_hard", false))
    val devUseHangulHard: StateFlow<Boolean> = _devUseHangulHard.asStateFlow()

    private val _devHardLayout = MutableStateFlow(prefs.getString("keyboard_dev_hard_layout", "keyboard_nebul_1969") ?: "keyboard_nebul_1969")
    val devHardLayout: StateFlow<String> = _devHardLayout.asStateFlow()

    fun updatePreference(key: String, value: Any) {
        prefs.edit().apply {
            when (value) {
                is Boolean -> {
                    putBoolean(key, value)
                    when (key) {
                        "hardware_use_moachigi" -> _hardwareUseMoachigi.value = value
                        "hardware_full_moachigi" -> _hardwareFullMoachigi.value = value
                        "hardware_alt_direct" -> _hardwareAltDirect.value = value
                        "system_use_standard_jamo" -> _systemUseStandardJamo.value = value
                        "reveal_dev_settings" -> _isDeveloperSettingsRevealed.value = value
                        "keyboard_dev_use_hangul_hard" -> _devUseHangulHard.value = value
                    }
                }
                is String -> {
                    putString(key, value)
                    when (key) {
                        "hardware_hangul_layout" -> _hardwareHangulLayout.value = value
                        "hardware_alphabet_layout" -> _hardwareAlphabetLayout.value = value
                        "system_action_on_lang_key_press" -> _systemLangKeyPress.value = value
                        "system_action_on_lang_key_long_press" -> _systemLangKeyLongPress.value = value
                        "system_action_on_alt_key_long_press" -> _systemAltKeyLongPress.value = value
                        "system_hardware_lang_key_stroke" -> _systemHardwareLangKeyStroke.value = value
                        "keyboard_dev_hard_layout" -> _devHardLayout.value = value
                    }
                }
                is Int -> {
                    putInt(key, value)
                    when (key) {
                        "hardware_full_moachigi_delay" -> _hardwareFullMoachingiDelay.value = value
                    }
                }
            }
            apply()
        }
    }

    fun revealDeveloperSettings() {
        updatePreference("reveal_dev_settings", true)
    }
}
