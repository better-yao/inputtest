package com.yao.dao;

import com.yao.bean.Gpsfpd;
import com.yao.service.C3p0Utils;

import java.io.*;
import java.sql.*;

public class inputWindsensorDao {
    public static void main(String[] args) {

        try {
            String sql="INSERT IGNORE INTO windsensor (DateTime,windspeed,winddir) VALUES (?,?,?)";
            File sqlfile = new File("F:/公司文件/临时sql文件/");
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = null;
            BufferedReader bfd = null;
            String str = null;
            conn.setAutoCommit(false);

            if (sqlfile.exists() && sqlfile.isDirectory()){
                File[] f = sqlfile.listFiles();
                for(int i=0;i<f.length;i++){
                    File file=f[i];
                    //表示包含Wind为名的文件
                    if (file.getName().indexOf("Wind") !=-1 ){
                        bfd = new BufferedReader(new FileReader(file));
                        while((str=bfd.readLine())!=null) {
                            String[] arr=str.split(",");
                            ps.setString(1,arr[0].substring(arr[0].indexOf("#")+1,arr[0].lastIndexOf("#")));
                            ps.setFloat(2,Float.parseFloat(arr[3]));
                            ps.setFloat(3,Float.parseFloat(arr[1]));
                            //打包代码，一定数量后在提交
                            ps.addBatch();
                        }
                        ps.executeBatch();//将打入数量的包进行sql语句的执行
                        conn.commit();//手动提交
                        ps.clearBatch();//清除打入包的代码
                    }
                }
            }
            C3p0Utils.close(conn,ps,rs);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
