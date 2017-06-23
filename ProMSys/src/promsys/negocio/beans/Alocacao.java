package promsys.negocio.beans;

public class Alocacao {
	private static long nextID=1;
	private long id;
	private Professor professor;
	private Disciplina disciplina;
	private String periodo;
	private Horario horario;
	private double cargaHoraria;
	
	
	public Alocacao (Professor prof, Disciplina dis, String periodo, Horario hora, double carga) {
		
		this.professor = prof;
		this.disciplina = dis;
		this.horario = hora;
		this.cargaHoraria = carga;
		this.id = nextID;
		nextID++;
	}


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


	public double getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public long getId() {
		return id;
	}
	
	public String toString() {
		String vari = "Professor: "+getProfessor()+" Disciplina: "+getDisciplina()+" Período: "+getPeriodo()+" Horario "+getHorario()+" Carga Horária: "+getCargaHoraria(); 
		return vari;
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
