package com.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			//jdbc code...
			Connection con = ConnectionProvider.createC();
			String q = "insert into students(sname, sphone, scity) values(?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			//set values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute...
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f = false;
		try {
			//jdbc code...
			Connection con = ConnectionProvider.createC();
			String q = "delete from students where sid=?";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			//set values of parameters
			pstmt.setInt(1, userId);
			//execute...
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudent() {
		boolean f = false;
		try {
			//jdbc code...
			Connection con = ConnectionProvider.createC();
			String q = "select * from students";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID : "+ id);
				System.out.println("NAME : "+ name);
				System.out.println("PHONE : "+ phone);
				System.out.println("CITY : "+ city);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
