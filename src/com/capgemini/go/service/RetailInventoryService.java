package com.capgemini.go.service;
import java.sql.SQLException;

import com.capgemini.go.dto.RetailerInventoryDTO;
public interface RetailInventoryService {

	public void getSoldItemDetails() throws SQLException;
	public void getTheItemWiseDeliveryTimeReport(String retailer_id,String p_unique_id) throws SQLException;
	public void getTheCategoryWiseDeliveryTimeReport(String retailer_id,String p_category) throws SQLException;
	
}
