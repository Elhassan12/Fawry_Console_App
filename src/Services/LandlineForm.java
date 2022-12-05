package Services;

import java.util.Scanner;

public class LandlineForm implements Form{
	Provider provider;
	
	public LandlineForm(Provider provider) {
		this.provider = provider;
	}
	
	@Override
	public void render() {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Telephone number: ");
		String phoneNumber = scanner.nextLine(); 
		provider.handleRequest(phoneNumber); 
		double amount = provider.getAmount(); 
		if (provider.getProviderName() == "Monthley Receipt") {
			System.out.println("Required amount from Telephone company: " + amount);
		}
		else {
			System.out.println("Required amount from Telephone company: " + amount);
		}
		
		provider.submitRequest(phoneNumber, amount);
	}
	
	
}
