package promsys.negocio;

import java.util.ArrayList;
import java.util.List;

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
	public void updateNomeProfessor(String nome, long id) throws ProfessorNaoExisteException, ProfessorJaExisteNomeException {
		boolean existeNome = false;
		List<Professor> p = this.lista();
		
		for(Professor o : p) {
			if(o.getNome().equals(nome))
				existeNome = true;
		}
		if(existeNome == false)
			this.professorRepository.atualizarNome(nome, id);
		else if(existeNome == true) {
			throw new ProfessorJaExisteNomeException(nome);
		}
	}
	public void addPossivelDisciplina(long idProf, Disciplina disciplina) throws ProfessorNaoExisteException, DisciplinaNaoExisteException, ProfessorDuasMaisDisciplinasException{
		Professor p = procurarProf(idProf);
		if(p != null && disciplina != null) {
			ArrayList<Disciplina> aptas = p.getDisciplinasPossiveis();
			if(aptas.size() >= 1) {
				boolean existe = false;
				for(Disciplina d : aptas) {
					if(d.equals(disciplina))
						existe = true;
				}
				if(existe == false)
					this.professorRepository.addPossivelDisciplina(idProf, disciplina);
			}
			else {
				throw new ProfessorDuasMaisDisciplinasException(p, disciplina);
			}
		}
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
	
	public List<Professor> lista() {
		return this.professorRepository.lista();
	}
}
