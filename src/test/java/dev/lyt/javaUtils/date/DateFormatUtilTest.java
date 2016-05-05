package dev.lyt.javaUtils.date;

import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class DateFormatUtilTest extends TestCase {

	@Test
	public void testDateToString() throws Exception {
		
		System.out.println(DateFormatUtil.DateToStringShortDate(new Date()));
		
		System.out.println(DateFormatUtil.DateToStringLongDate(new Date()));
	}

	public void testStringToDateStringString() {
		fail("Not yet implemented");
	}

	public void testDateToStringShortDate() {
		fail("Not yet implemented");
	}

	public void testDateToStringLongDate() {
		fail("Not yet implemented");
	}

	public void testStringToDateString() {
		fail("Not yet implemented");
	}

	public void testLongStringToDate() {
		fail("Not yet implemented");
	}

}
