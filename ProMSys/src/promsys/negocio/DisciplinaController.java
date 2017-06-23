package promsys.negocio;

import promsys.dao.*;
import promsys.negocio.beans.Disciplina;

public class DisciplinaController {

	private DisciplinaDAO disciplinaRepository;
	private static DisciplinaController instance;
	
	public static DisciplinaController getInstance() {
		if(instance == null){
			instance = new DisciplinaController();
		}
		return instance;
	}
	
	private DisciplinaController() {
		this.disciplinaRepository = DisciplinaDAO.getInstance(); 
	}
	
	
	public void criarDisciplina(String nome) {
		this.disciplinaRepository.criarDisciplina(nome);
	}
	
	public void salvarDisciplina(Disciplina d) {
		this.disciplinaRepository.salvarDisciplina(d);
	}
	
	public Disciplina procurarDisciplina(long id) {
		return this.disciplinaRepository.procurarDisciplina(id);
	}
	
	public boolean atualizarDisciplina(long id, String novoNome) {
		return this.disciplinaRepository.atualizarNomeDisciplina(id, novoNome);
	}
	
	public boolean deletarDisciplina(long id) {
		return this.disciplinaRepository.deletarDisciplina(id);
	}
	
	public String listarDisciplinas() {
		return this.listarDisciplinas();
	}
}
