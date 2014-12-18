package com.ihgoo.hipda.bean;

import com.ihgoo.hipda.utils.HiUtils;

public class ContentAttach extends ContentAbs {
	private String mTitle;
	private String mUrl;

	public ContentAttach(String paramString1, String paramString2) {
		this.mUrl = paramString1;
		this.mTitle = paramString2;
	}

	public String getContent() {
		return "<a href=\"" + HiUtils.getFullUrl(this.mUrl) + "\">"
				+ this.mTitle + "</a>";
	}

	public String getCopyText() {
		return "[附件:" + this.mTitle + "]";
	}
}