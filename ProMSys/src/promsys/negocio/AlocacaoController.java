package promsys.negocio;
import promsys.negocio.beans.*;
import java.util.List;
import promsys.dao.*;

public class AlocacaoController {
	
	/*
	 * private DisciplinaDAO repositorioDisciplina;
	private static DisciplinaController instancia;
	
	private DisciplinaController() {
		this.repositorioDisciplina = DisciplinaDAO.getInstance();
	}
	
	public static DisciplinaController getInstance() {
		if(instancia == null) {
			instancia = new DisciplinaController();
		}
		return instancia;
	}
	 */ /* IMPORTANTE
	 * Deve ser decidido a forma de se chamar um controller; se é atravéz do padrão Singleton, 
	 * ou a criação de uma instancia na fachada. 
	 * Apenas uma delas é a maneira correta de se fazer? Ambas maneiras estão certas?
	 */
	
	private AlocacaoDAO repositorioAlocacao;
	private static AlocacaoController instancia;
	
	private AlocacaoController() {
		this.repositorioAlocacao = AlocacaoDAO.getInstance();
	}
	
	public static AlocacaoController getInstance() {
		if(instancia == null)
			instancia = new AlocacaoController();
		return instancia;
	}
	
	public void cadastrar(Object obj) {
		if(obj != null && obj instanceof Alocacao) {
			this.repositorioAlocacao.cadastrar(obj);
		}
	}
	
	public void remover(long id) {
		this.repositorioAlocacao.remover(id);
	}
	
	public Alocacao lerPorID(long id) {
		return this.repositorioAlocacao.procurar(id);
	}
	
	public List<Alocacao> retornaAlocacoesPeriodo(String periodo) {
		return this.repositorioAlocacao.retornaAlocacoesPeriodo(periodo);
	}
	
	public boolean verificaExistencia(long id) {
		return this.repositorioAlocacao.existe(id);
	}
	
	public void atualizarHorario( long id, Horario nova) {
		this.repositorioAlocacao.atualizarHorario(id, nova);
	}
	
	public void atualizarProfessor(long id, Professor nova) {
		this.repositorioAlocacao.atualizarProfessor(id, nova);
	}
	
	public void atualizarPeriodo(long id, String nova) {
		this.repositorioAlocacao.atualizarPeriodo(id, nova);
	}
	
	public void atualizarDisciplina(long id, Disciplina nova) {
		this.repositorioAlocacao.atualizarDisciplina(id, nova);
	}
	
	public String listarTodasAlocacoes() {
		return this.repositorioAlocacao.listarTodasAlocacoes();
	}
}