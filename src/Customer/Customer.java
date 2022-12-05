package Customer;

import Payment.Wallet;
import Transaction.Transaction;

public class Customer {
	static int customerCount = 0;
	private int customerID; 
	String username; 
	String email;
	String password;
	public boolean isFirst = true;
	
	private Wallet wallet;  
	
	public Customer(String email, String password, String username) {
		this.email = email; 
		this.password = password; 
		this.username = username;
		this.wallet = new Wallet();
		Customer.customerCount++; 
		this.customerID = Customer.customerCount;
	}
	

	
	public Wallet getWallet() {
		return wallet; 
	}
	
	public String getPassword() {
		return password; 
	}
	
	public String getEmail() {
		return email; 
	}

	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public boolean isFirst() {
		return isFirst;
	}


	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
