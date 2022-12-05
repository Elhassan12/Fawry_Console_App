package Services;

public class VodafoneRecharge extends Provider{
	private double amount;  
//	private Form form = new MobileRechargeForm(this);
	

	public VodafoneRecharge() {
		super("mobile recharge");
		super.setProviderName("vodafone Recharge");
		super.form = new MobileRechargeForm(this); 
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
		if (to.charAt(2) == '0' && to.length() == 11) {
			return true; 
		}
		return false;
	}
	
	@Override
	public boolean handleRequestAmount(double amount) {
		if (amount <= 500) {
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
