import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Customer.CustomerController;
import Payment.PaymentGUI;
import Services.Provider;
import Services.ProviderController;
import Transaction.Transaction;
import Transaction.TransactionController;

public class SearchGui implements GUI{
	CustomerController customerController = new CustomerController(); 
	PaymentGUI paymentGUI = new PaymentGUI();
//	Transaction transaction; 
//	TransactionController transactionController = new TransactionController(); 
	PaymentOptionsGui paymentOptionsGui;
	ProviderController providerController = new ProviderController();
	private GUI context; 
	String[] serviceListNames = {"mobile recharge", "internet payment", "landline", "donation"};   
	
	public SearchGui(GUI context) {
		this.context = context;	 
	}
	
	@Override
	public void render() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Search for Service");
			String service = scanner.nextLine(); 
			while (!this.checkInput(service)) {
				System.out.println("Enter valid service name!");
				service = scanner.nextLine(); 
			}
			System.out.println(service);
			ArrayList<Provider> serviceList = new ArrayList<>();
			if (service.equals(serviceListNames[0])) {
				serviceList = providerController.getProviderList("mobile recharge");
			}
			else if (service.equals(serviceListNames[1])) {
				serviceList = providerController.getProviderList("internet payment");
			}
			else if (service.equals(serviceListNames[2])) {
				serviceList = providerController.getProviderList("landline");
			}
			else if (service.equals(serviceListNames[3])) {
				serviceList = providerController.getProviderList("donation");
			}
			
//			ArrayList<Provider> newList = providerController.getProviderList(service);
//			System.out.println(newList.size());
			
			for (int i = 0 ; i<serviceList.size() ; i++) {
				System.out.println(i+1 + "- " + serviceList.get(i).getProviderName());
			}
			System.out.println(serviceList.size()+1 + "- " + "Go Back");
			
		    int num2 = scanner.nextInt();
		    
			while (num2 > serviceList.size()+1 || num2 == 0) {
				
				System.out.println("Enter valid option!");
				num2 = scanner.nextInt();
			}
			
			if (num2 <= serviceList.size()) {
				serviceList.get(num2-1).getForm().render();
				double amount = serviceList.get(num2-1).getAmount();
				if (customerController.getCurrentCustomer().isFirst) {
					amount*=0.8;
					amount*= serviceList.get(num2-1).getFees();
					customerController.updateCustomerDiscount(customerController.getCurrentCustomer().getCustomerID());
				}
				paymentOptionsGui = new PaymentOptionsGui(this, amount, serviceList.get(num2-1));
				paymentOptionsGui.render();
				this.goBack();
			}
			
			if (num2 == serviceList.size()+1) {
				this.goBack();
			}
		} catch(Exception e) {
			System.out.println("Invalid Input");
			this.goBack();
		}
		
	}

	@Override
	public void goBack() {
		this.context.render();		
	}
	
	public boolean checkInput(String service) {
		for (int i = 0 ; i<this.serviceListNames.length ; i++) {
			if (service.equals(this.serviceListNames[i])) {
				return true;
			}
		}
		return false; 
	}

}
