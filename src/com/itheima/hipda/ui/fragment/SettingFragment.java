package com.itheima.hipda.ui.fragment;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

import com.itheima.hipda.R;
import com.itheima.hipda.bean.SettingHelper;

public class SettingFragment extends PreferenceFragment {

	private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {

		 public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
		    {
		      String str = paramObject.toString();
		      CharSequence localCharSequence;
		      if ((paramPreference instanceof ListPreference))
		      {
		        ListPreference localListPreference = (ListPreference)paramPreference;
		        int i = localListPreference.findIndexOfValue(str);
		        if (i >= 0)
		        {
		          localCharSequence = localListPreference.getEntries()[i];
		          paramPreference.setSummary(localCharSequence);
		        }
		      }
		    
		        paramPreference.setSummary(str);
		      return true;
		    }
	};


	private static void bindPreferenceSummaryToValue(Preference paramPreference) {
		paramPreference
				.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
		if ((paramPreference instanceof CheckBoxPreference)) {
			sBindPreferenceSummaryToValueListener.onPreferenceChange(
					paramPreference, Boolean.valueOf(PreferenceManager
							.getDefaultSharedPreferences(
									paramPreference.getContext()).getBoolean(
									paramPreference.getKey(), false)));
			return;
		}
		if ((paramPreference instanceof SwitchPreference)) {
			sBindPreferenceSummaryToValueListener.onPreferenceChange(
					paramPreference, Boolean.valueOf(PreferenceManager
							.getDefaultSharedPreferences(
									paramPreference.getContext()).getBoolean(
									paramPreference.getKey(), false)));
			return;
		}
		sBindPreferenceSummaryToValueListener.onPreferenceChange(
				paramPreference,
				PreferenceManager.getDefaultSharedPreferences(
						paramPreference.getContext()).getString(
						paramPreference.getKey(), ""));
	}

	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
//		getActivity().getActionBar().setNavigationMode(0);
//		getActivity().getActionBar().setTitle(2131296298);
//		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		addPreferencesFromResource(R.xml.preference);
		bindPreferenceSummaryToValue(findPreference("PERF_USERNAME"));
		bindPreferenceSummaryToValue(findPreference("PERF_SECQUESTION"));
		bindPreferenceSummaryToValue(findPreference("PERF_TAILTEXT"));
		bindPreferenceSummaryToValue(findPreference("PERF_TAILURL"));
		bindPreferenceSummaryToValue(findPreference("PERF_BLANKLIST_USERNAMES"));
		bindPreferenceSummaryToValue(findPreference("PERF_TEXTSIZE_POST_ADJ"));
	}

	public void onStop() {
//		SettingHelper.getInstance().reload();
		super.onStop();
	}

}
