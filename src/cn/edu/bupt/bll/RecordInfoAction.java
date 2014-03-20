package cn.edu.bupt.bll;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.bupt.dal.DBOper;
import cn.edu.bupt.model.CustomerInfo;

public class RecordInfoAction {
    private CustomerInfo cusInfo;
    
    public RecordInfoAction() {
        
    }
    
    public RecordInfoAction(CustomerInfo aCusInfo) {
        this.cusInfo = aCusInfo;
    }
    
    private String generateSQL() {
        if (cusInfo == null)
            return "";
        
        String sqlFormat = "insert into customer values('%s','%s','%s','%s'," +
        		"'%s','%s','%s')";
        
        if (cusInfo.getAddress() == null)
            cusInfo.setAddress("");
        
        if (cusInfo.getPortrait() == null)
            cusInfo.setPortrait("");
        
        String sql = String.format(sqlFormat, cusInfo.getId(), cusInfo.getName(),
                Integer.toString(cusInfo.getSex()), cusInfo.getAge(), 
                cusInfo.getNation(), cusInfo.getAddress(), cusInfo.getPortrait());
        
        System.out.println(sql);
        
        return sql;
    }
    
    /**
     * 该方法调用的前提是身份证号已经通过基础验证
     * @param aIdStr
     * @return
     */
    public boolean searchIdFromDB(String aIdStr) {
        String sql = "select * from customer where customerid='"+ aIdStr +"'";
        
        System.out.println(sql);

        try {
            ResultSet res = DBOper.getInstance().query(sql);
            
            res.last();
            
            int row = res.getRow();
            
            if (row == 1)
                return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean isIdCheckInRoom(String aIdStr) {
        String sql = "select * from reserve where customerid='"+ aIdStr +"' " +
        		"and money=0";
        
        try {
            ResultSet res = DBOper.getInstance().query(sql);
            
            res.last();
            
            int row = res.getRow();
            
            if (row == 1)
                return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean record() {
        
        String sql = this.generateSQL();
        
        boolean res = DBOper.getInstance().modify(sql);
        
        return res;
    }
}
