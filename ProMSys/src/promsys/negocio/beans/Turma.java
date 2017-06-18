package promsys.negocio.beans;

public class Turma {

	private Professor profTurma;
	private long idTurma;
	private static long nextID=1;
	private Disciplina disciplina;
	private Horario horario;
	private byte qtdAlunos; 
	
	//CONSTRUTORES
	public Turma(Professor p, String nome, Disciplina d, Horario h, byte qtdAlunos){
		this.profTurma = p;
		this.idTurma = nextID;
		nextID++;
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
	public long getIdTurma() {
		return idTurma;
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
	public void addProf(Object prof){
		if(prof instanceof Professor ){
			this.profTurma =(Professor) prof;
		}
	}
	public void removeProf(Object prof){
		if(prof instanceof Professor){
			this.profTurma = null;
		}
	}
	public void addHorario(Object novoHorario){
		if(novoHorario instanceof Horario){
			this.horario = (Horario) novoHorario;
		}
	}
	public void removeHorario(Object novoHorario){
		if(novoHorario instanceof Horario){
			this.horario = null;
		}
	}
	public void addDisciplina(Object disc){
		if(disc instanceof Disciplina){
			this.disciplina = (Disciplina) disc;
		}
	}
	public void removeDisciplina(Object disc){
		if(disc instanceof Disciplina){
			this.disciplina = null; 
		}
	}
	
	//EQUALS E toSTRING
	public String toString(){
		return String.format("Turma: "+ getIdTurma() + 
							"\n Professor responsável: " + getProfTurma() +
							"\n Disciplina: "+ getDisciplina() +
							"\n Horário: " + getHorario() +
							"\n Alunos nesta turma: " + getQtdAlunos());
	}
	public boolean equals(Object other){
		boolean verifica = false;
		
		if(other instanceof Turma){
			Turma t = (Turma) other;
			if(this.getIdTurma() == t.getIdTurma()){
				verifica = true;
			}
		}
		return verifica;
	}
}