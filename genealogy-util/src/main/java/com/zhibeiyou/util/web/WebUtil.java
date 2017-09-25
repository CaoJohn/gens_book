package com.zhibeiyou.util.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * httpclient帮助类
 * 
 * @author wwd
 * @date 2016-8-28
 *
 */
public class WebUtil {

	/**
	 * http post请求
	 * 
	 * @author wwd
	 * @date 2016-8-28
	 *
	 * @param url
	 * @param params
	 * @param encoding
	 * @return
	 */
	public static String HttpPost(String url, Map<String, Object> params,
			String encoding) {
		List<NameValuePair> list = new ArrayList<NameValuePair>(); // 封装请求体参数
		if ((params != null) && !params.isEmpty()) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (param.getValue() != null) {
					list.add(new BasicNameValuePair(param.getKey(), param
							.getValue().toString()));
				}
			}
		}
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,
					encoding); // 对请求体参数进行URL编码
			HttpPost httpPost = new HttpPost(url); // 创建一个POST方式的HttpRequest对象
			httpPost.setEntity(entity); // 设置POST方式的请求体
			HttpClient client = new DefaultHttpClient();
			HttpResponse httpResponse = client.execute(httpPost); // 执行POST请求
			int reponseCode = httpResponse.getStatusLine().getStatusCode(); // 获得服务器的响应码
			if (reponseCode == HttpStatus.SC_OK) {
				String resultData = EntityUtils.toString(
						httpResponse.getEntity(), encoding); // 获得服务器的响应内容
				return resultData;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * http get请求
	 * 
	 * @author wwd
	 * @date 2016-8-28
	 *
	 * @param url
	 * @param params
	 * @param encoding
	 * @return
	 */
	public static String HttpGet(String url, Map<String, Object> params,
			String encoding) {
		List<NameValuePair> list = new ArrayList<NameValuePair>(); // 封装请求体参数
		if ((params != null) && !params.isEmpty()) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				list.add(new BasicNameValuePair(param.getKey(), param
						.getValue().toString()));
			}
		}
		try {
			String param = URLEncodedUtils.format(list, encoding);
			System.out.println(url + "?" + param);
			HttpGet httpGet = new HttpGet(url + "?" + param); // 创建一个POST方式的HttpRequest对象
			HttpClient client = new DefaultHttpClient();
			HttpResponse httpResponse = client.execute(httpGet); // 执行POST请求
			int reponseCode = httpResponse.getStatusLine().getStatusCode(); // 获得服务器的响应码
			if (reponseCode == HttpStatus.SC_OK) {
				String resultData = EntityUtils.toString(
						httpResponse.getEntity(), encoding); // 获得服务器的响应内容
				return resultData;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * http get请求
	 * 
	 * @author wwd
	 * @date 2016-8-28
	 *
	 * @param url
	 * @param params
	 * @param encoding
	 * @return
	 */
	public static String HttpGet(String url, String params, String encoding) {
		try {
			String linkUrl = url;
			if (params != null && !params.equals("")) {
				linkUrl += "?" + params;
			}
			HttpGet httpGet = new HttpGet(linkUrl); // 创建一个POST方式的HttpRequest对象
			HttpClient client = new DefaultHttpClient();
			HttpResponse httpResponse = client.execute(httpGet); // 执行POST请求
			int reponseCode = httpResponse.getStatusLine().getStatusCode(); // 获得服务器的响应码
			if (reponseCode == HttpStatus.SC_OK) {
				String resultData = EntityUtils.toString(
						httpResponse.getEntity(), encoding); // 获得服务器的响应内容
				return resultData;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
