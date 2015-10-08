/*
**
** Written By: Geoff Ellis
** Date Created: 07/10/2015
** Last Modified: 07/10/2015
** Purpose: Create an Object to store MenuItem Details
**
*/

public class MenuItem {

	/**
	** Instance Variables
	*/
	private int itemID;
	private String itemDescription;
	private Double itemPrice;

	// Constructor
	public MenuItem() {}

	/**
	** Object Setters
	*/
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	** Object Getters
	*/
	public int getItemID() {
		return itemID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}
}


