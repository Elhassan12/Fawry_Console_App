package Admin;
import java.util.ArrayList;

public class AdminController {
	AdminData adminData; 
	ArrayList<Admin> AdminList = new ArrayList<Admin>();
	
	public AdminController() {
		adminData = AdminData.getInstance(); 
	}
	
	public boolean addAdmin(String email, String password) {
		ArrayList<Admin> adminList = adminData.getAdmin();
		
		for (Admin admin : adminList) {
			if (admin.getEmail().equals(email)) {
				return false;
			}
		}
		
		Admin admin= new Admin(email, password);
		adminData.addAdmin(admin);
		return true;
	}
	
	public ArrayList<Admin> getAdmin() {
		AdminList = adminData.getAdmin(); 
		return AdminList; 
	}
	
	public boolean checkSignIn(String email, String password) {
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		adminList = this.getAdmin();
		for (Admin admin : adminList) {
			if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				return true; 
			}
		}
		return false; 
	}

}
