/**
 * 
 */
package com.caoxianfei.util;

import org.junit.Test;

import com.caoxianfei.utils.NumberUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月23日下午9:40:26
 */
public class NumberTest {

	@Test
	public void isNumber() {
		boolean number = NumberUtil.isNumber("");
		System.out.println(number);
	}

	@Test
	public void isReal() {
		boolean number = NumberUtil.isReal("-1.0");
		System.out.println(number);
	}
	
	@Test
	public void add() {
		
		System.out.println(NumberUtil.add(1,2));
	}
	
	@Test
	public void sub() {
		System.out.println(NumberUtil.sub(8.02,3));
	}
	
	@Test
	public void mul() {
		System.out.println(NumberUtil.mul(6,2));
	}
	
	@Test
	public void div() {
		System.out.println(NumberUtil.div(10,3,10));
	}
	
	@Test
	public void round() {
		System.out.println(NumberUtil.round(6.346,2));
	}
}
