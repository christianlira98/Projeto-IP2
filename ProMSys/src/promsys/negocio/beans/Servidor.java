package promsys.negocio.beans;

public class Servidor extends Usuario {
	
	private static long nextID;
	
	private String login;
	private String senha;
	private long id;
	
	public Servidor(String n, String l, String s){
		super(n, l, s);
		this.id = nextID;
		nextID++;
	}
	
	//getters e setters

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public long getID(){
		return this.id;
	}
	
	public static long getNextID(){
		return nextID;
	}
		
}
