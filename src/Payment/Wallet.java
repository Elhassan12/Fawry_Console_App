package Payment;


public class Wallet implements Payment {
	String description = "Wallet"; 
	
	public String getDescription() {
		return description;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private double balance = 1000; 
	
	@Override
	public boolean pay(double amount) {
		if (amount > balance) {
			return false; 
		}
		else {
			this.maintainBalance(amount, false); 
		}
		return true;
	}
	
	public double maintainBalance(double amount, boolean maintain) {
		if (maintain) {
			balance += amount;
		}
		else {
			balance -= amount;
		}
		return balance; 
		
	}
	
	public boolean addFunds(double amount) {
			this.maintainBalance(amount, true);
			return true;
	}

}
