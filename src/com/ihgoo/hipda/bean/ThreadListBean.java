package com.itheima.hipda.bean;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class ThreadListBean {
	public int count = 0;
	private boolean mAddStickThreads = false;
	public List<ThreadBean> threads = new ArrayList();

	public ThreadListBean(Context paramContext) {
	}

	public void add(ThreadBean paramThreadBean) {
		if ((!this.mAddStickThreads) && (paramThreadBean.getIsStick())) {
			return;
		}
		this.threads.add(paramThreadBean);
		this.count = (1 + this.count);
	}
}
