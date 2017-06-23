package promsys.dao;

import promsys.negocio.beans.Servidor;
import java.util.ArrayList;

public class ServidorDAO {
	
	private static ServidorDAO instance;
	private static ArrayList<Servidor> admins = new ArrayList<>();
	
	private ServidorDAO(){
	}
	
	public static ServidorDAO getInstance(){
		if(instance == null){
			instance = new ServidorDAO();
		}
		return instance;
	}
	
	public void saveServidor(Servidor admin){
		admins.add(admin);
	}
	
	public boolean removeServidor(Servidor admin){
		return admins.remove(admin);
	}
	
	public boolean updateServidor(Servidor admin){
		boolean result = false;
		Servidor old = null;
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
	
	public Servidor findServidor(long id){
		Servidor result = null;
		for(int i = 0; i < admins.size() && result == null; i++){
			if(admins.get(i).getID() == id){
				result = admins.get(i);
			}
		}
		return result;
	}

}
