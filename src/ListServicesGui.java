import java.util.ArrayList;
import java.util.Scanner;

import Customer.CustomerController;
import Payment.PaymentGUI;
import Services.Provider;
import Services.ProviderController;
import Transaction.Transaction;
import Transaction.TransactionController;

public class ListServicesGui implements GUI {
//	Transaction transaction; 
	ProviderController providerController = new ProviderController();
	CustomerController customerController = new CustomerController(); 
//	TransactionController transactionController = new TransactionController(); 
	PaymentGUI paymentGUI = new PaymentGUI(); 
	PaymentOptionsGui paymentOptionsGui; 
	private GUI context; 
	
	public ListServicesGui(GUI context) {
		this.context = context;	 
		
	}

	@Override
	public void render() {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Provider> rechargeList = providerController.getProviderList("mobile recharge");
		ArrayList<Provider> internetPaymentList = providerController.getProviderList("internet payment");
		ArrayList<Provider> landlineList = providerController.getProviderList("landline");
		ArrayList<Provider> donationList = providerController.getProviderList("donation");
		ArrayList<Provider> allProviders = providerController.getAllProviderList(); 
		
		System.out.println("Mobile Recharge");
		for (int i = 0 ; i<rechargeList.size() ; i++) {
			System.out.println(i+1 + "- " + rechargeList.get(i).getProviderName());
		}
		
		System.out.println("Internet Payment");
		for (int i = 0 ; i<internetPaymentList.size() ; i++) {
			System.out.println(i+rechargeList.size()+1 + "- " + internetPaymentList.get(i).getProviderName());
		}
		
		System.out.println("Landline");
		for (int i = 0 ; i<landlineList.size() ; i++) {
			System.out.println(i+rechargeList.size()+internetPaymentList.size()+1 + "- " + landlineList.get(i).getProviderName());
		}
		
		System.out.println("Donation");
		for (int i = 0 ; i<donationList.size() ; i++) {
			System.out.println(i+rechargeList.size()+internetPaymentList.size()+landlineList.size()+1 + "- " + donationList.get(i).getProviderName());
		}
		
		System.out.println(allProviders.size()+1 + "- " + "Go Back");
	
		
		System.out.println("choose option");
		try {
			int num2 = scanner.nextInt();  
			
			while (num2 > allProviders.size()+1 || num2 == 0) {
				
				System.out.println("Enter valid option!");
				num2 = scanner.nextInt();
			}
			
			if (num2 <= allProviders.size()) {
				allProviders.get(num2-1).getForm().render();
				double amount = allProviders.get(num2-1).getAmount();
				if (customerController.getCurrentCustomer().isFirst) {
					amount*=0.8;
					amount*= allProviders.get(num2-1).getFees();
					customerController.updateCustomerDiscount(customerController.getCurrentCustomer().getCustomerID());
				}
				paymentOptionsGui = new PaymentOptionsGui(this, amount, allProviders.get(num2-1));
				paymentOptionsGui.render();
				this.goBack();
			}
			
			if (num2 == allProviders.size()+1) {
				this.goBack();
			}
		} catch (Exception e) {
			System.out.println("Invalid Input!");
			this.goBack();
		}
		
	}

	@Override
	public void goBack() {
		this.context.render();
	}

}
