package promsys.negocio.beans;

public class Disciplina {

	private long id;
	private static long nextId = 1;
	private String nome;
	
	public Disciplina(String nome) {
		this.nome = nome;
		this.id = nextId;
		nextId++;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public long getId() {
		return this.id;
	}
	
	public boolean equals(Disciplina outra) {
		
		if(outra != null && outra instanceof Disciplina) {
			
			if(this.nome == outra.nome && this.id == outra.id){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public String toString() {
		return String.format("Nome: %s\nID: %d", this.nome, this.id);
	}
	
}
