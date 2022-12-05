package Payment;

public class CreditCard implements Payment {
	
	String description = "Credit card"; 
	private String cardNo;
	private double balance = 0; 
	
	
	public CreditCard(String cardNo, double balance) {
		this.cardNo = cardNo;
		this.balance = balance;
	}


	@Override
	public boolean pay(double amount) {
		if (this.balance >= amount) {
			balance-= amount;
			return true; 
		}
		else {
			return false;
		}
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Extra methods 
	// Validate credit card number
	// Change credit card number and balance 
	
	

}
