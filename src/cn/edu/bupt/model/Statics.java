package cn.edu.bupt.model;

public class Statics {

    public final static String PORTRAIT_FOLDER = "C:\\rs_portrait\\";
    public final static String BG_NAME = "background.jpg";
    
    public final static String USERNAME = "admin";
    public final static String PASSWORD = "21232f297a57a5a743894a0e4a801fc3";
    
    public final static String DEFAULT_TIME_FORMAT = "yyyy年MM月dd日 HH:mm:ss";  
    public final static int ONE_SECOND = 1000;
    
    private static int count = 4;
    
    public static int getCount() {
        return count++;
    }
}
