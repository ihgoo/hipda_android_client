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

		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//设置滑动菜单的阴影
		sm.setShadowDrawable(R.drawable.shadow);
		//设置滑动菜单阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);
		
		
		
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
		// 设置滑动菜单的开关
		sm.toggle();
	}

}
