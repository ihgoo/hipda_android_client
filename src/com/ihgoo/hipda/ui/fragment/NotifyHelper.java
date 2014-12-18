package com.ihgoo.hipda.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.widget.TextView;

public class NotifyHelper {
	private Activity mActivity;
	private int mCntSMS = 0;
	private int mCntThread = 0;
	private TextView mViewSmsItemTextView;
	private TextView mViewThreadItemTextView;

	public static NotifyHelper getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public int getCntSMS() {
		return this.mCntSMS;
	}

	public int getCntThread() {
		return this.mCntThread;
	}

	public void init(Activity paramActivity) {
		this.mActivity = paramActivity;
	}

	public void initSmsItemTextView(TextView paramTextView) {
		this.mViewSmsItemTextView = paramTextView;
	}

	public void initThreadItemTextView(TextView paramTextView) {
		this.mViewThreadItemTextView = paramTextView;
	}

	public void setCntSMS(int paramInt) {
		this.mCntSMS = paramInt;
	}

	public void setCntThread(int paramInt) {
		this.mCntThread = paramInt;
	}

	@SuppressLint("NewApi")
	public void updateDrawer() {
		this.mActivity.runOnUiThread(new Runnable() {
			public void run() {
				if (NotifyHelper.this.mCntSMS > 0) {
					NotifyHelper.this.mViewSmsItemTextView.setText("短消息 ("
							+ NotifyHelper.this.mCntSMS + ")");
				}
				while (NotifyHelper.this.mCntThread > 0) {
					mViewThreadItemTextView.setText("帖子消息 ("
							+ NotifyHelper.this.mCntThread + ")");
					mViewSmsItemTextView.setText("短消息");
					return;
				}
				NotifyHelper.this.mViewThreadItemTextView.setText("帖子消息");
			}
		});
		if (this.mCntSMS + this.mCntThread > 0) {
			Notification.Builder localBuilder = new Notification.Builder(
					this.mActivity)
					.setSmallIcon(2130837595)
					.setContentTitle("您有新短消息或帖子通知")
					.setContentText(
							"短消息(" + String.valueOf(this.mCntSMS) + "), 帖子通知("
									+ String.valueOf(this.mCntThread)
									+ ") 请打开侧栏查阅").setAutoCancel(true);
			((NotificationManager) this.mActivity
					.getSystemService("notification")).notify(0,
					localBuilder.build());
			return;
		}
		((NotificationManager) this.mActivity.getSystemService("notification"))
				.cancel(0);
	}

	private static class SingletonHolder {
		public static final NotifyHelper INSTANCE = new NotifyHelper();
	}
}
