package com.itheima.hipda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.itheima.hipda.ui.fragment.MenuFragment;
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
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

		MenuFragment menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu, menuFragment).commit();
	}

	/**
	 * ChangeFragment
	 * 
	 * @param fragment
	 */
	public void switchFragment(Fragment fragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content, fragment).commit();
		// 设置滑动菜单的开关，如果是开了就关，如果是关了就开
		sm.toggle();
	}

}
