package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionProvider {
	public static Connection createC() {
		//to store the connection
		 Connection con = null;
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create the connection
			String user = "root";
			String password = "Khushi@12345";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
