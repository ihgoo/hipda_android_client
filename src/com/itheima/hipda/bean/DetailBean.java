package com.itheima.hipda.bean;

import java.util.ArrayList;

public class DetailBean {
	private String mAuthor;
	private String mAvatarUrl;
	private Contents mContents = new Contents();
	private String mFloor;
	private String mPostId;
	private String mPostStatus;
	private String mTimePost;
	private String mUid;

	private String unEscapeHtml(String paramString) {
		return paramString.replaceAll("&nbsp;", " ").replaceAll("&quot;", "\"")
				.replaceAll("&amp;", "&").replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">");
	}

	public String getAuthor() {
		return this.mAuthor;
	}

	public String getAvatarUrl() {
		return this.mAvatarUrl;
	}

	public Contents getContents() {
		return this.mContents;
	}

	public String getFloor() {
		return this.mFloor;
	}

	public String getPostId() {
		return this.mPostId;
	}

	public String getPostStatus() {
		return this.mPostStatus;
	}

	public String getTimePost() {
		return this.mTimePost;
	}

	public String getUid() {
		return this.mUid;
	}

	public boolean setAuthor(String paramString) {
		this.mAuthor = paramString;
		return !SettingHelper.getInstance().isUserBlack(paramString);
	}

	public void setAvatarUrl(String paramString) {
		if (paramString.contains("noavatar")) {
			this.mAvatarUrl = "";
			return;
		}
		this.mAvatarUrl = paramString.replaceAll("middle", "small");
	}

	public void setContents(Contents paramContents) {
		this.mContents = paramContents;
	}

	public void setFloor(String paramString) {
		this.mFloor = paramString;
	}

	public void setPostId(String paramString) {
		this.mPostId = paramString;
	}

	public void setPostStatus(String paramString) {
		this.mPostStatus = paramString;
	}

	public void setTimePost(String paramString) {
		this.mTimePost = paramString.substring(4);
	}

	public void setUid(String paramString) {
		this.mUid = paramString;
	}

	public class Contents {
		private int lastTextIdx = -1;
		private ArrayList<ContentAbs> list = new ArrayList();
		private Boolean newString = Boolean.valueOf(true);

		public Contents() {
		}

		public void addAttach(String paramString1, String paramString2) {
			this.list.add(new ContentAttach(paramString1, DetailBean.this
					.unEscapeHtml(paramString2)));
			this.newString = Boolean.valueOf(true);
		}

		public void addGoToFloor(String paramString, int paramInt) {
			this.list.add(new ContentGoToFloor(paramString, paramInt));
			this.newString = Boolean.valueOf(true);
		}

		public void addImg(String paramString, Boolean paramBoolean) {
			this.list.add(new ContentImg(paramString, paramBoolean
					.booleanValue()));
			this.newString = Boolean.valueOf(true);
		}

		public void addLink(String paramString1, String paramString2) {
			String str = "[<a href=\"" + paramString2 + "\">" + paramString1
					+ "</a>]";
			if (this.newString.booleanValue()) {
				this.list.add(new ContentText(str));
				this.lastTextIdx = (-1 + this.list.size());
				this.newString = Boolean.valueOf(false);
				return;
			}
			((ContentText) this.list.get(this.lastTextIdx)).append(str);
		}

		public void addQuote(String paramString) {
			this.list.add(new ContentQuote(DetailBean.this
					.unEscapeHtml(paramString)));
			this.newString = Boolean.valueOf(true);
		}

		public void addText(String paramString) {
			if (this.newString.booleanValue()) {
				this.list.add(new ContentText(DetailBean.this
						.unEscapeHtml(paramString)));
				this.lastTextIdx = (-1 + this.list.size());
				this.newString = Boolean.valueOf(false);
				return;
			}
			((ContentText) this.list.get(this.lastTextIdx))
					.append(DetailBean.this.unEscapeHtml(paramString));
		}

		public ContentAbs get(int paramInt) {
			return (ContentAbs) this.list.get(paramInt);
		}

		public String getCopyText() {
			StringBuilder localStringBuilder = new StringBuilder();
			for (int i = 0;; i++) {
				if (i >= this.list.size()) {
					return localStringBuilder.toString();
				}
				localStringBuilder.append(((ContentAbs) this.list.get(i))
						.getCopyText());
			}
		}

		public int getSize() {
			return this.list.size();
		}
	}
}

