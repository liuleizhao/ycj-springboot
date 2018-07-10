/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cs.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final String FORMAT_YYYY = "yyyy";
	private static final String FORMAT_MM = "MM";
	private static final String FORMAT_DD = "dd";
	private static final String FORMAT_E = "E";
	private static final String FORMAT_YYYYMM = "yyyy-MM";
	private static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";
//	private static final String FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	private static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_YYYYMMDDHHMMSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	
	private static final String FORMAT_HHMMSS = "HH:mm:ss";

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mm:ss.SSS", "yyyyMMddHHmmss", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
			"yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };

	/**
	 * 得到当前日期字符串 指定格式 例如：（yyyy-MM-dd）
	 */
	public static String getDate(String pattern) {
		return formatDate(new Date(), pattern);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate(FORMAT_YYYYMMDD);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return getDate(FORMAT_HHMMSS);
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return getDate(FORMAT_YYYYMMDDHHMMSS);
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return getDate(FORMAT_YYYY);
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return getDate(FORMAT_MM);
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return getDate(FORMAT_DD);
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return getDate(FORMAT_E);
	}

	/*------------------------日期格式化------------------------*/

	/**
	 * 得到指定日期字符串 指定格式
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * 得到指定日期字符串 格式（yyyy-MM-dd）
	 */
	public static String formatDate(Date date) {
		return formatDate(date, FORMAT_YYYYMMDD);
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, FORMAT_YYYYMMDDHHMMSS);
	}

	/**
	 * 获取年月
	 * 
	 * @param date
	 * @return
	 */
	public static String formatYearAndMonth(Date date) {
		return formatDate(date, FORMAT_YYYYMM);
	}

	/**
	 * 获取年
	 * 
	 * @param date
	 * @return
	 */
	public static String formatYear(Date date) {
		return formatDate(date, FORMAT_YYYY);
	}

	/*------------------------日期型字符串转化为日期------------------------*/

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(String str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/*------------------------日期计算------------------------*/
	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDifferenceOfDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 比较两个时间的大小(前面的时间比后面的时间多几天)
	 * 
	 * @param time
	 * @return 相差天数
	 */
	public static long compareTime(String before, String after) {
		long days = -2;
		Date d1 = parseDate(before);
		Date d2 = parseDate(after);
		long diff = d1.getTime() - d2.getTime();
		days = diff / (1000 * 60 * 60 * 24);
		return days;
	}

	public static Date addDate(Date date, int type, int intervel) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, intervel);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间之后n年的时间
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static Date getLaterYear(Date date, int intervel) {
		return addDate(date, Calendar.YEAR, +intervel);
	}

	/**
	 * @Description: 日期得到下一年前一天时间（有效期一年）
	 * @return String
	 * @date 2017-3-24
	 */
	public static Date getNextYear(Date date) throws ParseException {
		Calendar endtime = Calendar.getInstance();
		endtime.setTime(date);
		endtime.add(Calendar.YEAR, 1); // 日期加1年
		endtime.add(Calendar.DATE, -1);
		return endtime.getTime();
	}

	/**
	 * 获取指定时间n月之后的时间
	 * 
	 * @param lastDate
	 * @param month
	 * @return
	 */
	public static Date getLaterMonth(Date date, int intervel) {
		return addDate(date, Calendar.MONTH, intervel);
	}

	/**
	 * 指定时间n个月之前的时间
	 * 
	 * @param nextDate
	 * @param month
	 * @return
	 */
	public static Date getPreviousMonth(Date date, int month) {
		return addDate(date, Calendar.MONTH, -month);
	}

	/**
	 * 这个月的最后一天
	 * 
	 * @param date
	 */
	public static Date getLastDayofThisMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * 获取当前时间之后的时间
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getLaterDay(Date date, Integer days) {
		return addDate(date, Calendar.DAY_OF_MONTH, days);
	}

	/**
	 * 获取指定时间的下一天的同一时刻
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		return getLaterDay(date, 1);
	}

	/**
	 * 获取当前时间之后的时间
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getLaterDay(Integer days) {
		return getLaterDay(new Date(), days);
	}

	/**
	 * 获取指定时间的前一天时间的同一时刻
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreviousDay(Date date, Integer days) {
		return addDate(date, Calendar.DAY_OF_MONTH, -days);
	}

	/**
	 * 获取当前时间之前的时间
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getPreviousDay(Date date) {
		return getPreviousDay(date, 1);
	}

	/**
	 * 获取当前时间之前的时间
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getPreviousDay(Integer days) {
		return getPreviousDay(new Date(), days);
	}

	/**
	 * 获取n秒之前的时间
	 * 
	 * @param second
	 * @return
	 * @throws ParseException
	 */
	public static Date getPreviousSecond(Integer second) throws ParseException {
		return addDate(new Date(), Calendar.SECOND, -second);
	}

	/**
	 * 获取n秒之后的时间
	 * 
	 * @param second
	 * @return
	 */
	public static Date getLaterSecond(Date date, Integer second) {
		return addDate(date, Calendar.SECOND, second);
	}

	/**
	 * 获取n秒之后的时间
	 * 
	 * @param second
	 * @return
	 */
	public static Date getLaterSecond(Integer second) {
		return getLaterSecond(new Date(), second);
	}

	/**
	 * isToDay
	 * 
	 * @param day
	 * @return
	 */
	public static boolean isToDay(String day) {
		return getDate().equals(day);
	}

	/**
	 * isToday
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(java.sql.Date date) {
		return getDate().equals(formatDate(new Date(date.getTime())));
	}

	/**
	 * isToday
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(java.util.Date date) {
		return getDate().equals(formatDate(date));
	}

	/**
	 * isToday
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(java.sql.Timestamp date) {
		return getDate().equals(formatDate(new Date(date.getTime())));
	}

	/**
	 * 时间戳转换为字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String timestamp2Str(Timestamp time) {
		Date date = null;
		if (null != time) {
			date = new Date(time.getTime());
		}
		return formatDate(date, FORMAT_YYYYMMDDHHMMSSS);
	}

	/**
	 * 字符串转换时间戳
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp str2Timestamp(String str) throws ParseException {
		return str2Timestamp(str, FORMAT_YYYYMMDDHHMMSSS);
	}

	/**
	 * 字符串转换时间戳
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp str2Timestamp(String str, String format) throws ParseException {
		Date date = parseDate(str, format);
		return new Timestamp(date.getTime());
	}

	/**
	 * 获取当前时间之前n天的时间字符串list(升序)
	 * 
	 * @param number
	 * @return
	 */
	public static List<String> getDateList(int number) {
		List<String> list = new ArrayList<String>();
		Date date = new Date();
		int count = 0;
		do {
			list.add(DateUtils.formatDate(date));
			date = DateUtils.getPreviousDay(date);
			count++;
		} while (count < number);
		Collections.sort(list);
		return list;
	}
}
