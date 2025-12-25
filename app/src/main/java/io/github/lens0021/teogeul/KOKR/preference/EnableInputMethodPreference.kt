package io.github.lens0021.teogeul.KOKR.preference

import android.content.Context
import android.content.Intent
import android.preference.Preference
import android.provider.Settings
import android.util.AttributeSet

class EnableInputMethodPreference(context: Context, attrs: AttributeSet?) : Preference(context, attrs) {
    private val localContext: Context = context

    override fun onClick() {
        localContext.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
    }
}
