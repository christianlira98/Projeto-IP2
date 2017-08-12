package promsys.dao;

import promsys.negocio.beans.Servidor;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class ServidorDAO implements IServidorDAO, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3007858989186592561L;
	private static ServidorDAO instance;
	private List<Servidor> admins;
	
	private ServidorDAO(){
		admins = new ArrayList<Servidor>();
	}
	
	public static ServidorDAO getInstance(){
		if(instance == null){
			instance = new ServidorDAO();
		}
		return instance;
	}
	
	/*private static ServidorDAO lerDoArquivo() {
	 * 
	 * }
	 */
		
	
	public void cadastrar(Servidor admin){
		admins.add(admin);
	}
	
	public void remover(Servidor admin){
		admins.remove(admin);
	}
	
	public void atualizar(Servidor admin){
		//boolean result = false;
		for(int i = 0; i < admins.size(); i++){
			if(admin.getID() == admins.get(i).getID()){
				admins.remove(i);
				admins.set(i, admin);
			}
		}
		/*if(old != null){
			result = true;
		}
		*/
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
	
	public List<Servidor> listar() {
		return this.admins;
	}

}
