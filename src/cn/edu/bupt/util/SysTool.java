package cn.edu.bupt.util;

import java.io.File;
import java.security.MessageDigest;

import cn.edu.bupt.model.Statics;

public class SysTool {
    
    public static void createImageFoler() {
        File directory = new File(Statics.PORTRAIT_FOLDER);
        
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
    
    public static String generateRandomNum() {
        int fourNumInt = (int)(Math.random() * 10000);
        String fourNumStr = Integer.toString(fourNumInt);
        
        if (fourNumInt < 10) {
            fourNumStr = "000" + fourNumStr;
        } else if (fourNumInt < 100) {
            fourNumStr = "00" + fourNumStr;
        } else if (fourNumInt < 1000)
            fourNumStr = "0" + fourNumStr;
        
        return fourNumStr;
    }
    
    public static String md5(String aMd5Str) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C',
                'D','E','F'};       
        try {
            byte[] btInput = aMd5Str.getBytes();
            
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            
            // 获得密文
            byte[] md = mdInst.digest();
            
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
