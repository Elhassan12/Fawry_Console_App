import java.util.ArrayList;
import java.util.Scanner;

import Services.Provider;
import Services.ProviderController;

public class ServiceGui implements GUI {
	// ServiceGui serviceGui = new ServiceGui(this);
	SearchGui searchGui = new SearchGui(this); 
	ListServicesGui listServicesGui = new ListServicesGui(this); 
	private ProviderController providerController = new ProviderController(); 
	private GUI context; 
	
	public ServiceGui(GUI context) {
		this.context = context; 
	}
	
	@Override
	public void render() {
		try {
			Scanner scanner = new Scanner(System.in);
			int num; 
			do {
				System.out.println("Choose option: ");
				System.out.println("1- Search for Service");
				System.out.println("2- List all Services");
				System.out.println("3- Go Back");
				num = scanner.nextInt(); 
				
				if (num == 1) {
					searchGui.render();
				}
				
				else if (num == 2) {
					listServicesGui.render();
				}
				
				else if (num == 3) {
					this.goBack();
				}
			}while(num > 2 || num == 0);
		} catch (Exception e) {
			System.out.println("Invalid Input!");
			this.goBack();
		}
	}
	
	@Override
	public void goBack() {
		this.context.render(); 
	}

	
}
