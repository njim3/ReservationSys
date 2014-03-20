package cn.edu.bupt.bll;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cn.edu.bupt.dal.DBOper;
import cn.edu.bupt.model.ReserveInfo;
import cn.edu.bupt.model.Statics;

public class RecordReserveAction {
    private ReserveInfo reserveInfo;
    private String sql;
    
    public RecordReserveAction(ReserveInfo aInfo) {
        this.reserveInfo = aInfo;
    }
    
    private void genRecordSQL() {
        String sqlFrame = "insert into reserve(customerid, roomid, roomtype, checkintime) " +
        		"values('%s', %d, %d, '%s')";
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
                Statics.DEFAULT_TIME_FORMAT);
        String timeNowStr = dateFormatter.format(
                Calendar.getInstance().getTime());
        
        this.sql = String.format(sqlFrame, reserveInfo.getCusId(), 
                reserveInfo.getRoomId(), reserveInfo.getRoomType(), timeNowStr);
    }
    
    private void genUpdateSQL() {
        String sqlFrame = "update room set isCheck=1 where roomid=%d";
        
        this.sql = String.format(sqlFrame, reserveInfo.getRoomId());
    }
    
    public boolean recordInfo() {
        this.genRecordSQL();
        
        System.out.println(this.sql);
        
        boolean res = false;
        
        res = DBOper.getInstance().modify(this.sql);
        
        if (!res)
            return false;
        else {
            this.genUpdateSQL();
            
            res = DBOper.getInstance().modify(sql);
            
            if (!res)
                return false;
        }
        
        return true;
    }
}
