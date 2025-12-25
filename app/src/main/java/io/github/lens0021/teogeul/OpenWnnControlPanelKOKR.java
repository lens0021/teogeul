package io.github.lens0021.teogeul;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class OpenWnnControlPanelKOKR extends PreferenceActivity {

	private List<String> fragmentNames = new ArrayList<String>() {{
		add(InputMethodFragment.class.getName());
		add(HardKeyboardFragment.class.getName());
		add(SystemFragment.class.getName());
		add(AboutFragment.class.getName());
		add(DeveloperFragment.class.getName());
	}};

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(OpenWnnKOKR.getInstance() == null) {
			new OpenWnnKOKR(this);
		}

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

		if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
			addPreferencesFromResource(R.xml.teogeul_pref_ko_method);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_hardkeyboard);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_system);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_about);
			if(prefs.getBoolean("hidden_settings_revealed", false)) {
				addPreferencesFromResource(R.xml.teogeul_pref_ko_developer);
			}
		}

	}

	@TargetApi(11)
	@Override
	public void onBuildHeaders(List<Header> target) {
		if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("reveal_dev_settings", false)) {
			loadHeadersFromResource(R.xml.teogeul_pref_ko_headers_dev, target);
		} else {
			loadHeadersFromResource(R.xml.teogeul_pref_ko_headers, target);
		}
	}

	@TargetApi(11)
	@Override
	protected boolean isValidFragment(String fragmentName) {
		return fragmentNames.contains(fragmentName);
	}

	@TargetApi(11)
	public static class InputMethodFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_method);
		}
	}

	@TargetApi(11)
	public static class HardKeyboardFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_hardkeyboard);
		}
	}

	@TargetApi(11)
	public static class SystemFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_system);
		}
	}

	@TargetApi(11)
	public static class AboutFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_about);
		}
	}

	@TargetApi(11)
	public static class DeveloperFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.teogeul_pref_ko_developer);
		}
	}

}
