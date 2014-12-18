package com.ihgoo.hipda.bean;

public class ContentQuote extends ContentAbs {
	private String mQuote;

	public ContentQuote(String paramString) {
		this.mQuote = paramString;
	}

	public String getContent() {
		return "『" + this.mQuote + "』";
	}

	public String getCopyText() {
		return "『" + this.mQuote + "』";
	}
}
