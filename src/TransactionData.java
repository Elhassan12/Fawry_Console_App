

import java.sql.Date;
import java.util.ArrayList;

import Customer.Customer;
import Services.Provider;
import Services.Service;

public class TransactionData {
	ArrayList<Transaction> transactionList = new ArrayList<>(); 
	private static TransactionData transactionData = new TransactionData(); 
	private TransactionData() {}
	
	public static TransactionData getInstance() {
		return TransactionData.transactionData; 
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction); 
	}
	
	public void removeTransaction(int index) {
		transactionList.remove(index); 
	}
	
	public ArrayList<Transaction> getTransactionList() {
		return transactionList; 
	}
	
	public void updateTransactionPaymentWay(int transactionID, String paymentWay) { 
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.transactionList.get(i).getTransactionID() == transactionID) {
				this.transactionList.get(i).setPaymentway(paymentWay); 
				break;
			}
		}
	}
	
	public void updateTransactionService(int transactionID, Provider service) { 
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.transactionList.get(i).getTransactionID() == transactionID) {
				this.transactionList.get(i).setService(service);
				break;
			}
		}
	}
	
	public void updateTransactionDate(int transactionID, Date date) { 
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.transactionList.get(i).getTransactionID() == transactionID) {
				this.transactionList.get(i).setTransactionDate(date);
				break;
			}
		}
	}
	
	public void updateTransactionCustomer(int transactionID, Customer customer) { 
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.transactionList.get(i).getTransactionID() == transactionID) {
				this.transactionList.get(i).setCustomer(customer);
				break;
			}
		}
	}
	
	
	

}
