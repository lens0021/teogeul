package io.github.lens0021.teogeul

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.preference.PreferenceManager

class OpenWnnControlPanelKOKR : PreferenceActivity() {
    private val fragmentNames = listOf(
        InputMethodFragment::class.java.name,
        HardKeyboardFragment::class.java.name,
        SystemFragment::class.java.name,
        AboutFragment::class.java.name,
        DeveloperFragment::class.java.name
    )

    @Deprecated("Deprecated in Java")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (OpenWnnKOKR.getInstance() == null) {
            OpenWnnKOKR(this)
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            addPreferencesFromResource(R.xml.teogeul_pref_ko_method)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_hardkeyboard)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_system)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_about)
            if (prefs.getBoolean("hidden_settings_revealed", false)) {
                addPreferencesFromResource(R.xml.teogeul_pref_ko_developer)
            }
        }
    }

    @TargetApi(11)
    override fun onBuildHeaders(target: MutableList<Header>) {
        if (PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("reveal_dev_settings", false)) {
            loadHeadersFromResource(R.xml.teogeul_pref_ko_headers_dev, target)
        } else {
            loadHeadersFromResource(R.xml.teogeul_pref_ko_headers, target)
        }
    }

    @TargetApi(11)
    override fun isValidFragment(fragmentName: String): Boolean {
        return fragmentNames.contains(fragmentName)
    }

    @TargetApi(11)
    class InputMethodFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_method)
        }
    }

    @TargetApi(11)
    class HardKeyboardFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_hardkeyboard)
        }
    }

    @TargetApi(11)
    class SystemFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_system)
        }
    }

    @TargetApi(11)
    class AboutFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_about)
        }
    }

    @TargetApi(11)
    class DeveloperFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.teogeul_pref_ko_developer)
        }
    }
}
