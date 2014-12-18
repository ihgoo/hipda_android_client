package com.itheima.hipda.base;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter<T,Q> extends BaseAdapter {
	public Context ct;
	public List<T> lists;
	public View Q;
	
	public MyBaseAdapter(Context ct, List<T> lists) {
		super();
		this.ct = ct;
		this.lists = lists;
	}

	public MyBaseAdapter() {
		super();
	}

	public MyBaseAdapter(Context ct, List<T> lists, View q) {
		super();
		this.ct = ct;
		this.lists = lists;
		Q = q;
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
