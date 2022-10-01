package com.ketan.bean;

public class Bid_Tender {

	private int bid_no;             
	private String certification_type; 
	private String validity;           
	private int quantity;          
	private int price;              
	private String product_name;
	
	
	Bid_Tender(){
		
	}


	public Bid_Tender(int bid_no, String certification_type, String validity, int quantity, int price,
			String product_name) {
		super();
		this.bid_no = bid_no;
		this.certification_type = certification_type;
		this.validity = validity;
		this.quantity = quantity;
		this.price = price;
		this.product_name = product_name;
	}


	public int getBid_no() {
		return bid_no;
	}


	public void setBid_no(int bid_no) {
		this.bid_no = bid_no;
	}


	public String getCertification_type() {
		return certification_type;
	}


	public void setCertification_type(String certification_type) {
		this.certification_type = certification_type;
	}


	public String getValidity() {
		return validity;
	}


	public void setValidity(String validity) {
		this.validity = validity;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
