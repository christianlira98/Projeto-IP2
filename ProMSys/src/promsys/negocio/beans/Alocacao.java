package promsys.negocio.beans;

import java.io.Serializable;

public class Alocacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2278026790528082645L;
	private static long nextID=1;
	private long id;
	private Professor professor;
	private Disciplina disciplina;
	private Horario horario;
	
	//CONSTRUTOR
	public Alocacao (Professor prof, Disciplina dis, Horario hora) {
		
		this.professor = prof;
		this.disciplina = dis;
		this.horario = hora;
		this.id = nextID;
		nextID++;
	}

	//GETTERS AND SETTERS
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
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
	public long getId() {
		return id;
	}
	
	//EQUALS E TOSTRING
	public String toString() {
		return String.format("Professor: "+ getProfessor().getNome() + 
							"\nDisciplina: "+ getDisciplina().getNome() +
							"\nID da Alocação: %d", this.getId());
	}
	public boolean equals(Object aloc) {
		boolean vari = false;
		if(aloc instanceof Alocacao) {
			Alocacao temp = (Alocacao) aloc;
			if(this.professor.equals(temp.getProfessor()) 
					&& this.horario.equals(temp.getHorario())
					&& this.disciplina.equals(temp.getDisciplina())) {
					vari = true;
				}
		}
		return vari;
	}
}
