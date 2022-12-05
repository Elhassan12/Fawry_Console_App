package Payment;

import java.util.Scanner;
import Customer.CustomerController;

public class PaymentGUI {
	CustomerController customerController = new CustomerController(); 
	public boolean payByCreditCard(double amount) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Credit Card number: ");
		String cardNo = scanner.next(); 
		
		System.out.println("Enter Credit card Balance: ");
		double balance = scanner.nextDouble();
		
		CreditCard creditCard = new CreditCard(cardNo, balance); 
		if (customerController.payByCreditCard(amount, creditCard)) {
			// ----------------------------------- Save transaction here ---------------------------------------------------
			System.out.println("Successful Payment");
			return true;
		}
		else {
			System.out.println("Balance not Enough!");
			return false;
		}
	}
	
	public boolean payByWallet(double amount) {
		if (customerController.payByWallet(amount)) {
			// ----------------------------------- Save transaction here ---------------------------------------------------
			System.out.println("Successful Payment");
			System.out.println("Your Wallet Balance is: " + customerController.getWalletBalance());
			return true;
		}
		else {
			System.out.println("Wallet Balance not Enough!");
		}
		return false; 
	}
	
	public void payCash() {
		System.out.println("Recieve Money on Delivery :)");
	}
}
