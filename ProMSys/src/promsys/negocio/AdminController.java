package promsys.negocio;
import promsys.dao.AdminDAO;
import promsys.negocio.beans.Admin;

public class AdminController {
	
	private AdminController instance;
	
	private AdminController(){
	}
	
	public AdminController getInstance(){
		if(instance == null){
			instance = new AdminController();
		}
		return instance;
	}
	
	public boolean cadastroAdmin(String login, String senha){
		Admin admin = new Admin(login, senha);
		if(AdminDAO.getInstance().findAdmin(admin.getID()).equals(null)){
			AdminDAO.getInstance().saveAdmin(admin);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean excluiAdmin(long id){
		Admin found = AdminDAO.getInstance().findAdmin(id);
		if(found.equals(null)){
			return false;
		} else {
			AdminDAO.getInstance().removeAdmin(found);
			return true;
		}
	}
	
	public boolean atualizaAdmin(long id, String novoLogin, String novaSenha){
		Admin found = AdminDAO.getInstance().findAdmin(id);
		if(found.equals(null)){
			return false;
		} else {
			found.setLogin(novoLogin);
			found.setSenha(novaSenha);
			AdminDAO.getInstance().updateAdmin(found);
			return true;
		}
	}
	
	public Admin procuraAdmin(long id){
		return AdminDAO.getInstance().findAdmin(id);
	}
	
	public boolean fazLogin(String login, String senha){
		boolean logged = false;
		for(int i = 0; i<Admin.getNextID() && logged == false; i++){
			Admin foundTemp = AdminDAO.getInstance().findAdmin(i);
			if(foundTemp.getLogin().equals(login)){
				if(foundTemp.getSenha().equals(senha)){
					logged = true;
				}
			}
		}
		return logged;
	}
}
