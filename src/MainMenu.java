import java.util.Scanner;

import Payment.PaymentGUI;

public class MainMenu implements GUI {
	
	public void render() {
		try {
			Scanner scanner = new Scanner(System.in);
			Authentication authentication = new Authentication(this); 
			int num; 
			
			do {
				System.out.println("Choose Option: ");
				System.out.println("1- SignUp");
				System.out.println("2- SignIn As Customer");
				System.out.println("3- SignIn As Admin");
				num = scanner.nextInt(); 
				if (num == 1 ) {
					authentication.signUp();
				}
				else if (num == 2) {
					authentication.signInAsCustomer();
					
				}
				else if (num == 3) {
					authentication.signInAsAdmin();
				}
			}while (num > 3); 
		} catch (Exception e) {
			System.out.println("Invalid Input");
			this.goBack();
		}
		
		// --------------------------------- Test Payment GUI ------------------------------
		// PaymentGUI paymentGUI = new PaymentGUI(); 
		// paymentGUI.payByCreditCard(200.5);
		// paymentGUI.payByWallet(500.96);
	}

	@Override
	public void goBack() {		
	}

}
