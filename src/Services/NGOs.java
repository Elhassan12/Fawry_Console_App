package Services;

public class NGOs extends Provider{
	
	private double amount;  

	public NGOs() {
		super("donation");
		super.setProviderName("NGOs (Non profitable organizations)");
		super.form = new DonationForm(this); 
	}

	public double getAmount() {
		if (discount == 0) {
			return amount; 
		}
		return amount*discount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Form getForm() {
		return super.form;
	}

	public void setForm(Form form) {
		super.form = form;
	}

	@Override
	public boolean handleRequest(String to) {
		return true;
	}
	
	@Override
	public boolean handleRequestAmount(double amount) {
		if (amount <= 10000) {
			return true; 
		}
		return false;
	}

	@Override
	public void submitRequest(String to, double amount) {
		this.amount = amount; 
		this.to = to;
	}
}
