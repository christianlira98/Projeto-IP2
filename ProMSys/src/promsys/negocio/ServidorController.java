package promsys.negocio;
import java.util.List;

import promsys.dao.ServidorDAO;
import promsys.negocio.beans.Servidor;

public class ServidorController {
	
	private ServidorDAO repositorioServidores;
	private static ServidorController instance;
	
	private ServidorController(){
	}
	
	public static ServidorController getInstance(){
		if(instance == null){
			instance = new ServidorController();
		}
		return instance;
	}
	
	public void cadastroServidor(Servidor novo) {
		if(novo == null) {
			throw new IllegalArgumentException("Parâmetro Invalido");
		}
		else {
			repositorioServidores.cadastrar(novo);
		}
	}
	
	public boolean excluiServidor(long id){
		Servidor found = ServidorDAO.getInstance().procurar(id);
		if(found.equals(null)){
			return false;
		} else {
			ServidorDAO.getInstance().remover(found);
			return true;
		}
	}
	
	public boolean atualizaServidor(long id, String novoLogin, String novaSenha){
		Servidor found = ServidorDAO.getInstance().procurar(id);
		if(found.equals(null)){
			return false;
		} else {
			found.setLogin(novoLogin);
			found.setSenha(novaSenha);
			ServidorDAO.getInstance().atualizar(found);
			return true;
		}
	}
	
	public Servidor procuraServidor(long id){
		return ServidorDAO.getInstance().procurar(id);
	}
	
	public boolean fazLogin(String login, String senha){
		boolean logged = false;
		for(int i = 0; i<Servidor.getNextID() && logged == false; i++){
			Servidor foundTemp = ServidorDAO.getInstance().procurar(i);
			if(foundTemp.getLogin().equals(login)){
				if(foundTemp.getSenha().equals(senha)){
					logged = true;
				}
			}
		}
		return logged;
	}
	
	public List<Servidor> listar() {
		return this.repositorioServidores.listar();
	}
}
