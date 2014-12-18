package com.ihgoo.hipda.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.ihgoo.hipda.bean.ThreadBean;
import com.ihgoo.hipda.bean.ThreadListBean;
import com.ihgoo.hipda.net.StringRequestProxy;
import com.ihgoo.hipda.ui.fragment.NotifyHelper;
import com.ihgoo.hipda.utils.HttpUtils;
import com.ihgoo.hipda.utils.VolleyHelper;

public class ParserThreadList
{
  public static final String LOG_TAG = "HiParserThreadList";
  
  public static ThreadListBean parse(Context paramContext, Handler paramHandler, Document paramDocument)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    paramHandler.sendMessage(localMessage);
    
    
//    parseNotifyRunnable localparseNotifyRunnable = new parseNotifyRunnable(paramContext, paramDocument);
//    localparseNotifyRunnable.run();
    ThreadListBean localThreadListBean = new ThreadListBean(paramContext);
    Elements localElements1 = paramDocument.select("tbody[id]");
    
    
    
    if (!(localElements1.size()>0)) {
      return localThreadListBean;
    }
    
    
    Elements localElements10;
    for (Element localElement : localElements1) {
    	ThreadBean localThreadBean = new ThreadBean();
    	
    	String[] arrayOfString = localElement.attr("id").split("_");
    	if (arrayOfString.length != 2) {
    		continue;
        }
    	
    	String str1 = arrayOfString[0];
        String str2 = arrayOfString[1];
        String str3 = "thread_" + str2;
        localThreadBean.setTid(str2);
        localThreadBean.setIsStick(Boolean.valueOf(str1.startsWith("stickthread")).booleanValue());
        Elements localElements2 = localElement.select("span#" + str3);
        if (localElements2.size() != 0)
        {
          localThreadBean.setTitle(localElements2.first().text());
          Elements localElements3 = localElement.select("td.author");
          if (localElements3.size() != 0)
          {
            Elements localElements4 = localElements3.first().select("cite a");
            if ((localElements4.size() != 0) && (localThreadBean.setAuthor(localElements4.first().text())))
            {
              String str4 = localElements4.first().attr("href");
              if (str4.length() >= "space.php?uid=".length())
              {
                localThreadBean.setAuthorId(str4.substring("space.php?uid=".length()));
                Elements localElements5 = localElements3.first().select("em");
                if (localElements5.size() != 0)
                {
                  localThreadBean.setTimeCreate(localElements5.first().text());
                  Elements localElements6 = localElement.select("td.nums");
                  if (localElements6.size() != 0)
                  {
                    Elements localElements7 = localElements6.first().select("strong");
                    if (localElements7.size() != 0)
                    {
                      localThreadBean.setCountCmts(localElements7.first().text());
                      Elements localElements8 = localElements6.first().select("em");
                      if (localElements8.size() != 0)
                      {
                        localThreadBean.setCountViews(localElements8.first().text());
                        Elements localElements9 = localElement.select("td.lastpost cite");
                        if (localElements9.size() != 0)
                        {
                          localThreadBean.setLastPost(localElements9.first().text());
                          localElements10 = localElement.select("img.attach");
                          if (localElements10.size()>0) {
                        	  String str5 = localElements10.get(0).attr("src");
                        	    
                        	    
                        	    if (str5.isEmpty()) {
                        	    	break;
                        	    }
                        	    
                        	    if (str5.endsWith("image_s.gif")) {
                        	    	localThreadBean.setHavePic(Boolean.valueOf(true));
                        	    }
                        	    if (str5.endsWith("common.gif")) {
                        	    	localThreadBean.setHaveAttach(Boolean.valueOf(true));
                        	    }
                          }
                          localThreadListBean.add(localThreadBean);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    // for 循环结束
    return localThreadListBean;
    
    
    
    
	}

public static ThreadListBean parser() {
	// TODO Auto-generated method stub
	return null;
}
  }
  


//public static class parseNotifyRunnable implements Runnable {
//	private Context mCtx;
//	private Document mDoc;
//
//	public parseNotifyRunnable(Context paramContext, Document paramDocument) {
//		this.mCtx = paramContext;
//		this.mDoc = paramDocument;
//	}
//    
//    public void run()
//    {
//      Elements localElements = this.mDoc.select("div.promptcontent");
//      if (localElements.size() < 1) {
//        return;
//      }
//      String[] arrayOfString = localElements.first().text().split("\\) ");
//      int i = arrayOfString.length;
//      int j = 0;
//      if (j >= i)
//      {
//    	  StringRequestProxy localHiStringRequest = new StringRequestProxy( "http://www.hi-pda.com/forum/pm.php?checknewpm", new Response.Listener()
//        {
//
//		@Override
//		public void onResponse(Object arg0) {}
//        }, null);
//        VolleyHelper.getInstance().add(localHiStringRequest);
//        NotifyHelper.getInstance().updateDrawer();
//        return;
//      }
//      String str = arrayOfString[j];
//      if (str.contains("私人消息"))
//      {
//        int m = HttpUtils.getIntFromString(str);
//        NotifyHelper.getInstance().setCntSMS(m);
//        Log.v("NEW SMS:", String.valueOf(m));
//      }
//      for (;;)
//      {
//        j++;
//        break;
//        if (str.contains("帖子消息"))
//        {
//          int k = HttpUtils.getIntFromString(str);
//          NotifyHelper.getInstance().setCntThread(k);
//          Log.v("THREAD NOTIFY:", String.valueOf(k));
//        }
//      }
//    }
//  }



