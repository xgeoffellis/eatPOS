/*
**
** Written By: Geoff Ellis
** Date Created: 06/10/2015
** Last Modified: 07/10/2015
** Purpose: Create an Object to store a Customer's details
**
*/

public class Customer {

	/**
	** Instance Variables
	*/
	private int customerID;
	private String fullName;
	private String address;
	private String ccNumber;
	private String ccExpiry;
	private String phoneNumber;

	// Constructor
	public Customer() {}

	/**
	** Object Setters
	*/
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public void setExpiry(String ccExpiry) {
		this.ccExpiry = ccExpiry;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	** Object Getters
	*/
	public int getCustomerID() {
		return customerID;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String getAddress() {
		return this.address;
	}

	public String getNumber() {
		return this.ccNumber;
	}

	public String getExpiry() {
		return this.ccExpiry;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
