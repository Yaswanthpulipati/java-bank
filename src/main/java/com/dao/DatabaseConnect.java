package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

	public static Connection getConnection(String url,String username,String password) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
