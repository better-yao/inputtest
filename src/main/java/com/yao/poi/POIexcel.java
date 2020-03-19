package com.yao.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

import java.io.*;

public class POIexcel {

    public static void main(String[] args) {
        File f = new File("F:/公司文件/文件.xls");
        InputExcel(f);
    }

    private static void InputExcel(File f) {
        try {
            //POI文件导入功能
            HSSFWorkbook workbook = new HSSFWorkbook();//创建一个excel文件

            //-----------设置单元格格式-----------
            HSSFSheet sheet = workbook.createSheet("表格");//创建一个sheet工作蒲,并命名
            sheet.setColumnWidth(0,20 * 256);//设置单元格的宽度，参数一：指定哪一列单元格，参数二：指定的单元格的宽度大小
            sheet.setColumnWidth(1,20 * 256);//第二列单元格宽度为20*256
            sheet.setDefaultRowHeight((short) 300);//设置单元格同一高度
            HSSFDataFormat format=workbook.createDataFormat();//设置单元格内容格式（内容的格式）
            HSSFCellStyle cellStyle = workbook.createCellStyle();//设置单元格格式
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            //------------设置表的结构------------
            HSSFRow row1 = sheet.createRow(0);//创建第一行  索引为0
            sheet.addMergedRegion(new Region(0,(short)0,0,(short)1));// 四个参数分别是：起始行，起始列，结束行，结束列 (单个单元格)  可以用来合并单元格
            HSSFCell cell = row1.createCell(0);//创建一个单元格  这里用来做表头
            cell.setCellValue("时间坐标基础表");//给这个单元格添加值
            HSSFRow row2 = sheet.createRow(1);//创建第二行  索引时1
            HSSFCell cell2 = row2.createCell(0);//创建第二行第一列
            cell2.setCellValue("DateTime");//设置字段索引名称
            HSSFCell cell3 = row2.createCell(1);//创建第二行第二列
            cell3.setCellValue("Location");//设置字段索引名称
            //------读取文件(可以连接数据库)-------
            String path = POIexcel.class.getClassLoader().getResource("./prop/Line-1.txt").getPath();
            System.out.println(path);
            File file = new File(path.substring(1));
            FileInputStream fos = new FileInputStream( path);
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
