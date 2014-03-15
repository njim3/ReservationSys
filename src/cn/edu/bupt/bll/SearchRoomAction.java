package cn.edu.bupt.bll;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import cn.edu.bupt.dal.DBOper;
import cn.edu.bupt.dal.DBUtility;

public class SearchRoomAction {
    private String srId;
    private int srType;
    private String sql;
    
    public SearchRoomAction(String aId, int aType) {
        this.srId = aId;
        this.srType = aType;
    }
    
    private void constructSQL() {
        String sqlPrefix = "select roomid as '房间号', " +
        		"roomdescription as '房间信息', isCheck as '是否入住(1/0)' from room";
        
        switch (this.srType) {
        case 0:         // 全部
        {
            this.sql = sqlPrefix;
        }
            break;
        case 1:
        {
            this.sql = sqlPrefix + " where isCheck=1";
        }
            break;
        case 2:
        {
            this.sql = sqlPrefix + " where isCheck=0";
        }
            break;
        }
        
        if (this.srId != null && this.srId.length() != 0) {
            if (srType == 0)
                this.sql += " where roomid like '%" + this.srId + "%'";
            else
                this.sql += " and roomid like '%" + this.srId + "%'";
        }
        
        //System.out.print(sql);
    }
    
    private ResultSet searchRoom() {
        this.constructSQL();
        
        ResultSet rs = DBOper.getInstance().query(this.sql);
        
        return rs;
    }
    
    public DefaultTableModel getTableModel() {
        ResultSet res = this.searchRoom();
        
        if (res == null)
            return null;
        
        DefaultTableModel model = DBUtility.rs2Model(res);
        
        return model;
    }
}
