/**
 *
 * File Name:ResponseCode.java
 * Date:2017年8月29日上午10:56:15
 * Copyright (c) 2017, dong_cheng@outlook.com All Rights Reserved.
 *
*/

package com.zhibeiyou.util.constants;
/**
 * Function: desc
 * Reason:	 desc
 * Date:     2017年8月29日 上午10:56:15
 * @author   cheng
 * @version
 * @since    JDK 1.7
 * @see
 */
public enum ResponseCode {

	SUCCESS(0,"SUCCESS"),
	ERROR(1,"ERROR"),
	NEED_LOGIN(10,"NEED_LOGIN"),
	ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");
	
	private final int code;
	private final String desc;
	ResponseCode(int code,String desc){
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
}

