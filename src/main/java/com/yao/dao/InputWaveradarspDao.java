package com.yao.dao;

import com.yao.service.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.*;

public class InputWaveradarspDao {

    public static void main(String[] args) {

        try {

            String sql = "INSERT IGNORE INTO waveradarsp VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;
            conn.setAutoCommit(false);
            File sqlfile = new File("F:/公司文件/临时sql文件/");
            if (sqlfile.exists() && sqlfile.isDirectory()) {
                File[] f = sqlfile.listFiles();
                for (int i = 0; i < f.length; i++) {
                    File file = f[i];
                    if (file.getName().indexOf("Waveradar") != -1) {//表示包含Waveradar为名的文件
                        bfd = new BufferedReader(new FileReader(file));
                        while ((str = bfd.readLine()) != null) {

                            if (str.contains("Czz10=") && str.contains("Datetime#")){
                                String datetime = str.substring(str.indexOf("#") + 1, str.lastIndexOf("#"));
                                String Czz10 = str.substring(str.indexOf("Czz10=")+6, str.lastIndexOf("cm2/Hz")).trim();
                                String[] v=Czz10.split(",");
                                if(!(IfFloat.isFloat(v))){
                                    System.out.println(str);
                                    continue;
                                }
                                ps.setString(1, datetime);
                                ps.setFloat(2, Float.parseFloat(v[0]));
                                ps.setFloat(3, Float.parseFloat(v[1]));
                                ps.setFloat(4, Float.parseFloat(v[2]));
                                ps.setFloat(5, Float.parseFloat(v[3]));
                                ps.setFloat(6, Float.parseFloat(v[4]));
                                ps.setFloat(7, Float.parseFloat(v[5]));
                                ps.setFloat(8, Float.parseFloat(v[6]));
                                ps.setFloat(9, Float.parseFloat(v[7]));
                                ps.setFloat(10, Float.parseFloat(v[8]));
                                ps.setFloat(11, Float.parseFloat(v[9]));
                                ps.setFloat(12, Float.parseFloat(v[10]));
                                ps.setFloat(13, Float.parseFloat(v[11]));
                                ps.setFloat(14, Float.parseFloat(v[12]));
                                ps.setFloat(15, Float.parseFloat(v[13]));
                                ps.setFloat(16, Float.parseFloat(v[14]));
                                ps.setFloat(17, Float.parseFloat(v[15]));
                                ps.setFloat(18, Float.parseFloat(v[16]));
                                ps.setFloat(19, Float.parseFloat(v[17]));
                                ps.setFloat(20, Float.parseFloat(v[18]));
                                ps.setFloat(21, Float.parseFloat(v[19]));
                                ps.setFloat(22, Float.parseFloat(v[20]));
                                ps.setFloat(23, Float.parseFloat(v[21]));
                                ps.setFloat(24, Float.parseFloat(v[22]));
                                ps.setFloat(25, Float.parseFloat(v[23]));
                                ps.setFloat(26, Float.parseFloat(v[24]));
                                ps.setFloat(27, Float.parseFloat(v[25]));
                                ps.setFloat(28, Float.parseFloat(v[26]));
                                ps.setFloat(29, Float.parseFloat(v[27]));
                                ps.setFloat(30, Float.parseFloat(v[28]));
                                ps.setFloat(31, Float.parseFloat(v[29]));
                                ps.setFloat(32, Float.parseFloat(v[30]));
                                ps.setFloat(33, Float.parseFloat(v[31]));
                                ps.setFloat(34, Float.parseFloat(v[32]));
                                ps.setFloat(35, Float.parseFloat(v[33]));
                                ps.setFloat(36, Float.parseFloat(v[34]));
                                ps.setFloat(37, Float.parseFloat(v[35]));
                                ps.setFloat(38, Float.parseFloat(v[36]));
                                ps.setFloat(39, Float.parseFloat(v[37]));
                                ps.setFloat(40, Float.parseFloat(v[38]));
                                ps.setFloat(41, Float.parseFloat(v[39]));
                                ps.setFloat(42, Float.parseFloat(v[40]));
                                ps.setFloat(43, Float.parseFloat(v[41]));
                                ps.setFloat(44, Float.parseFloat(v[42]));
                                ps.setFloat(45, Float.parseFloat(v[43]));
                                ps.setFloat(46, Float.parseFloat(v[44]));
                                ps.setFloat(47, Float.parseFloat(v[45]));
                                ps.setFloat(48, Float.parseFloat(v[46]));
                                ps.setFloat(49, Float.parseFloat(v[47]));
                                ps.setFloat(50, Float.parseFloat(v[48]));
                                ps.setFloat(51, Float.parseFloat(v[49]));
                                ps.setFloat(52, Float.parseFloat(v[50]));
                                ps.addBatch();
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
