import java.util.Scanner;

public class RefundGui implements GUI{
	RefundController refundController = new RefundController(); 
	private GUI context;  
	
	public RefundGui(GUI context) {
		this.context = context;	  
	}
	@Override
	public void render() {
		Scanner scanner = new Scanner(System.in); 
		try {
			System.out.println("Enter Transaction ID: ");
			int transactionId = scanner.nextInt(); 
			refundController.makeRefund(transactionId);
			System.out.println("Transaction Refund Sended");
			this.goBack();
			
		} catch(Exception e) {
			System.out.println("Enter valid ID!");
			this.goBack();
		}
	}

	@Override
	public void goBack() {
		this.context.render();
	}

}
