package promsys.dao;

import java.util.ArrayList;
import promsys.negocio.beans.*;

public class DisciplinaDAO {
	
	private static DisciplinaDAO instance;
	private ArrayList<Disciplina> disciplinas;
	
	private DisciplinaDAO() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public static DisciplinaDAO getInstance() {
		if(instance == null) {
			instance = new DisciplinaDAO();
		}
		return instance;
	}
	
	public void salvarDisciplina(Disciplina  d) {
		this.disciplinas.add(d);
	}
	
	public Disciplina procurarNomeDisciplina(String nome) {
		boolean encontrou = false;
		Disciplina encontrada = null;
		int count = 0;
		
		for(int i = 1; i<this.disciplinas.size() && !encontrou; i++) {
			if(nome == this.disciplinas.get(i).getNome() ) {
				encontrou = true;
				encontrada = this.disciplinas.get(i);
			}
			else{
				count++;
			}
		}
		
		if(count == this.disciplinas.size()) {
			encontrada = null;
		}
		
		return encontrada;
	}
	
	public Disciplina procurarDisciplina(long id) {
		
		boolean encontrou = false;
		int j = 0;
		
		for(int i = 0; i < this.disciplinas.size() && !encontrou; i++) {
			if(id == this.disciplinas.get(i).getId() ) {
				j = i;
				encontrou = true;
			}
		}
		
		if(encontrou == true){
			return this.disciplinas.get(j);
		}
		else{
			return null;
		}
	}
	
	public boolean atualizarNomeDisciplina(long id, String novoNome) {
		
		boolean atualizado = false;
		
		if (this.procurarDisciplina(id) != null) {
			this.procurarDisciplina(id).setNome(novoNome);
			atualizado = true;
		}
		
		return atualizado;
	}
	
	public boolean deletarDisciplina(long id) {
		
		boolean deletado = false;
		
		if (this.procurarDisciplina(id) != null) {
			Disciplina d = this.procurarDisciplina(id);
			this.disciplinas.remove(d);
			deletado = true;
		}
		
		return deletado;
	}
	
	public boolean atualizarCargaHoraria(long id,double novaCargaHoraria) {
		boolean deletado = false;
		if(this.procurarDisciplina(id) != null){
			Disciplina d = this.procurarDisciplina(id);
			d.setCargaHoraria(novaCargaHoraria);
			deletado = true;
		}
		return deletado;
	}
	
	public String listarDisciplinas() {
		
		String lista = "";
		
		for (int i = 0; i < this.disciplinas.size(); i++) {
			lista += "**************************************\n" + this.disciplinas.get(i).toString();
		}
		
		return lista.toString();
	}
}
