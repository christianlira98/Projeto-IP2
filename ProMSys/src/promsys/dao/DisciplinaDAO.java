package promsys.dao;

import java.util.ArrayList;
import promsys.negocio.beans.*;

public class DisciplinaDAO {
	
	private static DisciplinaDAO instance;
	private ArrayList<Disciplina> disciplinas;
	
	private DisciplinaDAO() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public DisciplinaDAO getInstance() {
		if(instance == null) {
			instance = new DisciplinaDAO();
		}
		return instance;
	}
	
	//CRUD
	
	public void criarDisciplina(String nome) {
		
		if(nome.length() > 0){
			Disciplina d = new Disciplina(nome);
			salvarDisciplina(d);
		}
	}
	
	public void salvarDisciplina(Disciplina  d) {
		this.disciplinas.add(d);
	}
	
	public Disciplina procurarDisciplina(long id) {
		
		boolean encontrou = false;
		int count = 0, j = 0;
		
		for(int i = 0; i < this.disciplinas.size() && !encontrou; i++) {
			if(id == this.disciplinas.get(i).getId() ) {
				j = i;
				encontrou = true;
			}
			count++;
		}
		
		if(count == this.disciplinas.size() ){
			return null;
		}
		return this.disciplinas.get(j);
	}
	
	public void deletarDisciplina(Disciplina d) {
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if(d.equals(this.disciplinas.get(i)) ) {
				this.disciplinas.remove(i);
			}
		}
	}

}
