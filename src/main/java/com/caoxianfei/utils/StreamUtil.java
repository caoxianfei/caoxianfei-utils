package com.caoxianfei.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	

	/**
	 * 功能：批量关闭流。
	 *
	 * @param AutoCloseable... closeables 多个可关闭的对象
	 */
	public static void closings(AutoCloseable... closeables) {
		if (closeables == null || closeables.length == 0)
			throw new RuntimeException("参数异常");

		for (AutoCloseable autoCloseable : closeables) {
			try {
				autoCloseable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 功能：读取文本流，也可以将流转成字符串，默认编码为UTF-8
	 *
	 * @param InputStream inputStream 输入流
	 * @param boolean     isClose 读完后是否关闭流
	 *
	 * @return 字符串
	 */
	public static String asString(InputStream ins, boolean isClose) {

		byte[] b = new byte[1024];
		int len = -1;

		try {
			while ((len = ins.read(b)) != -1) {
				return new String(b, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(isClose) {
				closings(ins);
			}
		}

		return null;
	}

	/**
	 * 功能：按行读取文本文件，返回一个List集合，默认编码为UTF-8，默认关闭流
	 *
	 * @param File    textFile 文本文件
	 * @param String  encode 指定编码
	 * @param boolean isClose 处理完成后是否关闭流
	 *
	 * @return 字符串集合
	 */
	@SuppressWarnings("resource")
	public static List<String> readingLineFormTextFile(File textFile) throws IOException {
		return 	readingLineFormTextFile(new FileInputStream(textFile));

	}
	public static List<String> readingLineFormTextFile(InputStream inputStream) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		ArrayList<String> list = new ArrayList<String>();
		String line=null;
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		return list;

		
	}

	public static String readTextFile(File txtFile) throws FileNotFoundException {
		return asString(new FileInputStream(txtFile),true);
	}

}
