package io.github.lens0021.teogeul.KOKR.preference

import android.app.Service
import android.content.Context
import android.preference.Preference
import android.util.AttributeSet
import android.view.inputmethod.InputMethodManager

class PickInputMethodPreference(context: Context, attrs: AttributeSet?) : Preference(context, attrs) {
    private val localContext: Context = context

    override fun onClick() {
        val inputMethodManager = localContext.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showInputMethodPicker()
    }
}
