package com.yao.mergeall;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newPOI {//poi读取.xlsx的文件 --将excel文件读取出来并生成txt文件。

    public static void main(String[] args) {
        try {
            read2007Excel(new File("F:/公司文件/0-置顶文件-0/test8-fz.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read2007Excel(File file) throws IOException {

        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));

        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        String result="";
        XSSFRow row = null;
        XSSFCell cell1 = null;
        XSSFCell cell2 = null;
        XSSFCell cell3 = null;
        XSSFCell cell4 = null;
        XSSFCell cell5 = null;
        XSSFCell cell6 = null;
        XSSFCell cell7 = null;
        BufferedWriter bw =new BufferedWriter(new FileWriter("F:/a8.txt"));
        System.out.println("读取excel：");
        for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            cell1 = row.getCell(0);
            cell2 = row.getCell(1);
            cell3 = row.getCell(2);
            cell4 = row.getCell(3);
            cell5 = row.getCell(4);
            cell6 = row.getCell(5);
            cell7 = row.getCell(6);
            if (cell1 == null || cell2 == null || cell3 == null || cell4 == null || cell5 == null  || cell6 == null || cell7 == null) {
                continue;
            }

            if (DateUtil.isCellDateFormatted(cell1)){//判断获取的XSSFCell的值是否为日期类型
                //是日期类型就将其格式化为自定义的日期类型然后输出结果
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                double value1 = cell1.getNumericCellValue();//将cell1转化为数值类型
                Date date = DateUtil.getJavaDate(value1);//将其数值转化为日期date类型
                result = sdf.format(date);//然后格式化日期。
            }
            bw.write(result+","+cell2+","+cell3+","+cell4+","+cell5+","+cell6+","+cell7+"\r\n");

        }
        bw.close();
    }

}
