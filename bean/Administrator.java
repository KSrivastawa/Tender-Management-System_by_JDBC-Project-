package com.ketan.bean;

public class Administrator {

	private int id;
	private String name;
	private String dob;
	private String email;
	private String password;
	
	public Administrator() {
		// TODO Auto-generated constructor stub
	}

	public Administrator(int id, String name, String dob, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
