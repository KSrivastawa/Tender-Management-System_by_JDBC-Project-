package com.ketan.bean;

public class Vendor_Tender {

	private int vendor_id;
	private int tender_id;
	private int highest_offered_price;
	
	Vendor_Tender(){
		
	}

	public Vendor_Tender(int vendor_id, int tender_id, int highest_offered_price) {
		super();
		this.vendor_id = vendor_id;
		this.tender_id = tender_id;
		this.highest_offered_price = highest_offered_price;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public int getTender_id() {
		return tender_id;
	}

	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}

	public int getHighest_offered_price() {
		return highest_offered_price;
	}

	public void setHighest_offered_price(int highest_offered_price) {
		this.highest_offered_price = highest_offered_price;
	}


	
	
	
	
	
}
