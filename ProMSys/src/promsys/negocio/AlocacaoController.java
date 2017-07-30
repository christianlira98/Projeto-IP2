package promsys.negocio;
import promsys.negocio.beans.*;
import promsys.dao.*;

public class AlocacaoController {
	
	private IAlocacaoDAO repositorioAlocacao;

	private AlocacaoController(IAlocacaoDAO instancia) {
		this.repositorioAlocacao = instancia;
	}

	
	public void cadastrar(Object obj) {
		this.repositorioAlocacao.cadastrar(obj);
	}
	
	public void remover(long id) {
		this.repositorioAlocacao.remover(id);
	}
	
	public Alocacao lerPorID(long id) {
		return this.repositorioAlocacao.lerAlocID(id);
	}
	
	public Alocacao[] lerPorPeriodo(String periodo) {
		return this.repositorioAlocacao.lerAlocPeriodo(periodo);
	}
	
	public boolean verificaExistencia(long id) {
		return this.repositorioAlocacao.verificaExistencia(id);
	}
	
	public boolean updateHorario( long id, Horario nova) {
		return this.repositorioAlocacao.updateHorario(id, nova);
	}
	
	public boolean updateProfessor(long id, Professor nova) {
		return this.repositorioAlocacao.updateProfessor(id, nova);
	}
	
	public boolean updatePeriodo(long id, String nova) {
		return this.repositorioAlocacao.updatePeriodo(id, nova);
	}
	
	public boolean updateDisciplina(long id, Disciplina nova) {
		return this.repositorioAlocacao.updateDisciplina(id, nova);
	}
	
	public String listaAlocacoes() {
		return this.repositorioAlocacao.listarAlocacoes();
	}
}
