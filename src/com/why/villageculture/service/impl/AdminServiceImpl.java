package com.why.villageculture.service.impl;

import com.why.villageculture.dao.AdminDao;
import com.why.villageculture.dao.impl.AdminDaoImpl;
import com.why.villageculture.domain.Admin;
import com.why.villageculture.service.AdminService;
import com.why.villageculture.utils.PasswordUtils;
import org.junit.Test;

public class AdminServiceImpl implements AdminService {

    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) throws Exception {
        // 以用户名作为盐，来进行加密
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        // 将加密后的pwd，设置成用户的密码
        admin.setPassword(pwd);

        return dao.login(admin);
    }

    @Override
    public void save(Admin admin) throws Exception {
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        admin.setPassword(pwd);
        // 调dao来保存
        dao.save(admin);
    }

    @Test
    public void test1() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("number1");
        admin.setPassword("123456");

        System.out.println(service.login(admin));
    }

    @Test
    public void test2() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("rose");
        admin.setPassword("5678");
        admin.setLimits(2);
        service.save(admin);
    }
}
