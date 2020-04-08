package com.yao.mytest;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Test {

    public static void main(String[] args) {
        //MD5测试工具
        String password = DigestUtils.md5Hex("XbSys");
        System.out.println(password);
    }

}
