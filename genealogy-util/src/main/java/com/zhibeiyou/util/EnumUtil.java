package com.zhibeiyou.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 枚举帮助类
 * @author wwd
 * @date 2017年3月19日
 */
public final class EnumUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static List<EnumModel> EnumToList(Class cls) {
		List<EnumModel> list = new ArrayList<EnumModel>();
		try {
			Method m1 = cls.getMethod("getKey");
			Method m2 = cls.getMethod("getVal");
			Object[] objs = cls.getEnumConstants();
			for (Object obj : objs) {
				EnumModel model = new EnumModel();
				model.setKey(m1.invoke(obj));
				model.setVal(m2.invoke(obj));
				list.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}
	
	/**
	 * 
	 * @author wwd
	 * @date 2017年3月19日
	 * @param cls			enum类
	 * @param flag			true表示数组里的是要的，FALSE表示数组里的是不要的
	 * @param objects		enum中key的数组
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static List<EnumModel> EnumToList(Class cls,boolean flag, Object[] objects) {
		List<EnumModel> list = new ArrayList<EnumModel>();
		if(objects != null ){
			List<Object> objList = Arrays.asList(objects);
			try {
				Method m1 = cls.getMethod("getKey");
				Method m2 = cls.getMethod("getVal");
				Object[] objs = cls.getEnumConstants();
				for (Object obj : objs) {
					if(flag){
						if(objList.contains(m1.invoke(obj))){
							EnumModel model = new EnumModel();
							model.setKey(m1.invoke(obj));
							model.setVal(m2.invoke(obj));
							list.add(model);
						}
					}else{
						if(!objList.contains(m1.invoke(obj))){
							EnumModel model = new EnumModel();
							model.setKey(m1.invoke(obj));
							model.setVal(m2.invoke(obj));
							list.add(model);
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;

	}
	
	/**
	 * 
	 * 
	 * @param cls
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static Map<Object, Object> EnumToMap(Class cls){
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		try {
			Method m1 = cls.getMethod("getKey");
			Method m2 = cls.getMethod("getVal");
			Object[] objs = cls.getEnumConstants();
			for (Object obj : objs) {
				map.put(m1.invoke(obj), m2.invoke(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param cls			enum类
	 * @param flag			true表示数组里的是要的，FALSE表示数组里的是不要的
	 * @param objects		enum中key的数组
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static Map<Object, Object> EnumToMap(Class cls,boolean flag, Object[] objects){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(objects != null ){
			List<Object> list = Arrays.asList(objects);
			try {
				Method m1 = cls.getMethod("getKey");
				Method m2 = cls.getMethod("getVal");
				Object[] objs = cls.getEnumConstants();
				for (Object obj : objs) {
					if(flag){
						if(list.contains(m1.invoke(obj))){
							map.put(m1.invoke(obj), m2.invoke(obj));
						}
					}else{
						if(!list.contains(m1.invoke(obj))){
							map.put(m1.invoke(obj), m2.invoke(obj));
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
}
