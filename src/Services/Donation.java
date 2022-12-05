package Services;

import java.util.ArrayList;

import Discount.Discount;

public class Donation extends Service{
	ProviderController providerController = new ProviderController();
	ArrayList<Provider> donationList;
	
	public Donation(String serviceName, double fees) {
		super(serviceName,0);
		super.serviceList = providerController.getProviderList("donation");
		
	}

	public ArrayList<Provider> getInternetPaymentList() {
		return super.serviceList;
	}

}
