package com.jmu.uacs.util;

import java.util.Collection;

public class MyCollectionUtils {

	public static boolean hasOneEle(Collection collection) {
		if(collection != null && collection.size() == 1) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(Collection collection) {
		if(collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
}
