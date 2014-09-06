package com.itheima.hipda.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itheima.hipda.MainActivity;
import com.itheima.hipda.R;
import com.itheima.hipda.adapter.LeftAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

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

	@OnItemClick(R.id.left_drawer)
	public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong){
		System.out.println(paramInt);
		switch (paramInt) {
		case 0:

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:// 设置
			((MainActivity)getActivity()).switchFragment(new SettingFragment());
			break;
		case 8: 
			
			break;
		case 9:

			break;
		}
		
		
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_left_menu, null);
		ViewUtils.inject(this, view);
		return view;
	}

	

	

	
	
	

}
