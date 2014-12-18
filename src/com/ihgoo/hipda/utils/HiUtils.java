package com.ihgoo.hipda.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ihgoo.hipda.bean.SettingHelper;

public class HiUtils {

	public static int getForumID(Context paramContext, long paramLong) {
		return paramContext.getResources().getIntArray(2131165186)[((int) paramLong)];
	}

	public static String getFullUrl(String paramString) {
		return "http://www.hi-pda.com/forum/" + paramString;
	}

	public static Boolean isAutoLoadImg(Context paramContext) {
		if (SettingHelper.getInstance().isLoadImgOnMobileNwk()) {
			return Boolean.valueOf(true);
		}
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getActiveNetworkInfo();
		if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())
				|| (localNetworkInfo.getType() != 1)) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}
}
