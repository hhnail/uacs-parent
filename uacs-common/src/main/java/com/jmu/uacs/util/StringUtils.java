package com.jmu.uacs.util;

/**
 * 
 * @author Hhnail 字符串工具类
 */
public class StringUtils {

	// 检查字符串是否为空（既不能是null，也不能是空字符串""）
	public static boolean isEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return false;
		}
		return true;
	}
}
