package com.yao.dao;

import com.yao.tools.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputGpsimuDao {
    public static void main(String[] args) {

        try {
            String sql="INSERT IGNORE INTO gpsimu (DateTime,GyroX,GyroY,GyroZ,AccX,AccY,AccZ,Tpr) VALUES (?,?,?,?,?,?,?,?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String str;

            File sqlfile = new File("F:/公司文件/临时sql文件/");
            if (sqlfile.exists() && sqlfile.isDirectory()){
                File[] f = sqlfile.listFiles();
                for(int i=0;i<f.length;i++){
                    File file=f[i];
                    if (file.getName().indexOf("GPSIMU") !=-1 ){//表示包含GPSIMU为名的文件
                        bfd = new BufferedReader(new FileReader(file));
                        while((str=bfd.readLine())!=null) {
                            String[] arr=str.split(",");
                            String  Tpr=arr[9].substring(0,arr[9].lastIndexOf("*"));
                            if(!(IfFloat.isFloat(arr[3])) || !(IfFloat.isFloat(arr[4])) || !(IfFloat.isFloat(arr[5])) || !(IfFloat.isFloat(arr[6])) || !(IfFloat.isFloat(arr[7])) || !(IfFloat.isFloat(arr[8])) || !(IfFloat.isFloat(Tpr)) || !(arr[0].contains("Datetime#"))){
                                System.out.println(str);
                                continue;
                            }
                            ps.setString(1,arr[0].substring(arr[0].indexOf("#")+1,arr[0].lastIndexOf("#")));
                            ps.setFloat(2,Float.parseFloat(arr[3]));
                            ps.setFloat(3,Float.parseFloat(arr[4]));
                            ps.setFloat(4,Float.parseFloat(arr[5]));
                            ps.setFloat(5,Float.parseFloat(arr[6]));
                            ps.setFloat(6,Float.parseFloat(arr[7]));
                            ps.setFloat(7,Float.parseFloat(arr[8]));
                            ps.setFloat(8,Float.parseFloat(Tpr));
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
