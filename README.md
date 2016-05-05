# JavaUtils
总结的一些Java常用的util类

####1.格式化时间 SimpleDateFormat（DateFormat）

众所周知SimpleDateFormat(DateFormat)是线程不安全的，在源码中SimpleDateFormat有一段解释（如下）,在多线程的情况下如果创建一个静态的SimpleDateFormat对象就会出现问题。

	
	 Date formats are not synchronized.
	 It is recommended to create separate format instances for each thread.
	 If multiple threads access a format concurrently, it must be synchronized
	 externally.
	
解决方法：1、每个线程都创建一个SimpleDateFormat对象（就是只要是使用格式化时间就会创建一个SimpleDateFormat）,
	这样的话就会出现性能的问题（虽然这点性能对现在的机器来说无所谓，但对性能有严格要求的程序来说这个方法肯定不是最好的方法）

	
	public static String DateToString(Date date,String formatString){
		//将SimpleDateFormat作为方法内部的变量，每次调用格式化的时候都会创建新的对象
		//
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		return simpleDateFormat.format(date);
	}
	
[完整代码](/src/main/java/dev/lyt/javaUtils/date/DateFormatUtil.java)	

错误实例

	
	//将SimpleDateFormat作为成员变量这样在多线程中会出现问题
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
	
	public static String DateToString(Date date,String formatString){
		//将SimpleDateFormat作为方法内部的变量，每次调用格式化的时候都会创建新的对象
		return simpleDateFormat.format(date);
	}
	

