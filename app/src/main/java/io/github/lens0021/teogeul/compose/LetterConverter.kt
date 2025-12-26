package io.github.lens0021.teogeul.compose

import io.github.lens0021.teogeul.config.SettingsSnapshot

interface LetterConverter {
    fun convert(text: ComposingText): Boolean

    fun setPreferences(pref: SettingsSnapshot)
}
