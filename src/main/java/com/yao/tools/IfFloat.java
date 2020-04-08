package com.yao.tools;

import java.util.regex.Pattern;
//判断是否为float类型
public class IfFloat {
    public static boolean isFloat(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        //正则表达式float的判断
        Pattern pattern = Pattern.compile("^[+-]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][+-]?[0-9]+)?$");
        //返回结果为 boolean类型判断结果是否为float类型
        return pattern.matcher(str).matches();
    }

    public static boolean isFloat(String[] str) {
        for (String v : str) {
            if(!(isFloat(v))){
                return false;
            }
        }
        return true;
    }
}
