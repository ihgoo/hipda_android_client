package com.itheima.hipda.net;

import com.android.volley.Response.Listener;
import com.itheima.hipda.utils.BBSAPI;

public class AutoLogin {
	public void login(){
		new StringRequestProxy(BBSAPI.HIPDA_LOGIN, new Listener<String>() {

			
			@Override
			public void onResponse(String ret) {
				
			}
		}, null);
	}
}
