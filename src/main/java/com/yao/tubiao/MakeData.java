package com.yao.tubiao;

import java.io.*;

public class MakeData {
    public static void main(String[] args) {

        try {

        BufferedReader bfr = null;
        BufferedWriter bfw = new BufferedWriter(new FileWriter("F:/公司文件/bbbbb9.txt"));
        String str;
        File lineFile=new File("F:/公司文件/archive/Line # 09");

        if ( lineFile.isDirectory() && lineFile.exists()){
            File[] f=lineFile.listFiles();
            for (File file : f){
                bfr=new BufferedReader(new FileReader(file));

                if (file.getName().contains(".STS")){
                    str=bfr.readLine();
                    String[] arr = str.split(",");
                    String[] fen = arr[0].substring(0,10).split("/");
                    String all=fen[2]+"-"+fen[1]+"-"+fen[0]+" "+arr[0].substring(11)+","+arr[1]+"\r\n";
                    bfw.write(all);
                    System.out.println(arr[0]+"-------"+arr[1]);
                }
//                if (file.getName().contains(".ANG")){
//                        str=bfr.readLine();
//                        String[] arr = str.split(",");
//                        String[] fen = arr[0].substring(0,10).split("/");
//                        String all=fen[2]+"-"+fen[1]+"-"+fen[0]+" "+arr[0].substring(11)+","+arr[1]+"\r\n";
//                        bfw.write(all);
//                        System.out.println(arr[0]+"--ANG--"+arr[1]);
//
//                }
                bfw.flush();

            }
        }

        bfr.close();
        bfw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
