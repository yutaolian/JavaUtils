package dev.lyt.utils.dateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 格式化时间 Util(将SimpleDateFormat作为类的成员变量,使用synchronized同步实现多线程对成员变量的修改)
 * @author lianyutao
 *
 */
public class DateFormatUtil2 {
	

	private static final String DATE_STRING = "yyyy-MM-dd";
	
	private static final String DATE_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_STRING);
	
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATE_TIME_STRING);
	

	public static String DateToString(Date date) throws Exception {
		synchronized (dateFormat) {
			return dateFormat.format(date);
		}
	}
	
	public static String DateTimeToString(Date date) throws Exception {
		synchronized (dateTimeFormat) {
			return dateTimeFormat.format(date);
		}
	}
	
	public static Date StringToDate(String stringDate) throws Exception {
		synchronized (dateFormat) {
			return dateFormat.parse(stringDate);
		}
	}
	
	public static Date StringToDateTime(String stringDate) throws Exception {
		synchronized (dateTimeFormat) {
			return dateTimeFormat.parse(stringDate);
		}
	}
}
