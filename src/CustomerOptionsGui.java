import java.util.Scanner;

import Customer.CustomerController;
import Payment.PaymentGUI;

public class CustomerOptionsGui implements GUI {
	private GUI context;  
	RefundController refundController = new RefundController(); 
	ListRefundRequestsGui listRefundRequestsGui = new ListRefundRequestsGui(this);
	RefundGui refundGui = new RefundGui(this); 
	CustomerController customerController = new CustomerController();
	ServiceGui serviceGui = new ServiceGui(this);
	PaymentGUI paymentGUI = new PaymentGUI(); 
	
	public CustomerOptionsGui(GUI context) {
		this.context = context;	  
	}

	@Override
	public void render() {

		try {
			Scanner scanner = new Scanner(System.in);
			int num; 
			do {
				System.out.println("1- Request Service");
				System.out.println("2- Recharge Wallet");
				System.out.println("3- Refund");
				System.out.println("4- List Refund Requests");
				System.out.println("5- Go Back");
				num = scanner.nextInt(); 
				
				if (num == 1) {
					serviceGui.render();
				}
				else if (num == 2) {
					System.out.println("Recharge Wallet");
					System.out.println("Your Wallet balance is: " + customerController.getWalletBalance());
					System.out.println("Enetr Amount: ");
					double amount = scanner.nextDouble(); 
					if (paymentGUI.payByCreditCard(amount)) {
						customerController.addFundsToWallet(amount); 
					}
					else {
						while(!paymentGUI.payByCreditCard(amount)) {
							System.out.println("Enter valid credit card!");
						}
					}
					System.out.println("Your New Wallet balance is: " + customerController.getWalletBalance());
					this.render();
				}
				
				else if (num == 3) {
					refundGui.render();
				}
				
				else if (num == 4) {
					listRefundRequestsGui.render();
				}
				
				else if (num == 5) {
					this.goBack();
				}
			}while(num > 5 || num == 0);
		} catch(Exception e) {
			System.out.println("invalid Input!");
			this.goBack();
		}
	}
	

	@Override
	public void goBack() {
		this.context.render();
	}
}
