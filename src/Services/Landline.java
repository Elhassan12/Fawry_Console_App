package Services;

import java.util.ArrayList;

import Discount.Discount;

public class Landline extends Service {
	ArrayList<Provider> landlineList;
	ProviderController providerController = new ProviderController();

	public Landline(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("landline");
	}

	public ArrayList<Provider> getLandlineList() {
		return super.serviceList;
	}
	

	

}
