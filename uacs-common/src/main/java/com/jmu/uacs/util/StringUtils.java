package com.jmu.uacs.util;

/**
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


    /**
     * 将 int 类型的数组转化为 string 字符串
     *
     * @param intArr 需要转化的数组
     * @param separator 分隔符
     * @return
     */
    public static String parseIntArrayToString(Integer[] intArr, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < intArr.length; i++) {
            sb.append(intArr[i]).append(separator);
        }
        sb.substring(sb.length());
        return sb.toString();
    }
}
