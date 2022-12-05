package Services;

import java.util.ArrayList;

import Discount.Discount;

public class MobileRecharge extends Service {
	
	ArrayList<Provider> rechargeList; 
	ProviderController providerController = new ProviderController(); 

	public MobileRecharge(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("mobile recharge"); 
	}
	
	public ArrayList<Provider> getRechargeList() {
		return super.serviceList;
	}

	
	


}
