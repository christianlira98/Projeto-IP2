package promsys.fachada;

import promsys.negocio.*;
import promsys.negocio.beans.*;

public class Fachada {
	
	private AlocacaoController alocacoes;
	private DisciplinaController disciplinas;
	private ProfessorController professores;
	private ServidorController servidores;
	
	private static Fachada instance;
	
	private Fachada() {
		this.alocacoes = AlocacaoController.getInstance();
		this.disciplinas = DisciplinaController.getInstance();
		this.professores = ProfessorController.getInstance();
		this.servidores = ServidorController.getInstance();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	// Aloca��es
	
	public boolean salvaAlocacao(Object obj) {
		return alocacoes.salvaAloc(obj);
	}

	public boolean removeAlocacao(long id) {
		return alocacoes.removeAloc(id);
	}

	public Alocacao lerAlocacoPorID(long id) {
		return alocacoes.lerPorID(id);
	}

	public Alocacao[] lerAlocacaoPorPeriodo(String periodo) {
		return alocacoes.lerPorPeriodo(periodo);
	}

	public boolean verificaExistenciaAlocacao(long id) {
		return alocacoes.verificaExistencia(id);
	}

	public boolean updateHorarioAlocacao(long id, Horario nova) {
		return alocacoes.updateHorario(id, nova);
	}

	public boolean updateProfessorAlocacao(long id, Professor nova) {
		return alocacoes.updateProfessor(id, nova);
	}

	public boolean updatePeriodo(long id, String nova) {
		return alocacoes.updatePeriodo(id, nova);
	}

	public boolean updateDisciplinaAlocacao(long id, Disciplina nova) {
		return alocacoes.updateDisciplina(id, nova);
	}

	
	//Disciplinas
	
	public void salvarDisciplina(Disciplina d) {
		disciplinas.salvarDisciplina(d);
	}

	public Disciplina procurarDisciplina(long id) {
		return disciplinas.procurarDisciplina(id);
	}
	
	public Disciplina procurarNomeDisciplina(String nome) {
		return disciplinas.procurarNomeDisciplina(nome);
	}

	public boolean atualizarDisciplina(long id, String novoNome) {
		return disciplinas.atualizarDisciplina(id, novoNome);
	}
	
	public boolean atualizarCargaHoraria(long id, double novaCargaHoraria) {
		return disciplinas.atualizarCargaHoraria(id, novaCargaHoraria);
	}
	
	public boolean deletarDisciplina(long id) {
		return disciplinas.deletarDisciplina(id);
	}

	public String listarDisciplinas() {
		return disciplinas.listarDisciplinas();
	}
	
	//Professores

	public String updateNomeProfessor(String nome, long id) {
		return professores.updateNomeProfessor(nome, id);
	}

	public boolean addPossivelDisciplina(long idprof, Disciplina disciplina) {
		return professores.addPossivelDisciplina(idprof, disciplina);
	}

	public Professor procurarProf(long id) {
		return professores.procurarProf(id);
	}

	public boolean verificarExistencia(long id) {
		return professores.verificarExistencia(id);
	}

	public boolean cadastraProf(Professor prof) {
		return professores.cadastraProf(prof);
	}

	public boolean removeProf(long id) {
		return professores.removeProf(id);
	}

	public boolean removeDisciplinaPossivel(long idProf, long idDisciplina) {
		return professores.removeDisciplinaPossivel(idProf, idDisciplina);
	}
	
	public boolean fazLoginProfessor(String login, String senha) {
		return professores.fazLogin(login, senha);
	}
	
	public String listaProfessores() {
		return professores.listaProfessores();
	}
	
	//Servidor

	public void cadastroServidor(String nome, String login, String senha) {
		servidores.cadastroServidor(nome, login, senha);
	}

	public boolean excluiServidor(long id) {
		return servidores.excluiServidor(id);
	}

	public boolean atualizaServidor(long id, String novoLogin, String novaSenha) {
		return servidores.atualizaServidor(id, novoLogin, novaSenha);
	}

	public Servidor procuraServidor(long id) {
		return servidores.procuraServidor(id);
	}

	public boolean fazLoginServidor(String login, String senha) {
		return servidores.fazLogin(login, senha);
	}
		
}
