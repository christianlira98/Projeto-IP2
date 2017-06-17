package promsys.dao;

import promsys.negocio.beans.Admin;
import java.util.ArrayList;

public class AdminDAO {
	
	private static AdminDAO instance;
	private static ArrayList<Admin> admins = new ArrayList<>();
	
	private AdminDAO(){
	}
	
	public AdminDAO getInstance(){
		if(instance == null){
			instance = new AdminDAO();
		}
		return instance;
	}
	
	public void saveAdmin(Admin admin){
		admins.add(admin);
	}
	
	public boolean removeAdmin(Admin admin){
		return admins.remove(admin);
	}
	
	public boolean updateAdmin(Admin admin){
		boolean result = false;
		Admin old = null;
		for(int i = 0; i < admins.size(); i++){
			if(admin.getID() == admins.get(i).getID()){
				old = admins.remove(i);
				admins.set(i, admin);
			}
		}
		if(old != null){
			result = true;
		}
		return result;
	}
	
	public Admin findAdmin(long id){
		Admin result = null;
		for(int i = 0; i < admins.size() && result == null; i++){
			if(admins.get(i).getID() == id){
				result = admins.get(i);
			}
		}
		return result;
	}

}
