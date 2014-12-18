package com.itheima.hipda.bean;

import java.util.ArrayList;
import java.util.List;

public class SimpleListBean {
	private int mCount = 0;
	private List<SimpleListItemBean> mSimpleListItemBeans = new ArrayList();

	public void add(SimpleListItemBean paramSimpleListItemBean) {
		this.mSimpleListItemBeans.add(paramSimpleListItemBean);
		this.mCount = (1 + this.mCount);
	}

	public List<SimpleListItemBean> getAll() {
		return this.mSimpleListItemBeans;
	}

	public int getCount() {
		return this.mCount;
	}
}
