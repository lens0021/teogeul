package io.github.lens0021.teogeul

import android.content.SharedPreferences

interface LetterConverter {
    fun convert(text: ComposingText): Boolean

    fun setPreferences(pref: SharedPreferences)
}
