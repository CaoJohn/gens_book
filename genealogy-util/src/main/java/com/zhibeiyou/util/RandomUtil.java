package com.zhibeiyou.util;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数生成
 * @author wwd
 * @date   2016年11月16日
 */
public class RandomUtil {
	/**
	 * 获取UUID 去除"-"
	 * @author wwd
	 * @date   2016年11月16日
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 生成数字的随机数
	 * @author wwd
	 * @date   2016年11月16日
	 *
	 * @param 	digit		位数,最小为1，最大为20
	 * @return
	 */
	public static String getRandomCode(int digit){
		String code = "";
		if(digit <= 20 && digit > 0){
			Integer base = Integer.MAX_VALUE;
			Long l = (long) (Math.pow(10, digit) - 1);
			if(l < Integer.MAX_VALUE){
				base = (int) Math.pow(10, digit) - 1;
			}
			
			Random rm = new Random();
			Integer num = rm.nextInt(base);
			code = num.toString();
			int lenght = num.toString().length();
			for(int i = digit; i > lenght; i--){
				code = "0" + code;
			}
		}
		
		return code;
	}
	
	/**
	 * 格式整形
	 * @author wwd
	 * @date   2016年11月29日 下午1:41:51
	 * @param val
	 * @param digit
	 * @return
	 */
	public static String formatInt(Integer val, Integer digit){
		if(digit == null){
			return val == null ? null : val.toString();
		}
		if(val != null){
			String code = val.toString();
			if(digit < 9 && digit > 0){
				int lenght = val.toString().length();
				for(int i = digit; i > lenght; i--){
					code = "0" + code;
				}
			}
			
			return code;
		}else{
			return "";
		}
	
	}
	
}
