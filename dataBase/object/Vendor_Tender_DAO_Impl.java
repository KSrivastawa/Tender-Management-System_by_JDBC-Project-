package com.ketan.dataBase.object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ketan.Utility.DataBaseUtility;
import com.ketan.bean.VendorTenderAssignedFullDetails;
import com.ketan.bean.Vendor_Tender;

public class Vendor_Tender_DAO_Impl implements Vendor_Tender_DAO {
	
	@Override
	public List<VendorTenderAssignedFullDetails> viewAssignedDetails(int bid_tender) throws TenderAssignedException {
		List<VendorTenderAssignedFullDetails> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select count(bid_no) from bids group by bid_tender having bid_tender=? ");
			
			ps.setInt(1, bid_tender);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int count = rs.getInt("count(bid_no)");
				
				if(count > 2) {
					
					PreparedStatement ps1 = conn.prepareStatement("select vendor_id, offer_price from bids where offer_price = (select max(offer_price) from bids group by bid_tender having bid_tender = ?)");
					
					ps1.setInt(1, bid_tender);
					
					ResultSet rs1 = ps1.executeQuery();
					
					if(rs1.next()) {
						
						int vendorId = rs1.getInt("vendor_id");
						int offerPrice = rs1.getInt("offer_price");
						
						PreparedStatement ps2 = conn.prepareStatement("insert into vendor_tender values(?,?,?)");
						
						ps2.setInt(1, vendorId);
						ps2.setInt(2, bid_tender);
						ps2.setInt(3, offerPrice);
						
						int x = ps2.executeUpdate();
						
						if(x>0) {
							
							PreparedStatement ps3 = conn.prepareStatement("select v.id, v.vname, v.GST_no, v.edate, v.email, t.tender_Id, t.flat_type,"
									+ " t.base_price,vt.highest_offered_price, t.furniture, t.location, t.s_date, t.e_date from vendor v INNER JOIN tenders t"
									+ " INNER JOIN vendor_tender vt ON v.id = vt.id AND t.tender_Id = vt.tender_Id AND v.id = ?");
							
							ps3.setInt(1, vendorId);
							
							ResultSet rs2 = ps3.executeQuery();
							
							if(rs2.next()) {
								
								int vid = rs2.getInt("id");
								String vvname = rs2.getString("vname");
								int vgst = rs2.getInt("GST_no");
								String vedate = rs2.getString("edate");
								String vemail = rs2.getString("email");
								int tenderid = rs2.getInt("tender_Id");
								String flat = rs2.getString("flat_type");
								int bprice = rs2.getInt("base_price");
								int hop = rs2.getInt("highest_offered_price");
								String furn = rs2.getString("furniture");
								String loc = rs2.getString("location");
								String sd = rs2.getString("s_date");
								String ed = rs2.getString("e_date");
								
								VendorTenderAssignedFullDetails details = new VendorTenderAssignedFullDetails(vid, vvname, vgst, vedate, vemail, tenderid, flat, bprice, hop, furn, loc, sd, ed);
								
								list.add(details);
								
								
							}
							
							
							
						}else {
							throw new TenderAssignedException("join connection error...");
						}
						
						
						
					}else {
						throw new TenderAssignedException("technical error...");
					}
					
					
					
				}else {
					throw new TenderAssignedException("unable to assign because Vendor target not completed...");
				}
				
				
			}else {
				throw new TenderAssignedException("Unable to assign - required more number of Bids for this tender...");
			}
			
			
			
		} catch (SQLException e) {
			throw new TenderAssignedException(e.getMessage());
		}
		
		
		if(list.isEmpty())
			throw new TenderAssignedException("List is empty...");
		
		
		return list;
	}

}


 












