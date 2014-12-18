package com.itheima.hipda.bean;


import java.io.Serializable;

import android.graphics.Bitmap;

public class TopicInfo implements Serializable {
	private static final long serialVersionUID = -3580791524499026180L;
	private String time;
	private String content;
	private String pid;
	private String author;
	private String floor;
	private Bitmap head;
	
	@Override
	public String toString() {
		return "TopicInfo [time=" + time + ", content=" + content + ", pid="
				+ pid + ", author=" + author + ", floor=" + floor + ", head="
				+ head + "]";
	}
	
	
	



	public Bitmap getHead() {
		return head;
	}
	public void setHead(Bitmap head) {
		this.head = head;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
}
