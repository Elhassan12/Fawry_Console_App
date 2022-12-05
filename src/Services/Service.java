package Services;

import java.util.ArrayList;

import Discount.Discount;

public abstract class Service {
	ArrayList<Provider> serviceList;
	private String serviceName; 
	private double fees; 
	
	public Service(String serviceName, double fees) {
		this.serviceName = serviceName;
		this.fees = fees;
		this.serviceList = new ArrayList<>(); 
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public void updateDiscount(Discount discount) {
		for (int i =0 ; i<serviceList.size() ; i++) {
			serviceList.get(i).setDiscount(discount.getDiscountPrecentage());
		}
	}
	
}
