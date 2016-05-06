package dev.lyt.utils.md5Utils;

import java.security.MessageDigest;

/**
 * MD5加密
 * @author lianyutao
 *
 */
public class MD5Util {
	
	/**
	 * 生成32位MD5加密数据
	 * @param string
	 * @return
	 */
	public static String MD5_32(String string){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5"); 
            char[] charArray = string.toCharArray();  
            byte[] byteArray = new byte[charArray.length];  
      
            for (int i = 0; i < charArray.length; i++)  
                byteArray[i] = (byte) charArray[i];  
            
            byte[] md5Bytes = md5.digest(byteArray);  
            StringBuffer hexValue = new StringBuffer();  
            
            for (int i = 0; i < md5Bytes.length; i++){  
                int val = ((int) md5Bytes[i]) & 0xff;  
                if (val < 16)  
                    hexValue.append("0");  
                hexValue.append(Integer.toHexString(val));  
            }  
            return hexValue.toString();  
      
        }catch (Exception e){  
            e.printStackTrace();  
            return "";  
        }  
    }  
  
    public static void main(String args[]) {  
        String string = "123456";  
        System.out.println(MD5_32(string));  

  
    }  
}
