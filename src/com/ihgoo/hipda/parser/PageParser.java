package com.itheima.hipda.parser;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.itheima.hipda.GloableParams;
import com.itheima.hipda.bean.ForumThreadDetailInfo;
import com.itheima.hipda.bean.TopicInfo;


/**
 * HTML页面解析(dom方式)
 * @created 2014年8月6日
 * @author KelvinHu
 */
public class PageParser {
	private static PageParser instance = new PageParser();
	private PageParser() {}
	public static PageParser getInstance(){
		return instance;
	}
	
	
	
	
	
	private List<ForumThreadDetailInfo> forumThreadDetailInfos;
	private List<TopicInfo> topicInfos;

	/**
	 * 获得论坛列表详情
	 */
	public List<ForumThreadDetailInfo> getForumThreadListDetail(String string){
		// formhash
		String formhash = StringUtils.substringBetween(string,
				"formhash\" value=\"", "\" />");
		
		if (formhash!="" && GloableParams.formhash!=formhash) {
			GloableParams.formhash = formhash;
		}
		
		
		
		
		Document doc = Jsoup.parse(string);

		Element content = doc.getElementById("threadlist");
		Elements elementsByTag = content.getElementsByTag("tbody");

		forumThreadDetailInfos = new ArrayList<ForumThreadDetailInfo>();

		for (Element element : elementsByTag) {
			String id = element.id();
			if (id.startsWith("normalthread")) {

				Elements thElements = element.getElementsByTag("th");
				Elements elementsByTags = thElements.first().getElementsByTag(
						"a");

				ForumThreadDetailInfo detailInfo = new ForumThreadDetailInfo();

				// 帖子的链接
				String href = elementsByTags.attr("href");

				// 帖子的标题
				String title = elementsByTags.text();

				Elements authorElements = element.getElementsByClass("author");
				// 帖子的作者
				String author = authorElements.first().getElementsByTag("a")
						.text();
				// 帖子的时间
				String time = authorElements.first().getElementsByTag("em")
						.text();

				Elements numsElements = element.getElementsByClass("nums");
				// 帖子的回复数
				String reply = numsElements.first().getElementsByTag("strong")
						.text();
				String visit = numsElements.first().getElementsByTag("em")
						.text();

				// 帖子的id
				String thread_Id = element.getElementsByTag("span").first()
						.id();
				thread_Id = thread_Id.substring(7);

				detailInfo.setAuthor(author);
				detailInfo.setFolder(href);
				detailInfo.setTitle(title);
				detailInfo.setTime(time);
				detailInfo.setReply(reply);
				detailInfo.setVisit(visit);
				detailInfo.setId(thread_Id);

				forumThreadDetailInfos.add(detailInfo);
				detailInfo = null;
			}
		}
		return forumThreadDetailInfos;
	}

	/**
	 * 获取楼层讨论信息
	 */
	public List<TopicInfo> getTopicInfos(Document doc){
			Element elementById = doc.getElementById("postlist");
			Elements elementsByTag = elementById.getElementsByTag("table");

			topicInfos = new ArrayList<TopicInfo>();

			for (Element element : elementsByTag) {
				String id = element.id();
				if (id.startsWith("pid")) {
					TopicInfo topicInfo = new TopicInfo();
					Elements postauthorElementsByClass = element.getElementsByClass("postauthor");
					//获取楼层作者
					String author = postauthorElementsByClass.first().getElementsByClass("postinfo").text();
					//获取楼层发表时间
					String time = element.getElementsByClass("authorinfo").first().getElementsByTag("em").text();
					time = time.substring(4);


					//获取楼层内容
					String content = element.getElementsByClass("t_msgfont").text();
					//获取楼层
					String floor = element.getElementsByClass("postinfo").get(1).getElementsByTag("a").first().text();
					//获取pid
					//TODO



					topicInfo.setAuthor(author);
					topicInfo.setContent(content);
					topicInfo.setFloor(floor);
					topicInfo.setTime(time);


					topicInfos.add(topicInfo);
					topicInfo = null;
				}


			}

		return topicInfos;
	}




}

