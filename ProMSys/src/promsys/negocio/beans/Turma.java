package promsys.negocio.beans;

public class Turma {

	private Professor profTurma;
	private String idTurma;
	private Disciplina disciplina;
	private Horario horario;
	private byte qtdAlunos; 
	
	//CONSTRUTORES
	public Turma(){
		
	}
	public Turma(Professor p, String nome, Disciplina d, Horario h, byte qtdAlunos){
		this.profTurma = p;
		this.idTurma = nome;
		this.disciplina=d;
		this.horario=h;
		this.qtdAlunos=qtdAlunos;
	}
	
	//GETTERS AND SETTERS
	public Professor getProfTurma() {
		return profTurma;
	}
	public void setProfTurma(Professor profTurma) {
		this.profTurma = profTurma;
	}
	public String getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(String idTurma) {
		this.idTurma = idTurma;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public byte getQtdAlunos() {
		return qtdAlunos;
	}
	public void setQtdAlunos(byte qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}
	
	//MÉTODOS 
	public String toString(){
		return String.format("");
	}
	public boolean equals(){
		boolean verifica = false;
		
		return verifica;
	}
}
