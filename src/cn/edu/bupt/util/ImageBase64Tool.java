package cn.edu.bupt.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageBase64Tool {
    public static String image2Base64(String filePath) {
        InputStream in = null;
        byte[] data = null;
        
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        BASE64Encoder encoder = new BASE64Encoder();
        
        return encoder.encode(data);
    }
    
    public static boolean generateImage(String imgStr, String filePath) {
        if (imgStr == null)
            return false;
        
        BASE64Decoder decoder = new BASE64Decoder();
        
        try {
            byte[] b = decoder.decodeBuffer(imgStr);
            
            for(int i = 0; i < b.length; ++i)
            {
                if(b[i] < 0)     //调整异常数据
                    b[i] += 256;
            }
            
            OutputStream out = new FileOutputStream(filePath);
            
            out.write(b);
            out.flush();
            out.close();
            
            return true;
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}