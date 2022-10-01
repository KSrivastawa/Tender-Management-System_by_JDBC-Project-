package com.ketan.bean;

public class Bids {

	private int bid_no;                      
	private int offerPrice;              
	private int bid_tender;
	private int bid_vendor;
	private String status;
	
	public Bids() {
		// TODO Auto-generated constructor stub
	}

	public Bids(int bid_no, int offerPrice, int bid_tender, int bid_vendor, String status) {
		super();
		this.bid_no = bid_no;
		this.offerPrice = offerPrice;
		this.bid_tender = bid_tender;
		this.bid_vendor = bid_vendor;
		this.status = status;
	}

	
	public int getBid_no() {
		return bid_no;
	}

	public void setBid_no(int bid_no) {
		this.bid_no = bid_no;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}

	public int getBid_tender() {
		return bid_tender;
	}

	public void setBid_tender(int bid_tender) {
		this.bid_tender = bid_tender;
	}

	public int getBid_vendor() {
		return bid_vendor;
	}

	public void setBid_vendor(int bid_vendor) {
		this.bid_vendor = bid_vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
}
