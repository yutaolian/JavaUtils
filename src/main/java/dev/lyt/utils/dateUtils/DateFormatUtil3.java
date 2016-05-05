package dev.lyt.utils.dateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 使用ThreadLocal 实现多线程情况下，
 * @author lianyutao
 *
 */
public class DateFormatUtil3 {
	
	private static final String DATE_STRING = "yyyy-MM-dd";
	
	private static final String DATE_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * ThreadLocal的实现
	 */
	private static ThreadLocal<DateFormat> dateThreadLocal = new ThreadLocal<DateFormat>(){
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_STRING);
		};
	};
	
	private static ThreadLocal<DateFormat> dateTimeThreadLocal = new ThreadLocal<DateFormat>(){
		
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_TIME_STRING);
		};
	};
	

	/**
	 * ThreadLocal例外一种实现方法 
	 */
	
	//begin
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(); 
    
    public static DateFormat getDateFormat()   
    {  
        DateFormat dateFormat = threadLocal.get();  
        //ThreadLocal 的实现是原理是map
        if(dateFormat==null){  
        	dateFormat = new SimpleDateFormat(DATE_STRING);  
        	//这里需要设置
            threadLocal.set(dateFormat);  
        }  
        return dateFormat;  
    }  
    
    //end
	
	public static String DateToString(Date date) throws ParseException {
		return dateThreadLocal.get().format(date);
	}
	
	public static Date StringToDate(String dateString) throws ParseException {
		return dateThreadLocal.get().parse(dateString);
	}
	
	public static String DateTimeToString(Date date) throws ParseException {
		return dateTimeThreadLocal.get().format(date);
	}
	
	public static Date StringToDateTime(String dateString) throws ParseException {
		return dateTimeThreadLocal.get().parse(dateString);
	}


}
