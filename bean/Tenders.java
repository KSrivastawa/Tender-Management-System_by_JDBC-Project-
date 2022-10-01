package com.ketan.bean;

public class Tenders {

	private int tender_id;
	private String flat_type;
	private int base_price;
	private String furniture;
	private String location;
	private String s_date;
	private String e_date;
	
	public Tenders() {
		// TODO Auto-generated constructor stub
	}

	public Tenders(int tender_id, String flat_type, int base_price, String furniture, String location, String s_date,
			String e_date) {
		super();
		this.tender_id = tender_id;
		this.flat_type = flat_type;
		this.base_price = base_price;
		this.furniture = furniture;
		this.location = location;
		this.s_date = s_date;
		this.e_date = e_date;
	}

	public int getTender_id() {
		return tender_id;
	}

	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}

	public String getFlat_type() {
		return flat_type;
	}

	public void setFlat_type(String flat_type) {
		this.flat_type = flat_type;
	}

	public int getBase_price() {
		return base_price;
	}

	public void setBase_price(int base_price) {
		this.base_price = base_price;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}

	
	
	
	
}
