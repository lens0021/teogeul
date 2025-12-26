package io.github.lens0021.teogeul.KOKR

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import io.github.lens0021.teogeul.R
import io.github.lens0021.teogeul.TeogeulKOKR

class ListLangKeyActionDialogActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val labels =
            arrayOf(
                resources.getString(R.string.preference_system_switch_kor_eng),
                resources.getString(R.string.preference_system_switch_next_method),
                resources.getString(R.string.preference_system_list_methods),
                resources.getString(R.string.preference_system_open_settings),
            )
        val actions =
            arrayOf(
                TeogeulKOKR.LANGKEY_SWITCH_KOR_ENG,
                TeogeulKOKR.LANGKEY_SWITCH_NEXT_METHOD,
                TeogeulKOKR.LANGKEY_LIST_METHODS,
                TeogeulKOKR.LANGKEY_OPEN_SETTINGS,
            )
        val builder = AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog)
        builder
            .setTitle(R.string.preference_system_list_actions_title)
            .setItems(labels) { dialog: DialogInterface, which: Int ->
                TeogeulKOKR.getInstance()?.onLangKey(actions[which])
                dialog.dismiss()
                finish()
            }
            .setOnCancelListener { finish() }
            .show()
    }
}
