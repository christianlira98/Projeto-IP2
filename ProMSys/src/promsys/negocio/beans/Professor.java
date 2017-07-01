package promsys.negocio.beans;
import java.util.ArrayList;

public class Professor extends Usuario {
	//
	private static long nextID=1;
	private long id;
	private ArrayList<Disciplina> disciplinasPossiveis;
	
	//CONSTRUTOR
	public Professor(String nome, String login ,String senha) {
		super(nome, login, senha);
		this.id = nextID;
		nextID++;
		disciplinasPossiveis = new ArrayList<Disciplina>();
	}
	
	//GETTERS AND SETTERS
	public static long getNextID() {
		return nextID;
	}
	public long getId() {
		return id;
	}	
	public ArrayList<Disciplina> getDisciplinasPossiveis() {
		return this.disciplinasPossiveis;
	}
	
	//MÉTODOS
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
	
	//EQUALS E TOSTRING
	public boolean equals(Object prof) {
		boolean vari = false;
		if(prof instanceof Professor) {
			Professor compara = (Professor) prof;
			if (compara.getId() == this.id && compara.getNome() == this.getNome()) {
				vari = true;
			}
		}
		return vari;
	}
	public String toString() {
		String text = String.format( "Nome: "+getNome()+ 
							"\nID: "+getId()+
							"\nDisciplinas possíveis: \n");
		for(int i = 0; i < this.disciplinasPossiveis.size(); i++){
			text += this.disciplinasPossiveis.get(i).getNome() + "\n";
		}
		return text;
	}
	
}
