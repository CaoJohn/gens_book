package com.zhibeiyou.util;

import java.io.Serializable;

public class EnumModel implements Serializable {
	private static final long serialVersionUID = 6825478897802952328L;
	private Object key;
	private Object val;
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
	
	
}
