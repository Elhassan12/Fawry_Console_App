import java.util.ArrayList;
import java.util.Scanner;
import Transaction.TransactionController;

public class ListTransactinGui2 implements GUI{
	private GUI context;   
	// TransactionController transactionController; 
	RefundController refundController = new RefundController(); 
	TransactionGui transactionGui; 
	
	
	public ListTransactinGui2(GUI context) {
		this.context = context;	
		this.transactionGui = new TransactionGui(this);
	}

	@Override
	public void render() {
		ArrayList<Transaction> RequestRefundList = refundController.getRequestRefundList();
//		System.out.println(transcationList.size());
		for (int i = 0 ; i < RequestRefundList.size() ; i++) {
			System.out.println("TransactionID: " + RequestRefundList.get(i).getTransactionID());
			System.out.println(RequestRefundList.get(i).getService().getTo());
		}
		
		int num;
		try {
			if (RequestRefundList.isEmpty()) {
				System.out.println("There is no transaction for now!");
				this.goBack();
			}
			do {
				Scanner scanner = new Scanner(System.in); 
				num = scanner.nextInt(); 
				if (RequestRefundList.size() < num) {
					continue; 
				}
				this.transactionGui.setTransaction(RequestRefundList.get(num-1));
				transactionGui.render();
				
			}while (num > RequestRefundList.size() || num == 0); 
		} catch(Exception e) {
			System.out.println("Enter valid Option!");
			this.render();
		}
	}


	@Override
	public void goBack() {
		this.context.render();
	}
}

