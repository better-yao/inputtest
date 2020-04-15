package com.yao.mergeall;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yao.bean.NewBeanG;
import com.yao.bean.OneTest;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectTables {

    public static void main(String[] args) {
        try {
            String sql="SELECT DateTime,X,Y,utmzone,altitude,heading,roll,pitch FROM onetest";
            //c3p0数据库的使用，其中默认识别吃c3p0.properties属性文件里的mysql的配置
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //使用的时DBUtials实现简单的数据库的持久化过程（需要引入jar包或者maven的依赖）
            QueryRunner qr = new QueryRunner(ds);
            List<OneTest> list=qr.query(sql,new BeanListHandler<>(OneTest.class));
            BufferedWriter bw=new BufferedWriter(new FileWriter("F:/onetest.txt"));
            for (OneTest o:list){

                bw.write(o.getDateTime()+","+o.getX()+","+o.getY()+","+o.getUtmzone()+","+o.getAltitude()+","+o.getHeading()+","+o.getRoll()+","+o.getPitch()+"\r\n");
            }
            bw.flush();
            bw.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
