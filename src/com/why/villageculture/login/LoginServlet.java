package com.why.villageculture.login;

import java.io.IOException;


public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        // 获取用户的输入
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 判断用户名和密码是否正确
        if(name.equals("admin") && pwd.equals("1234")){
            System.err.println("登陆成功");
        } else {
            System.err.println("失败！");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
