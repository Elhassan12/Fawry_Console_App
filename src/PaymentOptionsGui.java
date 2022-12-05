import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import Customer.CustomerController;
import Payment.PaymentGUI;
import Services.Provider;
import Transaction.Transaction;
import Transaction.TransactionController;


public class PaymentOptionsGui implements GUI {
	private double amount; 
	Transaction transaction; 
	Provider provider; 
	CustomerController customerController= new CustomerController();
	TransactionController transactionController= new TransactionController(); 
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	PaymentGUI paymentGUI = new PaymentGUI(); 
	private GUI context; 
	
	public PaymentOptionsGui(GUI context, double amount, Provider provider) {
		this.context = context;	  
		this.amount = amount;
		this.provider = provider; 
	}
	String s;
	@Override
	public void render() {
		 
		try {
			int num; 
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("1- Pay By Credit card");
				System.out.println("2- Pay By Wallet");
				System.out.println("3- Cash On Deliver");
				System.out.println("4- Go Back");
				num = scanner.nextInt();
				
				if (num == 1) {
					if (paymentGUI.payByCreditCard(amount)) {
						s = "Credit Card";
//						transaction = new Transaction("Credit Card", Date.valueOf(LocalDate.now()), customerController.getCurrentCustomer(), this.provider);
//						transactionController.addTransaction(transaction);
//						this.transactionController.updateTransactionPaymentWay(this.transaction.getTransactionID(), "Credit Card");
//						this.transactionController.updateTransactionDate(this.transaction.getTransactionID(), Date.valueOf(LocalDate.now()));
					}
				}
				
				else if (num == 2) {
					if (paymentGUI.payByWallet(amount)) {
						s = "Wallet"; 
//						transaction = new Transaction("Wallet", Date.valueOf(LocalDate.now()), customerController.getCurrentCustomer(), this.provider);
//						System.out.println("Transactio ID: " + transaction.getTransactionID());
						// System.out.println("Transaction List size: " + transactionController.getTransactionList().size());
//						transactionController.addTransaction(transaction);
//						this.transactionController.updateTransactionPaymentWay(this.transaction.getTransactionID(), "Wallet");
//						this.transactionController.updateTransactionDate(this.transaction.getTransactionID(), Date.valueOf(LocalDate.now()));
					}
				}
				
				else if (num == 3) {
					paymentGUI.payCash();
					s = "Cash"; 
//					transaction = new Transaction("Cash", Date.valueOf(LocalDate.now()), customerController.getCurrentCustomer(), this.provider);
//					transactionController.addTransaction(transaction);
//					this.transactionController.updateTransactionPaymentWay(this.transaction.getTransactionID(), "Cash");
//					this.transactionController.updateTransactionDate(this.transaction.getTransactionID(), Date.valueOf(LocalDate.now()));
				}
				
				else if (num == 4 ) {
					this.goBack();
				}
			}while (num > 4 || num <= 0);
			if (s.isEmpty()) {
				s = " "; 
			}	
			transaction = new Transaction(s, Date.valueOf(LocalDate.now()), customerController.getCurrentCustomer(), this.provider);
			transactionController.addTransaction(transaction);
			// TransactionGui transactionGui = new TransactionGui(context); 
			// transactionGui.render();
		} catch (Exception e) {
			System.out.println("Error!");
			this.goBack();
		}
	}

	@Override
	public void goBack() {
		this.context.render();
	}
	

}
