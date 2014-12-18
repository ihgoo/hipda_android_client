package com.ihgoo.hipda.bean;

public class SimpleListItemBean {
	private String mAuthor;
	private String mAvatarUrl = "";
	private String mId;
	private String mInfo;
	private boolean mNew = false;
	private String mPid;
	private String mTime;
	private String mTitle;

	public String getAuthor() {
		return this.mAuthor;
	}

	public String getAvatarUrl() {
		return this.mAvatarUrl;
	}

	public String getId() {
		return this.mId;
	}

	public String getInfo() {
		return this.mInfo;
	}

	public String getPid() {
		return this.mPid;
	}

	public String getTime() {
		return this.mTime;
	}

	public String getTitle() {
		return this.mTitle;
	}

	public boolean isNew() {
		return this.mNew;
	}

	public void setAuthor(String paramString) {
		this.mAuthor = paramString;
	}

	public void setAvatarUrl(String paramString) {
		if (paramString.contains("noavatar")) {
			this.mAvatarUrl = "";
			return;
		}
		this.mAvatarUrl = paramString.replaceAll("middle", "small");
	}

	public void setId(String paramString) {
		this.mId = paramString;
	}

	public void setInfo(String paramString) {
		this.mInfo = paramString;
	}

	public void setNew(boolean paramBoolean) {
		this.mNew = paramBoolean;
	}

	public void setPid(String paramString) {
		this.mPid = paramString;
	}

	public void setTime(String paramString) {
		this.mTime = paramString;
	}

	public void setTitle(String paramString) {
		this.mTitle = paramString;
	}
}
