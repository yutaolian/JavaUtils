package dev.lyt.javaUtils.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * 
 * @author lianyutao
 *
 */
public class DateFormatUtil {
	
	
	private static final String FORMAT_STRING_LONG = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_STRING_SHORT = "yyyy-MM-dd";
	
	/**
	 * 时间转为字符串  自定义格式化时间
	 * @param Date date
	 * @param formatString
	 * @return
	 */
	public static String DateToString(Date date,String formatString) throws Exception{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 字符串转为时间 
	 * @param dateString
	 * @param formatString
	 * @return
	 * @throws Exception
	 */
	public static Date StringToDate(String dateString,String formatString) throws Exception{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		return simpleDateFormat.parse(dateString);
	}
	
	
	/**
	 * 返回年月日
	 * @param Date date
	 * @return "yyyy-MM-dd"
	 */
	public static String DateToStringShortDate(Date date) throws Exception{
		return DateToString(date, FORMAT_STRING_SHORT);
	}
	
	/**
	 * 返回年月日时分秒
	 * @param date
	 * @return "yyyy-MM-dd HH:mm:ss"
	 */
	public static String DateToStringLongDate(Date date) throws Exception{
		return DateToString(date, FORMAT_STRING_LONG);
	}
	
	/**
	 * 返回日期格式
	 * @param dateString "yyyy-MM-dd"
	 * @return date 
	 * @throws Exception
	 */
	public static Date StringToDate(String dateString) throws Exception{
		return StringToDate(dateString, FORMAT_STRING_SHORT);
	}
	
	/**
	 * 返回日期
	 * @param dateString  "yyyy-MM-dd HH:mm:ss"
	 * @return Date date
	 * @throws Exception
	 */
	public static Date LongStringToDate(String dateString) throws Exception{
		return StringToDate(dateString, FORMAT_STRING_LONG);
	}

}
