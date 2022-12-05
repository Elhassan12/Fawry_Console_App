import java.util.Iterator;
import java.util.Scanner;

import Admin.AdminController;
import Customer.CustomerController;
import Discount.DiscountController;
import Discount.DiscountObserver;
import Services.CancerHospital;
import Services.Donation;
import Services.EtisalatInternetPayment;
import Services.EtisalatRecharge;
import Services.Form;
import Services.InternetPayment;
import Services.Landline;
import Services.MobileRecharge;
import Services.MonthleyReceipt;
import Services.NGOs;
import Services.OrangeInternetPayment;
import Services.OrangeRecharge;
import Services.ProviderController;
import Services.QuarterReceipt;
import Services.Schools;
import Services.VodafoneInternetPayment;
import Services.VodafoneRecharge;
import Services.WeInternetPayment;
import Services.WeRecharge;

public class Main {

	
	public static void main(String[] args) {
		// Authentication authentication = new Authentication(); 
		// ------------------------------- Test Authentication ---------------------------
		CustomerController customerController = new CustomerController(); 
		customerController.addCustomer("a", "a", "1");
		customerController.addCustomer("b", "b", "2");
		//authentication.signUp();
		//authentication.signInAsCustomer();
		AdminController adminController = new AdminController(); 
		adminController.addAdmin("b", "2");  // Add admin manually 
		// authentication.signInAsAdmin();
		ProviderController providerController = new ProviderController();
		VodafoneRecharge vodafoneRecharge = new VodafoneRecharge();
		EtisalatRecharge etisalatRecharge = new EtisalatRecharge();
		OrangeRecharge orangeRecharge = new OrangeRecharge(); 
		WeRecharge weRecharge = new WeRecharge();
		VodafoneInternetPayment vodafoneInternetPayment = new VodafoneInternetPayment(); 
		EtisalatInternetPayment etisalatInternetPayment = new EtisalatInternetPayment(); 
		OrangeInternetPayment orangeInternetPayment = new OrangeInternetPayment(); 
		WeInternetPayment weInternetPayment = new WeInternetPayment(); 
		CancerHospital cancerHospital = new CancerHospital(); 
		Schools schools = new Schools(); 
		NGOs ngOs = new NGOs(); 
		MonthleyReceipt monthleyReceipt = new MonthleyReceipt(); 
		QuarterReceipt quarterReceipt = new QuarterReceipt(); 
		
	
		providerController.addProvider(vodafoneRecharge);
		providerController.addProvider(etisalatRecharge);
		providerController.addProvider(orangeRecharge);
		providerController.addProvider(weRecharge);
		providerController.addProvider(vodafoneInternetPayment);
		providerController.addProvider(etisalatInternetPayment);
		providerController.addProvider(orangeInternetPayment);
		providerController.addProvider(weInternetPayment);
		providerController.addProvider(cancerHospital);
		providerController.addProvider(schools);
		providerController.addProvider(ngOs);
		providerController.addProvider(monthleyReceipt);
		providerController.addProvider(quarterReceipt);
		MobileRecharge mobileRecharge = new MobileRecharge("mobile recharge", 10);
		InternetPayment internetPayment = new InternetPayment("internet payment", 10); 
		Landline landline = new Landline("landline", 10);
		Donation donation = new Donation("donation", 1); 
		
		DiscountController discountController = new DiscountController(); 
		DiscountObserver discountObserver = new DiscountObserver(); 
		discountObserver.subscribe(mobileRecharge);
		discountObserver.subscribe(internetPayment);
		discountObserver.subscribe(landline);
		discountObserver.subscribe(donation);
		 MainMenu mainMenu = new MainMenu();
		 
		 mainMenu.render();
		 // System.out.println(customerController.getCurrentCustomer().getUsername());
		 
		 // --------------------- Test Provider --------------
//		VodafoneRecharge vodafoneRecharge = new VodafoneRecharge(); 
		// vodafoneRecharge.getForm().render();
		// System.out.println(vodafoneRecharge.getTo());
		
		// Test List Services 

		 


	}

}
