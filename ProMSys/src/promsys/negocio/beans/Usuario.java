package promsys.negocio.beans;

public class Usuario {
	private String login;
	private String senha;
	private String nome;
	
	public Usuario(String n, String usr, String psw){
		this.nome = n;
		this.login = usr;
		this.senha = psw;
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
