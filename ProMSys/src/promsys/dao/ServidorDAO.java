package promsys.dao;

import promsys.exceptions.ServidorJaExisteException;
import promsys.exceptions.ServidorNaoExisteException;
import promsys.negocio.beans.Servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class ServidorDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3007858989186592561L;
	private static ServidorDAO instance;
	private static long nextID = 1;
	private List<Servidor> admins;
	
	private ServidorDAO(){
		this.admins = new ArrayList<Servidor>();
	}
	
	public static ServidorDAO getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}
	
	public void atualizaNome(long id, String nome) {
		for( int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getID() == id) {
				admins.get(i).setNome(nome);
			}
		}
	}
	
	public void atualizaLogin(long id, String login) {
		for( int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getID() == id) {
				admins.get(i).setLogin(login);
			}
		}
	}
	public void atualizaSenha(long id, String senha) {
		for( int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getID() == id) {
				admins.get(i).setSenha(senha);
			}
		}
	}
	
	public void atualizaPergunta(long id, String pergunta) {
			for( int i = 0; i < admins.size(); i++) {
				if(admins.get(i).getID() == id) {
					admins.get(i).setPergunta(pergunta);
				}
			}
		}
	public void atualizaResposta(long id, String resposta) {
		for( int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getID() == id) {
				admins.get(i).setResposta(resposta);
			}
		}
	}
	
	
	public void alteraSenha(long id, String senha) {
		for( int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getID() == id) {
				admins.get(i).setSenha(senha);
			}
		}
	}
	
	public static void leituraNextId () throws IOException {
		String linha = null;
		File arquivo = new File("IdServidor.dat");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		while( br.ready() ){
			linha = br.readLine();
		}
		nextID = Long.parseLong(linha);
		br.close();
		fr.close();
	}
	
	public void escreveNextId () throws IOException {
		File arquivo = new File("IdServidor.dat");
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(String.valueOf(getNextId()));
		bw.close();
		fw.close();
	}
	
	public long getNextId() {
		return nextID;
	}
	
	private static ServidorDAO lerArquivo() {
		ServidorDAO instance = null;
		File in = new File("Servidor.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instance = (ServidorDAO) o;
			leituraNextId();
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
			escreveNextId();
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
		admin.setId(nextID);
		nextID++;
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
	
	public Servidor procurarNome(String n) {
		Servidor resultado = null;
		for(int i = 0; i < admins.size() && resultado == null; i++) {
			if(admins.get(i).getNome().equals(n)) {
				resultado = admins.get(i);
			}
		}
		return resultado;
	}
	
	public List<Servidor> listar() {
		return this.admins;
	}

}
