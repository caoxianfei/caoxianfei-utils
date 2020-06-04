/**
 * 
 */
package com.caoxianfei.util;

import org.junit.Test;

import com.caoxianfei.utils.RandomUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月24日下午8:31:23
 */
public class RandomUtilTest {

	@Test
	public void nextInt() {
		System.out.println(RandomUtil.nextInt());  // 随即获取一个 最大的 十位 正整数
	}
	
	@Test
	public void nextIntMax() {
		System.out.println(RandomUtil.nextInt(5));   //输入一个数字保证 生成 0 到 x 范围内的最大正整数  方法内 加1 来保证范围
	}
	
	@Test
	public void nextIntMinMax() {
		System.out.println(RandomUtil.nextInt(5,10)); //输入一个 整数范围  进行一个随机生成最大的 正整数 随机生成结果 加上差值达到效果
	}
	
	@Test
	public void subIntegers() {
		int[] integer = RandomUtil.subIntegers(1, 20, 10);//指定一个范围 得到一个 长度为  x 的数组
		for (int i : integer) {
			System.out.println(i);    //得到一个  长度为x 的随机数组 且里边的值 不重复
		}
	}
	
	@Test
	public void nextCharacter() {
		System.out.println(RandomUtil.nextCharacter());   //随机获取一个 0-9 a-z A-Z 的 字符
	}
	
	@Test
	public void nextString() {
		System.out.println(RandomUtil.nextString(10)); // 得到长度为指定 的 一个字符串
	}
	
	@Test
	public void nextStringMinMax() {
		System.out.println(RandomUtil.nextString(2, 12));   // 随即获取一个 指定范围内长短的 随机字符串
	}
	
	@Test
	public void nextSimplifiedChineseString() {
		System.out.println(RandomUtil.nextSimplifiedChineseString(1));  //随机获取一个 指定长度的中文简体字符
	}
	
	@Test
	public void generateChinesePersonName() {  
		System.out.println(RandomUtil.generateChinesePersonName());    //随机获取一个人名
	}
	
	@Test
	public void uuid() { 
		System.out.println(RandomUtil.uuid());   //获取一串 不带 - 的 随机数
	}
	
}
