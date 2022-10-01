package com.ketan.dataBase.object;

import java.util.List;

import com.ketan.bean.VendorTenderAssignedFullDetails;


public interface Vendor_Tender_DAO {
	
	public List<VendorTenderAssignedFullDetails> viewAssignedDetails(int bid_tender)throws TenderAssignedException;
}
