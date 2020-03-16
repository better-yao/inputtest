package com.yao.dao;

import com.yao.tools.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.*;

public class InputHeaveDao {
    public static void main(String[] args) {

        try {
            String sql = "INSERT IGNORE INTO heave(DateTime,heave) VALUES (?,?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;
            File sqlfile = new File("F:/公司文件/临时sql文件/");
            if (sqlfile.exists() && sqlfile.isDirectory()) {
                File[] f = sqlfile.listFiles();
                for (int i = 0; i < f.length; i++) {
                    File file = f[i];
                    if (file.getName().indexOf("Waveradar") != -1) {//表示包含Waveradar为名的文件
                        bfd = new BufferedReader(new FileReader(file));
                        while ((str = bfd.readLine()) != null) {
                            if (str.contains("heave=") && str.contains("Datetime#")){
                                String datetime = str.substring(str.indexOf("#") + 1, str.lastIndexOf("#"));
                                String heave = str.substring(str.indexOf("heave=")+6, str.lastIndexOf("cm")).trim();
                                if(!(IfFloat.isFloat(heave))){
                                    System.out.println(str);
                                    continue;
                                }
                                ps.setString(1, datetime);
                                ps.setFloat(2, Float.parseFloat(heave));
                                ps.addBatch();
                            }else{
                                continue;
                            }
                        }
                        System.out.println(file.getName());
                        ps.executeBatch();
                        conn.commit();
                        ps.clearBatch();
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
