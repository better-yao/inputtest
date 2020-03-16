package com.yao.tools;

import java.util.regex.Pattern;

public class IfFloat {
    public static boolean isFloat(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[+-]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][+-]?[0-9]+)?$");
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
