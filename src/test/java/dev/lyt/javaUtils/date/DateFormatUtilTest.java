package dev.lyt.javaUtils.date;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import dev.lyt.utils.dateUtils.DateFormatUtil;
import dev.lyt.utils.dateUtils.DateFormatUtil2;
import dev.lyt.utils.dateUtils.DateFormatUtil3;
import junit.framework.TestCase;

public class DateFormatUtilTest extends TestCase {

	@Test
	public void testDateToString() throws Exception {
		
		long begin = System.currentTimeMillis();
		
		for (int i = 0; i < 10000000; i++) {
			
			DateFormatUtil2.DateTimeToString(new Date());
		}
		long end = System.currentTimeMillis();
		
		System.out.println(end-begin);
	}

	@Test
	public void testDateTimeToString() throws Exception {
		
		//System.out.println(new Date());
		long begin = System.currentTimeMillis();
		FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 10000000; i++) {
			fastDateFormat.format(new Date());
		}
		//System.out.println(fastDateFormat.format(new Date()));
		//System.out.println(fastDateFormat.parse("2016-05-05 23:23:12"));
		long end = System.currentTimeMillis();
		
		System.out.println(end-begin);
	}

}
