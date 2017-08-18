package promsys.negocio;

import promsys.dao.ProfessorDAO;
import promsys.exceptions.*;
import promsys.negocio.beans.*;
import java.util.List;


public class ProfessorController {
	
	private ProfessorDAO professorRepository;
	private static ProfessorController instancia;
	
	private ProfessorController () {
		this.professorRepository = ProfessorDAO.getInstance();
	}
	
	public static ProfessorController getInstance() {
		if(instancia == null) {
			instancia = new ProfessorController();
		}
		return instancia;
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
	public void addPossivelDisciplina(long idProf, Disciplina disciplina) throws ProfessorNaoExisteException, DisciplinaNaoExisteException {
		Professor p = procurarProf(idProf);
		if(p != null && disciplina != null) {
			// Um professor pode ter várias disciplinas aptas.
			/*
			ArrayList<Disciplina> aptas = p.getDisciplinasPossiveis();
			if(aptas.size() >= 1) {
				boolean existe = false;
				for(Disciplina d : aptas) {
					if(d.equals(disciplina))
						existe = true;
				}
				if(existe == false) {
					this.professorRepository.addPossivelDisciplina(idProf, disciplina);
				}
			}
			*/
			this.professorRepository.addPossivelDisciplina(idProf, disciplina);
		}
		else if(p == null) {
			throw new ProfessorNaoExisteException(idProf);
		}
		else if(disciplina == null) {
			throw new DisciplinaNaoExisteException(disciplina);
		}
	}
	public Professor procurarProf(long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Parâmentro inválido");
		}
		return this.professorRepository.procurar(id);
	}
	
	public Professor procurarPorNome(String nome) {
		if(nome == null) {
			throw new IllegalArgumentException("Parâmentro Nulo");
		}
		else {
			return this.professorRepository.procurarPorNome(nome);
		}
	}
	public boolean verificarExistencia(long id) {
		if(id <=0) {
			throw new IllegalArgumentException("Parâmentro inválido");
		}
		else {
			return this.professorRepository.existe(id);
		}
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
		if(id <= 0) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		}
		else if(!this.professorRepository.existe(id)) {
			throw new ProfessorNaoExisteException(id);
		}
		else {
			this.professorRepository.remover(id);
		}
	}
	
	public boolean estaEntreDisAptas(long idProf, long idDis) {
		boolean aux = false;
		if(idProf <= 0 || idDis <= 0) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		}
		aux = this.professorRepository.estaEntreAptasDis(idProf, idDis);
		return aux;
	}
	public void removeDisciplinaPossivel(long idProf, long idDisciplina) throws ProfessorNaoExisteException, NaoEstaEntreOsPossiveisException{
		if(idProf <= 0 || idDisciplina <= 0) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		}
		else if(!this.professorRepository.existe(idProf)) {
			throw new ProfessorNaoExisteException(idProf);
		}
		else if (!this.professorRepository.estaEntreAptasDis(idProf, idDisciplina)) {
			throw new NaoEstaEntreOsPossiveisException(idProf,idDisciplina);
		}
		else {
			this.professorRepository.removerPossivelDisciplina(idProf, idDisciplina);
		}
	}
	
	public void alteraSenhaProf(long id, String senha) {
		this.professorRepository.alteraSenhaProf(id, senha);
	}
	
	public void alteraLoginProf(long id, String login) {
		this.professorRepository.alteraLoginProf(id, login);
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

