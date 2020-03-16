package com.yao.dao;

import com.yao.bean.Gpsfpd;
import com.yao.tools.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.*;

public class InputTempDao {
    public static void main(String[] args) {

        try {
            String sql = "INSERT IGNORE INTO temperature(DateTime,tem,humidity,bar) VALUES (?,?,?,?)";
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
                    if (file.getName().indexOf("Temp") != -1) {//表示包含GPSFP为名的文件
                        bfd = new BufferedReader(new FileReader(file));
                        while((str = bfd.readLine()) != null) {
                            String T = str.substring(str.indexOf("T=")+2, str.lastIndexOf("'C ")).trim();
                            String RH = str.substring(str.indexOf("RH=")+3, str.lastIndexOf("%RH")).trim();
                            String P = str.substring(str.indexOf("P=")+2, str.lastIndexOf("hPa")).trim();

                            T=T.equals("*****")?"0.0":T;
                            RH=RH.equals("*****")?"0.0":RH;
                            P=P.equals("*****")?"0.0":P;
                            if(!(IfFloat.isFloat(T)) || !(IfFloat.isFloat(RH)) || !(IfFloat.isFloat(P)) ){
                                System.out.println(str);
                                continue;
                            }
                            ps.setString(1, str.substring(str.indexOf("#") + 1, str.lastIndexOf("#")));
                            ps.setFloat(2, Float.parseFloat(T));
                            ps.setFloat(3, Float.parseFloat(RH));
                            ps.setFloat(4, Float.parseFloat(P));
                            ps.addBatch();
                        }
                        System.out.println(file.getName());
                        ps.executeBatch();
                        conn.commit();
                        ps.clearBatch();
                    }

                }
                C3p0Utils.close(conn,ps,rs);
            }

        }  catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
