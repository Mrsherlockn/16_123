package com.why.villageculture.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DSUtils {
    public static DataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection(){
        Connection conn;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
