package com.ketan.dataBase.object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ketan.Utility.DataBaseUtility;
import com.ketan.bean.Bids;

public class Bids_DAO_Impl implements Bids_DAO {

	@Override
	public String bidAgainstTender(int offerPrice, int bid_tender, int bid_vendor, String bid_status)
			throws BidInsertException {
		
		String status = "Not Inserted";
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select count(bid_no) from bids group by bid_tender having bid_tender = ?");
			
			ps.setInt(1, bid_tender);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int count  = rs.getInt("count(bid_no)");
				
				if(count < 3) {
					
					PreparedStatement ps2 = conn.prepareStatement("insert into bids(offer_price, bid_tender, vendor_id, status_of_bid) "
							+ "values(?,?,?,?)");
					
					ps2.setInt(1, offerPrice);
					ps2.setInt(2, bid_tender);
					ps2.setInt(3, bid_vendor);
					ps2.setString(4, bid_status);
					
					int x = ps2.executeUpdate();
					
					if(x>0)
						status = "Bid placed against tender successfully...\n";
					else
						throw new BidInsertException("Technical error...\n"+status);
					
				}else {
					throw new BidInsertException("Bid limit Exceeded...\n"+status);
				}
				
				
			}else {
				throw new BidInsertException("Bid data error...\n"+status);
			}
			
			
		} catch (SQLException e) {
			throw new BidInsertException(e.getMessage());
		}
		
		
		return status;
	}


	
	
	
	@Override
	public List<Bids> viewAllBidsOf_A_Tender(int bid_tender) throws BidDetailsException {
		
		List<Bids> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from bids where bid_tender = ?");
			
			ps.setInt(1, bid_tender);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int bi = rs.getInt("bid_no");
				int p = rs.getInt("offer_price");
				int bt = rs.getInt("bid_tender");
				int vi = rs.getInt("vendor_id");
				String st = rs.getString("status_of_bid");
				
				Bids bids = new Bids(bi, p, bt, vi, st);
				
				list.add(bids);
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(list.isEmpty())
			throw new BidDetailsException("List is empty...");
		
		
		return list;
	}

	@Override
	public List<Bids> viewAllBidsByBid_No_Tender(int bid_no, int bid_tender) throws BidDetailsException {
		
		List<Bids> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement psc = conn.prepareStatement("select count(bid_no) from bids group by bid_tender having bid_tender=?");
			psc.setInt(1, bid_tender);
			
			ResultSet rsc = psc.executeQuery();
			if(rsc.next()) {
				
				int count = rsc.getInt("count(bid_no)");
				
				if(count > 2) {
					
					
					PreparedStatement ps1 = conn.prepareStatement("select bid_no from bids where offer_price = (select max(offer_price) from bids group by bid_tender having bid_tender = ?)");
					
					ps1.setInt(1, bid_tender);
					
					ResultSet rs1 = ps1.executeQuery();
					
					if(rs1.next()) {
						
						int bn = rs1.getInt("bid_no");
							
							if(bn == bid_no) {
								
								PreparedStatement psu = conn.prepareStatement("update bids set status_of_bid = 'Selected' where bid_no =?");
								
								psu.setInt(1, bid_no);
								
								int x = psu.executeUpdate();
								
								if(x>0) {
									PreparedStatement psf = conn.prepareStatement("select * from bids where bid_no =?");
									
									psf.setInt(1, bid_no);
									
									ResultSet rs3 = psf.executeQuery();
									
									if(rs3.next()) {
										
										int bi = rs3.getInt("bid_no");
										int p = rs3.getInt("offer_price");
										int bt = rs3.getInt("bid_tender");
										int vi = rs3.getInt("vendor_id");
										String st = rs3.getString("status_of_bid");
										
										Bids bids = new Bids(bi, p, bt, vi, st);
										
										list.add(bids);
										
									}
									
								}
							}else {
								PreparedStatement psf = conn.prepareStatement("select * from bids where bid_no =?");
								
								psf.setInt(1, bid_no);
								
								ResultSet rs2 = psf.executeQuery();
								
								if(rs2.next()) {
									
									int bi = rs2.getInt("bid_no");
									int p = rs2.getInt("offer_price");
									int bt = rs2.getInt("bid_tender");
									int vi = rs2.getInt("vendor_id");
									String st = rs2.getString("status_of_bid");
									
									Bids bids = new Bids(bi, p, bt, vi, st);
									
									list.add(bids);
									
								}
							}
							
						
					}
					
					
				}
				else {
					throw new BidDetailsException("Pending...");
				}
				
			}
			
		
			
			
		} catch (SQLException e) {
			throw new BidDetailsException(e.getMessage());
		}
		
		if(list.isEmpty())
			throw new BidDetailsException("No Bid record found...");
		
		return list;
	}

	@Override
	public List<Bids> ViewOwnBidHistory(int v_id) throws BidDetailsException {
		List<Bids> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement psl = conn.prepareStatement("select * from bids where vendor_id = ?");
			
			psl.setInt(1, v_id);
			
			ResultSet rsl = psl.executeQuery();
			
			while(rsl.next()) {
				
				int bi = rsl.getInt("bid_no");
				int p = rsl.getInt("offer_price");
				int bt = rsl.getInt("bid_tender");
				int vi = rsl.getInt("vendor_id");
				String st = rsl.getString("status_of_bid");
				
				Bids bids = new Bids(bi, p, bt, vi, st);
				
				list.add(bids);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		if(list.isEmpty())
			throw new BidDetailsException("List is empty...");
		
		
		return list;
	}




	
	
	
}














