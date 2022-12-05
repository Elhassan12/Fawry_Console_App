import java.util.ArrayList;

import Customer.CustomerController;
import Customer.CustomerData;

public class RefundController {
	private RefundData refundData = RefundData.getInstance(); 
	CustomerController customerController = new CustomerController(); 
	TransactionController transactionController = new TransactionController(); 
	CustomerData customerData = CustomerData.getInstance(); 
	
	public RefundController() {}
	
	public void addRefund(Transaction transaction) {
		customerController.updateCustomer(transaction.getCustomer().getCustomerID(), transaction.getService().getAmount());
		transactionController.removeTransaction(transaction); 
		this.refundData.addRefund(transaction);
	}
	
	public void makeRefund(int transactionID) {
		refundData.addRequestRefund(transactionID);
	}
	
	public ArrayList<Transaction> getRequestRefundList() {
		return this.refundData.getRequestRefundList();
	}
}
