package promsys.negocio;
import java.util.List;
import promsys.exceptions.*;

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
	
	public void cadastroServidor(Servidor novo) throws ServidorJaExisteException {
		if(novo == null) {
			throw new IllegalArgumentException("Parâmetro Invalido");
		}
		else {
			if(novo.getID()==0L){
				repositorioServidores.cadastrar(novo);
				repositorioServidores.escreveArquivo();
			}else {
				throw new ServidorJaExisteException(novo.getID());
			}
		}
	}
	
	public void excluiServidor(long id) throws ServidorNaoExisteException{
		Servidor found = ServidorDAO.getInstance().procurar(id);
		if(found.equals(null)){
			throw new ServidorNaoExisteException(id);
		} else {
			ServidorDAO.getInstance().remover(found);
		}
	}
	
	public void atualizaServidor(long id, String novoLogin, String novaSenha) throws ServidorNaoExisteException {
		Servidor found = ServidorDAO.getInstance().procurar(id);
		if(found.equals(null)){
			throw new ServidorNaoExisteException(id);
		
		} else {
			found.setLogin(novoLogin);
			found.setSenha(novaSenha);
			ServidorDAO.getInstance().atualizar(found);
		}
	}
	
	public Servidor procuraServidor(long id) throws ServidorNaoExisteException{
		Servidor found = ServidorDAO.getInstance().procurar(id);
		if(found.equals(null)!=false) {
			return found;
		}else {
			throw new ServidorNaoExisteException(id);	
		}
	}
	
	public boolean fazLogin(String login, String senha){
		boolean logged = false;
		for(int i = 0; i<repositorioServidores.getNextId() && logged == false; i++){
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
