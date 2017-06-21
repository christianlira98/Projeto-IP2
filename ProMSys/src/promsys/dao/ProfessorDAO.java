package promsys.dao;
import promsys.negocio.beans.*;
import java.util.ArrayList;

public class ProfessorDAO{
	private static ProfessorDAO instance;
	private ArrayList<Professor> prof = new ArrayList<>(); 
	private String [] tempo = null;
	
	private ProfessorDAO() {
		
	}
	
	
	public static ProfessorDAO getInstance() {
		if(instance == null) {
			instance = new ProfessorDAO();
		}
		return instance;
	}
	
	public String[] procuraPorNome(String nome) {
		int z = 0;
		if(nome != null) {
			for(int i = 0; i < this.prof.size(); i++) {
				if(this.prof.get(i).getNome() == nome) {
					tempo = new String[++z];
					tempo[z] = this.prof.get(i).toString();
				}
			}
		}
		return tempo;
	}
	
	public boolean cadastrarProfessor(Professor prof) {
		 boolean vari = false;
		if(prof != null ) {
			this.prof.add(prof);
			vari = true;
		}
		return vari;
	}
	
	public boolean removerProfessor(long id) {
		boolean vari = false;
		if(id >=1) {
			for(int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == id) {
					prof.remove(i);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public String lerProfessor (long id) {
		String vari = null;
		if(id>=1) {
			for (int i = 0; i  < this.prof.size() && vari==null;i++) {
				if(this.prof.get(i).getId() == id) {
					vari = this.prof.get(i).toString();
				}
			}
		}
		return vari;
	}
	
	public String updateNome (String nome, long id) {
		String vari = null;
		if(nome !=null && id >= 1) {
			for(int i = 0; i < this.prof.size() && vari == null; i++) {
				if(this.prof.get(i).getId() == id) {
					this.prof.get(i).setNome(nome);
					vari = this.prof.get(i).toString();
				}
			}
		}
		return vari;
	}
	
	public boolean addPossiveisDisciplinas(long idprof, Disciplina disciplina) {
		boolean vari = false;
		if(idprof >= 0 && disciplina != null) {
			for( int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idprof) {
					this.prof.get(i).addDisciplinasPossiveis(disciplina);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean addMinistradaDisciplinas(long idprof, Disciplina disciplina) {
		boolean vari = false;
		if(idprof >= 0 && disciplina != null) {
			for( int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idprof) {
					this.prof.get(i).addDisciplina(disciplina);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean removePossiveisDisciplinas(long idProf, long idDisciplina) {
		boolean vari = false;
		if(idProf >= 1 && idDisciplina >= 1) {
			for(int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idProf) {
					this.prof.get(i).removeDisciplinaPossivel(idDisciplina);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean removeMinistradaDisciplina(long idProf, long idDisciplina) {
		boolean vari = false;
		if(idProf >= 1 && idDisciplina >= 1) {
			for(int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idProf) {
					this.prof.get(i).removeDisciplinaMinistrada(idDisciplina);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	
	private long retornaIndice(long id) {
		long tempIndice = -1;
		for(int i = 0; i < this.prof.size(); i++) {
			if(this.prof.get(i).getId() == id) {
				tempIndice = i;
			}
		}
		return tempIndice;
	}
	
	
	public boolean verificaExistencia(long id) {
		boolean vari = false;
		for(int i = 0; i < this.prof.size() && !vari; i++) {
			if(this.prof.get(i).getId()==id) {
				vari = true;
			}
		}
		return vari;
	}
	
	
}