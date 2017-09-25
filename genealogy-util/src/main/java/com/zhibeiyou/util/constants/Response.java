/**
 *
 * File Name:Response.java
 * Date:2017年8月29日上午10:50:08
 * Copyright (c) 2017, dong_cheng@outlook.com All Rights Reserved.
 *
*/

package com.zhibeiyou.util.constants;

import java.io.Serializable;


/**
 * Function: desc Reason: desc Date: 2017年8月29日 上午10:50:08
 * 
 * @author cheng
 * @version
 * @since JDK 1.7
 * @see
 */

public class Response<T> implements Serializable {

	private int status;
	private String msg;
	private T data;

	private Response(int status) {
		this.status = status;
	}

	private Response(int status, T data) {
		this.status = status;
		this.data = data;
	}

	private Response(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private Response(int status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public static <T> Response<T> msgSuccess() {
		return new Response<T>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> Response<T> msgSuccess(String msg) {
		return new Response<T>(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static <T> Response<T> msgSuccess(T data) {
		return new Response<T>(ResponseCode.SUCCESS.getCode(), data);
	}

	public static <T> Response<T> msgSuccess(String msg, T data) {
		return new Response<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	public static <T> Response<T> msgFail() {
		return new Response<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> Response<T> msgFail(String errorMessage) {
		return new Response<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static <T> Response<T> msgFail(int errorCode, String errorMessage) {
		return new Response<T>(errorCode, errorMessage);
	}

}
