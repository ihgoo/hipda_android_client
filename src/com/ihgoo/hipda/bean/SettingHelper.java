package com.itheima.hipda.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingHelper {
	public static final String PERF_ADDTAIL = "PERF_ADDTAIL";
	public static final String PERF_BLANKLIST_USERNAMES = "PERF_BLANKLIST_USERNAMES";
	public static final String PERF_COOKIEAUTH = "PERF_COOKIEAUTH";
	public static final String PERF_EINK_OPTIMIZATION = "PERF_EINK_OPTIMIZATION";
	public static final String PERF_ENCODEUTF8 = "PERF_ENCODEUTF8";
	public static final String PERF_LOADIMGONMOBILENWK = "PERF_LOADIMGONMOBILENWK";
	public static final String PERF_NIGHTTHEME = "PERF_NIGHTTHEME";
	public static final String PERF_PASSWORD = "PERF_PASSWORD";
	public static final String PERF_PREFETCH = "PERF_PREFETCH";
	public static final String PERF_SECANSWER = "PERF_SECANSWER";
	public static final String PERF_SECQUESTION = "PERF_SECQUESTION";
	public static final String PERF_SHOWSTICKTHREADS = "PERF_SHOWSTICKTHREADS";
	public static final String PERF_SORTBYPOSTTIME = "PERF_SORTBYPOSTTIME";
	public static final String PERF_TAILTEXT = "PERF_TAILTEXT";
	public static final String PERF_TAILURL = "PERF_TAILURL";
	public static final String PERF_TEXTSIZE_POST_ADJ = "PERF_TEXTSIZE_POST_ADJ";
	public static final String PERF_USERNAME = "PERF_USERNAME";
	private boolean mAddTail = true;
	private String[] mBlanklistUsernames = null;
	private String mCookieAuth = "";
	private Context mCtx;
	private boolean mEinkOptimization = false;
	private boolean mEncodeUtf8 = false;
	private boolean mIsLandscape = false;
	private boolean mLoadImgOnMobileNwk = true;
	private boolean mNightTheme = false;
	private String mPassword = "";
	private String mPostTextSizeAdj = "";
	private boolean mPreFetch = true;
	private String mSecAnswer = "";
	private String mSecQuestion = "";
	private SharedPreferences mSharedPref;
	private boolean mShowStickThreads = false;
	private boolean mSortByPostTime = false;
	private String mTailText = "";
	private String mTailUrl = "";
	private String mUsername = "";

	public static SettingHelper getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public String[] getBlanklistUsernames() {
		return this.mBlanklistUsernames;
	}

	public String[] getBlanklistUsernamesFromPref() {
		this.mBlanklistUsernames = this.mSharedPref.getString(
				"PERF_BLANKLIST_USERNAMES", "").split(" ");
		return this.mBlanklistUsernames;
	}

	public String getCookieAuth() {
		return this.mCookieAuth;
	}

	public String getCookieAuthFromPref() {
		this.mCookieAuth = this.mSharedPref.getString("PERF_COOKIEAUTH", "");
		return this.mCookieAuth;
	}

	public String getEncode() {
		if (this.mEncodeUtf8)
			return "UTF8";
		return "GBK";
	}

	public boolean getIsLandscape() {
		return this.mIsLandscape;
	}

	public String getPassword() {
		return this.mPassword;
	}

	public String getPasswordFromPref() {
		this.mPassword = this.mSharedPref.getString("PERF_PASSWORD", "");
		return this.mPassword;
	}

	public int getPostTextsizeAdj() {
		return Integer.parseInt(this.mPostTextSizeAdj);
	}

	public String getPostTextsizeAdjFromPref() {
		this.mPostTextSizeAdj = this.mSharedPref.getString(
				"PERF_TEXTSIZE_POST_ADJ", "0");
		return this.mPostTextSizeAdj;
	}

	public String getSecAnswer() {
		return this.mSecAnswer;
	}

	public String getSecAnswerFromPref() {
		this.mSecAnswer = this.mSharedPref.getString("PERF_SECANSWER", "");
		return this.mSecAnswer;
	}

	public String getSecQuestion() {
		return this.mSecQuestion;
	}

	public String getSecQuestionFromPref() {
		this.mSecQuestion = this.mSharedPref.getString("PERF_SECQUESTION", "");
		return this.mSecQuestion;
	}

	public String getTailText() {
		return this.mTailText;
	}

	public String getTailTextFromPref() {
		this.mTailText = this.mSharedPref.getString("PERF_TAILTEXT", "");
		return this.mTailText;
	}

	public String getTailUrl() {
		return this.mTailUrl;
	}

	public String getTailUrlFromPref() {
		this.mTailUrl = this.mSharedPref.getString("PERF_TAILURL", "");
		return this.mTailUrl;
	}

	public String getUsername() {
		return this.mUsername;
	}

	public String getUsernameFromPref() {
		this.mUsername = this.mSharedPref.getString("PERF_USERNAME", "");
		return this.mUsername;
	}

	public void init(Context paramContext) {
		this.mCtx = paramContext;
		this.mSharedPref = PreferenceManager
				.getDefaultSharedPreferences(this.mCtx);
		reload();
	}

	public boolean isAddTail() {
		return this.mAddTail;
	}

	public boolean isAddTailFromPref() {
		this.mAddTail = this.mSharedPref.getBoolean("PERF_ADDTAIL", true);
		return this.mAddTail;
	}

	public boolean isEinkOptimization() {
		return this.mEinkOptimization;
	}

	public boolean isEinkOptimizationFromPref() {
		this.mEinkOptimization = this.mSharedPref.getBoolean(
				"PERF_EINK_OPTIMIZATION", false);
		return this.mEinkOptimization;
	}

	public boolean isEncodeUtf8() {
		return this.mEncodeUtf8;
	}

	public boolean isEncodeUtf8FromPref() {
		this.mEncodeUtf8 = this.mSharedPref
				.getBoolean("PERF_ENCODEUTF8", false);
		return this.mEncodeUtf8;
	}

	public boolean isLoadImgOnMobileNwk() {
		return this.mLoadImgOnMobileNwk;
	}

	public boolean isLoadImgOnMobileNwkFromPref() {
		this.mLoadImgOnMobileNwk = this.mSharedPref.getBoolean(
				"PERF_LOADIMGONMOBILENWK", true);
		return this.mLoadImgOnMobileNwk;
	}

	public boolean isLoginInfoValid() {
		return (!this.mUsername.isEmpty()) && (!this.mPassword.isEmpty());
	}

	public boolean isNightTheme() {
		return this.mNightTheme;
	}

	public boolean isNightThemeFromPref() {
		this.mNightTheme = this.mSharedPref
				.getBoolean("PERF_NIGHTTHEME", false);
		return this.mNightTheme;
	}

	public boolean isPreFetch() {
		return this.mPreFetch;
	}

	public boolean isPreFetchFromPref() {
		this.mPreFetch = this.mSharedPref.getBoolean("PERF_PREFETCH", true);
		return this.mPreFetch;
	}

	public boolean isShowStickThreads() {
		return this.mShowStickThreads;
	}

	public boolean isShowStickThreadsFromPref() {
		this.mShowStickThreads = this.mSharedPref.getBoolean(
				"PERF_SHOWSTICKTHREADS", false);
		return this.mShowStickThreads;
	}

	public boolean isSortByPostTime() {
		return this.mSortByPostTime;
	}

	public boolean isSortByPostTimeFromPref() {
		this.mSortByPostTime = this.mSharedPref.getBoolean(
				"PERF_SORTBYPOSTTIME", false);
		return this.mSortByPostTime;
	}

	public boolean isUserBlack(String paramString) {
		String[] arrayOfString = this.mBlanklistUsernames;
		int i = arrayOfString.length;
		for (int j = 0;; j++) {
			if (j >= i)
				return false;
			if (arrayOfString[j].equals(paramString))
				return true;
		}
	}

	public void reload() {
		getUsernameFromPref();
		getPasswordFromPref();
		getSecQuestionFromPref();
		getSecAnswerFromPref();
		getCookieAuthFromPref();
		isShowStickThreadsFromPref();
		isLoadImgOnMobileNwkFromPref();
		isPreFetchFromPref();
		isSortByPostTimeFromPref();
		isAddTailFromPref();
		getTailTextFromPref();
		getTailUrlFromPref();
		isNightThemeFromPref();
		isEncodeUtf8FromPref();
		isEinkOptimizationFromPref();
		getBlanklistUsernamesFromPref();
		getPostTextsizeAdjFromPref();
	}

	public void setAddTail(boolean paramBoolean) {
		this.mAddTail = paramBoolean;
		this.mSharedPref.edit().putBoolean("PERF_ADDTAIL", paramBoolean)
				.commit();
	}

	public void setBlanklistUsernames(String paramString) {
		this.mBlanklistUsernames = paramString.split(" ");
		this.mSharedPref.edit()
				.putString("PERF_BLANKLIST_USERNAMES", paramString).commit();
	}

	public void setCookieAuth(String paramString) {
		this.mCookieAuth = paramString;
		this.mSharedPref.edit().putString("PERF_COOKIEAUTH", paramString)
				.commit();
	}

	public void setEinkOptimization(boolean paramBoolean) {
		this.mEinkOptimization = paramBoolean;
		this.mSharedPref.edit()
				.putBoolean("PERF_EINK_OPTIMIZATION", paramBoolean).commit();
	}

	public void setEncodeUtf8(boolean paramBoolean) {
		this.mEncodeUtf8 = paramBoolean;
		this.mSharedPref.edit().putBoolean("PERF_ENCODEUTF8", paramBoolean)
				.commit();
	}

	public void setIsLandscape(boolean paramBoolean) {
		this.mIsLandscape = paramBoolean;
	}

	public void setLoadImgOnMobileNwk(boolean paramBoolean) {
		this.mLoadImgOnMobileNwk = paramBoolean;
		this.mSharedPref.edit()
				.putBoolean("PERF_LOADIMGONMOBILENWK", paramBoolean).commit();
	}

	public void setNightTheme(boolean paramBoolean) {
		this.mNightTheme = paramBoolean;
		this.mSharedPref.edit().putBoolean("PERF_NIGHTTHEME", paramBoolean)
				.commit();
	}

	public void setPassword(String paramString) {
		this.mPassword = paramString;
		this.mSharedPref.edit().putString("PERF_PASSWORD", paramString)
				.commit();
	}

	public void setPostTextsizeAdj(String paramString) {
		this.mPostTextSizeAdj = paramString;
		this.mSharedPref.edit()
				.putString("PERF_TEXTSIZE_POST_ADJ", paramString).commit();
	}

	public void setPreFetch(boolean paramBoolean) {
		this.mPreFetch = paramBoolean;
		this.mSharedPref.edit().putBoolean("PERF_PREFETCH", paramBoolean)
				.commit();
	}

	public void setSecAnswer(String paramString) {
		this.mSecAnswer = paramString;
		this.mSharedPref.edit().putString("PERF_SECANSWER", paramString)
				.commit();
	}

	public void setSecQuestion(String paramString) {
		this.mSecQuestion = paramString;
		this.mSharedPref.edit().putString("PERF_SECQUESTION", paramString)
				.commit();
	}

	public void setShowStickThreads(boolean paramBoolean) {
		this.mShowStickThreads = paramBoolean;
		this.mSharedPref.edit()
				.putBoolean("PERF_SHOWSTICKTHREADS", paramBoolean).commit();
	}

	public void setSortByPostTime(boolean paramBoolean) {
		this.mSortByPostTime = paramBoolean;
		this.mSharedPref.edit().putBoolean("PERF_SORTBYPOSTTIME", paramBoolean)
				.commit();
	}

	public void setTailText(String paramString) {
		this.mTailText = paramString;
		this.mSharedPref.edit().putString("PERF_TAILTEXT", paramString)
				.commit();
	}

	public void setTailUrl(String paramString) {
		this.mTailUrl = paramString;
		this.mSharedPref.edit().putString("PERF_TAILURL", paramString).commit();
	}

	public void setUsername(String paramString) {
		this.mUsername = paramString;
		this.mSharedPref.edit().putString("PERF_USERNAME", paramString)
				.commit();
	}

	private static class SingletonHolder {
		public static final SettingHelper INSTANCE = new SettingHelper();
	}
}