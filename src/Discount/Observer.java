package Discount;

import Services.Service;

public interface Observer {
	void subscribe(Service service);
	void unsubscribe(Service service);
	void notifyDiscount(String serviceName, String discountType, Discount discount);
}
