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
	public String updateNomeProfessor(String nome, long id) {
		return this.professorRepository.updateNome(nome, id);
	}
	public boolean addPossivelDisciplina(long idprof, Disciplina disciplina) {
		return this.professorRepository.addPossiveisDisciplinas(idprof, disciplina);
	}
	public Professor procurarProf(long id) {
		return this.professorRepository.lerProfessor(id);
	}
	public boolean verificarExistencia(long id) {
		return this.professorRepository.verificaExistencia(id);
	}
	public boolean cadastraProf(Professor prof) {
		return this.professorRepository.cadastrarProfessor(prof);
	}
	public boolean removeProf(long id) {
		return this.professorRepository.removerProfessor(id);
	}
	public boolean removeDisciplinaPossivel(long idProf, long idDisciplina) {
		return this.professorRepository.removePossiveisDisciplinas(idProf, idDisciplina);
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
