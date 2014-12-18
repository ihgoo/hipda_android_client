package com.ihgoo.hipda.net;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.ihgoo.hipda.bean.SettingHelper;

/**
 * 自定义的volley请求
 * @author KelvinHu
 *
 */
public class StringRequestProxy extends StringRequest {


	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		try {
			// 设置编码
			String string = new String(response.data, "gbk");
			return Response.success(string, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return super.parseNetworkResponse(response);
	}

	public StringRequestProxy(String url, Listener<String> listener,
			ErrorListener errorListener) {
		super(url, listener, errorListener);
	}
	
	
	
	public StringRequestProxy(int method, String url, Listener<String> listener, ErrorListener errorListener){
		super(method, url, listener, errorListener);
	}
	

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> map = new HashMap<String, String>();
        map.put("Cookie", "cdb_auth=" + SettingHelper.getInstance().getCookieAuth());
		return map;
	}


}
