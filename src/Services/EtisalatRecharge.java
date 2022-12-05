package Services;

public class EtisalatRecharge extends Provider{
	private double amount;  
//	private Form form = new MobileRechargeForm(this);
	

	public EtisalatRecharge() {
		super("mobile recharge");
		super.setProviderName("Etisalat Recharge");
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
		if (to.charAt(2) == '1' && to.length() == 11) {
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
