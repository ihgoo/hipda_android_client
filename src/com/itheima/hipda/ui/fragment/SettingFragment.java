package com.itheima.hipda.ui.fragment;

import com.itheima.hipda.R;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
	}
	
	
	
	
}
