package io.github.lens0021.teogeul

import io.github.lens0021.teogeul.data.SettingsSnapshot

interface LetterConverter {
    fun convert(text: ComposingText): Boolean

    fun setPreferences(pref: SettingsSnapshot)
}
