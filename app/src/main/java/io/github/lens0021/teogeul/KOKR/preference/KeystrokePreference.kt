package io.github.lens0021.teogeul.KOKR.preference

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.TypedArray
import android.os.Build
import android.preference.Preference
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import io.github.lens0021.teogeul.R
import java.util.concurrent.atomic.AtomicInteger

class KeystrokePreference : Preference {
    private var defaultValue: String? = null

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onCreateView(parent: ViewGroup): View {
        return super.onCreateView(parent)
    }

    override fun onClick() {
        val view = View.inflate(context, R.layout.select_keystroke, null)
        val display = view.findViewById<EditText>(R.id.key_display)
        val description = view.findViewById<TextView>(R.id.key_description)
        description.text = summary

        val control = view.findViewById<CheckBox>(R.id.key_control)
        val alt = view.findViewById<CheckBox>(R.id.key_alt)
        val win = view.findViewById<CheckBox>(R.id.key_win)
        val shift = view.findViewById<CheckBox>(R.id.key_shift)
        val code = AtomicInteger(0)

        val stroke = parseKeyStroke(getPersistedString(defaultValue ?: "----0"))
        control.isChecked = stroke.control
        alt.isChecked = stroke.alt
        win.isChecked = stroke.win
        shift.isChecked = stroke.shift
        code.set(stroke.keyCode)
        if (Build.VERSION.SDK_INT >= 12) {
            display.setText(KeyEvent.keyCodeToString(stroke.keyCode))
        } else {
            display.setText(stroke.keyCode.toString())
        }

        val dialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setView(view)
            .setOnKeyListener { _: DialogInterface, keyCode: Int, _: KeyEvent ->
                code.set(keyCode)
                if (Build.VERSION.SDK_INT >= 12) {
                    display.setText(KeyEvent.keyCodeToString(keyCode))
                } else {
                    display.setText(keyCode.toString())
                }
                false
            }
            .setPositiveButton(R.string.dialog_button_ok) { _: DialogInterface, _: Int ->
                val builder = StringBuilder()
                builder.append(if (control.isChecked) 'c' else '-')
                builder.append(if (alt.isChecked) 'a' else '-')
                builder.append(if (win.isChecked) 'w' else '-')
                builder.append(if (shift.isChecked) 's' else '-')
                builder.append(code.get().toString())
                persistString(builder.toString())
            }
            .setNegativeButton(R.string.dialog_button_cancel) { _: DialogInterface, _: Int ->
            }
            .create()
        dialog.show()
        super.onClick()
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any? {
        return a.getString(index)
    }

    override fun onSetInitialValue(restorePersistedValue: Boolean, defaultValue: Any?) {
        super.onSetInitialValue(restorePersistedValue, defaultValue)
        if (!restorePersistedValue) {
            this.defaultValue = defaultValue as? String
        }
    }

    data class KeyStroke(
        val control: Boolean,
        val alt: Boolean,
        val win: Boolean,
        val shift: Boolean,
        val keyCode: Int
    )

    companion object {
        @JvmStatic
        fun parseKeyStroke(keyStrokeStr: String): KeyStroke {
            val keyCode = keyStrokeStr.substring(4).toInt()
            val control = keyStrokeStr[0] == 'c'
            val alt = keyStrokeStr[1] == 'a'
            val win = keyStrokeStr[2] == 'w'
            val shift = keyStrokeStr[3] == 's'
            return KeyStroke(control, alt, win, shift, keyCode)
        }
    }
}
