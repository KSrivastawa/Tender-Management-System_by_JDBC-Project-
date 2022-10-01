package com.ketan.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseUtility {

	public static Connection provideTenderConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/tender_management_system";
		
		try {
			conn = DriverManager.getConnection(url,"root","Prashant@20");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
		
	}
	
}
