package com.ketan.dataBase.object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.ketan.Utility.DataBaseUtility;
import com.ketan.bean.Vendor;

public class Vendor_DAO_Impl implements Vendor_DAO {

	
	@Override
	public String adminLogin(String username, String password) {
		
		String status = "Login failed...";
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement psE = conn.prepareStatement("Select * from administrator where email =?");
			
			psE.setString(1, username);
			
			ResultSet rsE = psE.executeQuery();
			
			if(rsE.next()) {
				
				PreparedStatement ps = conn.prepareStatement("Select email from administrator where password = ?");
				
				ps.setString(1, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					String email = rs.getString("email");
					
					if(email.equals(username)) {
					
						status = "Login Successful...";
						
						
					}else {
						status = "username and password mismatch....\n";
					}
					
				}else {
					status = "password not correct according username\n";
				}
				
				
			}else {
				status = "username not found..\n";
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			status = e.getMessage();
		}
		
		
		return status;
	}

	
	
	
	@Override
	public String registerNewVendor(String name, int gst_no, String edate, String email, String password,
			int signature_id) throws RegisterNewVendorException {
		
		String status = "Not Inserted...";
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into vendor(vname,GST_no,edate,email,password,signature_id) values(?,?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setInt(2, gst_no);
			ps.setString(3, edate);
			ps.setNString(4, email);
			ps.setString(5, password);
			ps.setInt(6, signature_id);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "Registered Successfully...\n";
			else
				throw new RegisterNewVendorException("Technical error...\n");
				
			
		} catch (SQLException e) {
			status = e.getMessage();
		}
		
		
		return status;
	}

	@Override
	public List<Vendor> viewAllVendorsDetails() throws VendorDetailsExecption {
		
		List<Vendor> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from vendor");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int i = rs.getInt("id");
				String vn = rs.getString("vname");
				int gs = rs.getInt("GST_no");
				String ed = rs.getString("edate");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int si = rs.getInt("signature_id");
				
				Vendor vendor = new Vendor(i, vn, gs, ed, e, p, si);
				
				list.add(vendor);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(list.isEmpty())
			throw new VendorDetailsExecption("List Is Empty...\n");
		
		
		return list;
	}

	
	
	@Override
	public String vendorLogin(String username, String password) {
		
		String status = "Login failed...";
		
		try(Connection conn = DataBaseUtility.provideTenderConnection()) {
			
			PreparedStatement psE = conn.prepareStatement("Select * from vendor where email =?");
			
			psE.setString(1, username);
			
			ResultSet rsE = psE.executeQuery();
			
			if(rsE.next()) {
				
				PreparedStatement ps = conn.prepareStatement("Select email from vendor where password = ?");
				
				ps.setString(1, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					String email = rs.getString("email");
					
					if(email.equals(username)) {
					
						status = "Login Successful...";
						
						
					}else {
						status = "username and password mismatch....\n";
					}
					
				}else {
					status = "password not correct according username\n";
				}
				
				
			}else {
				status = "username not found..\n";
			}
			
			
			
			
			
		} catch (SQLException e) {
			status = e.getMessage();
		}
		
		
		
		return status;
	}
	

}












