package com.ketan.bean;

public class Vendor {

	private int id;
	private String vname;
	private int gst_no;
	private String edate;
	private String email;
	private String password;
	private int signature_id;
	
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(int id, String vname, int gst_no, String edate, String email, String password, int signature_id) {
		super();
		this.id = id;
		this.vname = vname;
		this.gst_no = gst_no;
		this.edate = edate;
		this.email = email;
		this.password = password;
		this.signature_id = signature_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public int getGst_no() {
		return gst_no;
	}

	public void setGst_no(int gst_no) {
		this.gst_no = gst_no;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
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

	public int getSignature_id() {
		return signature_id;
	}

	public void setSignature_id(int signature_id) {
		this.signature_id = signature_id;
	}
	

	
	
}
