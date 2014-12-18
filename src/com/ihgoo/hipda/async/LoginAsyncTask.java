package com.itheima.hipda.async;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.itheima.hipda.R;
import com.itheima.hipda.bean.SettingHelper;
import com.itheima.hipda.utils.BBSAPI;
import com.itheima.hipda.utils.HttpUtils;

/**
 * 异步登录
 * @author KelvinHu
 *
 */
public class LoginAsyncTask extends AsyncTask<String, Void, Boolean>{
	private Context mContext;
	private Handler mHandler;
	private AndroidHttpClient client = AndroidHttpClient.newInstance(BBSAPI.USER_AGENT);
	private HttpContext localContext;
	private BasicCookieStore cookieStore;
	private String mErrorMSG;
	
	
	public LoginAsyncTask(Context mContext, Handler mHandler) {
		this.mContext = mContext;
		this.mHandler = mHandler;
	}
	
	
	public static boolean checkLoggedin(Handler paramHandler,Document paramDocument){
		if (!paramDocument.select("div.alert_error").isEmpty())
	    {
	      if (paramHandler != null)
	      {
	        Message localMessage = Message.obtain();
	        localMessage.what = -1;
	        Bundle localBundle = new Bundle();
	        localBundle.putString("ERROR_MSG", "登录失败,请检查账户信息");
	        localMessage.setData(localBundle);
	        paramHandler.sendMessage(localMessage);
	      }
	      return false;
	    }
	    return true;
		
		
		
	} 
	
	

	/**
	 * 1、获取cdb_sid cookie
	 */
	private void loginStep1(){
		HttpGet httpGet = new HttpGet(BBSAPI.HIPDA_BASE);
		try {
			client.execute(httpGet, localContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2、获取formhash
	 * @param paramString
	 * @return
	 */
	private String loginStep2(String paramString){
		 HttpGet httpGet = new HttpGet(BBSAPI.HIPDA_PRELOGIN + paramString);
		 try {
			 String str = EntityUtils.toString(client.execute(httpGet, localContext).getEntity(), BBSAPI.CHARSET);
			 Document localDocument = Jsoup.parse(str);
			 Element element = localDocument.select("input[name=formhash]").first();
			 if (element==null) {
				return "";
			}
			 return element.attr("value");
		 
		 } catch (IOException e) {
			e.printStackTrace();
			return "Can not get formhash";
		}
	}


	/**
	 * 3、填写表单登录
	 * @param paramString
	 * @return
	 */
	private boolean loginStep3(String paramString){
		HttpPost httpPost = new HttpPost(BBSAPI.HIPDA_LOGIN);
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_formhash", paramString);
		map.put("referer", "http://www.hi-pda.com/forum/index.php");
		map.put("loginfield", "username");
		map.put("username", SettingHelper.getInstance().getUsername());
		map.put("password", SettingHelper.getInstance().getPassword());
		map.put("questionid", SettingHelper.getInstance().getSecQuestion());
		map.put("answer", SettingHelper.getInstance().getSecAnswer());
		map.put("cookietime", "2592000");
		try {
			HttpEntity httpEntity = client.execute(httpPost, localContext).getEntity();
			String ret = EntityUtils.toString(httpEntity, BBSAPI.CHARSET);
			if (!ret.contains(mContext.getResources().getString(R.string.login_success))) {
				return false;
			}else {
				return true;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	@Override
	protected Boolean doInBackground(String... paramArgs) {
		mErrorMSG = "无法访问HIPDA，请检查网络";
		if (mHandler != null) {
			Message message = Message.obtain();
			message.what = 1;
			mHandler.sendMessage(message);
		}
		cookieStore = new BasicCookieStore();
		localContext.setAttribute("http.cookie-store", cookieStore);
		loginStep1();
		Iterator<Cookie> iterator = cookieStore.getCookies().iterator();
		if (iterator.hasNext()) {
			
			String formhash = loginStep2(paramArgs[0]);
			
			if (formhash!= null) {
				if (loginStep3(formhash)) {
					
					HttpUtils.saveAuth(mContext, cookieStore);
					
					return true;
				}
			}
		}
		
		
		if (mHandler!=null ) {
			Message message = Message.obtain();
			Bundle bundle = new Bundle();
			bundle.putString("ERROR_MSG", mErrorMSG);
			message.setData(bundle);
			mHandler.sendMessage(message);
		}
		
		
		return false;
		
		
		
		
		
	}
}
