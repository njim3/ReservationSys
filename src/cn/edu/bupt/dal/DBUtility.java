package cn.edu.bupt.dal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class DBUtility {
    
    public static DefaultTableModel rs2Model(ResultSet res) {
        if (res == null)
            return null;
        
        try {
            res.last();
            
            int resRow = res.getRow();
            res.first();
            
            if (resRow == 0)
                return null;
            
            Vector<String> columnHeads = new Vector<String>();
            Vector<Vector> rows = new Vector<Vector>();
            
            ResultSetMetaData rsmd = (ResultSetMetaData)res.getMetaData();
            
            for (int i = 1; i <= rsmd.getColumnCount(); ++i)
                columnHeads.addElement(rsmd.getColumnName(i));
            
            do {
                rows.addElement(getNextRow(res, rsmd));
            } while (res.next());
            
            DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
            
            return model;
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    private static Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)
            throws SQLException {
        Vector<String> currentRow = new Vector<String>();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            currentRow.addElement(rs.getString(i));
        return currentRow; // 返回一条记录
    }
    
    public static Vector<String> singleColumn2Vector(ResultSet res) {
        Vector<String> resVector = new Vector<String>();
        
        resVector.add("");
        
        try {
            while (res.next()) {
                resVector.add(res.getString(1));
            }
            
            return resVector;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resVector;
    }
}
