package com.zhibeiyou.util;

/**
 * 字符串工具类
 * @author 
 * @date   2016年11月16日 下午8:49:35
 */
public final class StrUtil {
	/**
	 * 判断字符串为空
	 */
	public static boolean isEmpty(String str){
		if(str != null && str.trim() != ""){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断字符串不为空
	 */
	public static boolean notEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * 判断字符串为空（多个）
	 */
	public static boolean isEmpty(String ...strings){
		if(strings == null){
			return true;
		}else{
			for(String str : strings){
				if(notEmpty(str)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串不为空（多个）
	 */
	public static boolean notEmpty(String ...strings){
		if(strings == null){
			return false;
		}else{
			for(String str : strings){
				if(isEmpty(str)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 字符串去除前后多余空格
	 */
	public static String trim(String str){
		if(isEmpty(str)){
			return "";
		}
		return str.trim();
	}
}
