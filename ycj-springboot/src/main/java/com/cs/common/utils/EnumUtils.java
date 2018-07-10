package com.cs.common.utils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import com.cs.common.enums.ClientTypeEnum;
import com.cs.mvc.mybatis.enumhandler.Identifiable;




/**
 * 操作枚举的工具类
 * @author vicent
 */
public class EnumUtils {

    /**
     * 根据一个索引得到某个枚举类的枚举值
     * @param <I>
     * @param <K>
     * @param type
     * 	枚举类的Class
     * @param id
     * 	索引
     * @return
     * @throws AssertionError
     * 	若提供的索引在枚举中没有对映的映射,抛出此断言错误
     */
	public static <T extends Enum<T> & Identifiable<K>, K> T getEnum(Class<T> type, K id) {
		T[] arr = type.getEnumConstants();
		if (arr == null || arr.length <= 0) {
			 throw new AssertionError("不能够映射:" + id + "到枚举" + type.getSimpleName());
		}
		for (T t : arr) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		 throw new AssertionError("不能够映射:" + id + "到枚举" + type.getSimpleName());
	}
	
	public static <T extends Enum<T> & Identifiable<K>, K> T get(Class<T> type, K id) {
		EnumSet<T> set = EnumSet.allOf(type);
		if (set == null || set.size() <= 0) {
			throw new AssertionError("不能够映射:" + id + "到枚举" + type.getSimpleName());
		}
		for (T t : set) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		throw new AssertionError("不能够映射:" + id + "到枚举" + type.getSimpleName());
	}
	
	/**
	 * @Title: getAll 
	 * @Description: 获取枚举所有的值的列表
	 * @param: @param calzz
	 * @param: @return    
	 * @return: List<T>    
	 * @throws 
	 * @author llz
	 * @Date 2018年7月10日 下午7:55:46
	 */
	public static <T extends Enum<T> & Identifiable<K>, K> List<T> getAll(Class<T> calzz) {
		return Arrays.asList(calzz.getEnumConstants());
	}

}
