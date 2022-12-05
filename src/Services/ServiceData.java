package Services;

import java.util.ArrayList;


public class ServiceData {
	ArrayList<Service> serviceList = new ArrayList<>(); 
	private ServiceData () {}
	private static ServiceData serviceData = new ServiceData(); 
	
	public static ServiceData getInstance() {
		return ServiceData.serviceData;
	}
	
	public void addService(Service service) {
		serviceList.add(service); 
	}
	
	public ArrayList<Service> getServiceList() {
		return serviceList; 
	}
	
}
