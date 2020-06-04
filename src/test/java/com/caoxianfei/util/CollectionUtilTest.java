/**
 * 
 */
package com.caoxianfei.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.caoxianfei.utils.CollectionUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月25日下午9:04:50
 */
public class CollectionUtilTest {
			
	@Test
	public void testIsEmpty() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		boolean empty = CollectionUtil.isEmpty(list);  //如果是 空就 返回 true 不为空就返回 false
		System.out.println(empty);
	}
}
