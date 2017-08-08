package promsys.negocio;

import promsys.dao.ProfessorDAO;
import promsys.exceptions.*;
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
	public void updateNomeProfessor(String nome, long id) throws ProfessorNaoExisteException{
		this.professorRepository.atualizarNome(nome, id);
	}
	public void addPossivelDisciplina(long idprof, Disciplina disciplina) throws ProfessorNaoExisteException, DisciplinaNaoExisteException{
		this.professorRepository.addPossivelDisciplina(idprof, disciplina);
	}
	public Professor procurarProf(long id) {
		return this.professorRepository.procurar(id);
	}
	
	public Professor procurarPorNome(String nome) {
		return this.professorRepository.procurarPorNome(nome);
	}
	public boolean verificarExistencia(long id) {
		return this.professorRepository.existe(id);
	}
	
	public void cadastraProf(Professor prof) throws ProfessorJaExisteException{
		if(prof == null) {
			throw new IllegalArgumentException("Parâmetro Nulo");
		}
		else {
			if(prof.getId() == 0L) {
				this.professorRepository.cadastrar(prof);
				this.professorRepository.escreveArquivo();
			}
			else {
				throw new ProfessorJaExisteException(prof.getId());
			}
		}
	}
	
	public void removeProf(long id) throws ProfessorNaoExisteException{
		this.professorRepository.remover(id);
	}
	public void removeDisciplinaPossivel(long idProf, long idDisciplina) throws ProfessorNaoExisteException, NaoEstaEntreOsPossiveisException{
		this.professorRepository.removerPossivelDisciplina(idProf, idDisciplina);
	}
	public boolean fazLogin(String login, String senha) {
		boolean logged = false;
		if(ProfessorDAO.getNextId() > 1) {
			for(int i = 0; i<ProfessorDAO.getNextId(); i++) {
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
