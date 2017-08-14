package promsys.negocio.beans;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7136042784309587047L;
	private String login;
	private String senha;
	private String nome;
	
	//CONSTRUTOR
	public Usuario(String n, String usr, String psw){
		this.nome = n;
		this.login = usr;
		this.senha = psw;
	}

	//GETTERS AND SETTERS
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