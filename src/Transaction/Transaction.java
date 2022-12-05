package Transaction;

import java.sql.Date;
import Customer.Customer;
import Services.Form;
import Services.Provider;
import Services.Service;
 

public class Transaction {
	private String status = " "; 


	private String paymentway;
	private static int transactionCount = 0;
	private int transactionID;
	Date transactionDate;
	Customer customer;
	Provider service;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public Transaction(String paymentWay, Date transactionDate, Customer customer, Provider service) {
		Transaction.transactionCount++;
		this.transactionID = Transaction.transactionCount;
		this.paymentway = paymentWay; 
		this.transactionDate = transactionDate; 
		this.customer = customer;
		this.service = service; 
		
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Provider getService() {
		return service;
	}

	public void setService(Provider service) {
		this.service = service;
	}

	public String getPaymentway() {
		return paymentway;
	}

	public void setPaymentway(String paymentway) {
		this.paymentway = paymentway;
	}
}
