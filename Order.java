/*
**
** Written By: Geoff Ellis
** Date Created: 08/10/2015
** Last Modified: 08/10/2015
** Purpose: Create an Object to hold an Order
**
*/

import java.util.ArrayList;

public class Order {

	/**
	** Instance Variables
	*/
	private int orderID;
	private int customerID;
	private String orderDate;
	private String orderType;
	private String orderStatus;
	private ArrayList<OrderItem> orderItems;


	// Constructor
	public Order() {
		orderItems = new ArrayList<OrderItem>();
	}
	

	/**
	** Object Setters
	*/

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}	

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}


	/**
	** Object Getters
	*/
	
	public Double getOrderTotal() {
		Double orderTotal = 0.0;
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem oi = orderItems.get(i);
			Double price = oi.getItemPrice();
			int qty = oi.getItemQty();

			orderTotal = orderTotal + (price*qty);
		}
		return orderTotal;
	}
	

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public String getOrderDate() {
		return this.orderDate;
	}
}
