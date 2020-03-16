package com.yao.mytest;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Test {

    public static void main(String[] args) {
        String password = DigestUtils.md5Hex("XbSysadmin-111");
        System.out.println(password);
    }

}
