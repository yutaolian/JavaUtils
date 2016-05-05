package dev.lyt.utils.numberUtils;

import java.util.Random;

public class NumberUtil {
	/**
	 * 产生一个六位数的随机数
	 * @return
	 */
	
	public final static int getRandom6(){
		
		Random rand = new Random(); 
		
		final int min = 100000 ;
		
		final int max = 999999;
		
		return Math.abs(rand.nextInt()) % (max - min + 1) + min;

	
	}
	

}
