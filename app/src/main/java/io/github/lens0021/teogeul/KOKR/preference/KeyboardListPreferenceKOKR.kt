package io.github.lens0021.teogeul.KOKR.preference

import android.content.Context
import android.preference.ListPreference
import android.util.AttributeSet

class KeyboardListPreferenceKOKR : ListPreference {
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context) : this(context, null)
}
