package com.yao.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputExcel {
    private static POIFSFileSystem fs;//poi文件流
    private static HSSFWorkbook wb;//获得execl
    private static HSSFRow row;//获得行
    private static HSSFSheet sheet;//获得工作簿
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in= new FileInputStream("F:/公司文件/文件.xls");
        imports(in);
    }
    public static void imports(InputStream in ){
        String str = "";
        try {
            fs = new POIFSFileSystem(in);//文件流(将指定的excel文件放入poi文件流中)
            wb = new HSSFWorkbook(fs);//通过文件流获得excel文件的对象
            sheet=wb.getSheetAt(0);//获得工作薄
            //int rowfirst=sheet.getFirstRowNum();//获取第一行的行数（行数走的索引表达）
            int rowend=sheet.getLastRowNum();//获取最后一行的行数（行数走的索引表达）
            for (int i = 2; i <=rowend; i++) {
                row=sheet.getRow(i);//循环执行每一行
                int colNum = row.getPhysicalNumberOfCells();//获取一行的总列数
                int j = 0;
                while (j < colNum) {
                    str += getCellFormatValue(row.getCell((short) j)).trim() + "-";//字符串拼接然后输出每一行
                    j++;
                }
                System.out.println(str);//输出到控制台
                str="";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //--------笔记--------
    /*
    CELL_TYPE_NUMERIC　　数值型　  0
    CELL_TYPE_STRING　 字符串型   1 
    CELL_TYPE_FORMULA　 公式型    2
    CELL_TYPE_BLANK　　  空值     3  
    CELL_TYPE_BOOLEAN　 布尔型    4
    CELL_TYPE_ERROR　　 错误      5
    */
    //-------------------

    private static String getCellFormatValue(HSSFCell cell) {//自定义的函数方法（将每个单元格里面的数据进行格式化）
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {//用switch去实现getCellType()的值
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC://数值类型
                case HSSFCell.CELL_TYPE_FORMULA: {//公式类型
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断当前的cell是否为Date
                        Date date = cell.getDateCellValue();//是date类型的话进行格式化日期，然后返回给上一个字符串。
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化日期，年-月-日 格式
                        cellvalue = sdf.format(date);
                    }
                    else {// 如果是纯数字  取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());//将获取的纯数值类型的Cell，通过valueof方法转换成字符串格式。
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_STRING://代表当前类型为字符串类型
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default://默认值为空
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";//cell值不符合上面的null值时，返回的结果改为空。
        }
        return cellvalue;//将获取的单元格内容返还给main方法
    }
}
