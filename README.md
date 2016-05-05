# JavaUtils
总结的一些Java常用的util类

###1.格式化时间 SimpleDateFormat（DateFormat）实现线程安全的使用

众所周知SimpleDateFormat(DateFormat)是线程不安全的，在源码中SimpleDateFormat有一段解释（如下）,在多线程的情况下如果创建一个静态的SimpleDateFormat对象就会出现问题。

	 Date formats are not synchronized.
	 It is recommended to create separate format instances for each thread.
	 If multiple threads access a format concurrently, it must be synchronized
	 externally.
	
####解决方法：1、每个线程都创建一个SimpleDateFormat对象（就是只要是使用格式化时间就会创建一个SimpleDateFormat）,处理的时间多的话就会生成对应个数的SimpleDateFormat对象
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
但是如果将simpleDateFormat.format(date)方法用关键字synchronized修饰那个这种方法也是可以的

####方法2.使用synchronized修饰,将SimpleDateFormat作为类的成员变量，可以减少SimpleDateFormat的创建次数,不过同步的话就会有锁,也会比较影响性能实现代码如下,
但是这样的话对自定义实现返回格式貌似无力(不过一般也不需要,返回格式一般是这两种)

	
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
	

[完整代码](/src/main/java/dev/lyt/utils/date/DateFormatUtil2.java)

####方法3.使用ThreadLocal（推荐使用）线程只会创建一个SimpleDateFormat实例。其他线程用的是这个线程的副本，实现方法如下

		/**
	 * ThreadLocal的实现
	 */
	private static ThreadLocal<DateFormat> dateThreadLocal = new ThreadLocal<DateFormat>(){
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_STRING);
		};
	};
	/**
	 * ThreadLocal例外一种实现方法 
	 */
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

[完整代码](/src/main/java/dev/lyt/utils/date/DateFormatUtil3.java)	

####方法4,Apache Common Lang 包中的 FastDateFormat,（推荐使用）实现代码

		//date转string
		FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMdd");
		fastDateFormat.format(new Date());
		
		//string转date
		FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMdd");
		fastDateFormat.parse("20160505");
		
FastDateFormat的官方解释是 “FastDateFormat is a fast and thread-safe” ，测试了一下生成十万条的话 方法1是最慢的（你懂得）
方法2，方法3，差不多，但是比方法4要快点（近3分之1）,方法4有缓存（apache实现的还是不错的,使用ConcurrentHashMap实现）而且有时区比较规范,Lang包下面还有好多
方法可以使用，如果在服务器上应该还会更快些

####方法5.Joda-Time 没有仔细研究过，据说不错，完后试试。[可参考这个帖子](http://www.tuicool.com/articles/3YbmYjB)

###2.时间输出格式（类似微信每天消息在几分钟前，几小时前，几天前等）
[实现代码](/src/main/java/dev/lyt/utils/date/ShowTimeUtil.java)



















