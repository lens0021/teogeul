package io.github.lens0021.teogeul.KOKR

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import io.github.lens0021.teogeul.OpenWnnKOKR
import io.github.lens0021.teogeul.R

class ListLangKeyActionDialogActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val labels = arrayOf(
            resources.getString(R.string.preference_system_switch_kor_eng),
            resources.getString(R.string.preference_system_switch_next_method),
            resources.getString(R.string.preference_system_list_methods),
            resources.getString(R.string.preference_system_open_settings)
        )
        val actions = arrayOf(
            OpenWnnKOKR.LANGKEY_SWITCH_KOR_ENG,
            OpenWnnKOKR.LANGKEY_SWITCH_NEXT_METHOD,
            OpenWnnKOKR.LANGKEY_LIST_METHODS,
            OpenWnnKOKR.LANGKEY_OPEN_SETTINGS
        )
        val builder = when {
            Build.VERSION.SDK_INT >= 21 -> AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog)
            Build.VERSION.SDK_INT >= 11 -> AlertDialog.Builder(this, android.R.style.Theme_Dialog)
            else -> AlertDialog.Builder(this)
        }
        builder
            .setTitle(R.string.preference_system_list_actions_title)
            .setItems(labels) { dialog: DialogInterface, which: Int ->
                OpenWnnKOKR.getInstance()?.onLangKey(actions[which])
                dialog.dismiss()
                finish()
            }
            .setOnCancelListener { finish() }
            .show()
    }
}
