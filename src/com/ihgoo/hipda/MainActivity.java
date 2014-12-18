package com.ihgoo.hipda;

import android.os.Bundle;
import android.view.Window;

import com.ihgoo.hipda.ui.fragment.MenuFragment;
import com.itheima.hipda.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu sm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.content_fragemnt);
		setBehindContentView(R.layout.menu_fragment);

		
		
		// init slidingMenu
		sm = this.getSlidingMenu();
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setMode(SlidingMenu.LEFT);

		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//设置滑动菜单的阴影
		sm.setShadowDrawable(R.drawable.shadow);
		//设置滑动菜单阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);
		
		
		
		MenuFragment menuFragment = new MenuFragment();
		getFragmentManager().beginTransaction()
				.replace(R.id.menu, menuFragment).commit();
	}

	
	
	/**
	 * ChangeFragment
	 * 
	 * @param fragment
	 */
	public void switchFragment(android.app.Fragment fragment) {
		getFragmentManager().beginTransaction()
				.replace(R.id.content, fragment).commit();
		// 设置滑动菜单的开关
		sm.toggle();
	}
	
	/**
	 * addFragment
	 * 
	 * @param fragment
	 */
	public void addFragment(android.app.Fragment fragment) {
		getFragmentManager().beginTransaction()
				.add(R.id.content, fragment).commit();
		// 设置滑动菜单的开关
		sm.toggle();
	}
	
	

}
