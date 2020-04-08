package com.yao.tools;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Utils {
    //log日志
    static Logger logger = Logger.getLogger(C3p0Utils.class.getName());

    //创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");//连接c3p0.xml文件的格式


    public static Connection getConnection(){
        try {
            return dataSource.getConnection();

        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!", e);
            return null;
        }
    }


    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);

            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);

            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }
    }
}
