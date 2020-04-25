/**
 * 
 */
package com.caoxianfei.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author (caoxianfei) email:(948315767@qq.com)
 * @version v1.0
 * @date 
 *	  创建于:2020年4月24日下午8:28:18
 */
public class RandomUtil {

	/**
	* 功能：获取随机正整数
	*
	* @return int 正整数
	*/
	public static int nextInt(){
		int value = ThreadLocalRandom.current().nextInt();  //通过本地线程 随即的生成一个 正  整数
		return (value & 0x7FFFFFFF) | 0x1000100;   //获取最大值  本行代码相当于 无论 正 负  都返回一个 最大正数
	}
	
	/**
	* 功能：获取指定最大范围的随机正整数
	* 示例：max=5，那么返回0-5(包括5)之间任意一个数
	*
	* @param int max 最大范围，要包含最大范围值。
	* @return 随机数
	*/
	public static int nextInt(int max) {
		int value = ThreadLocalRandom.current().nextInt(max + 1);  //随机获取 0 - 输入值 之间的正整数
		return value; 
	}
	
	/**
	* 功能：获取指定一段范围内最大的随机正整数
	* 示例：min=5,max=10，那么返回5-10(包括5和10)之间任意一个数
	*
	* @param int min 最小范围，要包含最小范围值。
	* @param int max 最大范围，要包含最大范围值。
	* @return 随机数
	*/
	public static int nextInt(int min, int max) {
		int value = ThreadLocalRandom.current().nextInt((max + 1) - min);  //指定一段范围内的 一个正整数
		return min + value;
	}
	
	/**
	* 功能：在最小值与最大值之间截取随机数
	* 场景：在List集合中截取多个的随机记录。
	*
	* @param int min 起始值。
	* @param int max 结束值。
	* @return 多个随机数
	*/
	public static int[] subIntegers(int min, int max, int subLength){
		int size = max - min;

		int[] array = new int[size];

		for(int i = 0; i < size; i++){
			array[i] = min + i;
		}

		if(size <= subLength){
			return array;
		}

		int temp1, temp2, len = array.length;

		int subRandoms[] = new int[subLength];

		for(int i = 0; i < subLength; i++)  {
			temp1 = Math.abs(nextInt()) % len;
			subRandoms[i] = array[temp1];
			temp2 = array[temp1];
			array[temp1] = array[len-1];
			array[len-1] = temp2;
			len--;
		}
		
		return subRandoms;
	}
	
	static char[] table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	/**
	* 功能：获取1-9,a-Z之间的随机字符，即包括数字或字母(含大小写)的字符
	*
	* @return 随机字符
	*/
	public static char nextCharacter(){
		int i = nextInt(table.length - 1);   //防止下标越界
		return table[i];
	}
	
	/**
	* 功能：获取指定长度的随机字符数
	* 场景：创建验证码
	*
	* @param int length 长度。
	* @return 随机字符串
	*/
	public static String nextString(int length){
		String[] string = new String[length];
		String s = "";                               //通过输入的数组长度  进行一个循环遍历他最终得到的 随机字符串长度
		  
		for (int j = 0; j < string.length; j++) {
			int i = nextInt(table.length - 1);
			s +=  table[i];
		}
		
		return s ;
	}
	
	/**
	* 功能：获取长度min-max之间的字符串
	*
	* @return 随机字符串
	*/
	public static String nextString(int minLength, int maxLength){
		String s ="";
		int nextInt = nextInt(minLength, maxLength + 1);    //随机 获取 指定范围内的一个长度
		for (int i = 0; i < nextInt; i++) {			// 随机获取指定长度 进行一个 循环
			int nextInt2 = nextInt(table.length - 1);   //随机得到一个 字符数组的 下标
			s += table[nextInt2];				//  通过得到的一个随机下标  进行一个 字符串 累加
		}
		return s;
	}
	
	
	
	
    /**
    * 功能：获取指定长度的随机中文字符串
    *
    * @param int length 长度
    * @return 随机简体中文字符串
    */
    public static String nextSimplifiedChineseString(int length){
    	String ret="";
        for(int i=0;i<length;i++){
            String str = null;                                     // 随便取多少个 字符
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try
            {
                str = new String(b, "GBk"); //转成中文
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
             ret+=str;
        }
    return ret;
    }
    
    
    /**
    * 功能：创建一个中文姓名
    *
    * @return 人名
    */
    public static String generateChinesePersonName(){
    	  Random random = new Random();
          String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                  "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                  "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                  "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                  "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                  "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
          String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
          String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
          int index = random.nextInt(Surname.length - 1);
          String name = Surname[index]; //获得一个随机的姓氏
          int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
          if(i==2){
              int j = random.nextInt(girl.length()-2);
              if (j % 2 == 0) {
                  name = "女-" + name + girl.substring(j, j + 2);
              } else {
                  name = "女-" + name + girl.substring(j, j + 1);   
              }

          }
          else{
              int j = random.nextInt(girl.length()-2);
              if (j % 2 == 0) {
                  name = "男-" + name + boy.substring(j, j + 2);
              } else {
                  name = "男-" + name + boy.substring(j, j + 1);
              }

          }

          return name;
    }
    
    
    /**
    * 功能：获取不带横线的UUID
    * 场景：上传文件时作为新文件名
    *
    * @return 不带横线的UUID
    */
    public static String uuid(){
    	return UUID.randomUUID().toString().replace("-", "");
    }
    
    
    
}
