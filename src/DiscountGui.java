import java.util.Scanner;

import Customer.CustomerController;
import Discount.Discount;
import Discount.DiscountController;
import Payment.PaymentGUI;

public class DiscountGui implements GUI {
	DiscountController discountController = new DiscountController() ;
	Discount discount;  
	private GUI context;  
	
	public DiscountGui(GUI context) {
		this.context = context;	  
	}
	
	@Override
	public void render() {
		try {
			String serviceName = null; 
			Scanner scanner = new Scanner(System.in);  
			System.out.println("Enter Discount Type: ");
			String type = scanner.nextLine();
			if (type.equals("specific")) {
				System.out.println("Enter Specific Service: ");
				serviceName = scanner.nextLine();
			}
			System.out.println("Enter Discount Precentage: ");
			double precentage = scanner.nextDouble();
			this.discount = new Discount(type, precentage); 
			
			if (type.equals("overall")) {
				discountController.setOverallDiscount(discount);
			}
			else if (type.equals("specific")) {
				discountController.setSpecificDiscount(discount);
			}
			
			discountController.notifyDiscount(serviceName, type, discount);
			System.out.println("Discount has been Apllied :)");
			this.goBack();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error!!");
			this.goBack();
		}
	}

	@Override
	public void goBack() {
		this.context.render();
	}
	
}
