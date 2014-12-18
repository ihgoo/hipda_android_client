package com.ihgoo.hipda.net;

import org.apache.commons.lang3.StringUtils;

import com.ihgoo.hipda.GloableParams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * 网络判断工具
 * @author Administrator
 *
 */
public class NetUtils {
	
	/**
	 * 检查是否链接网络
	 * @return
	 */
	public static boolean checkNet(Context context){
		//无线局域网
		boolean isWlan = isWlanConnection(context);
		
		//通过基站链接网络
		boolean isAPN = isAPNConnection(context);
		
		//得到用户通过基站链接是  wap(有网关)方式、 还是net方式
		if(isAPN){
			String ip = android.net.Proxy.getDefaultHost();
			if(StringUtils.isNotBlank(ip)){
				GloableParams.isWap = true;
			}
		}
		
		return isWlan || isAPN;
	}

	/**
	 * 是否通过基站链接网络
	 * @param context 
	 * @return
	 */
	private static boolean isAPNConnection(Context context) {
		return getIsConnectionByType(context, ConnectivityManager.TYPE_MOBILE);
	}

	/**
	 * 是否通过 wlan 链接网络
	 * @param context 
	 * @return
	 */
	private static boolean isWlanConnection(Context context) {
		return getIsConnectionByType(context, ConnectivityManager.TYPE_WIFI);
	}
	
	/**
	 * 检查指定类型的网络是否链接
	 * @param context
	 * @return
	 */
	private static boolean getIsConnectionByType(Context context, int type){
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(type);
		return networkInfo!=null;
	}
	

}
