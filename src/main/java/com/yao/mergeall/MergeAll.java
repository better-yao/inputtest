package com.yao.mergeall;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yao.bean.Gpsfpd;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MergeAll {
    public static void main(String[] args) {
        try {
            //c3p0数据库的使用，其中默认识别吃c3p0.properties属性文件里的mysql的配置
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //使用的时DBUtials实现简单的数据库的持久化过程（需要引入jar包或者maven的依赖）
            QueryRunner qr = new QueryRunner(ds);
            String sql="SELECT DateTime,Heading,Roll,Pitch,Latitude,Longitude,Altitude,Ve,Vn,Vu,Baseline FROM gpsfpd ORDER BY DateTime ASC";
            List<Gpsfpd> list=qr.query(sql,new BeanListHandler<>(Gpsfpd.class));

            for (Gpsfpd gps: list) {
                System.out.print(gps.getDateTime()+"===");
                insertSql(gps,ds);
            }
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSql(Gpsfpd gps,ComboPooledDataSource ds){
        try {
            QueryRunner qr = new QueryRunner(ds);
            String sql1="INSERT IGNORE INTO mergeall (DateTime,Heading,Roll,Pitch,Latitude,Longitude,Altitude,Ve,Vn,Vu,Baseline) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            String sql2="update mergeall set Heading =?, Roll =?, Pitch =?, Latitude =?, Longitude =?, Altitude =?, Ve =?, Vn =?, Vu =?, Baseline =? where DateTime =?";
            String sql3="select * from mergeall where DateTime=?";

            String datetime = gps.getDateTime();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(datetime);//设置起始日期（字符串格式化为指定格式的Date类型）
            System.out.print(date1.getTime()+"===");//输出毫秒值。
            Calendar ca = Calendar.getInstance();
            ca.setTime(date1);//设置当前日期-----起始时间
            ca.add(Calendar.MILLISECOND,500);//加500毫秒  来进行自动毫秒值四舍五入到秒
            //获取年
            int year = ca.get(Calendar.YEAR);
            //获取月份，0表示1月份
            int month = ca.get(Calendar.MONTH) + 1;
            //获取当前天数
            int day = ca.get(Calendar.DAY_OF_MONTH);
            //获取当前小时
            int hour = ca.get(Calendar.HOUR_OF_DAY);
            //获取当前分钟
            int min = ca.get(Calendar.MINUTE);
            //获取当前秒
            int sec = ca.get(Calendar.SECOND);
            //拼接字符串（时间格式为：yyyy-MM-dd HH:mm:ss）
            String time = year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
            System.out.println(time);
            Object[] o1 = {time,gps.getHeading(),gps.getRoll(),gps.getPitch(),gps.getLatitude(),gps.getLongitude(),gps.getAltitude(),gps.getVe(),gps.getVn(),gps.getVu(),gps.getBaseline()};
            Object[] o2 = {gps.getHeading(),gps.getRoll(),gps.getPitch(),gps.getLatitude(),gps.getLongitude(),gps.getAltitude(),gps.getVe(),gps.getVn(),gps.getVu(),gps.getBaseline(),time};
            Gpsfpd gpsfpd = qr.query(sql3, time , new BeanHandler<>(Gpsfpd.class));
            if (null==gpsfpd){
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
