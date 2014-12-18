package com.ihgoo.hipda.utils;

import java.util.Iterator;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import android.content.Context;

import com.ihgoo.hipda.bean.SettingHelper;

public class HttpUtils {

	
	  public static void saveAuth(Context paramContext, CookieStore paramCookieStore)
	  {
	    Iterator<Cookie> localIterator = paramCookieStore.getCookies().iterator();
	    for (;;)
	    {
	      if (!localIterator.hasNext()) {
	        return;
	      }
	      Cookie localCookie = (Cookie)localIterator.next();
	      if (localCookie.getName().equals("cdb_auth"))
	      {
	        String str = localCookie.getValue();
	        SettingHelper.getInstance().setCookieAuth(str);
	      }
	    }
	  }
}
