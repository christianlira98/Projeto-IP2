package promsys.dao;
import promsys.negocio.beans.*;
import java.util.ArrayList;

public class ProfessorDAO{
	private static ProfessorDAO instance;
	private ArrayList<Professor> prof = new ArrayList<>(); 
	
	private ProfessorDAO() {
		
	}
	
	
	public static ProfessorDAO getInstance() {
		if(instance == null) {
			instance = new ProfessorDAO();
		}
		return instance;
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
		int cond = 0;
		if(id >=1) {
			for(int i = 0; i < this.prof.size() && cond !=-1; i++) {
				if(this.prof.get(i).getId() == id) {
					cond = -1;
					prof.remove(i);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public String lerProfessor (long id) {
		String vari = null;
		int cond = 0;
		if(id>=1) {
			for (int i = 0; i  < this.prof.size() && cond !=-1;i++) {
				if(this.prof.get(i).getId() == id) {
					cond = -1;
					vari = this.prof.get(i).toString();
				}
			}
		}
		return vari;
	}
	
	public String updateNome (String nome, long id) {
		String vari = null;
		int cond = 0;
		if(nome !=null && id >= 1) {
			for(int i = 0; i < this.prof.size() && cond!=-1; i++) {
				if(this.prof.get(i).getId() == id) {
					cond = -1;
					this.prof.get(i).setNome(nome);
					vari = this.prof.get(i).toString();
				}
			}
		}
		return vari;
	}
	
	public boolean addPossiveisDisciplinas(long idprof, Disciplina disciplina) {
		boolean vari = false;
		int cond = 0;
		if(idprof >= 0 && disciplina != null) {
			for( int i = 0; i < this.prof.size() && cond != -1; i++) {
				if(this.prof.get(i).getId() == idprof) {
					this.prof.get(i).addDisciplinasPossiveis(disciplina);
					cond = -1;
				}
			}
		}
		return vari;
	}
	
	public boolean addMinistradaDisciplinas(long idprof, Disciplina disciplina) {
		boolean vari = false;
		int cond = 0;
		if(idprof >= 0 && disciplina != null) {
			for( int i = 0; i < this.prof.size() && cond != -1; i++) {
				if(this.prof.get(i).getId() == idprof) {
					this.prof.get(i).addDisciplina(disciplina);
					cond = -1;
				}
			}
		}
		return vari;
	}
	
	public boolean removePossiveisDisciplinas(long idProf, long idDisciplina) {
		boolean vari = false;
		int cond = 0;
		if(idProf >= 1 && idDisciplina >= 1) {
			for(int i = 0; i < this.prof.size() && cond !=-1; i++) {
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
		int cond = 0;
		if(idProf >= 1 && idDisciplina >= 1) {
			for(int i = 0; i < this.prof.size() && cond !=-1; i++) {
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
		int cond = 0;
		for(int i = 0; i < this.prof.size() && cond != -1; i++) {
			if(this.prof.get(i).getId()==id) {
				cond = -1;
				vari = true;
			}
		}
		return vari;
	}
	
	
}