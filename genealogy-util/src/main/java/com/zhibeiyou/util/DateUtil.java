package com.zhibeiyou.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 * 
 * @author 
 * @date 2016年11月16日 下午9:27:31
 */
public final class DateUtil {
	/**
	 * yyyy
	 */
	public static final String y = "yyyy";
	/**
	 * yyyy-MM
	 */
	public static final String ym = "yyyy-MM";
	/**
	 * yyyy-MM-dd
	 */
	public static final String ymd = "yyyy-MM-dd";
	/**
	 * dd
	 */
	public static final String d = "dd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String ymdhms = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String ymdhm = "yyyy-MM-dd HH:mm";

	/**
	 * 获取过去7天
	 * 
	 * @author 
	 * @date 2016年11月16日 下午9:27:56
	 * @param date
	 *            如：2016-8-26的格式yyyy-MM-dd
	 * @return
	 */
	public static List<String> getLast7Days(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, -8);
			for (int i = 0; i < 7; i++) {
				cal.add(Calendar.DATE, 1);
				list.add(sf.format(cal.getTime()));
			}
		}
		return list;
	}

	/**
	 * 获取上周日期
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static List<String> getLastWeekDays(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.WEEK_OF_MONTH, -1);
			for (int i = 0; i < 7; i++) {
				cal.add(Calendar.DATE, -1 * cal.get(Calendar.DAY_OF_WEEK) + 2 + i);
				list.add(sf.format(cal.getTime()));
			}
		}
		return list;
	}

	/**
	 * 获取上周day
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static List<String> getLastWeekDay(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(d);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.WEEK_OF_MONTH, -1);
			for (int i = 0; i < 7; i++) {
				cal.add(Calendar.DATE, -1 * cal.get(Calendar.DAY_OF_WEEK) + 2 + i);
				list.add(sf.format(cal.getTime()));
			}
		}
		return list;
	}

	public static Date getMonthByInterval(Date date, int interval) {
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, interval);
			return cal.getTime();
		}
		return null;
	}

	public static Date getLastMonth(Date date) {
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, -1);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * 获取上个月日期
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static List<String> getLastMonthDays(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, -1);

			Date d = getMonthStart(cal.getTime());
			Date monthEnd = getMonthEnd(cal.getTime());
			while (!d.after(monthEnd)) {
				list.add(sf.format(d));
				d = getNext(d);
			}
		}
		return list;
	}

	/**
	 * 获取上个月day
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static List<String> getLastMonthDay(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(d);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, -1);

			Date d = getMonthStart(cal.getTime());
			Date monthEnd = getMonthEnd(cal.getTime());
			while (!d.after(monthEnd)) {
				list.add(sf.format(d));
				d = getNext(d);
			}
		}
		return list;
	}

	/**
	 * 获取上一年月份信息
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static List<String> getLastYearMonths(Date date) {
		List<String> list = new ArrayList<String>();
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(y);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, -1);
			String year = sf.format(cal.getTime());
			list.add(year.concat("-01"));
			list.add(year.concat("-02"));
			list.add(year.concat("-03"));
			list.add(year.concat("-04"));
			list.add(year.concat("-05"));
			list.add(year.concat("-06"));
			list.add(year.concat("-07"));
			list.add(year.concat("-08"));
			list.add(year.concat("-09"));
			list.add(year.concat("-10"));
			list.add(year.concat("-11"));
			list.add(year.concat("-12"));

		}
		return list;
	}

	/**
	 * 获取一个月的开始
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (1 - index));
		return calendar.getTime();
	}

	/**
	 * 获取一个月的结束
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		int index = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, (-index));
		return calendar.getTime();
	}

	/**
	 * 获取下一天
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static Date getNext(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 获取前一天
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 * @return
	 */
	public static Date getBefore(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间差后的日期
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param date
	 *            对比日期
	 * @param diff
	 *            增量（正数则加，负数则减）
	 * @return
	 */
	public static Date getDiffDay(Date date, int diff) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, diff);
		return calendar.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ymd);
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 格式日期
	 * 
	 * @author 
	 * 
	 * @date 2016-8-26
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date != null && format != null && !format.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;

	}

	public static Date formatDate2(Date date, String format) throws ParseException {
		if (date != null && format != null && !format.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(sdf.format(date));
		}
		return null;
	}

	/**
	 * 获取之前的日期列表
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param date
	 *            对比日期
	 * @param days
	 *            天数
	 * @return
	 */
	public static List<Date> getBeforeDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		List<Date> dl = new ArrayList<Date>();
		if (days > 0) {
			for (int i = days; i > 0; i--) {
				c.setTime(date);
				c.add(Calendar.DAY_OF_MONTH, -i);
				dl.add(c.getTime());
			}
		}
		return dl;
	}

	/**
	 * 获取之前的日期列表
	 * 
	 * @author 
	 * @date 2017-09-19
	 * 
	 * @param date
	 *            对比日期
	 * @param days
	 *            天数
	 * @return
	 */
	public static List<String> getBeforeDays(Date date, int days, String format) {
		Calendar c = Calendar.getInstance();
		List<String> dl = new ArrayList<String>();
		SimpleDateFormat sf = new SimpleDateFormat(format);
		if (days > 0) {
			for (int i = days; i > 0; i--) {
				c.setTime(date);
				c.add(Calendar.DAY_OF_MONTH, -i);
				dl.add(sf.format(c.getTime()));
			}
		} else {
			dl.add(sf.format(date));
		}
		return dl;
	}

	/**
	 * 获取之后的日期列表
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param date
	 *            对比日期
	 * @param days
	 *            天数
	 * @return
	 */
	public static List<Date> getAfterDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		List<Date> dl = new ArrayList<Date>();
		if (days > 0) {
			for (int i = 1; i <= days; i++) {
				c.setTime(date);
				c.add(Calendar.DAY_OF_MONTH, i);
				dl.add(c.getTime());
			}
		}
		return dl;
	}

	/**
	 * 获取时间列表
	 * 
	 * @author 
	 * @date 2016年12月21日 上午11:14:09
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getBetweenDays(Date startDate, Date endDate) {
		List<String> list = new ArrayList<String>();
		if (startDate != null && endDate != null) {
			SimpleDateFormat sf = new SimpleDateFormat(ymd);
			Calendar c = Calendar.getInstance();
			if (startDate.before(endDate)) {
				while (startDate.before(endDate)) {
					String dateStr = sf.format(startDate);
					if (!list.contains(dateStr)) {
						list.add(dateStr);
					}
					c.setTime(startDate);
					c.add(Calendar.DATE, 1);
					startDate = c.getTime();
				}
				list.add(sf.format(endDate));
			} else if (startDate.equals(endDate)) {
				String dateStr = sf.format(startDate);
				list.add(dateStr);
			}

		}
		return list;
	}

	/**
	 * 分钟数之差
	 * 
	 * @author 
	 * @date 2016-8-26
	 *
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差分钟数
	 * @throws ParseException
	 */
	public static int minuteBetween(Date smdate, Date bdate) throws ParseException {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(smdate);
		cal2.setTime(bdate);

		long time1 = cal1.getTimeInMillis();
		long time2 = cal2.getTimeInMillis();

		long minute = (time2 - time1) / (1000 * 60);
		return Integer.parseInt(String.valueOf(minute));
	}

	/**
	 * 计算两个日期之间相差的小时数
	 * 
	 * @author 
	 * @date 2016年11月16日 下午8:44:54
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int hourBetween(Date smdate, Date bdate) throws ParseException {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(smdate);
		cal2.setTime(bdate);

		long time1 = cal1.getTimeInMillis();
		long time2 = cal2.getTimeInMillis();

		long hour = (time2 - time1) / (1000 * 60 * 60);
		return Integer.parseInt(String.valueOf(hour));
	}

	/**
	 * 计算两个日期之间相差的周数
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差周数
	 * @throws ParseException
	 */
	public static int weekBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ymd);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_week = (time2 - time1) / (1000 * 3600 * 24 * 7);

		return Integer.parseInt(String.valueOf(between_week));
	}

	/**
	 * 计算两个日期之间相差的月数
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差月数
	 * @throws ParseException
	 */
	public static int monthBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ym);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(sdf.parse(smdate));
		cal2.setTime(sdf.parse(bdate));

		return (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH)
				- cal1.get(Calendar.MONTH);
	}

	/**
	 * 计算两个日期之间相差的月数
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @param num
	 *            超过天数算一个月
	 * @return 相差月数
	 * @throws ParseException
	 */
	public static int monthBetween(String smdate, String bdate, int num) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ym);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(sdf.parse(smdate));
		cal2.setTime(sdf.parse(bdate));
		Integer months = 0;
		months = (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH)
				- cal1.get(Calendar.MONTH);
		if (cal2.get(Calendar.DATE) - cal1.get(Calendar.DATE) > num) {
			months += 1;
		}
		return months;
	}

	/**
	 * 计算两个日期之间相差的年数
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差年数
	 * @throws ParseException
	 */
	public static int yearBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(sdf.parse(smdate));
		cal2.setTime(sdf.parse(bdate));

		return cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
	}

	/**
	 * 判断两个时间的大小
	 * 
	 * @author 
	 * @date 2016-8-26
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return boolean
	 * @throws ParseException
	 */
	public static boolean dateCompare(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ymdhms);
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();

		return time2 >= time1;
	}

	public static Date getCurrentTime() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	public static java.sql.Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(getCurrentTime().getTime());
	}

	public static java.sql.Timestamp getCurrentTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}

	/**
	 * 当前Calendar
	 * 
	 * @return
	 *
	 */
	public static Calendar currentCal() {
		return Calendar.getInstance();
	}

	/**
	 * Calendar
	 * 
	 * @return
	 *
	 */
	public static Calendar calendar(Calendar cal) {
		return null != cal ? cal : currentCal();
	}

	/**
	 * 当前日期
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Date currentDate() {
		return calendar(null).getTime();
	}

	/**
	 * 当前日期
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Date currentDate(Calendar cal) {
		return calendar(cal).getTime();
	}

	/**
	 * 年份
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentYear(Calendar cal) {
		return calendar(cal).get(Calendar.YEAR);
	}

	/**
	 * 月份
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMonth(Calendar cal) {
		return calendar(cal).get(Calendar.MONTH) + 1;
	}

	/**
	 * 几号
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentDayOfMonth(Calendar cal) {
		return calendar(cal).get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 小时
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentHour(Calendar cal) {
		return calendar(cal).get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 分钟
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMinute(Calendar cal) {
		return calendar(cal).get(Calendar.MINUTE);
	}

	/**
	 * 秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentSecond(Calendar cal) {
		return calendar(cal).get(Calendar.SECOND);
	}

	/**
	 * 当前毫秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMilliSecond(Calendar cal) {
		return calendar(cal).get(Calendar.MILLISECOND);
	}

	/**
	 * 长毫秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Long currentMilliLong(Calendar cal) {
		return currentDate(cal).getTime();
	}

	/**
	 * 设置一天的开始
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDayOfStart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 设置一天的结束
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDayOfEnd(Date date, boolean is24Hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, is24Hour ? 23 : 11);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static String getDateStr(Date date, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return	sdf.format(date);
	}
}
