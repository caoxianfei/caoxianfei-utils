/**
 * 
 */
package com.caoxianfei.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import com.caoxianfei.utils.StringUtil;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月23日下午4:24:03
 */
public class StringUtilTest {
	
		@Test
		public void hasLength() {
			
			boolean bo = StringUtil.hasLength(" ");
			
			System.out.println(bo);
		}

		@Test
		public void hasText() {
		
		  boolean text = StringUtil.hasText("");
		  
		  System.out.println(text);
		 
		
		}
		
		@Test
		public void isEmail() {
			
			boolean email = StringUtil.isEmail("948315767@qq.com");
			
			System.out.println(email);
			
		}
		
		@Test
		public void isPhone() {
			
			boolean phone = StringUtil.isPhone("15879352381"); 
			
			System.out.println(phone); 
			
		}
		
		@Test
		public void isLetter() {
			
			boolean letter = StringUtil.isLetter("aaa");
			
			System.out.println(letter);
		}
	
		
		@Test
		public void hidden() {
			
			String phone = "13823588392";
			String hiddenPhone = StringUtil.hidden(phone, 3, 7);
			System.out.println(hiddenPhone);
			Assert.assertEquals(hiddenPhone, "138****8392");
			
			String username = "zhangjihao";
			String hiddenUsername = StringUtil.hidden(username, 1, username.length() - 1);
			System.out.println(hiddenUsername);
			Assert.assertEquals(hiddenUsername, "z********o");
			
			String name = "高巍";
			String hiddenName = StringUtil.hidden(name, 1, null);
			System.out.println(hiddenName);
			Assert.assertEquals(hiddenName, "高*");
			
			String str1 = "中华人民共和国";
			String hiddenStr = StringUtil.hidden(str1, null, null);
			System.out.println(hiddenStr);
			Assert.assertEquals(hiddenStr, hiddenStr);
			
			String str2 = "中华人民共和国";
			String hiddenStr2 = StringUtil.hidden(str2, null, 100);
			System.out.println(hiddenStr2);
			Assert.assertEquals(hiddenStr2, hiddenStr2);
			
		}
	
}
