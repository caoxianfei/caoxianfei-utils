/**
 * 
 */
package com.caoxianfei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月24日下午7:24:29
 */
public final class DateUtil {

	
	
	
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: 产生一个日期在 minDatem 和maxDate
	 * @param minDatem
	 * @param maxDate
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(Date minDate,Date maxDate) {
		long t1 = minDate.getTime();//从1970到minDate的毫米值  1
		long t2 = maxDate.getTime();//从1970到maxDate的毫米值 10
		double d = Math.random();//产生0 -  1 之间随机小数
	//	System.out.println(d);
		 long t3= (long) (( t2 - t1 +1 )*d +t1);
		 
		/*
		 * System.out.println("t1:"+t1); System.out.println("t2:"+t2);
		 * System.out.println("t3:"+t3);
		 */
		return new Date(t3);
		
		
	}	
	
	
	
	public static Date addDays(int days,Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}
	
	
	/**
	* 功能：根据生日计算年龄
	* 示例：现在是2020-4-23，如果生日是2020-5-20，那结果是19
	* 
	* @param Date，生日
	* @return int 年龄
	*/
	public static int getAge(Date birthday){
		 int age = 0;
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(birthday);
		 
		 Calendar cal1 = Calendar.getInstance();
		 
		 if(cal1.after(cal)) {//当前日期是否在输入日期之后
			 //获取当前日期的年份
			 int year = cal1.get(Calendar.YEAR); 
			 //获取当前日期的月份
			 int month = cal1.get(Calendar.MONTH);
			 //获取当前日期
			 int date = cal1.get(Calendar.DAY_OF_MONTH);
			 //获取输入的年份
			 int birYear = cal.get(Calendar.YEAR);
			 //获取输入的月份
			 int birMonth = cal.get(Calendar.MONTH);
			 //获取输入的日期
			 int birDate = cal.get(Calendar.DAY_OF_MONTH);
			 
			 age = year - birYear;
			 if(month < birMonth) {
				 age --;      //当前月份大于 输入月份  
			 }
			 else if(month == birMonth) {
				 if(date < birDate) {
					 age -- ;
				 }
			 }
		 }
		 
		 return age;
		 
	}
	
	
	/**
	* 功能：给定时间对象，获取该时间的月初1日0时0分0秒0毫秒
	* 示例：2018-11-11 08:30:16 → 2018-11-01 00:00:00
	* 使用场景：可用在数据库里查询某月的时间范围
	*
	* @param Date 源时间
	* @return Date 月初时间
	 * @throws ParseException 
	*/
	public static String getFirstDayOfMonth(Date src) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(src);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		/*
		 * String date = year + "-" + month +"-" + "01" + " 00:00:00"; SimpleDateFormat
		 * sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); new
		 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
		 */
		return  year + "-" + month +"-" + "01" + " 00:00:00" ;
	}
	
	/**
	* 功能：给定时间对象，获取该时间的月末最后一天的23时23分59秒999毫秒
	* 示例：2018-11-11 08:30:16 → 2018-11-30 23:23:59
	* 使用场景：可用在数据库里查询某月的时间范围
	*
	* @param Date 源时间
	* @return Date 月末时间
	*/
	public static String getLastDayOfMonth(Date src){
		/**
		 * 	通过判断当前月份为大月还是小月
		 * 	然后再进行一个月份的 天数归整到当月的最后时刻
		 */
		Calendar cal = Calendar.getInstance();				
		cal.setTime(src);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		if(month%2 == 0 && month != 8 && month != 10 && month != 12 || month == 11) {
			return year + "-" + month +"-" + "30" + " 23:23:59";      
																		
		}else { 
			return year + "-" + month +"-" + "31" + " 23:23:59";
		}
		
	}
	
	
	/**
	* 功能：获取当前日期指定天数之前或之后的日期，如果参数为负数，则往前回滚。
	* 示例1：当前是2018-08-08，参数days=5，结果是2018-08-13
	* 示例2：当前是2018-08-08，参数days=-4，结果是2018-08-04
	* 
	* @param int days 偏移的天数，如果为负数则往前回滚。
	* @return Date 新日期
	*/
	public static String offsetDate(int days) {
		Calendar cal = Calendar.getInstance();
		/* cal.setTime(src); */  //如需指定日期 则 放开 注释   否则 自动 选中当前的系统时间
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = 0;
		if(days > 0 ) {
			 day = cal.get(Calendar.DAY_OF_MONTH) + days;
		}else {
			 day = cal.get(Calendar.DAY_OF_MONTH) - (days * -1);  //当中 涉及 年月 的进退   还需补充!!!!!!!!!!!!!!!!!!!!!!!
		}
		
		return year + "-" + month + "-" + day;
	}
	
	/**
	* 功能：获取当前季节，如春季、夏季、秋季、冬季。
	* 
	* @return Season 季节
	*/
	public static Season getCurrentSeason() {
		//TODO 实现代码
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1 ;   //月份从 0  开始计算 所以  加上 1
		if(month < 7) {
			if(month < 4) {
				
				return Season.SPRING;
			}
			return Season.SUMMER;
			
		}else {
			if(month < 10) {
				return Season.AUTUMN;
			}
			return Season.WINTER;
		}
	}
	
	
	/**
	* 功能：获取人性化时间，例如5分钟之内则显示“刚刚”，其它显示16分钟前、2小时前、3天前、4月前、5年前等
	*
	* @param Date date 源时间。
	* @return 人性化时间
	*/
	public static String getDisplayTime(Date date){
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date);
		long time = cal.getTimeInMillis();
		long time2= cal2.getTimeInMillis(); //  将日期转化成  毫秒   1秒 = 1000 毫秒
		long timeEnd = (time2 - time)/1000;   // 将  毫秒 转化成秒 缩小 单位
		if(timeEnd <0) {    // 当 输入的时间  小于  系统时间  说明 评论后 过了 多久时间
			timeEnd = timeEnd * -1;   //将  负数 进行转换  防止 负数出现  导致 程序错误
			if(timeEnd < (3*60)) {
				return "刚刚";            //3分钟以内  显示 刚刚
			}
			else if(timeEnd < (12 * 300) && timeEnd >= (3*60)) {
				int num = (int)timeEnd/60;     // 1小时以内  3分钟往后 包括五分钟  显示 多少分钟
				return num + "分钟前";
			}
			else if (timeEnd < (288 * 300) && timeEnd >=(12 * 300)) {
				int num = (int) timeEnd/(12*300);   //  一天以内  一小时(包含) 以上  显示 多少小时前
				return num + "小时前";
			}
			else if (timeEnd < (720 * 3600 ) && timeEnd >= (288 * 300)) {
				int num = (int) timeEnd/(288 * 300);   // 30天以内 1天 (包含)  显示多少天以前   
				return num + "天前";					//此处存在问题  没有考虑 大月小月 30天 和 31 天的问题  还需补充!!!!!!!!!
			}
			else if (timeEnd < (24 * 365 * 3600 + (7 * 24 * 3600)) && timeEnd >= (720 * 3600 )) {
				int num = (int) timeEnd/(720 * 3600 );    // 一年之内   一月往上 (包含)  
				return num + "月前";
			}
			else if (timeEnd  >= (24 * 365 * 3600 + (7 * 24 * 3600)) ) {
				int num = (int) timeEnd/(24 * 365 * 3600 + (7 * 24 * 3600));   //一年以上(包含)  显示 多少年前
				return num + "年前";
			}
		}
		  //    所有判断条件的  数值 都是 经过 转换  讲  年 月 日 时 分 秒 进行一个 数值的换算  简化 数字位数  
		
		return "人家动态都没发!你就评论了啊？";
	}
	
	
	//枚举方法
	public enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}
	
}
