package com.capgemini.go.client;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.go.exception.RetailerException;
import com.capgemini.go.service.RetailInventoryService;
import com.capgemini.go.service.RetailerInventoryServiceImpl;

public class Client {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
	
		RetailInventoryService service = null;
		service = new RetailerInventoryServiceImpl();
			System.out.println("Select Operation");
			System.out.println("1 get all details");
			System.out.println("2.Show item wise delivery time");
			System.out.println("3.show categoey wise delivery time");

			int op = scanner.nextInt();
            String retailer_id=null;
			switch (op) {
			case 1:
				try {
					service.getSoldItemDetails();
				} catch (SQLException|RetailerException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 2:
				System.out.println("enter retailer_id,p_unique_id");
				retailer_id=scanner.next();
				boolean b=Pattern.compile("[1-9]").matcher(retailer_id).matches();
				if(b==false)
					throw new RetailerException("retailer id must be a single digit number");
				scanner.nextLine();
				String p_unique_id=scanner.nextLine();
				try {
					service.getTheItemWiseDeliveryTimeReport(retailer_id,p_unique_id);;
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("enter retailer_id,p_categoey");
				retailer_id=scanner.next();
				scanner.nextLine();
				String p_category=scanner.nextLine();
				service.getTheCategoryWiseDeliveryTimeReport(retailer_id,p_category);
			    break;
			default:
				throw new RetailerException("Please enter a valid input");
			}		
		}
	}
