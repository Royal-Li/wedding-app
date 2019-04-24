	package com.application.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil{
	/**
	* 
	* @description   String 转 date
	* @param str
	* @return Date
	* @throws Exception
	*/
	public static Date stringToDate(String str) throws Exception{
		
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = format.parse(str);
		} catch (Exception e) {
			if(e instanceof ParseException){
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					date = format.parse(str);
				} catch (Exception e2) {
					if(e2 instanceof ParseException){
						try {
							SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
							date = format.parse(str);
						} catch (Exception e3) {
							if(e3 instanceof ParseException){
								try {
									SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
									date = format.parse(str);
								} catch (Exception e4) {
									e4.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		
		//System.out.println(date);
		return date;
	}
	
	
	/**
	 *  String 转 Date 
	 * @description  
	 * @param str 传入的String 日期
	 * @param dateFormat 传入的 String的format格式(如：yyyy-MM-dd;yyyy/MM/dd ... 等等)
	 * @return Date
	 * @throws Exception
	 */
	public static Date stringToDate(String str,String dateFormat) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date= format.parse(str);
		return date;
	}
	 
	 
	/**
	* 
	* @description  date转String，转换后的String格式是：yyyy-MM-dd HH:mm:ss
	* @param date 传入的日期
	* @return String 转成String后的日期格式
	*/
	public static String dateToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String strDate = format.format(date);
		System.out.println(strDate);
		return strDate;
	}
	/**
	 * Date 转 String
	 * @description  
	 * @param date 传入的date
	 * @param dataFormat 转换成String的格式 (如：yyyy-MM-dd;yyyy/MM/dd ... 等等)
	 * @return String
	 */
	public static String dateToString(Date date, String dataFormat){
		SimpleDateFormat format = new SimpleDateFormat(dataFormat); 
		String strDate = format.format(date);
		return strDate;
	}
	 
	 
	/**
	* 
	* @description  计算两个日期之间相差的天数
	* @param startDate
	* @param endDate
	* @return
	*/
	public static int daysBetweenTowDates(Date startDate,Date endDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timeStart = calendar.getTime().getTime();
		calendar.setTime(endDate);
		long timeEnd = calendar.getTime().getTime();
		int days = (int)(timeEnd / 1000 - timeStart / 1000)/3600/24;
		return Math.abs(days);
	}
	 
	 
	 
	/**
	* 
	* @description  计算两日期之间相差的年数
	* @param startDate
	* @param endDate
	* @return
	*/
	public static int yearsBetweenTowDates(Date startDate, Date endDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		int startYear = calendar.get(Calendar.YEAR);
		calendar.setTime(endDate);
		int endYear = calendar.get(Calendar.YEAR);
		System.out.println(endYear - startYear);
		return endYear - startYear;
	}
	/**
	* 
	* @description  计算两日期之间相差的分钟数
	* @param startDate
	* @param endDate
	* @return
	*/
	public static int minutesBetweenTowDates(Date startDate, Date endDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timeStart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeEnd = calendar.getTimeInMillis();
		int minutes = (int)(timeEnd - timeStart )/(1000*60);
		return minutes;
	}
	/**
	 * 通过出生日期计算年龄
	 * @description  
	 * @param birthday  出生日期
	 * @param nowDate   传入的日期（）
	 * @return int 年龄值
	 */
	public static int calculateAge(Date birthday,Date nowDate) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(nowDate);
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		
		
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		
		if(yearNow == yearBirth && monthNow == monthBirth && dayOfMonthNow == dayOfMonthBirth){ //birthday is today
			return 0;
		}else{
			Calendar birthdayCal = Calendar.getInstance();
			birthdayCal.setTime(birthday);
			if ( cal.before(birthdayCal) ) {
				throw new IllegalArgumentException(
						"The birthDay is before Now.It's unbelievable!");
			}
			int age = yearNow - yearBirth;

			if (monthNow <= monthBirth) {
				if (monthNow == monthBirth) {
					if (dayOfMonthNow < dayOfMonthBirth) {
						age--;
					}
				} else {
					age--;
				}
			}
			return age;
			
		}
		
	}
	
	/**
	 * 
	 * @description 比较两个时间的大小，需要注意连个参数的时间格式，是12小时制，如 12:09 AM
	 * @author Arwen Liu
	 * @date 2019-01-17
	 * @param date1 时间1( 格式是 12:09 AM 或者 12:09 PM)
	 * @param date2 时间2( 格式是 12:09 AM 或者 12:09 PM)
	 * @return boolean 如果时间1  大于或等于 时间2 则为true,否则为false 
	 */
	public static boolean compareDate1MoreThanOrEqualDate2 (String date1, String date2){
		String[] arrDate1 = date1.split(" ");
		String[] arrDate2 = date2.split(" ");
		
		if(!arrDate1[1].toString().equals(arrDate2[1].toString())){
			if("AM".equalsIgnoreCase(arrDate1[1])  && "PM".equalsIgnoreCase(arrDate2[1])){
				return false;
			}
			return true;
		}else {
			String[] arrTime1 = arrDate1[0].split(":");
			String[] arrTime2 = arrDate2[0].split(":");
			if(Integer.parseInt(arrTime1[0]) > Integer.parseInt(arrTime2[0])){
				return true;
			}else if(Integer.parseInt(arrTime1[0]) == Integer.parseInt(arrTime2[0])  ){
				if(Integer.parseInt(arrTime1[1]) == Integer.parseInt(arrTime2[1])  || Integer.parseInt(arrTime1[1]) > Integer.parseInt(arrTime2[1]) ){
					return true;
				}
				return false;
			}
			return false;
		}
		
	}
	
	/**
	 * 
	 * @description 根据 Calendar实例获取是周几
	 * @author Arwen Liu
	 * @date 2019-02-25
	 * @param calendar Calendar
	 * @return 星期几
	 */
	public static String getWeekDayByCalendar(Calendar calendar){
		String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDays[w];
	}
	/**
	 @description 比较两个时间的大小，需要注意连个参数的时间格式，是24小时制
	 * @author Doris
	 * @date 2019-03-19
	 * @param date1 时间1( 格式是 12:09)
	 * @param date2 时间2( 格式是 23:09)
	 * @return boolean 如果时间1  大于或等于 时间2 则为true,否则为false 
	 */
	public static boolean compareDateOn24(String date1, String date2){

		String[] arrTime1 = date1.split(":");
		String[] arrTime2 = date2.split(":");
		if(Integer.parseInt(arrTime1[0]) > Integer.parseInt(arrTime2[0])){
			return true;
		}else if(Integer.parseInt(arrTime1[0]) == Integer.parseInt(arrTime2[0])  ){
			if(Integer.parseInt(arrTime1[1]) == Integer.parseInt(arrTime2[1])  || Integer.parseInt(arrTime1[1]) > Integer.parseInt(arrTime2[1]) ){
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * 将12小时制转成24小时制（9:00AM -> 09:00 2:00PM -> 14:00  12:30PM-> 12:30 12:30AM-> 12:30 ）
	 * @param date
	 * @return
	 */
	public static String stringToTime24(String time){
		if(time.toUpperCase().contains("PM") || time.toUpperCase().contains("AM")){
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mmaa",Locale.ENGLISH);
			Date date = null;
			try {
				date = dateFormat.parse(time);
				return dateToString(date, "HH:mm");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return time;
	}
	/*public static void main(String[] args) throws Exception {
		Calendar instance = Calendar.getInstance();
		instance.setTime(stringToDate("2019-02-24"));
		String weekDayByCalendar = getWeekDayByCalendar(instance);
		System.out.println(weekDayByCalendar);
		
	}*/
 
}
