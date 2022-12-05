
import java.util.Scanner;

import Admin.AdminController;
import Customer.CustomerController;
import Discount.DiscountController;
import Discount.DiscountObserver;
import Services.MobileRecharge;
import Services.ProviderController;
import Services.VodafoneRecharge;

public class Authentication implements GUI {
	AdminOptionsGui adminOptionsGui = new AdminOptionsGui(this); 
	
	private String username;
	private String email;
	private String password;
	private GUI context;
	private Scanner scanner = new Scanner(System.in);  
	CustomerController customerController = new CustomerController();
	AdminController adminController = new AdminController();
	
	public Authentication(GUI context) {
		this.context = context; 
	}
	
	
	public void signUp() {
		try {
			
			System.out.println("Enter Username: ");
			username = scanner.next();
			
			System.out.println("Enter Email: ");
			email = scanner.next(); 
			
			System.out.println("Enter Password: ");
			password = scanner.next(); 
			
			 boolean check = customerController.addCustomer(username, email, password);
			 
			 if (check) {
				System.out.println("SignUp Successfully");
				System.out.println("signIn");
				this.signInAsCustomer();
			 }
			 else {
				 System.out.println("Error Message: Customer already Exist! \n");
				 System.out.println("signUp Again");
				 this.signUp();
			 }
		} catch (Exception e) {
			this.signUp();
		}

		
	}
	
	public void signInAsCustomer() {
		
		System.out.println("Enter Email: ");
		email = scanner.next(); 
		
		System.out.println("Enter Password: ");
		password = scanner.next(); 
		
		 boolean check = customerController.checkSignIn(email, password); 
		 
		 if (check) {
			System.out.println("SignIn Successfully");
//			ListServicesGui listServicesGui = new ListServicesGui(this);
//			listServicesGui.render();
//			ServiceGui serviceGui = new ServiceGui(this); 
//			serviceGui.render();
			CustomerOptionsGui customerOptionsGui = new CustomerOptionsGui(this); 
			customerOptionsGui.render();
		 }
		 else {
			 System.out.println("Error Message: Inavlid \n");
			 System.out.println("signIn Again");
			 this.signInAsCustomer();
		 }
	}
	
	public void signInAsAdmin() {
		System.out.println("Enter Email: ");
		email = scanner.next(); 
		
		System.out.println("Enter Password: ");
		password = scanner.next(); 
		
		 boolean check = adminController.checkSignIn(email, password); 
		 
		 if (check) {
			System.out.println("SignIn Successfully");
			adminOptionsGui.render();
			// ------------------------- Call the next GUI Here --------------------
		 }
		 else {
			 System.out.println("Error Message: Inavlid \n");
			 System.out.println("signIn Again");
			 this.signInAsAdmin();
		 }
	}

	@Override
	public void render() {
		this.context.render();
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		
	}
}




























