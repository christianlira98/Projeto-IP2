package promsys.negocio.beans;

import java.io.Serializable;

public class Disciplina implements Serializable {

	private static final long serialVersionUID = -2060557199150717524L;
	private long id;
	private String nome;
	private double cargaHoraria;
	private String codigoTurma;
	
	//CONSTRUTOR
	public Disciplina(String nome, double cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	
	//GETTERS AND SETTERS
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setCodigoTurma(String codTurma) {
		this.codigoTurma = codTurma;
	}
	public String getCodigoTurma() {
		return this.codigoTurma;
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
