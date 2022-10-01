package com.ketan.bean;

public class VendorTenderAssignedFullDetails {

	private int id;
	private String vname;
	private int gst_no;
	private String edate;
	private String email;
	private int tender_id;
	private String flat_type;
	private int base_price;
	private int highest_offered_price;
	private String furniture;
	private String location;
	private String s_date;
	private String e_date;
	
	public VendorTenderAssignedFullDetails() {
		// TODO Auto-generated constructor stub
	}

	public VendorTenderAssignedFullDetails(int id, String vname, int gst_no, String edate, String email, int tender_id,
			String flat_type, int base_price, int highest_offered_price, String furniture, String location,
			String s_date, String e_date) {
		super();
		this.id = id;
		this.vname = vname;
		this.gst_no = gst_no;
		this.edate = edate;
		this.email = email;
		this.tender_id = tender_id;
		this.flat_type = flat_type;
		this.base_price = base_price;
		this.highest_offered_price = highest_offered_price;
		this.furniture = furniture;
		this.location = location;
		this.s_date = s_date;
		this.e_date = e_date;
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

	public int getHighest_offered_price() {
		return highest_offered_price;
	}

	public void setHighest_offered_price(int highest_offered_price) {
		this.highest_offered_price = highest_offered_price;
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
