package promsys.negocio.beans;
import java.util.ArrayList;
public class Professor {
	//
	private static long nextID=1;
	private long id;
	private String nome;
	private ArrayList<Disciplina> disciplinasPossiveis;
	private ArrayList<Disciplina> disciplinaMinistrada; // NESTE PERÍODO LETIVO !
	
	public Professor(String nome) {
		this.nome = nome;
		this.id = nextID++;
		disciplinasPossiveis = new ArrayList<Disciplina>();
		disciplinaMinistrada = new ArrayList<Disciplina>();
	}
	

	public long getNextID() {
		return nextID;
	}
	
	public ArrayList<Disciplina> getDisciplinasPossiveis() {
		return this.disciplinasPossiveis;
	}
	
	public boolean addDisciplinasPossiveis(Disciplina disciplina) {
		boolean vari = false;
		if(disciplina !=null) {
			this.disciplinasPossiveis.add(disciplina);
			vari = true;
		}
		return vari;
	}
	
	public boolean removeDisciplinaPossivel(long id) {
		boolean vari = false;
		if(id>=0){
			for(int i = 0; i < this.disciplinasPossiveis.size() && !vari; i++) {
				if(this.disciplinasPossiveis.get(i).getId() == id) {
					this.disciplinasPossiveis.remove(i);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean removeDisciplinaMinistrada(long id) {
		boolean vari = false;
		if(id>=0){
			for(int i = 0; i < this.disciplinaMinistrada.size() && !vari; i++) {
				if(this.disciplinaMinistrada.get(i).getId() == id) {
					this.disciplinaMinistrada.remove(i);
					vari = true;
				}
			}
		}
		return vari;
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
	
	public ArrayList<Disciplina> getDisciplina() {
		return this.disciplinaMinistrada;
	}

	public void setTurma(ArrayList<Disciplina> disciplina) {
		this.disciplinaMinistrada = disciplina;
	}
	
	public boolean addDisciplina(Disciplina dis) {
		boolean vari = false;
		if(dis != null) {
			for(int i = 0; i < this.disciplinasPossiveis.size() && !vari; i++) {
				if(this.disciplinasPossiveis.get(i).getId() == dis.getId()) {
					this.disciplinaMinistrada.add(dis);
					vari = true;
				}
			}
		}
		return vari;
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
		return " Nome: "+getNome()+ "\n ID: "+getId()+ " Disciplinas ministradas: "+getDisciplina();
	}
	
}
