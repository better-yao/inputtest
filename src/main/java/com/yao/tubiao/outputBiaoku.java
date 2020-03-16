package com.yao.tubiao;

import com.yao.service.C3p0Utils;
import com.yao.tools.IfFloat;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class outputBiaoku {




    public static void main(String[] args) {

        try {

            String sql = "SELECT * FROM biao ORDER BY datetime ASC";
            Connection conn = C3p0Utils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            String str;
            File sqlfile = new File("F:/公司文件/archive/biao/Line-9.txt");
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sqlfile));
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                bfw.write(rs.getString(1)+","+rs.getString(2)+"\r\n");
            }
            bfw.flush();

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
