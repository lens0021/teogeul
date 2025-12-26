package io.github.lens0021.teogeul.korean

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import io.github.lens0021.teogeul.R
import io.github.lens0021.teogeul.IMEService

class LangKeyActionDialog : Activity() {
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
                IMEService.LANGKEY_SWITCH_KOR_ENG,
                IMEService.LANGKEY_SWITCH_NEXT_METHOD,
                IMEService.LANGKEY_LIST_METHODS,
                IMEService.LANGKEY_OPEN_SETTINGS,
            )
        val builder = AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog)
        builder
            .setTitle(R.string.preference_system_list_actions_title)
            .setItems(labels) { dialog: DialogInterface, which: Int ->
                IMEService.getInstance()?.onLangKey(actions[which])
                dialog.dismiss()
                finish()
            }
            .setOnCancelListener { finish() }
            .show()
    }
}
