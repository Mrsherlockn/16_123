package com.why.villageculture.servlet;

import com.why.villageculture.domain.Admin;
import com.why.villageculture.service.AdminService;
import com.why.villageculture.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private AdminService service = new AdminServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 设置响应头
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            Admin admin = new Admin();
            BeanUtils.populate(admin, request.getParameterMap());

            admin = service.login(admin);

            if (admin == null) {
                System.out.println("登陆失败：" + admin);

                request.setAttribute("msg", "登陆失败！请检查用户名或密码！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                System.out.println("登陆成功：" + admin);
                response.getWriter().print("<span style='color:green'>登陆成功</span>");

            }
        } catch (Exception e) {

            request.setAttribute("msg", "错误！");
            request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
        }
    }
}
