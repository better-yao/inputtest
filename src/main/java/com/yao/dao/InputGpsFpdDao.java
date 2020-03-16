package com.yao.dao;

import com.yao.tools.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputGpsFpdDao {
    public static void main(String[] args) {

        try {
            String sql="INSERT IGNORE INTO gpsfpd (DateTime,Heading,Roll,Pitch,Latitude,Longitude,Altitude,Ve,Vn,Vu,Baseline,spmx,spmy,spmz,aftx,afty,aftz,sway,surge,heave) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;
            conn.setAutoCommit(false);

            File sqlfile = new File("F:/公司文件/临时sql文件/");
            if (sqlfile.exists() && sqlfile.isDirectory()){
                File[] f = sqlfile.listFiles();
                for(int i=0;i<f.length;i++){
                    File file=f[i];
                    if (file.getName().indexOf("GPSFPD") !=-1 ){//表示包含GPSFP为名的文件
                        bfd = new BufferedReader(new FileReader(file));
                        while((str=bfd.readLine())!=null) {
                            String[] arr=str.split(",");
                            if(!(IfFloat.isFloat(arr[3])) || !(IfFloat.isFloat(arr[4])) || !(IfFloat.isFloat(arr[5])) || !(IfFloat.isFloat(arr[6])) || !(IfFloat.isFloat(arr[7])) || !(IfFloat.isFloat(arr[8])) || !(IfFloat.isFloat(arr[9])) || !(IfFloat.isFloat(arr[10])) || !(IfFloat.isFloat(arr[11])) || !(IfFloat.isFloat(arr[12])) || !(arr[0].contains("Datetime#"))){
                                System.out.println(str);
                                continue;
                            }
                            ps.setString(1,arr[0].substring(arr[0].indexOf("#")+1,arr[0].lastIndexOf("#")));
                            ps.setFloat(2,Float.parseFloat(arr[3]));
                            ps.setFloat(3,Float.parseFloat(arr[5]));
                            ps.setFloat(4,Float.parseFloat(arr[4]));
                            ps.setFloat(5,Float.parseFloat(arr[6]));
                            ps.setFloat(6,Float.parseFloat(arr[7]));
                            ps.setFloat(7,Float.parseFloat(arr[8]));
                            ps.setFloat(8,Float.parseFloat(arr[9]));
                            ps.setFloat(9,Float.parseFloat(arr[10]));
                            ps.setFloat(10,Float.parseFloat(arr[11]));
                            ps.setFloat(11,Float.parseFloat(arr[12]));
                            ps.setFloat(12,0);
                            ps.setFloat(13,0);
                            ps.setFloat(14,0);
                            ps.setFloat(15,0);
                            ps.setFloat(16,0);
                            ps.setFloat(17,0);
                            ps.setFloat(18,0);
                            ps.setFloat(19,0);
                            ps.setFloat(20,0);
                            ps.addBatch();//打入包
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
