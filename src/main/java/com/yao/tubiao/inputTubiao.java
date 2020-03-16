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
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;
            conn.setAutoCommit(false);
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
                            ps.addBatch();
                        }
                        System.out.println(file.getName());
                        ps.executeBatch();
                        conn.commit();
                        ps.clearBatch();
                    }


                }
            }
            C3p0Utils.close(conn,ps,rs);
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
