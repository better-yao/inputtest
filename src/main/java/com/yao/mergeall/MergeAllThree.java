package com.yao.mergeall;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yao.bean.Windsensor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MergeAllThree {
    public static void main(String[] args) {
        try {
            //c3p0数据库的使用，其中默认识别吃c3p0.properties属性文件里的mysql的配置
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //使用的时DBUtials实现简单的数据库的持久化过程（需要引入jar包或者maven的依赖）
            QueryRunner qr = new QueryRunner(ds);
            String sql="SELECT DateTime,windspeed,winddir FROM windsensor ORDER BY DateTime ASC";
            //查询query
            List<Windsensor> list=qr.query(sql,new BeanListHandler<>(Windsensor.class));

            for (Windsensor wind: list) {
                insertSql(wind,ds);
            }
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSql(Windsensor wind,ComboPooledDataSource ds){
        try {
            String sql1="INSERT INTO mergeall (DateTime,windspeed,winddir) VALUES (?,?,?)";
            String sql2="update mergeall set windspeed=?, winddir=? where DateTime =?";
            String sql3="select * from mergeall where DateTime=?";
            QueryRunner qr = new QueryRunner(ds);
            Object[] o1 = {wind.getDateTime(),wind.getWindspeed(),wind.getWinddir()};
            Object[] o2 = {wind.getWindspeed(),wind.getWinddir(),wind.getDateTime()};
            Windsensor windsensor = qr.query(sql3, wind.getDateTime(), new BeanHandler<>(Windsensor.class));
            if (null==windsensor){
                System.out.println("没有重复");
                qr.update(sql1,o1);
            }else {
                System.out.println("有重复--");
                qr.update(sql2,o2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
