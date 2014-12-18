package com.ihgoo.hipda.bean;

import java.util.ArrayList;
import java.util.List;

public class DetailListBean {
	private int mCount = 0;
	private List<DetailBean> mDetailBeans = new ArrayList();
	private Boolean mHaveNext = Boolean.valueOf(false);
	private int mLastPage = 1;
	private int mPage = 0;
	private String mTitle;

	public void add(DetailBean paramDetailBean) {
		this.mDetailBeans.add(paramDetailBean);
		this.mCount = (1 + this.mCount);
	}

	public List<DetailBean> getAll() {
		return this.mDetailBeans;
	}

	public int getCount() {
		return this.mCount;
	}

	public Boolean getHaveNext() {
		return this.mHaveNext;
	}

	public String getLastId() {
		if (this.mDetailBeans.size() == 0) {
			return "";
		}
		return ((DetailBean) this.mDetailBeans.get(-1
				+ this.mDetailBeans.size())).getPostId();
	}

	public int getLastPage() {
		return this.mLastPage;
	}

	public int getPage() {
		return this.mPage;
	}

	public String getTitle() {
		return this.mTitle;
	}

	public void setHaveNext(Boolean paramBoolean) {
		this.mHaveNext = paramBoolean;
	}

	public void setLastPage(int paramInt) {
		this.mLastPage = paramInt;
	}

	public void setPage(int paramInt) {
		this.mPage = paramInt;
	}

	public void setTitle(String paramString) {
		this.mTitle = paramString;
	}
}
