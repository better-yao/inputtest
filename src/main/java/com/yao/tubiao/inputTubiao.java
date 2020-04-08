package com.yao.tubiao;

import com.yao.service.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 将数据插入到数据库中
 */

public class inputTubiao {

    public static void main(String[] args) {

        try {

            String sql = "INSERT IGNORE INTO biao (datetime,location) VALUES (?,?)";
            Connection conn = C3p0Utils.getConnection();//c3p0数据库连接池获取连接
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;
            conn.setAutoCommit(false);//设置为手动改提交  不是自动提交
            File sqlfile = new File("F:/公司文件/archive/biao/");
            if (sqlfile.exists() && sqlfile.isDirectory()) {
                File[] f = sqlfile.listFiles();
                for (int i = 0; i < f.length; i++) {
                    File file = f[i];
                    if(file.getName().indexOf("bbbbb9") != -1){
                        bfd = new BufferedReader(new FileReader(file));
                        while ((str = bfd.readLine()) != null) {
                            String[] arr=str.split(",");
                            String datetime=arr[0];
                            String location=arr[1];
                            if(!(IfFloat.isFloat(location))){
                                System.out.println(str);
                                continue;
                            }
                            ps.setString(1, datetime);
                            ps.setString(2, location);
                            ps.addBatch();//打包
                        }
                        System.out.println(file.getName());
                        ps.executeBatch();//执行sql
                        conn.commit();//手动提交
                        ps.clearBatch();//清空打入包的代码
                    }


                }
            }
            C3p0Utils.close(conn,ps,rs);//结束关闭资源
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
