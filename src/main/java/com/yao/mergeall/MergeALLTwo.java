package com.yao.mergeall;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yao.bean.Gpsfpd;
import com.yao.bean.Waveradar;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MergeALLTwo {

    public static void main(String[] args) {
        try {
            //c3p0数据库的使用，其中默认识别吃c3p0.properties属性文件里的mysql的配置
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //使用的时DBUtials实现简单的数据库的持久化过程（需要引入jar包或者maven的依赖）
            QueryRunner qr = new QueryRunner(ds);
            String sql="SELECT DateTime,HDiv3,TDiv3,Hm0,Tm02,Hmax,H10 FROM waveradar ORDER BY DateTime ASC";
            //查询query
            List<Waveradar> list=qr.query(sql,new BeanListHandler<>(Waveradar.class));

            for (Waveradar wa: list) {
                insertSql(wa,ds);
            }
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSql(Waveradar wa,ComboPooledDataSource ds){
        try {
            String sql1="INSERT INTO mergeall (DateTime,HDiv3,TDiv3,Hm0,Tm02,Hmax,H10) VALUES (?,?,?,?,?,?,?)";
            String sql2="update mergeall set HDiv3=?, TDiv3=?, Hm0=? ,Tm02=? ,Hmax=? ,H10=? where DateTime =?";
            String sql3="select * from mergeall where DateTime=?";
            QueryRunner qr = new QueryRunner(ds);
            Object[] o1 = {wa.getDateTime(),wa.getHDiv3(),wa.getTDiv3(),wa.getHm0(),wa.getTm02(),wa.getHmax(),wa.getH10()};
            Object[] o2 = {wa.getHDiv3(),wa.getTDiv3(),wa.getHm0(),wa.getTm02(),wa.getHmax(),wa.getH10(),wa.getDateTime()};
            Waveradar waveradar = qr.query(sql3, wa.getDateTime(), new BeanHandler<>(Waveradar.class));
            if (null==waveradar){
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
