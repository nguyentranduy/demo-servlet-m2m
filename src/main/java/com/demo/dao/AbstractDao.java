package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/servlet";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
