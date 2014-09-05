package com.itheima.hipda.ui.fragment;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.itheima.hipda.ApplicationController;
import com.itheima.hipda.R;
import com.itheima.hipda.net.StringRequestCookie;
import com.itheima.hipda.net.StringRequestProxy;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MenuFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_left_menu, null);
		ViewUtils.inject(this, view);
		return view;
	}

	
	@OnClick({ R.id.tv_message, R.id.tv_topic, R.id.tv_mytopic,
			R.id.tv_myreply, R.id.tv_collect })
	public void changeFragment(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.tv_message:
			
			
			
			
			
			StringRequestCookie stringRequestCookie = new StringRequestCookie("http://www.baidu.com/", new Listener<String>() {

				@Override
				public void onResponse(String arg0) {
					System.out.println(arg0);
				}
			}, new ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError arg0) {
					System.out.println(arg0);
				}
			});
		
			
			ApplicationController.getInstance().addToRequestQueue(stringRequestCookie);
//			
			
//			((MainActivity) getActivity()).switchFragment(fragment);
			break;
		case R.id.tv_topic:

			StringRequestProxy stringRequestProxy = new StringRequestProxy(
					Request.Method.POST,
					"http://www.hi-pda.com/forum/logging.php?action=login&loginsubmit=yes", 
					new Listener<String>() {

						@Override
						public void onResponse(String arg0) {
							System.out.println(arg0);
						}
					},
					new ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError arg0) {
							System.out.println(arg0);
							
						}
					}){

						@Override
						protected Map<String, String> getParams()
								throws AuthFailureError {
							Map<String, String> params = new HashMap<String, String>();
					        params.put("sid=Hh4x6G&formhash=c5fe8779&loginfield=username&username=721675401&password=872528758&questionid=0&answer=&loginsubmit=%B5%C7%C2%BC&cookietime", "2592000");
							return params;
						}
				
			};
			ApplicationController.getInstance().addToRequestQueue(stringRequestProxy);
			
			break;
		case R.id.tv_mytopic:

			break;
		case R.id.tv_myreply:

			break;
		case R.id.tv_collect:

			break;
		}

	}

	

	
	
	

}
