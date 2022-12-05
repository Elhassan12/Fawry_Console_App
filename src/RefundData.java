import java.util.ArrayList;

public class RefundData {
	TransactionController transactionController = new TransactionController();
	ArrayList<Transaction> refundList = new ArrayList<Transaction>(); 
	ArrayList<Transaction> requestRefundList = new ArrayList<>();
	
	private static final RefundData refundData = new RefundData(); 
	private RefundData() {}
	
	public ArrayList<Transaction> getRequestRefundList() {
		return requestRefundList;
	}


	public static RefundData getInstance() {
		return RefundData.refundData; 
	}

	public ArrayList<Transaction> getRefundList() {
		return refundList;
	}

	
	public void addRefund(Transaction transaction) {
		refundList.add(transaction); 
	}
	
	
	public void addRequestRefund(int transactionID) {
		requestRefundList.add(transactionController.getTransactionList().get(transactionID)); 
	}
	
	
	
	
}
