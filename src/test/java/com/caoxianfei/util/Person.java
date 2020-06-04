/**
 * 
 */
package com.caoxianfei.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月26日下午7:32:17
 */
public class Person {

	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
	
	private Integer age;
	
	private String about;
	
	private String created;

	@Override
	public String toString() {
		return "编号:" + id + "姓名:" + name + " 年龄:" + age + " 介绍:" + about + " 注册日期:" + created ;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Integer id, String name, Integer age, String about, String created) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.about = about;
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
}
