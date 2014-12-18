package com.itheima.hipda.async;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.itheima.hipda.R.string;
import com.itheima.hipda.bean.ThreadListBean;
import com.itheima.hipda.net.StringRequestProxy;
import com.itheima.hipda.parser.ParserThreadList;
import com.itheima.hipda.utils.VolleyHelper;

public class ThreadListLoader extends AsyncTaskLoader<ThreadListBean> {
	private Context mContext;
	private int mForumId = 0;
	private int mPage = 1;
	private Handler mHandler;
	private String mRsp;
	private Object mLocked;
	

	public ThreadListLoader(Context paramContext, Handler paramHandler,
			int paramInt1, int paramInt2) {
		super(paramContext);
		this.mContext = paramContext;
		this.mHandler = paramHandler;
		this.mForumId = paramInt1;
		this.mPage = paramInt2;
		this.mLocked = this;
	}
	
	/**
	 * 取论坛帖子列表
	 */
	private void fetchForumList(){
		Message localMessage = Message.obtain();
		localMessage.what = 2;
		mHandler.sendMessage(localMessage);
		String str = "http://www.hi-pda.com/forum/forumdisplay.php?fid=" + mForumId + "&page=" + mPage;
		
		StringRequestProxy requestProxy = new StringRequestProxy(str, new ThreadListListener(), new ThreadListErrorListener());
		
		VolleyHelper.getInstance().add(requestProxy);
		
	}
	
	
	private class ThreadListErrorListener implements ErrorListener{

		@Override
		public void onErrorResponse(VolleyError error) {
			
			synchronized (mLocked) {
				mLocked.notify();
			}
		}
		
	} 
	
	
	private class ThreadListListener implements Listener<String>{

		@Override
		public void onResponse(String str) {
			if (str!=null) {
				mRsp = str;
			}
			synchronized (mLocked) {
				mLocked.notify();
			}
			
		}
		
	}
	

	@Override
	public ThreadListBean loadInBackground() {
		if (mPage==0) {
			return null;
		}
		
		// 若用户未登录，则试2次完整登录
		for (int i = 0; i < 4; i++) {
			Document document = Jsoup.parse(mRsp);
			
			fetchForumList();
			
			// 锁等待
			synchronized (mLocked) {
				try {
					mLocked.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if (LoginAsyncTask.checkLoggedin(mHandler, document)) {
				new LoginAsyncTask(mContext, mHandler).doInBackground(new String[0]);
			}
			
			
			return ParserThreadList.parser();
			
			
		}
		
		
		
		
		
		
		
		return null;
	}

}
