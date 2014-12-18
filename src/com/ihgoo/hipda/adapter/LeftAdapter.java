package com.itheima.hipda.adapter;

import com.itheima.hipda.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftAdapter extends ArrayAdapter<String>{

	private Context mContext;
	private int mItemRsc;
	private LayoutInflater mInflater;
	private int color;
	private Drawable mLocalDrawable;
	
	public LeftAdapter(Context context, int resource, String[] arrayString) {
		super(context, resource, arrayString);
		this.mContext = context;
	    this.mItemRsc = resource;
	    this.mInflater = LayoutInflater.from(context);
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String str = getItem(position);
		if (convertView==null) {
			convertView = View.inflate(mContext,mItemRsc, null);
		}
		
		TextView tv_title =  (TextView) convertView.findViewById(R.id.tv_title);
		ImageView iv_color_block = (ImageView) convertView.findViewById(R.id.iv_color_block);
		ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
		
		
		
		if (str.equals("我的回复")) {
			color = mContext.getResources().getColor(R.color.darkpurple);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_pencil);
		}else if (str.equals("设置")) {
			color = mContext.getResources().getColor(R.color.darkgreen);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_gear);
		}else if (str.equals("切换主题")) {
			color = mContext.getResources().getColor(R.color.darkorange);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_contrast);
		}else if (str.equals("短消息")) {
			color = mContext.getResources().getColor(R.color.darkred);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_mail);
		}else if (str.equals("帖子消息")) {
			color = mContext.getResources().getColor(R.color.darkblue);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_info2);
		}else if (str.equals("发表新帖")) {
			color = mContext.getResources().getColor(R.color.purple);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_brush);
		}else if (str.equals("搜索")) {
			color = mContext.getResources().getColor(R.color.blue);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_zoom);
		}else if(str.contains("我的收藏")){
			color = mContext.getResources().getColor(R.color.orange);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_heart);
		}else if(str.contains("论坛")){
			color = mContext.getResources().getColor(R.color.darkred);
			mLocalDrawable = mContext.getResources().getDrawable(R.drawable.google_pencil);
		}
		
		
		iv_color_block.setBackgroundColor(color);
		tv_title.setText(str);
		iv_icon.setImageDrawable(mLocalDrawable);
		
		return convertView;
	}
	
	
}
