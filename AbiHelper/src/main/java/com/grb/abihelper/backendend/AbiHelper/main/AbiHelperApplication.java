package com.grb.abihelper.backendend.AbiHelper.main;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class AbiHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbiHelperApplication.class, args);
	}
}
