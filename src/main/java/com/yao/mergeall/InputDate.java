package com.yao.mergeall;

import com.yao.tools.C3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputDate {

    public static void main(String[] args) {
        try {
            String sql="INSERT INTO mergeall (DateTime) VALUES (?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ResultSet rs = null;
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-2-23 00:00:00");//设置起始日期（字符串格式化为指定格式的Date类型）
            Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-2-24 00:00:00");//设置结束日期
            Calendar ca = Calendar.getInstance();//定义日期（日历）格式对象
            ca.setTime(date1);//Calandar日历对象设置起始时间，便于循环日期使用的对象
            //判断两个日期的大小
            while(ca.getTime().before(date2)){
                //通过日历类获取时间
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
                String time = year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
                System.out.println(time);
                ps.setString(1, time);
                ps.addBatch();//打包
                ca.add(Calendar.SECOND,1);//进行当前日期的秒数加1
            }
            ps.executeBatch();
            conn.commit();
            ps.clearBatch();
            C3p0Utils.close(conn,ps,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
