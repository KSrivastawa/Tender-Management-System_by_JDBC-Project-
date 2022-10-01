package com.ketan.dataBase.object;

import java.util.List;

import com.ketan.bean.Bids;

public interface Bids_DAO {

	public String bidAgainstTender(int offerPrice, int bid_tender, int bid_vendor, String status)throws BidInsertException;
	
	public List<Bids> viewAllBidsOf_A_Tender(int bid_tender)throws BidDetailsException;
	
	public List<Bids> viewAllBidsByBid_No_Tender(int bid_no, int bid_tender)throws BidDetailsException;
	
	public List<Bids> ViewOwnBidHistory(int v_id)throws BidDetailsException;
	
	
}
