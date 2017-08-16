package promsys.fachada;

import java.util.List;

import promsys.exceptions.AlocacaoJaExisteException;
import promsys.exceptions.AlocacaoNaoExisteException;
import promsys.exceptions.DisciplinaCargaInvalidaException;
import promsys.exceptions.DisciplinaJaExisteException;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.exceptions.MesmoProfessorHorarioException;
import promsys.exceptions.NaoEstaEntreOsPossiveisException;
import promsys.exceptions.ProfessorDuasMaisDisciplinasException;
import promsys.exceptions.ProfessorJaExisteException;
import promsys.exceptions.ProfessorJaExisteNomeException;
import promsys.exceptions.ProfessorJaPossuiHorarioException;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.exceptions.ServidorJaExisteException;
import promsys.exceptions.ServidorNaoExisteException;
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
	
	public void cadastrarAlocacao(Object obj) throws MesmoProfessorHorarioException, AlocacaoJaExisteException {
		alocacoes.cadastrar(obj);
	}

	public void removerAlocacao(long id) throws AlocacaoNaoExisteException {
		alocacoes.remover(id);
	}

	public Alocacao lerAlocacoPorID(long id) {
		return alocacoes.lerPorID(id);
	}
/*
	public Alocacao[] lerAlocacaoPorPeriodo(String periodo) {
		return alocacoes.lerPorPeriodo(periodo);
	}
*/
	public boolean verificaExistenciaAlocacao(long id) {
		return alocacoes.verificaExistencia(id);
	}

	public void atualizarHorarioAlocacao(long id, Horario nova) throws MesmoProfessorHorarioException {
		alocacoes.atualizarHorario(id, nova);
	}

	public void atualizarProfessorAlocacao(long id, Professor nova) throws ProfessorDuasMaisDisciplinasException, ProfessorJaPossuiHorarioException {
		alocacoes.atualizarProfessor(id, nova);
	}
/*
	public boolean updatePeriodo(long id, String nova) {
		return alocacoes.updatePeriodo(id, nova);
	}
*/
	public void atualizarDisciplinaAlocacao(long id, Disciplina nova) {
		alocacoes.atualizarDisciplina(id, nova);
	}
	
	public List<Alocacao> listarAlocacoes() {
		return alocacoes.listar();
	}

	
	//Disciplinas
	
	public void cadastrarDisciplina(Disciplina d) throws DisciplinaJaExisteException, DisciplinaCargaInvalidaException {
		disciplinas.cadastrarDisciplina(d);
	}

	public Disciplina procurarDisciplina(long id) {
		return disciplinas.procurarDisciplina(id);
	}
	
	public Disciplina procurarNomeDisciplina(String nome) {
		return disciplinas.procurarNomeDisciplina(nome);
	}

	public void atualizarDisciplina(long id, String novoNome) {
		disciplinas.atualizarDisciplina(id, novoNome);
	}
	
	public void atualizarCargaHoraria(long id, double novaCargaHoraria) throws DisciplinaCargaInvalidaException {
		disciplinas.atualizarCargaHoraria(id, novaCargaHoraria);
	}
	
	public void removerDisciplina(long id) throws DisciplinaNaoExisteException {
		disciplinas.removerDisciplina(id);
	}

	public String listarDisciplinas() {
		return disciplinas.listarDisciplinas();
	}
	
	//Professores

	public void atualizarNomeProfessor(String nome, long id) throws ProfessorNaoExisteException, ProfessorJaExisteNomeException {
		professores.updateNomeProfessor(nome, id);
	}

	public void addPossivelDisciplina(long idprof, Disciplina disciplina) throws ProfessorNaoExisteException, DisciplinaNaoExisteException {
		professores.addPossivelDisciplina(idprof, disciplina);
	}

	public Professor procurarProf(long id) {
		return professores.procurarProf(id);
	}
	
	public Professor procurarProf(String nome) {
		return professores.procurarPorNome(nome);
	}


	public boolean verificarExistencia(long id) {
		return professores.verificarExistencia(id);
	}

	public void cadastraProf(Professor prof) throws ProfessorJaExisteException {
		professores.cadastraProf(prof);
	}

	public void removeProf(long id) throws ProfessorNaoExisteException {
		professores.removeProf(id);
	}

	public void removeDisciplinaPossivel(long idProf, long idDisciplina) throws ProfessorNaoExisteException, NaoEstaEntreOsPossiveisException {
		professores.removeDisciplinaPossivel(idProf, idDisciplina);
	}
	
	public boolean fazLoginProfessor(String login, String senha) {
		return professores.fazLogin(login, senha);
	}
	
	public String listaProfessores() {
		return professores.listaProfessores();
	}
	
	//Servidor

	public void cadastroServidor(Servidor novo) throws ServidorJaExisteException {
		servidores.cadastroServidor(novo);
	}

	public void excluiServidor(long id) throws ServidorNaoExisteException {
		servidores.excluiServidor(id);
	}

	public void atualizaServidor(long id, String novoLogin, String novaSenha) throws ServidorNaoExisteException {
		servidores.atualizaServidor(id, novoLogin, novaSenha);
	}

	public Servidor procuraServidor(long id) throws ServidorNaoExisteException {
		return servidores.procuraServidor(id);
	}

	public boolean fazLoginServidor(String login, String senha) {
		return servidores.fazLogin(login, senha);
	}
		
}
