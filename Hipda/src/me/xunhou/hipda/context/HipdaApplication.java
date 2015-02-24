package me.xunhou.hipda.context;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class HipdaApplication extends Application{
	
	static Context instance;

	@Override
	public void onCreate() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
			.displayer(new FadeInBitmapDisplayer(50))
	    	.bitmapConfig(Bitmap.Config.RGB_565)
	    	.imageScaleType(ImageScaleType.EXACTLY) // default
	    	.cacheInMemory(true)
	    	.cacheOnDisk(true)
	    	.build();
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
			.memoryCache(new WeakMemoryCache())
			.defaultDisplayImageOptions(options)
			.build();
		
		ImageLoader.getInstance().init(config);

//		 JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
//         JPushInterface.init(this);     		// 初始化 JPush
		
		try {
			Class.forName("android.os.AsyncTask");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.onCreate();
		instance = getApplicationContext();
//		RequestManager.init(this);
//		 CrashHandler crashHandler = CrashHandler.getInstance() ;
//         crashHandler.init(this) ;
	}

	public static void cleanDb() {
	}

	// 实例对象
	public static WeakReference<Activity> instanceRef;

	public static synchronized Context getInstance() {
		if (instanceRef == null || instanceRef.get() == null) {
			return HipdaApplication.getContext();
		} else {
			return instanceRef.get();
		}
	}

	public static synchronized Activity getActivity() {
		Activity result = null;
		if (instanceRef != null && instanceRef.get() != null) {
			result = instanceRef.get();
		}
		return result;
	}

	public static synchronized Context getContext() {
		return instance;
	}

	public static SparseArray<WeakReference<Activity>> taskStack = new SparseArray<WeakReference<Activity>>();

	public static synchronized SparseArray<WeakReference<Activity>> getTaskStack() {
		return taskStack;
	}
	
	
//	private static DaoMaster daoMaster;
//	private static DaoSession daoSession;
//	
//	/**
//	 * 取得DaoMaster
//	 *
//	 * @param context
//	 * @return
//	 */
//	public static DaoMaster getDaoMaster(Context context)
//	{
//	    if (daoMaster == null)
//	    {
//	        OpenHelper helper = new DaoMaster.DevOpenHelper(context, "taskdetail-db", null);
//	        daoMaster = new DaoMaster(helper.getWritableDatabase());
//	    }
//	    return daoMaster;
//	}
//	/**
//	 * 取得DaoSession
//	 *
//	 * @param context
//	 * @return
//	 */
//	public static DaoSession getDaoSession(Context context)
//	{
//	    if (daoSession == null)
//	    {
//	        if (daoMaster == null)
//	        {
//	            daoMaster = getDaoMaster(context);
//	        }
//	        daoSession = daoMaster.newSession();
//	    }
//	    return daoSession;
//	}
	

}
