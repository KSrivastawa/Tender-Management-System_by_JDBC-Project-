package com.ketan.dataBase.object;

import java.util.List;

import com.ketan.bean.Vendor;

public interface Vendor_DAO {
	

	public String adminLogin(String username, String password);
	
	public String registerNewVendor(String name, int gst_no, String edate, String email, String password, int signature_id)throws RegisterNewVendorException;

	public List<Vendor> viewAllVendorsDetails() throws VendorDetailsExecption;
	
	public String vendorLogin(String username, String password);
	

}
