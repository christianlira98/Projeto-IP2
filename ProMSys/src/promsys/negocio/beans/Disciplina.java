package promsys.negocio.beans;

public class Disciplina {

	private long id;
	private static long nextId = 1;
	private String nome;
	private double cargaHoraria;
	
	//CONSTRUTOR
	public Disciplina(String nome, double cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.id = nextId;
		nextId++;
	}
	
	//GETTERS AND SETTERS
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public long getId() {
		return this.id;
	}
	public void setCargaHoraria(double cargaHoraria){
		this.cargaHoraria=cargaHoraria;
	}
	public double getCargaHoraria(){
		return this.cargaHoraria;
	}
	
	//EQUALS E TOSTRING
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
		return String.format("Nome: %s\nID: %d\nCarga Horaria: %d", this.getNome(), this.getId(), this.getCargaHoraria());
	}
	
}
