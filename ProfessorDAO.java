package promsys.dao;
import promsys.negocio.beans.*;
import java.util.ArrayList;

public class ProfessorDAO{
	private static ProfessorDAO instance;
	private ArrayList<Professor> prof = new ArrayList<>(); 
	
	private ProfessorDAO() {
		
	}
	
	
	public ProfessorDAO getInstance() {
		if(instance == null) {
			instance = new ProfessorDAO();
		}
		return instance;
	}
	
	public boolean cadastrar(Professor prof) {
		 boolean vari = false;
		if(prof != null ) {
			this.prof.add(prof);
			vari = true;
		}
		return vari;
	}
	
	public boolean remover(long id) {
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
	
	public String ler (long id) {
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
	
	public String updateDisciplina (long identificadorProf, String identificadorTurma, byte novoQtd, Horario novaHora) {
		String vari = null;
		int cond = 0;
		if(identificadorTurma != null && identificadorProf >=1) {
			for(int i = 0;i < this.prof.size() && cond !=-1;i++) {
				if(this.prof.get(i).getId() == identificadorProf) {
					for(int j = 0; j < this.prof.get(i).getTurma().size(); j++) {
						if(this.prof.get(i).getSingleTurma(j).getIdTurma() == identificadorTurma) {
							cond = -1;
							this.prof.get(i).getSingleTurma(j).setQtdAlunos(novoQtd);
							this.prof.get(i).getSingleTurma(j).setHorario(novaHora);
							vari = this.prof.get(i).getSingleTurma(j).toString();
						}
					}
				}
			}
		}
		return vari;
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
