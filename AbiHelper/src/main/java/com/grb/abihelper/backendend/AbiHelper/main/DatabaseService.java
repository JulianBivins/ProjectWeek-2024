package com.grb.abihelper.backendend.AbiHelper.main;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;

@Service
public class DatabaseService {
    HikariDataSource source;
    public DatabaseService() {
        source  = new HikariDataSource();
        source.setJdbcUrl("jdbc:mysql://localhost:3306/Abidatenbank");
        source.setUsername("Bootspring");


    }
    public  Connection getConnection() {
        try {
            return source.getConnection(); //Immer eine neue connec
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
