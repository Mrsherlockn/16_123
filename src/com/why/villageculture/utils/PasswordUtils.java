package com.why.villageculture.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordUtils {

    public static String md5(String password, String salt){

        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String pwd = encoder.encodePassword(password.toLowerCase(), salt.toLowerCase());
        return pwd;
    }

    public static void main(String[] args){
        String pwd = PasswordUtils.md5("123456","number1");
        System.err.println(pwd);

        pwd = PasswordUtils.md5("123456","number2");
        System.err.println(pwd);
    }
}
