package com.capgemini.go.dao;

import java.util.ArrayList;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.util.DataBaseUtil;

public class RetailerInventoryDaoImpl implements RetailerInventoryDao {

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	RetailerInventoryDTO info;
	ArrayList<RetailerInventoryDTO> ar;
	public RetailerInventoryDaoImpl() throws SQLException {
		connection = DataBaseUtil.myconnection();
		connection.setAutoCommit(false);
	}
	
	@Override
	public ArrayList<RetailerInventoryDTO> getSoldItemDetails() throws SQLException {
		st = connection.createStatement();
	
		rs = st.executeQuery("select * from retailinventory");
	
		ar = new ArrayList<>();
		while (rs.next()) {
		
			info = null;
		    info=new RetailerInventoryDTO();	
			info.setRetailerId(rs.getString(1));
			info.setProductCategory(rs.getString(2));
			info.setProductId(rs.getString(3));
			info.setProductUniqueId(rs.getString(4));
			info.setProductDispatchTimestamp(rs.getTimestamp(5));
			info.setProductReceiveTimestamp(rs.getTimestamp(6));
			ar.add(info);
		}
		return ar ;
	}

@Override
public ArrayList<RetailerInventoryDTO> getItemWiseDeliveryTimeReport(String retailer_id,String p_unique_id) throws SQLException {
		
		st = connection.createStatement();
		pst = connection.prepareStatement
				("select * from RetailInventory where p_unique_id=?");
		pst.setString(1,p_unique_id);
		rs = null;
		rs = pst.executeQuery();
		ar = new ArrayList<>();
		while (rs.next()) {
			info = null;
			info = new RetailerInventoryDTO();
			info.setRetailerId(rs.getString(1));
			info.setProductCategory(rs.getString(2));
			info.setProductId(rs.getString(3));
			info.setProductUniqueId(rs.getString(4));
			info.setProductDispatchTimestamp(rs.getTimestamp(5));
			info.setProductReceiveTimestamp(rs.getTimestamp(6));
			ar.add(info);
		}
		return ar ;
	}

@Override
public ArrayList<RetailerInventoryDTO> getCategoryWiseDeliveryTimeReport(String retailer_id, String p_category) throws SQLException {
	st = connection.createStatement();
	pst = connection.prepareStatement
			("select * from RetailInventory where p_category=?");
	pst.setString(1,p_category);
	rs=null;
	rs=pst.executeQuery();
	ar = new ArrayList<>();
	while (rs.next()) {
		info = null;
		info = new RetailerInventoryDTO();
		info.setRetailerId(rs.getString(1));
		info.setProductCategory(rs.getString(2));
		info.setProductId(rs.getString(3));
		info.setProductUniqueId(rs.getString(4));
		info.setProductDispatchTimestamp(rs.getTimestamp(5));
		info.setProductReceiveTimestamp(rs.getTimestamp(6));
		ar.add(info);
	}
	return ar ;
}
	
}
