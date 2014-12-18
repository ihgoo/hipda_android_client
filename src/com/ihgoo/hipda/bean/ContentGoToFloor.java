package com.ihgoo.hipda.bean;

public class ContentGoToFloor extends ContentAbs {
	private int floor;
	private String text;

	public ContentGoToFloor(String paramString, int paramInt) {
		this.text = paramString;
		this.floor = paramInt;
	}

	public String getContent() {
		return this.text;
	}

	public String getCopyText() {
		return this.text;
	}

	public int getFloor() {
		return this.floor;
	}
}
