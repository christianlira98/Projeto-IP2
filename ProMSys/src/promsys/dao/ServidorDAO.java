package promsys.dao;

import promsys.negocio.beans.Servidor;

import java.io.Serializable;
import java.util.ArrayList;

public class ServidorDAO implements IServidorDAO, Serializable {
	
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
	
	public void cadastrar(Servidor admin){
		admins.add(admin);
	}
	
	public void remover(Servidor admin){
		admins.remove(admin);
	}
	
	public void atualizar(Servidor admin){
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
	}
	
	public Servidor procurar(long id){
		Servidor result = null;
		for(int i = 0; i < admins.size() && result == null; i++){
			if(admins.get(i).getID() == id){
				result = admins.get(i);
			}
		}
		return result;
	}

}
