package Discount;

public class DiscountController {
	DiscountObserver discountObserver = new DiscountObserver(); 
	DiscountData discountData = DiscountData.getInstance(); 
	
	public void setOverallDiscount(Discount discount) {
		discountData.setOveralldiscount(discount);
	}
	
	public void setSpecificDiscount(Discount discount) {
		discountData.setSpecificdiscount(discount);
	}
	
	public Discount getOverallDiscount() {
		return discountData.getOveralldiscount(); 
	}
	
	public Discount getSpoecificDiscount() {
		return discountData.getSpecificdiscount(); 
	}
	
	public void notifyDiscount(String serviceName, String discountType, Discount discount) {
		discountObserver.notifyDiscount(serviceName, discountType, discount);
	}
}
