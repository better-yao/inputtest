package com.yao.mergeall;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yao.bean.Cha;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class Chaju {
    public static void main(String[] args) {
        try {
            //c3p0数据库的使用，其中默认识别吃c3p0.properties属性文件里的mysql的配置
            ComboPooledDataSource ds = new ComboPooledDataSource();
            String str;
            QueryRunner qr = new QueryRunner(ds);
            String sql="SELECT DateTime,XF-XG AS X ,YF-YG AS Y FROM onetest";
            String sql1="insert into chaju(DateTime,x,y) values(?,?,?)";

            List<Cha> list=qr.query(sql,new BeanListHandler<>(Cha.class));
            for (Cha c:list) {

                Object[] o={c.getDateTime(),c.getX(),c.getY()};
                qr.update(sql1,o);
            }
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
