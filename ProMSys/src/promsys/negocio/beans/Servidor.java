package promsys.negocio.beans;

import java.io.Serializable;

public class Servidor extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4670224172030542186L;
	private long id;
	private String pergunta;
	private String resposta;
	
	//CONSTRUTOR
	public Servidor(String n, String l, String s, String pergunta, String resposta){
		super(n, l, s);
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	
	//GETTERS AND SETTERS
	public long getID(){
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	//EQUALS E TOSTRING
	public boolean equals(Object object){
		boolean equal = false;
		if(object instanceof Servidor && ((Servidor) object).getID() == this.id){
			equal = true;
		}
		return equal;
	}
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public long getId() {
		return id;
	}

	public String toString(){
		String str = this.getNome() + " - " + this.getLogin();
		return str;
	}
		
}
