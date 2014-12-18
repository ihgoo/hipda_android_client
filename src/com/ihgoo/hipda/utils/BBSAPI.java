package com.ihgoo.hipda.utils;



/**
 * Hipda接口
 * @created 2014年8月12日
 * @author KelvinHu
 */
public interface BBSAPI {
	
	/**
	 * 论坛首页
	 */
	String HIPDA_BASE = "http://www.hi-pda.com/forum";
	/**
	 * e-link版(游客可访问)
	 */
	String HIPDA_EINK = HIPDA_BASE + "/forumdisplay.php?fid=7";
	
	/**
	 * 准备登录的地址
	 */
	String HIPDA_PRELOGIN = HIPDA_BASE + "/logging.php?action=login&referer=http:///www.hi-pda.com/forum/index.php&sid=";
	
	/** 登录地址 **/
	String HIPDA_LOGIN = HIPDA_BASE + "/logging.php?action=login&loginsubmit=yes&inajax=1";
	
	/**
	 * 网页编码格式
	 */
	String CHARSET = "GBK";
	
	/**
	 * 模拟的user_agent
	 */
	String USER_AGENT = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)";
	
//	public final static String 
	
	
	
}
