package Customer;
import java.util.ArrayList;

import Transaction.Transaction;

public class CustomerData {
	private static Customer currentCustomer;
	ArrayList<Transaction> customerRefundList = new ArrayList<Transaction>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	private static CustomerData customerData = new CustomerData(); 
	private CustomerData() {}
	
	public void addCustomerRefund(Transaction transaction) {
		transaction.setStatus("Waiting...");
		customerRefundList.add(transaction); 
	}
	
	public ArrayList<Customer> getCustomer() {
		return customerList; 
	}
	
	public static CustomerData getInstance() {
		return customerData; 
	}
	
	public ArrayList<Transaction> getCustomerRefundList() {
		return customerRefundList;
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer); 
	}
	
	public void setCurrentCustomer(Customer currentCustomer) {
		CustomerData.currentCustomer = currentCustomer; 
	}
	
	public Customer getCurrentCustmer() {
		return CustomerData.currentCustomer ; 
	}
	
	public void updateCustomer(int customerID, double amount) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				customer.getWallet().setBalance(customer.getWallet().getBalance() + amount);
			}
		}
	}
	
	public void approveRefund(int transactionID) {
		for (var transaction: customerRefundList) {
			if (transaction.getTransactionID() == transactionID) {
				transaction.setStatus("Approved");
			}
		}
	}
	
	public void rejectRefund(int transactionID) {
		for (var transaction: customerRefundList) {
			if (transaction.getTransactionID() == transactionID) {
				transaction.setStatus("Rejected :(");
			}
		}
	}
	
	public void updateCustomerDiscount(int customerID) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				customer.setFirst(false);
			}
		}
	}
	
	
}
