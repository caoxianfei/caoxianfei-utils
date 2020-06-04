/**
 * 
 */
package com.caoxianfei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.caoxianfei.utils.RandomUtil;
import com.caoxianfei.utils.StringUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月26日下午7:35:18
 */
public class TestWeek {

	@Test
	public void test() {
		int id=0;
		for (int k = 0; k < 10000; k++) {
			String name = RandomUtil.generateChinesePersonName();
			int age = RandomUtil.nextInt(1,120);
			String string = RandomUtil.nextSimplifiedChineseString(140);
			int i = RandomUtil.nextInt(1,4);
			int j = RandomUtil.nextInt(1,26);
			String src = "2020"+ "-" + i + "-" + j;
			Date date=null;
			try {
				date= new SimpleDateFormat("yyyy-MM-dd").parse(src);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id++;
			Person p = new Person();
			p.setId(id);
			p.setName(name);
			p.setAge(age);
			p.setAbout(string);
			p.setCreated(src);
			System.out.println(p);
		}
		
	}
	
}
