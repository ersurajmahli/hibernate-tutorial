package com.forgyan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {

	public static void main(String[] args) {
		String jdbc_url ="jdbc:mysql://localhost:3306/hibdemo?useSSL=false";
		String jdbc_user = "root";
		String jdbc_pass = "root";
		try {
			System.out.println("Connecting t database "+jdbc_url);
			Connection conn = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
			System.out.println("Connection Successful");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
