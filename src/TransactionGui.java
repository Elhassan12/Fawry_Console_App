import java.util.Scanner;

import Customer.CustomerController;

import Transaction.TransactionController;

public class TransactionGui implements GUI{
	
	CustomerController customerController = new CustomerController();  
	private GUI context;   
	Transaction transaction;
//	TransactionController transactionController = new TransactionController(); 
	
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TransactionGui(GUI context) {
		this.context = context;	  
	}
	
	public GUI getContext() {
		return context;
	}

	public void setContext(GUI context) {
		this.context = context;
	}

	@Override
	public void render() {
		System.out.println("---------------- Transaction Info: ------------------------");
		System.out.println("Transaction Date: " + transaction.getTransactionDate());
		System.out.println("Customer ID: " + transaction.getCustomer().getCustomerID());
		System.out.println("Service Category: " + transaction.getService().getCategory());
		System.out.println("Service Name: " + transaction.getService().getProviderName());
		System.out.println("To: " + transaction.getService().getTo());
		System.out.println("Amount: " + transaction.getService().getAmount());
		System.out.println("Payment Way: " + transaction.getPaymentway());
		
		int num;
		try {
			
			do {
				Scanner scanner = new Scanner(System.in); 
				System.out.println("1- Approve Rfund");
				System.out.println("2- Reject Rfund");
				System.out.println("3- Go Back");
				num = scanner.nextInt(); 
				

				if (num == 1 ) {
					customerController.approveRefund(transaction.getTransactionID()); 
					this.goBack();
				}
				
				else if (num == 2) {
					customerController.rejectRefund(transaction.getTransactionID());
					this.goBack();
				}
				
				else if (num == 3 ) {
					this.goBack(); 
				}
				
			}while (num > 3 || num == 0); 
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
