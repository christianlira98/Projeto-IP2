package promsys.dao;

import promsys.exceptions.ServidorJaExisteException;
import promsys.exceptions.ServidorNaoExisteException;
import promsys.negocio.beans.Servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		this.admins = new ArrayList<Servidor>();
	}
	
	public static ServidorDAO getInstance(){
		if(instance == null){
			instance = new ServidorDAO();
		}
		return instance;
	}
	
	public ServidorDAO lerArquivo() {
		ServidorDAO instance = null;
		File in = new File("Servidor.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instance = (ServidorDAO) o;
		}catch(Exception e) {
			instance = new ServidorDAO();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {
					
				}
			}
		}
		return instance;
	}
		
	public void escreveArquivo() {
		if(instance == null) {
			return;
		}
		File out = new File("Servidor.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oo = null;
		
		try {
			fos = new FileOutputStream(out);
			oo = new ObjectOutputStream(fos);
			oo.writeObject(instance);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(oo != null) {
				try {
					oo.close();
				}catch(IOException e ) {
					
				}
			}
		}
		
	}
	
	public void cadastrar(Servidor admin){
		admins.add(admin);
	}
	
	public void remover(Servidor admin) throws ServidorNaoExisteException{
		//admins.remove(admin);
		boolean verifica = false;
		if(admin.getID() >=1) {
			for(int i = 0; i < this.admins.size() && !verifica; i++) {
				if(admins.get(i).getID() == admin.getID()) {
					this.admins.remove(i);
					verifica = true;
				}
			}
			if(verifica == false) {
				throw new ServidorNaoExisteException(admin.getID());
			}
		}
		else {
			throw new ServidorNaoExisteException(admin.getID());
		}
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
