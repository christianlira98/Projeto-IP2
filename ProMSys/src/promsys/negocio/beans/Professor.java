package promsys.negocio.beans;
import java.util.ArrayList;
public class Professor {
	private static long nextID=1;
	private long id;
	private String nome;
	private ArrayList<Turma> turma;
	
	public Professor(String nome) {
		this.nome = nome;
		this.id = nextID++;
		turma = new ArrayList<Turma>();
	}
	

	public long getNextID() {
		return nextID;
	}


	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Turma getSingleTurma(long idTurma) {
		Turma temp = null;
		int cond = 0;
		for(int i = 0; i< this.turma.size() && cond != -1;i++) {
			if(this.turma.get(i).getIdTurma() == idTurma) {
				cond = -1;
				temp = this.turma.get(i);
			}
		}
		return temp;
	}
	public Turma getSingleTurma(int idTurma) {
		return this.turma.get(idTurma);
	}
	public ArrayList<Turma> getTurma() {
		return turma;
	}

	public void setTurma(ArrayList<Turma> turma) {
		this.turma = turma;
	}
	
	public void addTurma(Turma turma) {
		if(turma != null) {
			this.turma.add(turma);
		}
	}
	
	public boolean equals(Object prof) {
		boolean vari = false;
		if(prof instanceof Professor) {
			Professor compara = (Professor) prof;
			if (compara.getId() == this.id && compara.getNome() == this.nome) {
				vari = true;
			}
		}
		return vari;
	}
	
	public String toString() {
		return " Nome: "+getNome()+ "\n ID: "+getId()+ " Turmas: "+getTurma();
	}
	
}