package Services;

import java.util.Scanner;

public class DonationForm implements Form{
	Provider provider;
	
	public DonationForm(Provider provider) {
		this.provider = provider;
	}
	@Override
	public void render() {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Donation Destination: ");
		String destination = scanner.nextLine(); 
		provider.handleRequest(destination); 
		System.out.println("Enter Amount of Donation: ");
		double amount = scanner.nextDouble(); 
		provider.submitRequest(destination, amount);
	}
	
}
