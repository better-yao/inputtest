package com.yao.poi;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

import java.io.*;
//读取txt文件的数据，生成excel文件
public class toExcel {
    public static void main(String[] args) {
        try {
            String str;
            File f = new File("F:/testone.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            BufferedWriter bw = new BufferedWriter(new FileWriter("F:/full.txt"));
            while((str=br.readLine())!=null){
                String[] a=str.trim().split(" ");
                for ( String s: a) {
                    if(!"".equals(s)){
                        bw.write(s+",");
                        System.out.print(s+",");
                    }
                }
                bw.write("\r\n");//生成txt文件时用来换行用的（换行操作）
                System.out.println();
            }
            bw.flush();//字符流写入要刷新，否则会有后面部分数据没有写入。刷新后就自动写入了。
            bw.close();
            br.close();
            File fpoi = new File("F:/full.xls");
            InputExcel(fpoi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void InputExcel(File f) {
        try {
            //POI文件导出成excel表文件功能
            HSSFWorkbook workbook = new HSSFWorkbook();//创建一个excel文件

            //-----------设置单元格格式-----------
            HSSFSheet sheet = workbook.createSheet("表格");//创建一个sheet工作蒲,并命名
            sheet.setColumnWidth(0,7 * 256);//设置单元格的宽度，参数一：指定哪一列单元格，参数二：指定的单元格的宽度大小
            sheet.setColumnWidth(1,15 * 256);//第二列单元格宽度为20*256
            sheet.setColumnWidth(2,15 * 256);
            sheet.setColumnWidth(3,15 * 256);
            sheet.setDefaultRowHeight((short) 350);//设置单元格同一高度
            HSSFDataFormat format=workbook.createDataFormat();//设置单元格内容格式（内容的格式）
            HSSFCellStyle cellStyle = workbook.createCellStyle();//设置单元格格式
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            //------------设置表的结构------------
            HSSFRow row1 = sheet.createRow(0);//创建第一行  索引为0
            sheet.addMergedRegion(new Region(0,(short)0,0,(short)3));// 四个参数分别是：起始行，起始列，结束行，结束列 (单个单元格)  可以用来合并单元格
            HSSFCell cell = row1.createCell(0);//创建一个单元格  这里用来做表头
            cell.setCellValue("生成的表格");//给这个单元格添加值
            HSSFRow row2 = sheet.createRow(1);//创建第二行  索引时1
            HSSFCell cell2 = row2.createCell(0);//创建第二行第一列
            cell2.setCellValue("序号");//设置字段索引名称
            HSSFCell cell3 = row2.createCell(1);//创建第二行第二列
            cell3.setCellValue("one");//设置字段索引名称
            HSSFCell cell4 = row2.createCell(2);
            cell4.setCellValue("two");
            HSSFCell cell5 = row2.createCell(3);
            cell5.setCellValue("three");
            //------读取文件(可以连接数据库)-------
            FileInputStream fos = new FileInputStream( "F:/full.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(fos,"utf8"));//字节流转换字符流
            //---------表里面添加数据阶段----------
            for(int i=0; ;i++){
                String s=bfr.readLine();
                if (null==s){
                    break;
                }
                String[] arr=s.split(",");
                HSSFRow row = sheet.createRow(i + 2);
                HSSFCell zicell1 = row.createCell(0);
                zicell1.setCellValue(arr[0]);
                HSSFCell zicell2 = row.createCell(1);
                zicell2.setCellValue(arr[1]);
                HSSFCell zicell3 = row.createCell(2);
                zicell3.setCellValue(arr[2]);
                HSSFCell zicell4 = row.createCell(3);
                zicell4.setCellValue(arr[3]);
            }
            //--------生成excel表文件--------
            FileOutputStream fileOut = new FileOutputStream(f);
            workbook.write(fileOut);
            fos.close();
            bfr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

