package com.cusm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	
	/**
	 * long时间转换为能看懂的String类型
	 * @param time
	 * @param format
	 * @return
	 */
	 public static String fomatDateLongToStr(Long time,String format){
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	Date date = new Date(time);
    	return sdf.format(date);
	 }
	 
	 /**
	  * string类型的时间转换为long类型
	  * @param time
	  * @param format
	  * @return
	  */
	 public static long fomatDateStrToLong(String time,String format){
		 SimpleDateFormat sdf =new SimpleDateFormat(format);
		 //设置要读取的时间字符串格式
		 Date date = new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 //转换为Date类
		 return date.getTime();
	 }

}
