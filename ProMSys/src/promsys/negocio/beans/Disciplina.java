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
	public boolean equals(Object outra) {
		
		if(outra instanceof Disciplina) {
			Disciplina temp = (Disciplina) outra;
			if(this.nome == temp.getNome() && this.id == temp.getId()){
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
		String text = String.format("Nome: %s\nID: %d\nCarga Horaria: %.2f", this.getNome(), this.getId(), this.getCargaHoraria());
		return text;
	}
	
}
