package com.ihgoo.hipda.bean;

import java.io.Serializable;



public class LoginInfo implements Serializable{
	private static final long serialVersionUID = -11726547924827677L;
	private String answer;
	private String cookietime;
	private String formhash;
	private String loginfield;
	private String password;
	private String questionid;
	private String referer;
	private String username;
	
	
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCookietime() {
		return cookietime;
	}
	public void setCookietime(String cookietime) {
		this.cookietime = cookietime;
	}
	public String getFormhash() {
		return formhash;
	}
	public void setFormhash(String formhash) {
		this.formhash = formhash;
	}
	public String getLoginfield() {
		return loginfield;
	}
	public void setLoginfield(String loginfield) {
		this.loginfield = loginfield;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
