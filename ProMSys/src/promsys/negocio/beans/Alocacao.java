package promsys.negocio.beans;

public class Alocacao {

	private static long nextID=1;
	private long id;
	private Professor professor;
	private Disciplina disciplina;
	private String periodo;
	private Horario horario;
	
	//CONSTRUTOR
	public Alocacao (Professor prof, Disciplina dis, String periodo, Horario hora) {
		
		this.professor = prof;
		this.disciplina = dis;
		this.horario = hora;
		this.periodo = periodo;
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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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
							"\nPeríodo: " + getPeriodo() +"\n"+ getHorario() +
							"\nID da Alocação: %d", this.getId());
	}
	public boolean equals(Object aloc) {
		boolean vari = false;
		if(aloc instanceof Alocacao) {
			Alocacao temp = (Alocacao) aloc;
			if(temp.getId() == this.id) {
				vari = true;
			}
			
		}
		return vari;
	}
}
