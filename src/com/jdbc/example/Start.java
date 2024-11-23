package com.jdbc.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to EXIT app");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				//add student...
				System.out.println("Enter student name: ");
				String name = br.readLine();
				
				System.out.println("Enter student contact No. : ");
				String phone = br.readLine();
				
				System.out.println("Enter student City: ");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is successfully added");
				}else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
				
			}else if(c == 2) {
				//delete student...
				System.out.println("Enter student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted....");
				}else {
					System.out.println("Something went wrong.");
				}
				
			}else if(c == 3) {
				//display student...
				StudentDao.showAllStudent();
			}else if(c == 4) {
				//exit app...
				break;
			}else {
				
			}
		}
		
		System.out.println("Thank you for using my application");
		System.out.println("See you soon...<3");

	}

}
