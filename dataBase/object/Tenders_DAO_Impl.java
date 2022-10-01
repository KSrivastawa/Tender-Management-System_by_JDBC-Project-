package com.ketan.dataBase.object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ketan.Utility.DataBaseUtility;
import com.ketan.bean.Tenders;

public class Tenders_DAO_Impl implements Tenders_DAO {

	@Override
	public String registerTenders(int tender_id, String flat_type, int base_price, String furniture, String location, String s_date,
			String e_date) throws TendersDetailsException {
		
		String status = "Not Inserted ...";
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into tenders values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, tender_id);
			ps.setString(2, flat_type);
			ps.setInt(3, base_price);
			ps.setString(4, furniture);
			ps.setString(5, location);
			ps.setString(6, s_date);
			ps.setString(7, e_date);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "Registered Successfully...\n";
			else {
				throw new TendersDetailsException("Technical error...\n");			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return status;
	}

	
	
	@Override
	public List<Tenders> viewAllTendersDetails() throws TendersDetailsException {
		List<Tenders> list = new ArrayList<>(); 
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from tenders");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ti = rs.getInt("tender_Id");
				String ft = rs.getString("flat_type");
				int bp = rs.getInt("base_price");
				String fr = rs.getString("furniture");
				String lc = rs.getString("location");
				String sd = rs.getString("s_date");
				String ed = rs.getString("e_date");
				
				Tenders tenders = new Tenders(ti, ft, bp, fr, lc, sd, ed);
				
				list.add(tenders);
				
				
			}
			
			
		} catch (SQLException e) {
			throw new TendersDetailsException("Technical error...\n");
		}
		
		if(list.isEmpty())
			throw new TendersDetailsException("List is Empty...\n");
		
		
		return list;
	}

	
	
}
