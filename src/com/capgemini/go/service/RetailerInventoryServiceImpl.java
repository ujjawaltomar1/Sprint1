package com.capgemini.go.service;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.go.dao.RetailerInventoryDao;
import com.capgemini.go.dao.RetailerInventoryDaoImpl;
import com.capgemini.go.dto.RetailerInventoryDTO;
public class RetailerInventoryServiceImpl implements RetailInventoryService{

	RetailerInventoryDao dao;
	ArrayList<RetailerInventoryDTO> ar;
	RetailerInventoryDTO info;
	Scanner scanner = new Scanner(System.in);
	String retailer_id,p_unique_id,p_category;
	
	@Override
	public void getSoldItemDetails() throws SQLException {
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getSoldItemDetails();
		for(RetailerInventoryDTO info1:ar) {
			
			//LocalDateTime sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime();
			//LocalDateTime receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime();
			
			
			LocalDate dispatch_TS=info1.getProductDispatchTimestamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimestamp().toLocalDateTime().toLocalDate();

			LocalDateTime dispatch_TS1=info1.getProductDispatchTimestamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimestamp().toLocalDateTime();		
			
			Duration duration=Duration.between(receive_TS1, dispatch_TS1);
            Period period=Period.between(receive_TS, dispatch_TS);		
	
            System.out.println(info1+" dispatch time = " +"Y-" +period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays()+" "+duration);
		}
	}
	
	@Override
	public void getTheItemWiseDeliveryTimeReport(String retailer_id, String p_unique_id) throws SQLException {
		RetailerInventoryDTO info=new RetailerInventoryDTO();
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getItemWiseDeliveryTimeReport(retailer_id,p_unique_id);
		for(RetailerInventoryDTO info1:ar) {
			
			LocalDate sale_TS=info1.getProductDispatchTimestamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimestamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductDispatchTimestamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimestamp().toLocalDateTime();
		
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" dispatch time = " +"Y-" +period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays()+" "+duration);
	
		}
	}
	
	@Override
	public  void getTheCategoryWiseDeliveryTimeReport(String retailer_id, String p_unique_id) throws SQLException {
		RetailerInventoryDTO info=new RetailerInventoryDTO();
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getCategoryWiseDeliveryTimeReport(retailer_id,p_unique_id);
		for(RetailerInventoryDTO info1:ar) {
			
			LocalDate sale_TS=info1.getProductDispatchTimestamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimestamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductDispatchTimestamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimestamp().toLocalDateTime();
			

			
			
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" dispatch time = " +"Y-" +period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays()+" "+duration);
		
	}
}
}
