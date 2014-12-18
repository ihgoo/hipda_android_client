package com.ihgoo.hipda.bean;

import com.ihgoo.hipda.utils.HiUtils;

public class ContentImg extends ContentAbs {
	private boolean mInternal;
	private String mUrl;

	public ContentImg(String paramString, boolean paramBoolean) {
		this.mInternal = paramBoolean;
		this.mUrl = paramString;
	}

	public String getContent() {
		if (this.mInternal) {
			return HiUtils.getFullUrl(this.mUrl);
		}
		return this.mUrl;
	}

	public String getCopyText() {
		return "[图片:" + this.mUrl + "]";
	}

	public void setExternalUrl(String paramString) {
		this.mUrl = paramString;
		this.mInternal = false;
	}

	public void setInternalUrl(String paramString) {
		this.mUrl = paramString;
		this.mInternal = true;
	}
}

