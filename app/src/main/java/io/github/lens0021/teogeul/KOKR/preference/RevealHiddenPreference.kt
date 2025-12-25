package io.github.lens0021.teogeul.KOKR.preference

import android.content.Context
import android.preference.Preference
import android.util.AttributeSet
import android.widget.Toast
import io.github.lens0021.teogeul.R

class RevealHiddenPreference(context: Context, attrs: AttributeSet?) : Preference(context, attrs) {
    companion object {
        const val REVEAL = 10
        const val ALERT = 7
    }

    private val localContext: Context = context
    private var clickCount = 0
    private var showingToast: Toast? = null

    override fun onClick() {
        clickCount++
        if (clickCount >= REVEAL) {
            persistBoolean(true)
        } else if (clickCount >= ALERT) {
            val message = String.format(
                localContext.getString(R.string.preference_reveal_hidden_msg),
                REVEAL - clickCount
            )
            showingToast?.cancel()
            showingToast = Toast.makeText(localContext, message, Toast.LENGTH_SHORT)
            showingToast?.show()
        }
        super.onClick()
    }
}
