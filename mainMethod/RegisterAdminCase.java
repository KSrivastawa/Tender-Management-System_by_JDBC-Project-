package com.ketan.mainMethod;

import java.util.Scanner;

import com.ketan.bean.Administrator;
import com.ketan.dataBase.object.Administrator_DAO;
import com.ketan.dataBase.object.Administrator_DAO_Impl;

public class RegisterAdminCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin Id:");
		int id = sc.nextInt();
		
		System.out.println("Enter Admin Name:");
		String name = sc.next();
		
		System.out.println("Enter Admin DateOfBirth(yyyy/mm/dd):");
		String dob = sc.next();
		
		System.out.println("Enter Admin email:");
		String email = sc.next();
		
		System.out.println("Create Admin password:");
		String password = sc.next();
		
		Administrator admin = new Administrator();
		
		admin.setId(id);
		admin.setName(name);
		admin.setDob(dob);
		admin.setEmail(email);
		admin.setPassword(password);
		
		Administrator_DAO dao = new Administrator_DAO_Impl();
		
		String result = dao.registerAdmin(id, name, dob, email, password);
		
		System.out.println(result);
		

	}

}






