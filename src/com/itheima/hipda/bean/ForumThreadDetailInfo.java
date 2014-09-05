package com.itheima.hipda.bean;


import java.io.Serializable;



public class ForumThreadDetailInfo implements Serializable{
	private static final long serialVersionUID = 3382544833491538861L;
	private String folder;
	private int icon;
	private String visit;
	private String reply;
	private String author;
	private String title;
	private String time;
	private String id;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setVisit(String visit) {
		this.visit = visit;
	}
	
	
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	public String getVisit() {
		return visit;
	}


	public String getReply() {
		return reply;
	}


	@Override
	public String toString() {
		return "ForumThreadDetailInfo [folder=" + folder + ", icon=" + icon
				+ ", visit=" + visit + ", reply=" + reply + ", author="
				+ author + ", title=" + title + ", time=" + time + ", id=" + id
				+ "]";
	}
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	
	
}
