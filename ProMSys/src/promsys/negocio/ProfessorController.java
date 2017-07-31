package promsys.negocio;

import promsys.dao.ProfessorDAO;
import promsys.negocio.beans.*;

public class ProfessorController {
	
	private ProfessorDAO professorRepository;
	private static ProfessorController instance;
	
	private ProfessorController () {
		this.professorRepository = ProfessorDAO.getInstance();
	}
	
	public static ProfessorController getInstance() {
		if(instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	public void updateNomeProfessor(String nome, long id) {
		this.professorRepository.atualizarNome(nome, id);
	}
	public void addPossivelDisciplina(long idprof, Disciplina disciplina) {
		this.professorRepository.addPossivelDisciplina(idprof, disciplina);
	}
	public Professor procurarProf(long id) {
		return this.professorRepository.procurar(id);
	}
	public boolean verificarExistencia(long id) {
		return this.professorRepository.existe(id);
	}
	public void cadastraProf(Professor prof) {
		this.professorRepository.cadastrar(prof);
	}
	public void removeProf(long id) {
		this.professorRepository.remover(id);
	}
	public void removeDisciplinaPossivel(long idProf, long idDisciplina) {
		this.professorRepository.removerPossivelDisciplina(idProf, idDisciplina);
	}
	public boolean fazLogin(String login, String senha) {
		boolean logged = false;
		if(Professor.getNextID() > 1) {
			for(int i = 0; i<Professor.getNextID(); i++) {
				Professor p = procurarProf(i);
				if (login == p.getLogin() && senha == p.getSenha() ) {
					logged = true;
				}
			}
		}
		return logged;
	}
	public String listaProfessores() {
		return this.professorRepository.listarProfessores();
	}
}
