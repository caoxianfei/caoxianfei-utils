/**
 * 
 */
package com.caoxianfei.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月23日下午4:22:11
 */
public final class StringUtil {

	/*
	 * 功能:检测字符串是否为空
	 *  StringUtil.hasLength(null) -> false
	 * StringUtil.hasLength("") -> false
	 * StringUtil.hasLength(" ") -> true
	 * StringUtil.hasLength("Hello") -> true
	 * 
	 * */
	public static boolean hasLength(String src) {
		
		return  src != null && src.length()>0 ;
		
	}
	
	/**
	* 功能：检查包含空白字符在内的字符系列长度，并处理过滤前后空格
	* 示例：
	* StringUtil.hasText(null) -> false
	* StringUtil.hasText("") -> false
	* StringUtil.hasText(" ") -> false
	* StringUtil.hasText("Hello") -> true
	*/
	public static boolean hasText(String text) {

		if( null == text || "".equals(text.trim()) ) {
			
			return false;	
			
		}
		return true;
		
	}
	
	
	/**
	* 功能：验证是否为合格邮箱
	* 示例：
	* StringUtil.isEmail(null) -> false
	* StringUtil.isEmail("") -> false
	* StringUtil.isEmail("zhangjihao@") -> false
	* StringUtil.isEmail("zhangjihao@sohu") -> false
	* StringUtil.isEmail("zhangjihao@sohu.com") -> true
	*/
	public static boolean isEmail(String email) {
		if (null==email || "".equals(email)){
	        	return false; 
		}
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		boolean matches = Pattern.compile(regex).matcher(email).matches();
		
		return matches;
	}
	
	/**
	* 功能：验证是否为合格手机
	* 示例：
	* StringUtil.isPhone(null) -> false
	* StringUtil.isPhone("") -> false
	* StringUtil.isPhone("14312039428") -> false
	* StringUtil.isPhone("13900139000") -> true
	*/
	public static boolean isPhone(String phone) {
		if (null == phone || "".equals(phone)){
        	return false; 
		}
		String regex = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(phone);
		return matcher.matches();
	}
	
	/**
	* 功能：判断是否全部为字母
	* 示例：
	* StringUtil.isLetter(null) -> false
	* StringUtil.isLetter("") -> false
	* StringUtil.isLetter(".com") -> false
	* StringUtil.isLetter("howSun") -> true
	*/
	public static boolean isLetter(String src) {
		if(null ==  src || "".equals(src)) {
			return false;
		}
		String regex = "[a-zA-Z]";
		Pattern compile = Pattern.compile(regex);
		for (int i = 0; i < src.length(); i++) {
			Matcher matcher = compile.matcher(src.substring(i,i+1));
			if(matcher.matches()!=true) {
				return false;
			}
		}
		return true;
	}
	
	/**
	* 功能：隐藏字符串
	* 示例：
	* StringUtil.hidden("13856237928", 3,7) -> "138****7928"
	* 参数1：src，源字符串
	* 参数2：start，从开始的位置隐藏，如果为空，则全部不隐藏，
	* 参数3：end，结束位置，如果为空或为-1，则直到末尾都隐藏，如果超过源字符串长度，则只到末尾
	*/
	public static String hidden(String src , Integer start ,Integer end) {
		if(src == null){
			return src;
		}
		
		StringBuffer result = new StringBuffer();

		if(end == null){
			end = src.length();
		}
		
		char[] chars = src.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if(start != null && start <= i && i < end){
				result.append('*');
			}else{
				result.append(c);
			}
		}

		return result.toString();
		
	}
	
}
