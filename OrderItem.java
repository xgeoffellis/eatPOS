/*
**
** Written By: Geoff Ellis
** Date Created: 08/10/2015
** Last Modified: 08/10/2015
** Purpose: Create an Object to hold an Order Item
**
*/


public class OrderItem {

	/**
	** Instance Variables
	*/
	private int itemQty;
	private Double itemPrice;
	private String itemDescription;

	// Constructor
	public OrderItem() {}

	/**
	** Object Setters
	*/

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	** Object Getters
	*/

	public int getItemQty() {
		return this.itemQty;
	}

	public Double getItemPrice() {
		return this.itemPrice;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}
}
