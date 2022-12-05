import java.util.Scanner;

public class AdminOptionsGui implements GUI {
	DiscountGui discountGui = new DiscountGui(this);
	private GUI context;  
	ListTransactinGui2 listTransactinGui2; 
	
	public AdminOptionsGui(GUI context) {
		this.context = context;	  
	}
	
	
	@Override
	public void render() {

		try {
			Scanner scanner = new Scanner(System.in);
			int num;
			do {
				System.out.println("1- Apply Discount");
				System.out.println("2- List Refund Requests");
				System.out.println("3- Go Back");
				num = scanner.nextInt();
				if (num == 1) {
					discountGui.render();
					this.goBack();
				}
				
				else if (num == 2) {
					this.listTransactinGui2 = new ListTransactinGui2(context); 
					listTransactinGui2.render();
				}
				
				else if(num == 3) {
					this.goBack();
				}
			}while (num > 3 || num <= 0 ); 
		} catch (Exception e ) {
			System.out.println("Invalid Input!");
			this.goBack();
		}

		
		
	}

	@Override
	public void goBack() {
		this.context.render();
	}
	

}
