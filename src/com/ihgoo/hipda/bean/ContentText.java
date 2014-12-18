package com.ihgoo.hipda.bean;

public class ContentText extends ContentAbs {
	private StringBuilder mSb = new StringBuilder();

	public ContentText(String paramString) {
		this.mSb.append(paramString);
	}

	public void append(String paramString) {
		this.mSb.append(paramString);
	}

	public String getContent() {
		return this.mSb.toString();
	}

	public String getCopyText() {
		return this.mSb.toString().replaceAll("<br>", "\n");
	}
}
