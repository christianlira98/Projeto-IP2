package promsys.negocio;
import promsys.dao.ServidorDAO;
import promsys.negocio.beans.Servidor;

public class ServidorController {
	
	private static ServidorController instance;
	
	private ServidorController(){
	}
	
	public static ServidorController getInstance(){
		if(instance == null){
			instance = new ServidorController();
		}
		return instance;
	}
	
	public boolean cadastroServidor(String nome, String login, String senha){
		Servidor admin = new Servidor(nome, login, senha);
		if(ServidorDAO.getInstance().findServidor(admin.getID()).equals(null)){
			ServidorDAO.getInstance().saveServidor(admin);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean excluiServidor(long id){
		Servidor found = ServidorDAO.getInstance().findServidor(id);
		if(found.equals(null)){
			return false;
		} else {
			ServidorDAO.getInstance().removeServidor(found);
			return true;
		}
	}
	
	public boolean atualizaServidor(long id, String novoLogin, String novaSenha){
		Servidor found = ServidorDAO.getInstance().findServidor(id);
		if(found.equals(null)){
			return false;
		} else {
			found.setLogin(novoLogin);
			found.setSenha(novaSenha);
			ServidorDAO.getInstance().updateServidor(found);
			return true;
		}
	}
	
	public Servidor procuraServidor(long id){
		return ServidorDAO.getInstance().findServidor(id);
	}
	
	public boolean fazLogin(String login, String senha){
		boolean logged = false;
		for(int i = 0; i<Servidor.getNextID() && logged == false; i++){
			Servidor foundTemp = ServidorDAO.getInstance().findServidor(i);
			if(foundTemp.getLogin().equals(login)){
				if(foundTemp.getSenha().equals(senha)){
					logged = true;
				}
			}
		}
		return logged;
	}
}
