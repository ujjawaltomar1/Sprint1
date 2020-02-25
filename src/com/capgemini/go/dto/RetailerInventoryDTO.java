package com.capgemini.go.dto;
import java.sql.Timestamp;
import java.util.*;
import java.sql.*;

public class RetailerInventoryDTO {
String retailerId;
String productCategory;
String productId;
String productUniqueId;
Timestamp productDispatchTimestamp;
Timestamp productReceiveTimestamp;
public RetailerInventoryDTO(String retailerId, String productCategory, String productId, String productUniqueId,
		Timestamp productDispatchTimestamp, Timestamp productReceiveTimestamp, Timestamp productSaleTimestamp) {
	super();
	this.retailerId = retailerId;
	this.productCategory = productCategory;
	this.productId = productId;
	this.productUniqueId = productUniqueId;
	this.productDispatchTimestamp = productDispatchTimestamp;
	this.productReceiveTimestamp = productReceiveTimestamp;
}

public RetailerInventoryDTO() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "RetailerInventoryDTO [retailerId=" + retailerId + ", productCategory=" + productCategory + ", productId="
			+ productId + ", productUniqueId=" + productUniqueId + ", productDispatchTimestamp="
			+ productDispatchTimestamp + ", productReceiveTimestamp=" + productReceiveTimestamp + "]";
}


public String getRetailerId() {
	return retailerId;
}

public void setRetailerId(String retailerId) {
	this.retailerId = retailerId;
}

public String getProductCategory() {
	return productCategory;
}

public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

public String getProductId() {
	return productId;
}

public void setProductId(String productId) {
	this.productId = productId;
}

public String getProductUniqueId() {
	return productUniqueId;
}

public void setProductUniqueId(String productUniqueId) {
	this.productUniqueId = productUniqueId;
}

public Timestamp getProductDispatchTimestamp() {
	return productDispatchTimestamp;
}

public void setProductDispatchTimestamp(Timestamp timestamp) {
	this.productDispatchTimestamp = timestamp;
}

public Timestamp getProductReceiveTimestamp() {
	return productReceiveTimestamp;
}

public void setProductReceiveTimestamp(Timestamp timestamp)
{
	this.productReceiveTimestamp=timestamp;
}
}
