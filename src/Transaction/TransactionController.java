package Transaction;

import java.sql.Date;
import java.util.ArrayList;

import Customer.Customer;
import Services.Provider;
import Services.Service;

public class TransactionController {
	TransactionData transactionData ;
	
	
	public TransactionController() {
		this.transactionData = TransactionData.getInstance();
	}
	
	
	public void addTransaction(Transaction transaction) {
		this.transactionData.addTransaction(transaction);
//		ArrayList<Transaction> newList = this.getTransactionList();
//		for (Transaction transaction2 : newList) {
//			System.out.println(transaction2.getService().getTo());
//		}
//		for (int  i = 0; i< this.getTransactionList().size() ; i++) {
//			System.out.println(this.getTransactionList().get(i).getService().getTo());
//		}
	}
	
	public boolean removeTransaction(Transaction transaction) {
		if (this.transactionData.getTransactionList().size() == 0) {
			return false; 
		}
		int index = this.transactionData.getTransactionList().indexOf(transaction);
		if (index == -1) {
			return false;
		}
		this.transactionData.removeTransaction(index); 
		return true;
	}
	
	public Transaction getTransaction(int transactionID) {
		if (this.transactionData.getTransactionList().size() == 0) {
			 return null;
		}
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.getTransactionList().get(i).getTransactionID() == transactionID) {
				return this.getTransactionList().get(i); 
			}
		}
		return null;
	}
	

	
	public ArrayList<Transaction> getTransactionList() {
		return transactionData.getTransactionList(); 
	}
	
	public ArrayList<Transaction> getTransactionForCustomer(int customerID) {
		ArrayList<Transaction> customerTransactions = new ArrayList<>(); 
		for (int i =0 ; i<this.getTransactionList().size() ; i++) {
			if (this.getTransactionList().get(i).getCustomer().getCustomerID() == customerID) {
				customerTransactions.add(this.getTransactionList().get(i)); 
			}
		}
		return customerTransactions; 
	}
	
	public void updateTransactionPaymentWay(int transactionID, String paymentWay) {
		transactionData.updateTransactionPaymentWay(transactionID, paymentWay);
	}
	
	public void updateTransactionService(int transactionID, Provider service) {
		transactionData.updateTransactionService(transactionID, service);
	}
	
	public void updateTransactionDate(int transactionID, Date date) {
		transactionData.updateTransactionDate(transactionID, date);
	}
	
	public void updateTransactionCustomer(int transactionID, Customer customer) {
		transactionData.updateTransactionCustomer(transactionID, customer);
	}
	
}


// Save transaction
// in GUI : 
	// Display transaction. 
	// Approve/Reject Refund => Delete transaction 


















