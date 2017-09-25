package com.zhibeiyou.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 * @author wwd
 * @date 2014-7-17
 *
 */
public final class ValidatorUtil {
	private static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";		//邮箱
	private static final String ID_CARD_NO = "^\\d{15}|\\d{18}$";									//身份证
	private static final String TELEPHONE = "^((\\d{3,4}-)|\\d{3,4})?\\d{7,8}$";					//座机
	private static final String MOBILEPHONE = "^(13[0-9]|15[0-9]|18[0-9])\\d{8}$";					//手机号
	private static final String HK_MOBILEPHONE = "^(5|6|9)[0-9]{7}$";								//验证香港手机
	
	private static final String INTEGER = "^-?0*[1-9][0-9]{0,9}$";									//验证是否是Integer
	private static final String LONG = "^-?0*[1-9][0-9]{0,17}$";									//验证LONG
	
	private static final String MONEY = "^[0-9]{1,10}(.[0-9]{1,2})?$";								//验证金额
	private static final String AREA = "^[0-9]{1,10}(.[0-9]{1,2})?$";								//验证面积
	
	private static final String PERCENT = "^[0]{1}[.]{1}([0-9]{1,3})$";
	
	private static final String COORDINATE = "^(\\d{1,3})?[.]\\d{1,6}$";							//验证坐标
	
	
	/**
	 * 校验数组有效
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param arr
	 * @return
	 */
	public static boolean arrayIsValid(Object[] arr) {
		return null != arr && arr.length > 0;
	}
	
	/**
	 * 校验数组无效
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param arr
	 * @return
	 */
	public static boolean arrayIsNotValid(Object[] arr) {
		return !arrayIsValid(arr);
	}	
	
	

	/**
	 * 验证是否整数
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateInteger(String input){
		if(match(input, INTEGER)){
			Integer base = Integer.MAX_VALUE;
			if(Long.parseLong(input) >base){
				return false;
			}else{
				base = Integer.MIN_VALUE;
				if(base > Long.parseLong(input)){
					return false;
				}else{
					return true;
				}
			}
		}
			
		return false;
	}
	
	/**
	 * 检验是否long
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateLong(String input){
		if(match(input, LONG)){
			BigDecimal base = new BigDecimal(Long.MAX_VALUE);
			BigDecimal bd = new BigDecimal(input);
			if(bd.compareTo(base) > 0){
				return false;
			}else{
				base = new BigDecimal(Long.MIN_VALUE);
				if(base.compareTo(bd) > 0){
					return false;
				}else{
					return true;
				}
			}
		}
			
		return false;
	}
	
	/**
	 * 检验是否未long
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param list
	 * @return
	 */
	public static boolean validateLong(List<String> list){
		boolean flag = true;
		if(list != null && list.size() > 0){
			for(String s : list){
				flag = validateLong(s);
				if(!flag){
					return false;
				}
			}
		}else{
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 验证邮箱
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateEmail(String input){
		return match(input, EMAIL);
	}
	
	/**
	 * 验证座机
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateTelephone(String input){
		return match(input, TELEPHONE);
	}
	
	/**
	 * 验证手机
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateMobilephone(String input){
		return match(input, MOBILEPHONE);
	}
	
	/**
	 * 验证香港手机
	 * @author  wwd
	 * @date    2016-8-10
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validateHKMobilephone(String input){
		return match(input, HK_MOBILEPHONE);
	}
	
	/**
	 * 验证身份证
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateIDcardno(String input){
		return match(input, ID_CARD_NO);
	}
	
	/**
	 * 正则验证
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean validateStr(String str, String regex){
		return match(str, regex);
	}
	
	/**
	 *  检验金额
	 * @author wwd
	 * @date   2016-4-18
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validateMoney(String input){
		return match(input, MONEY);
	}
	
	/**
	 * 判断字符串长度
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param str
	 * @param maxLength
	 * @return
	 */
	public static boolean validateStr(String str, int maxLength){
		if(StrUtil.isEmpty(str)){
			return false;
		}else{
			if(str.length() > maxLength){
				return false;
			}else{
				return true;
			}
		}
	}
	
	/**
	 * 判断字符串是否相同
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param str
	 * @param compareStr
	 * @return 	
	 * 		1	相同
	 * 		0	不同
	 * 		-1	其中有空字符串
	 */
	public static Integer validateBoolStr(String str,String compareStr){
		if(StrUtil.notEmpty(str, compareStr)){
			if(str.equals(compareStr)){
				return 1;
			}else{
				return 0;
			}
		}else{
			return -1;
		}
	}
	
	/**
	 * 验证面积
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validateArea(String input){
		return match(input, AREA);
	}
	
	/**
	 * 验证小于0的小数，小数点后面3位
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param input
	 * @return
	 */
	public static boolean validatePercent(String input){
		return match(input,PERCENT);
	}
	
	public static boolean validateCoordinate(String input){
		return match(input,COORDINATE);
	}
	
	/**
	 * 正则表达式验证
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean match(String str, String regex){
		if(str != null){
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			return m.matches();
		}else{
			return false;
		}
		
	}
	
	/**
	 * 验证时间字符串
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param time				时间字符串
	 * @param format			格式
	 * @return
	 */
	public static boolean validateDate(String time,String format){
		boolean flag = false;
		if(StrUtil.notEmpty(time,format)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.parse(time);
				flag = true;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	/**
	 * 单个为空
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj){
		return obj == null ? true : false;
	}
	
	/**
	 * 全为null
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param objs
	 * @return
	 */
	public static boolean isAllNull(Object... objs){
		if(objs != null && objs.length > 0){
			for(Object obj : objs){
				if(obj != null){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 全都不为null
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param objs
	 * @return
	 */
	public static boolean isAllNotNull(Object... objs){
		if(objs != null && objs.length > 0){
			for(Object obj : objs){
				if(obj == null){
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
	/**
	 * 不是全为空
	 * @author wwd
	 * @date   2016-8-25
	 *
	 * @param objs
	 * @return
	 */
	public static boolean isNotAllNull(Object... objs){
		return !isAllNull(objs);
	}
	
//	public static void main(String[] args){
//		String url = "/index/fin/findPage";
//		String regex = "^/([A-Za-z0-9_]{1,}/){0,}(get|find)[A-Za-z0-9_]{0,}Page$";
//		System.out.println(match(url, regex));
//	}
}
