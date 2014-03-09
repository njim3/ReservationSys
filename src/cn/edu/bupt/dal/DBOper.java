package cn.edu.bupt.dal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class DBOper {
    private static DBOper uniqueInstance = null;
    private String propertiesPath = "../model/dbconn.properties";
    private Properties connProperties = new Properties();
    private Connection dbConn = null;
    private Statement stmt = null;
    
    /**
     * 注册MSSQL驱动，从dbconn.properties中读取配置
     */
    private DBOper() {
        InputStream in = null;
        
        try {
            in = DBOper.class.getResourceAsStream(propertiesPath);
            
            connProperties.load(in);
            
            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // connect to the db        
        try {
            Class.forName(connProperties.getProperty("connstr"));
            String dbUrl = "jdbc:" + connProperties.getProperty("dbtype") + "://"
                    + connProperties.getProperty("dbhost") + ";DatabaseName="
                    + connProperties.getProperty("db");
            
            System.out.println(dbUrl);
            
            dbConn = DriverManager.getConnection(dbUrl, 
                    connProperties.getProperty("username"), 
                    connProperties.getProperty("password"));
            
            stmt = dbConn.createStatement();
            
            if (stmt != null)
                System.out.println("数据库连接成功！");
            else
                System.out.println("数据库连接失败！");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 单例模式，获得DBOper的全局实例
     * @return DBOper实例
     */
    public static DBOper getInstance() {
        if (uniqueInstance == null) {
            // 加锁，并发
            synchronized (DBOper.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new DBOper();
            }
        }
        
        return uniqueInstance;
    }
    
    /**
     * 查询
     * @param sql String
     * @return ResultSet结果集
     */
    public ResultSet query(String sql) {
//        System.out.println(sql);
        
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 插入和更新
     * @param sql String
     * @return boolean是否插入或者更新成功
     */
    public boolean modify(String sql) {
        try {
            int res = stmt.executeUpdate(sql);
            
            return res > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 得到数据库中所有的表名
     * @return Vector<String> 表名以Vector形式返回
     */
    public Vector<String> getAllTableName() {
        Vector<String> resVector = new Vector<String>();
        
        try {
            DatabaseMetaData dbmd = this.dbConn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            
            while (rs.next()) {
                resVector.add(rs.getString(3));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resVector;
    }
    
    /**
     * 输出ResultSet结果集
     * @param rs ResultSet
     */
    public void opResultSet(ResultSet rs) {
        if (rs == null)
            return ;
        
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= columnCount; ++i)
                    System.out.print(rs.getString(i) + " ");
                
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
