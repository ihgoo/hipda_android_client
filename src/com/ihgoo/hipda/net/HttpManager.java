package com.itheima.hipda.net;




import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.itheima.hipda.bean.ForumThreadDetailInfo;
import com.itheima.hipda.parser.PageParser;
import com.itheima.hipda.utils.BBSAPI;
import com.itheima.hipda.utils.StreamUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * HTTP通讯管理:用于访问网络数据
 * @created 2014年8月7日
 * @author KelvinHu
 */
public class HttpManager {

	private static HttpManager instance = new HttpManager();
	private HttpManager(){}
	public static HttpManager getInstance(){
		return instance;
	}
	
	private HttpUtils httpUtils;
	private Document doc;
	
	
	/**
	 * 获取httputils单一对象
	 */
	private void getHttpUtils() {
		if (httpUtils == null) {
			httpUtils = new HttpUtils();
			httpUtils.configUserAgent(BBSAPI.USER_AGENT);
			httpUtils.configResponseTextCharset(BBSAPI.CHARSET);
		}
	}
	
	
	/**
	 * 从网络获取document
	 * @param url
	 * @return
	 * 
	 */
	public Document getDocumentByNet(String url){
		
		String result = this.sendSync(HttpMethod.GET, url,null);
		doc = Jsoup.parseBodyFragment(result);
		return doc;
	}
	
	public String sendSync(HttpMethod method, String url){
		return sendSync(method, url, null);
	}
	
	/**
	 * 同步方式请求网络
	 * @param method
	 * @param url
	 * @param params
	 * @return
	 */
	public String sendSync(HttpMethod method, String url,RequestParams params){
		getHttpUtils();
		try {
			ResponseStream responseStream = httpUtils.sendSync(method, url, params);
			String result = StreamUtils.parserStream(responseStream.getBaseStream());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 异步方式访问网络（GET方式）
	 * @param method
	 * @param url
	 * @param callBack
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public HttpHandler sendGet(String url,RequestCallBack callBack){
		getHttpUtils();
		return httpUtils.send(HttpMethod.GET, url, callBack);
	}
	
	@SuppressWarnings("unchecked")
	public HttpHandler sendPost(String url,RequestParams params,RequestCallBack callBack){
		getHttpUtils();
		return httpUtils.send(HttpMethod.POST, url, params, callBack);
	}
	
	
	/**
	 * 通过网络获得论坛帖子bean
	 * @param url
	 * @return
	 */
	public List<ForumThreadDetailInfo> getForumThreadDetailInfo(String url){
		getHttpUtils();
		
		try {
			String result = this.sendSync(HttpMethod.GET, url,null);
			if (result!=null) {
				return PageParser.getInstance().getForumThreadListDetail(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
