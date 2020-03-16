package com.yao.dao;

import com.yao.tools.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputWaveradarDao {
    public static void main(String[] args) {
        try{
            String sql="INSERT IGNORE INTO waveradar (DateTime,HDiv3,TDiv3,Hm0,Tm02,Hmax,H10,Ngd_zP,AV10_H) VALUES (?,?,?,?,?,?,?,?,?)";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ResultSet rs = null;
            BufferedReader bfd =null;
            String[] arr=new String[9];
            File sqlfile = new File("F:/公司文件/临时sql文件/");
            if (sqlfile.exists() && sqlfile.isDirectory()) {
                File[] f = sqlfile.listFiles();
                for (int i = 0; i < f.length; i++) {
                    File file = f[i];
                    if (file.getName().indexOf("Waveradar") != -1) {//表示包含Waveradar为名的文件
                        String str;
                        String datetime,Hm0,Tm02,HDiv3,TDiv3,Hmax,H10,Ngd_zP,AV10_H;
                        bfd = new BufferedReader(new FileReader(file));
                        while ((str = bfd.readLine()) != null) {

                            if(str.contains("Hm0=") && str.contains("Datetime#")){
                                datetime = str.substring(str.indexOf("#") + 1, str.lastIndexOf("#"));
                                Hm0 = str.substring(str.indexOf("Hm0=")+4, str.lastIndexOf("cm")).trim();
                                for(int j=0;j<9;j++){
                                    arr[j]=bfd.readLine();
                                }
                                if(arr[8]==null||arr[4]==null||arr[3]==null||arr[2]==null||arr[1]==null||arr[0]==null||!arr[0].contains("Tm02=")||!arr[1].contains("H1/3=")||!arr[2].contains("T1/3=")||!arr[4].contains("Hmax=")||!arr[8].contains("Ngd_zP=")||!arr[3].contains("AV10_H=")){
                                    continue;
                                }
                                Tm02=arr[0].substring(arr[0].indexOf("Tm02=")+5, arr[0].lastIndexOf("s")).trim();
                                HDiv3=arr[1].substring(arr[1].indexOf("H1/3=")+5, arr[1].lastIndexOf("cm")).trim();
                                TDiv3=arr[2].substring(arr[2].indexOf("T1/3=")+5, arr[2].lastIndexOf("s")).trim();
                                Hmax=arr[4].substring(arr[4].indexOf("Hmax=")+5, arr[4].lastIndexOf("cm")).trim();
                                H10="0.0";
                                Ngd_zP=arr[8].substring(arr[8].indexOf("Ngd_zP=")+7, arr[8].lastIndexOf("%")).trim();
                                AV10_H=arr[3].substring(arr[3].indexOf("AV10_H=")+7, arr[3].lastIndexOf(";")).trim();

//                                System.out.println(Tm02+"####"+HDiv3+"####"+TDiv3+"####"+Hmax+"####"+Ngd_zP+"####"+AV10_H);

                                if(!(IfFloat.isFloat(Hm0)) || !(IfFloat.isFloat(Tm02)) || !(IfFloat.isFloat(HDiv3)) || !(IfFloat.isFloat(TDiv3)) || !(IfFloat.isFloat(Hmax)) || !(IfFloat.isFloat(Ngd_zP)) || !(IfFloat.isFloat(AV10_H))){
                                    System.out.println(str);
                                    continue;
                                }
                                else {
                                    ps.setString(1,datetime);
                                    ps.setFloat(2,Float.parseFloat(HDiv3));
                                    ps.setFloat(3,Float.parseFloat(TDiv3));
                                    ps.setFloat(4,Float.parseFloat(Hm0));
                                    ps.setFloat(5,Float.parseFloat(Tm02));
                                    ps.setFloat(6,Float.parseFloat(Hmax));
                                    ps.setFloat(7,Float.parseFloat(H10));
                                    ps.setFloat(8,Float.parseFloat(Ngd_zP));
                                    ps.setFloat(9,Float.parseFloat(AV10_H));
                                    ps.addBatch();
                                }

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
