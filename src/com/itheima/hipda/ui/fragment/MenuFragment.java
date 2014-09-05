package com.itheima.hipda.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.itheima.hipda.R;
import com.itheima.hipda.adapter.LeftAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MenuFragment extends Fragment {

	@ViewInject(R.id.left_drawer)
	private ListView left_drawer;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LeftAdapter adapter = new LeftAdapter(getActivity(), R.layout.item_drawer, getResources().getStringArray(R.array.left_menu));
		left_drawer.setAdapter(adapter);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_left_menu, null);
		ViewUtils.inject(this, view);
		return view;
	}

	

	

	
	
	

}
