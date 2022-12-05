import java.util.ArrayList;
import java.util.Scanner;

import Customer.CustomerController;
import Transaction.Transaction;

public class ListRefundRequestsGui implements GUI{
	private GUI context;  
	
	public ListRefundRequestsGui(GUI context) {
		this.context = context;	  
	}
	customerRefundRequestGui customerRefundRequestGui = new customerRefundRequestGui(this); 
	CustomerController customerController = new CustomerController(); 
	@Override
	public void render() {
		ArrayList<Transaction> customerRefundList = customerController.getCustomerRefundList(); 
		for (int i = 0 ; i < customerRefundList.size() ; i++) {
			if (customerRefundList.get(i).getCustomer().getCustomerID() == customerController.getCurrentCustomer().getCustomerID()) {
				System.out.println("TransactionID: " + customerRefundList.get(i).getTransactionID());
			}
		}
		
		int num;
		try {
			if (customerRefundList.isEmpty()) {
				System.out.println("There is no transaction for now!");
				this.goBack();
			}
			do {
				Scanner scanner = new Scanner(System.in); 
				num = scanner.nextInt(); 
				if (customerRefundList.size() < num) {
					continue; 
				}
				System.out.println(customerRefundList.get(0).getService().getTo());
				this.customerRefundRequestGui.setTransaction(customerRefundList.get(num-1));
				customerRefundRequestGui.render();
				
			}while (num > customerRefundList.size() || num == 0); 
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
