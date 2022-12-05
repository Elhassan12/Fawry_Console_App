package Discount;
import java.util.ArrayList;
import Services.Service;
import Services.ServiceData;

public class DiscountObserver implements Observer {
	ArrayList<Service> servicesList;
	ServiceData serviceData = ServiceData.getInstance(); 
	
	public DiscountObserver() {
		this.servicesList = serviceData.getServiceList(); 
	}
	
	@Override
	public void subscribe(Service service) {
		servicesList.add(service); 
	}; 
	
	@Override
	public void unsubscribe(Service service) {
		servicesList.remove(service); 
	}

	@Override
	public void notifyDiscount(String serviceName, String discountType, Discount discount) {
		if (discountType.equals("overall")) {
			for(int i =0 ; i<servicesList.size() ; i++) {
				servicesList.get(i).updateDiscount(discount);
			}
		}
		else if (serviceName.equals("mobile recharge")) {
			servicesList.get(0).updateDiscount(discount);
			}
		else if (serviceName.equals("internet payment")) {
			servicesList.get(1).updateDiscount(discount);
			}
		else if (serviceName.equals("landline")) {
			servicesList.get(2).updateDiscount(discount);
			}
		else if (serviceName.equals("donation")) {
			servicesList.get(3).updateDiscount(discount);
			}
	}
	
	
	
	// Discount options
	// create discount first 
	// Observe 
	// Make controller for serviceData


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
