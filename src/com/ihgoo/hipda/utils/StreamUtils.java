package com.itheima.hipda.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StreamUtils {
	/**
	 * 把服务器的流 解析成String
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static String parserStream(InputStream is) throws IOException{
		InputStreamReader isr=new InputStreamReader(is,BBSAPI.CHARSET);
		BufferedReader reader=new BufferedReader(isr);
		
		// 定义内存流 接受输入流
		StringWriter sw=new StringWriter();
		String str=null;
		while((str=reader.readLine())!=null){
			sw.write(str);
		}
		return sw.toString();
		
		
	}
}