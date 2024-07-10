package com.grb.abihelper.backendend.AbiHelper.main;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {

    public static void main(String[] args) {

        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

