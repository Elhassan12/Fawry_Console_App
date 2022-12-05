package Admin;

import java.util.ArrayList;


public class AdminData {
	 
	ArrayList<Admin> AdminList = new ArrayList<Admin>();

	private static AdminData adminData = new AdminData(); 
	private AdminData() {}
	
	public ArrayList<Admin> getAdmin() {
		return AdminList; 
	}
	
	public static AdminData getInstance() {
		return adminData; 
	}
	
	public void addAdmin(Admin admin) {
		AdminList.add(admin); 
	}





	
	

}
