/**
 * 
 */
package com.caoxianfei.utils;

import java.util.Collection;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月25日下午9:04:09
 */
public class CollectionUtil {

	/**
	 * 
	    * @Title: isEmpty 
	    * @Description: 判断集合是否为空
	    * @param @param collection
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isEmpty(Collection<?> collection ) {
		return null==collection || collection.isEmpty();  //为空就返回 true 不为空就false
	}
	
}
