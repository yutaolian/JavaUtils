package dev.lyt.utils.date;

import java.text.ParseException;
import java.util.Date;

public class ShowTimeUtil {
	
	
	public static String ShowTime(String dateString) throws ParseException {
		Date date = DateFormatUtil3.StringToDateTime(dateString);
		long timeStamp = date.getTime();

		Date currentTime = new Date();
		long currentTimeStamp = currentTime.getTime();
		
		if (timeStamp>currentTimeStamp) {
			return dateString;
		}
		return calculateTime(currentTimeStamp, timeStamp ,date);
	}
	
	public static String ShowTime(Date date) throws ParseException {
		long timeStamp = date.getTime();

		Date currentTime = new Date();
		long currentTimeStamp = currentTime.getTime();
		
		if (timeStamp>currentTimeStamp) {
			return DateFormatUtil3.DateTimeToString(date);
		}
		return calculateTime(currentTimeStamp, timeStamp,date);
	}
	
	private static String calculateTime(long currentTimeStamp,long timeStamp,Date date) throws ParseException{
		
		long seconds = (currentTimeStamp - timeStamp) / 1000;
		long minutes = Math.abs(seconds / 60);
		long hours = Math.abs(minutes / 60);
		long days = Math.abs(hours / 24);

		if (seconds <= 15) {
			return "刚刚";
		} else if (seconds < 60) {
			return seconds + "秒前";
		} else if (seconds < 120) {
			return "1分钟前";
		} else if (minutes < 60) {
			return minutes + "分钟前";
		} else if (minutes < 120) {
			return "1小时前";
		} else if (hours < 24) {
			return hours + "小时前";
		} else if (hours < 24 * 2) {
			return "1天前";
		} else if (days < 7) {//一周以内
			return days + "天前";
		} else {
			return DateFormatUtil3.DateTimeToString(date);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(ShowTime("2016-05-01 18:05:59"));
	}
}
