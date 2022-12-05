package Services;

import java.util.ArrayList;

import Discount.Discount;

public class InternetPayment extends Service {
	ArrayList<Provider> internetPaymentList; 
	ProviderController providerController = new ProviderController(); 
	
	public InternetPayment(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("internet payment"); 
	}

	public ArrayList<Provider> getInternetPaymentList() {
		return super.serviceList;
	}


}
