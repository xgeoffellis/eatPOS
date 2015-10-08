/*
**
** Written By: Geoff Ellis
** Date Created: 05/10/2015
** Last Modified: 08/10/2015
** Purpose: Provide an abstraction layer for the database
**
*/

import java.sql.*;
import java.util.ArrayList;

public class Database {

	public static void main(String[] args) {}

	/**
	** Insert a Menu Item into the Database
	*/
    public static void insertNewMenuItem(String itemDesc, Double itemPrice) {
        Connection c = null;
		Statement statement = null;
		try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

  			statement = c.createStatement();
        	String sql = String.format("INSERT INTO Menu (itemDescription, itemPrice) VALUES ('%s', '%f');", itemDesc, itemPrice); 
     		statement.executeUpdate(sql);

     	} catch ( Exception e ) {
      		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      		System.exit(0);
    	}
    }

	/**
	** Insert a new customer record into the database
	*/
    public static void insertNewCustomer(String fullName, String address, String ccNumber, String ccExpiry, String phoneNumber) {
        Connection c = null;
        Statement statement = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            
            statement = c.createStatement();
            String sql = String.format("INSERT INTO Customers (fullName, address, ccNumber, ccExpiry, phoneNumber) VALUES ('%s', '%s', '%s', '%s', '%s');", fullName, address, ccNumber, ccExpiry, phoneNumber); 
            statement.executeUpdate(sql);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
  

	/**
	** Insert a new order record into the database
	*/
    public static void insertNewOrder(String orderDate, int customerID, String orderType, String orderStatus) {
        Connection c = null;
        Statement statement = null;
        try {
            
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("INSERT INTO Orders (orderDate, customerID, orderType, orderStatus) VALUES ('%s', '%s', '%s', '%s');", orderDate, customerID, orderType, orderStatus); 
            statement.executeUpdate(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

	/**
	** Insert an item to the OrderList
	*/
    public static void insertOrderListItem(int orderID, int orderItem, int orderQuantity) {
        Connection c = null;
        Statement statement = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();      
            String sql = String.format("INSERT INTO OrderList (orderID, orderItem, orderQuantity) VALUES ('%s', '%s', '%s');", orderID, orderItem, orderQuantity); 
            statement.executeUpdate(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

	/**
	** Update a customer's details in the database
	*/
    public static void updateCustomer(int customerID, String fullName, String address, String ccNumber, String ccExpiry) {
        Connection c = null;
        Statement statement = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("UPDATE Customers SET fullName = '%s', address = '%s', ccNumber = '%s', ccExpiry = '%s' WHERE customerID = '%d';", fullName, address, ccNumber, ccExpiry, customerID); 
            statement.executeUpdate(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

	/**
	** Update the menu item's details
	*/
    public static void updateMenuItem(int itemID, String itemDesc, Double itemPrice) {
        Connection c = null;
        Statement statement = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("UPDATE Menu SET itemDescription = '%s', itemPrice = '%f' WHERE itemID = '%d';", itemDesc, itemPrice, itemID); 
            statement.executeUpdate(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    /**
    ** Update the Order Status From Unpaid/Incomplete to Paid/Complete
    */ 
    public static void updateOrderStatus(int orderID, String orderStatus) {
        Connection c = null;
        Statement statement = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("UPDATE Orders SET orderStatus = '%s' WHERE orderID = '%d';", orderStatus, orderID); 
            statement.executeUpdate(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

	/**
	** Get the customers data from the database
	*/
    public static Customer getCustomer(String phoneNumber) {
        Connection c = null;
        Statement statement = null;
        Customer customer = new Customer();

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("SELECT * FROM Customers WHERE phoneNumber = '%s';", phoneNumber);
            ResultSet r = statement.executeQuery(sql);
            while ( r.next() ) {
                int customerID = r.getInt("customerID");
                String fullName = r.getString("fullName");
                String address  = r.getString("address");
                String ccNumber = r.getString("ccNumber");
                String ccExpiry = r.getString("ccExpiry");
                customer.setCustomerID(customerID);
                customer.setFullName(fullName);
                customer.setAddress(address);
                customer.setNumber(ccNumber);
                customer.setExpiry(ccExpiry);
                customer.setPhoneNumber(phoneNumber);
            }
            statement.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return customer;
    }

    /**
    ** Get a list of Menu Items
    */
    public static ArrayList<MenuItem> getMenuItems() {
        Connection c = null;
        Statement statement = null;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("SELECT * FROM Menu");
            ResultSet r = statement.executeQuery(sql);
            while ( r.next() ) {
                int itemID = r.getInt("itemID");
                String itemDescription = r.getString("itemDescription");
                Double itemPrice = r.getDouble("itemPrice");
                

                MenuItem mi = new MenuItem();
                mi.setItemID(itemID);
                mi.setItemDescription(itemDescription);
                mi.setItemPrice(itemPrice);
                menuItems.add(mi);
            }
            statement.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return menuItems;
    }

    /** 
    ** Get Order
    */
    public static Order getOrder(int orderID) {
        Connection c = null;
        Statement statement = null;

        Order order = new Order();

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("SELECT * FROM Orders LEFT OUTER JOIN OrderList ON Orders.orderID = OrderList.orderID WHERE Orders.orderID = '%s';", orderID);
            ResultSet r = statement.executeQuery(sql);

            while ( r.next() ) {
            
                String orderDate = r.getString("orderDate");
                int customerID = r.getInt("customerID");
                String orderType = r.getString("orderType");
                String orderStatus = r.getString("orderStatus");
                int orderItems = r.getInt("orderItem");
                int orderQty = r.getInt("orderQuantity");

                Statement statement2 = null;
                statement2 = c.createStatement();
                String sql2 = String.format("SELECT * FROM Menu WHERE itemID = '%s';", orderItems);
                ResultSet r2 = statement2.executeQuery(sql2);

                while ( r2.next() ) {   
                    OrderItem orderItem = new OrderItem();

                    String description = r2.getString("itemDescription");
                    Double price = r2.getDouble("itemPrice");

                    orderItem.setItemQty(orderQty);
                    orderItem.setItemPrice(price);
                    orderItem.setItemDescription(description);
                    
                    order.addOrderItem(orderItem);  
                }
                order.setOrderID(orderID);
                order.setOrderDate(orderDate);
                order.setCustomerID(customerID);
                order.setOrderType(orderType);
                order.setOrderStatus(orderStatus);
            }
            statement.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return order;
    }

    /**
    ** Get Daily Sales Totals
    */
    public static Double getDailySales(String date) {


        Connection c = null;
        Statement statement = null;

        Double dailyTotal = 0.0;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

            statement = c.createStatement();
            String sql = String.format("SELECT * FROM Orders LEFT OUTER JOIN OrderList ON Orders.orderID = OrderList.orderID WHERE Orders.orderDate = '%s';", date);
            ResultSet r = statement.executeQuery(sql);
            while ( r.next() ) {
                
                int orderItems = r.getInt("orderItem");
                int orderQty = r.getInt("orderQuantity");
                Statement statement2 = null;
                statement2 = c.createStatement();
                String sql2 = String.format("SELECT * FROM Menu WHERE itemID = '%s';", orderItems);
                ResultSet r2 = statement2.executeQuery(sql2);
                while ( r2.next() ) {

                    String description = r2.getString("itemDescription");
                    Double price = r2.getDouble("itemPrice");
                    dailyTotal = dailyTotal + (orderQty*price);
                }
            }
            statement.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return dailyTotal;
    }
}

