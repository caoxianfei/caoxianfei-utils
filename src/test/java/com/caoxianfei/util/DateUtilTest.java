/**
 * 
 */
package com.caoxianfei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.caoxianfei.utils.DateUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月24日下午8:06:45
 */
public class DateUtilTest {

	@Test
	public void getAge() throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-11-06"); // 自定义日期格式 将字符串写入 进行一个日期的转换
		System.out.println(DateUtil.getAge(date));   // 测试  当前时间的年龄
	}
	
	@Test
	public void getFirstDayOfMonth() {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-11-06");   //获取当前月份 第一天开始的 时间
			System.out.println(DateUtil.getFirstDayOfMonth(date));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getLastDayOfMonth() {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-10-06");     //自动获取 当前月为大月小月  最后一天 的最后 时期
			System.out.println(DateUtil.getLastDayOfMonth(date));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void offsetDate() {
		System.out.println(DateUtil.offsetDate(-5)); // 输入一个 整数正负参数 计算当前日前的 前后 x 日期 为负则后退 为正则前进 
	}
	
	
	@Test
	public void getCurrentSeason() {
		System.out.println(DateUtil.getCurrentSeason());   // 自动获取当前月份 为哪个  季节
	}
	
	@Test
	public void getDisplayTime() {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-5-11 19:59:10");     
			System.out.println(DateUtil.getDisplayTime(date));
		} catch (Exception e) {                            // 比如 微信评论的 刚刚  分钟前 小时前 等等
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
