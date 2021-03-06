package promsys.controller;
import java.util.List;
import promsys.exceptions.*;
import promsys.dao.ProfessorDAO;
import promsys.dao.ServidorDAO;
import promsys.negocio.beans.Servidor;

public class ServidorController {
	
	private ServidorDAO repositorioServidores;
	private static ServidorController instance;
	
	private ServidorController(){
		this.repositorioServidores = ServidorDAO.getInstance();
	}
	
	public static ServidorController getInstance(){
		if(instance == null){
			instance = new ServidorController();
		}
		return instance;
	}
	public void alteraSenha(long id, String senha) {
		this.repositorioServidores.alteraSenha(id, senha);
		repositorioServidores.escreveArquivo();
	}
	
	public void atualizaNome(long id, String nome) {
		this.repositorioServidores.atualizaNome(id, nome);
		repositorioServidores.escreveArquivo();
	}
	public void atualizaSenha(long id, String senha) {
		this.repositorioServidores.atualizaSenha(id, senha);
		repositorioServidores.escreveArquivo();
	}
	public void atualizaLogin(long id, String login) {
		this.repositorioServidores.atualizaLogin(id, login);
		repositorioServidores.escreveArquivo();
	}
	public void atualizaPergunta(long id, String pergunta) {
		this.repositorioServidores.atualizaPergunta(id, pergunta);
		repositorioServidores.escreveArquivo();
	}
	public void atualizaResposta(long id, String resposta) {
		this.repositorioServidores.atualizaResposta(id, resposta);
		repositorioServidores.escreveArquivo();
	}
	public void cadastroServidor(Servidor novo) throws ServidorJaExisteException {
		if(novo == null) {
			throw new IllegalArgumentException("Par�metro Invalido");
		}
		else {
			if(ServidorController.getInstance().procuraNome(novo.getNome())!= null) {
				throw new ServidorJaExisteException(novo.getID());
			}
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
		if(found!=null) {
			return found;
		}else {
			throw new ServidorNaoExisteException(id);	
		}
	}
	
	public Servidor procuraNome(String n)  {
		Servidor procura = ServidorDAO.getInstance().procurarNome(n);
		if(procura != null) {
			return procura;
		}else {
			return null;
		}
	}
	
	public boolean fazLogin(String login, String senha){
		boolean logged = false;
		String senhaF, loginF;
		for(int i = 0; i<repositorioServidores.getNextId() && logged == false; i++){
			Servidor foundTemp = ServidorDAO.getInstance().procurar(i);
			if(foundTemp != null) {
				senhaF = foundTemp.getSenha();
				loginF = foundTemp.getLogin();
			if(loginF.equals(login)){
				if(senhaF.equals(senha)){
					logged = true;
				}
			}
		}
		}
		return logged;
	}
	
	public List<Servidor> listar() {
		return this.repositorioServidores.listar();
	}
}
