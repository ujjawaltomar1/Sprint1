package com.capgemini.go.dao;
import java.util.ArrayList;
import java.sql.SQLException;

import com.capgemini.go.dto.*;
public interface RetailerInventoryDao {

public ArrayList<RetailerInventoryDTO>getSoldItemDetails() throws SQLException;
public ArrayList<RetailerInventoryDTO>getItemWiseDeliveryTimeReport(String retailer_id,String p_unique_id) throws SQLException;
public ArrayList<RetailerInventoryDTO>getCategoryWiseDeliveryTimeReport(String retailer_id,String p_category) throws SQLException;
}
