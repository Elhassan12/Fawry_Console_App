package Services;

import java.util.Scanner;

public class MobileRechargeForm implements Form {
	Provider provider; 

	public MobileRechargeForm(Provider provider) {
		this.provider = provider;
	}
	

	@Override
	public void render() {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enetr number: ");
		String number = scanner.next();
		
		System.out.println("Enetr Amount: ");
		double amount = scanner.nextDouble();
		
//		while (!provider.handleRequest(number)) {
//			System.out.println("Enetr valid number!: ");
//			number = scanner.next();
//		}
		while (!provider.handleRequestAmount(amount)) {
			System.out.println("Error Message: Amount must be less than 500");
			System.out.println("Enter valid Amount: ");
			amount = scanner.nextDouble();
		}

		provider.submitRequest(number, amount);
	}
	

}
