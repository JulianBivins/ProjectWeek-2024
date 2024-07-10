package com.grb.abihelper.backendend.AbiHelper.main;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class AbiHelperApplication {

	public static void main(String[] args) {
	try {

		DataSource source = createDataSource();
		Connection connection = source.getConnection();

		SpringApplication.run(AbiHelperApplication.class, args);
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	public  static DataSource createDataSource() {
		HikariDataSource source = new HikariDataSource();
		source.setJdbcUrl("jdbc:mysql://localhost:3306/Abidatenbank");
		source.setUsername("Bootspring");

		return  source;
	}

}
