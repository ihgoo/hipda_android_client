package com.itheima.hipda.bean;

public class ThreadBean {
	private String mAuthor;
	private String mAuthorId;
	private String mCountCmts;
	private String mCountViews;
	private Boolean mHaveAttach = Boolean.valueOf(false);
	private Boolean mHavePic = Boolean.valueOf(false);
	private boolean mIsStick = false;
	private String mLastPost;
	private String mTid;
	private String mTimeCreate;
	private String mTitle;

	public String getAuthor() {
		return this.mAuthor;
	}

	public String getAuthorId() {
		return this.mAuthorId;
	}

	public String getCountCmts() {
		return this.mCountCmts;
	}

	public String getCountViews() {
		return this.mCountViews;
	}

	public Boolean getHaveAttach() {
		return this.mHaveAttach;
	}

	public Boolean getHavePic() {
		return this.mHavePic;
	}

	public boolean getIsStick() {
		return this.mIsStick;
	}

	public String getLastPost() {
		return this.mLastPost;
	}

	public String getTid() {
		return this.mTid;
	}

	public String getTimeCreate() {
		return this.mTimeCreate.replaceAll("-", "/");
	}

	public String getTitle() {
		return this.mTitle;
	}

	public boolean setAuthor(String paramString) {
		this.mAuthor = paramString;
		return !SettingHelper.getInstance().isUserBlack(paramString);
	}

	public void setAuthorId(String paramString) {
		this.mAuthorId = paramString;
	}

	public void setCountCmts(String paramString) {
		this.mCountCmts = paramString;
	}

	public void setCountViews(String paramString) {
		this.mCountViews = paramString;
	}

	public void setHaveAttach(Boolean paramBoolean) {
		this.mHaveAttach = paramBoolean;
	}

	public void setHavePic(Boolean paramBoolean) {
		this.mHavePic = paramBoolean;
	}

	public void setIsStick(boolean paramBoolean) {
		this.mIsStick = paramBoolean;
	}

	public void setLastPost(String paramString) {
		this.mLastPost = paramString;
	}

	public void setTid(String paramString) {
		this.mTid = paramString;
	}

	public void setTimeCreate(String paramString) {
		this.mTimeCreate = paramString;
	}

	public void setTitle(String paramString) {
		this.mTitle = paramString;
	}
}

