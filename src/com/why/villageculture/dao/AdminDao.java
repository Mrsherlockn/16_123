package com.why.villageculture.dao;

import com.why.villageculture.domain.Admin;

import java.util.List;


public interface AdminDao {

    public Admin login(Admin admin) throws Exception;
    public List<Admin> queryAll() throws Exception;
    public void save(Admin admin) throws Exception;
}
