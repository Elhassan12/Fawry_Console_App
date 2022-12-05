package Customer;
import java.util.ArrayList;

import Payment.CreditCard;
import Transaction.Transaction;

public class CustomerController {
	
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	private static Customer currentCustomer; 
	
	CustomerData customerData; 
	public CustomerController() {
		customerData = CustomerData.getInstance(); 
	}
	
	public ArrayList<Transaction> getCustomerRefundList() {
		return this.customerData.customerRefundList;
	}
	
	public void addCustomerRefund(Transaction transaction) {
		this.customerData.addCustomerRefund(transaction); 
	}
	
	public boolean addCustomer(String username, String email, String password) {
		ArrayList<Customer> customerList = customerData.getCustomer(); 
		
		for (Customer customer : customerList) {
			if (customer.email.equals(email)) {
				return false;
			}
		}
		
		Customer customer = new Customer(email, password, username);
		customerData.addCustomer(customer);
		// customerData.setCurrentCustomer(customer);
		return true;
	}
	
	public ArrayList<Customer> getCustomer() {
		customerList = customerData.getCustomer(); 
		return customerList; 
	}
	
	public void setCurrentCustomer(Customer currentCustomer) {
		 customerData.setCurrentCustomer(currentCustomer);
	}
	
	public Customer getCurrentCustomer() {
		return customerData.getCurrentCustmer(); 
	}
	
	public boolean checkSignIn(String email, String password) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList = this.getCustomer();
		for (Customer customer : customerList) {
			if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
				customerData.setCurrentCustomer(customer);
				return true; 
			}
		}
		return false; 
	}
	
	public double getWalletBalance() {
		return customerData.getCurrentCustmer().getWallet().getBalance(); 
	}
	
	public boolean addFundsToWallet(double amount) {
		return customerData.getCurrentCustmer().getWallet().addFunds(amount);
	}
	
	public boolean payByWallet(double amount) {
		return customerData.getCurrentCustmer().getWallet().pay(amount);
	}
	
	public boolean payByCreditCard(double amount, CreditCard creditCard) {
		return creditCard.pay(amount);
	}
	
	public void updateCustomer(int customerID, double amount) {
		this.customerData.updateCustomer(customerID, amount);
	}
	
	public void approveRefund(int transactionID) {
		customerData.approveRefund(transactionID);
	}
	
	public void rejectRefund(int transactionID) {
		customerData.rejectRefund(transactionID);
	}
	
	public void updateCustomerDiscount(int customerID) {
		customerData.updateCustomerDiscount(customerID);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
