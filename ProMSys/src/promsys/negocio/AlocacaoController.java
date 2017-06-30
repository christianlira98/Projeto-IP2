package promsys.negocio;
import promsys.negocio.beans.*;
import promsys.dao.AlocacaoDAO;

public class AlocacaoController {
	private AlocacaoDAO alocacaoRepository;
	private static AlocacaoController instance;

	private AlocacaoController() {
		this.alocacaoRepository = AlocacaoDAO.getInstance();
	}
	
	public static AlocacaoController getInstance() {
		if(instance == null) {
			instance = new AlocacaoController();
		}
		return instance;
	}
	
	public boolean salvaAloc(Object obj) {
		return this.alocacaoRepository.salvaAloc(obj);
	}
	
	public boolean removeAloc(long id) {
		return this.alocacaoRepository.removeAloc(id);
	}
	
	public Alocacao lerPorID(long id) {
		return this.alocacaoRepository.lerAlocID(id);
	}
	
	public Alocacao[] lerPorPeriodo(String periodo) {
		return this.alocacaoRepository.lerAlocPeriodo(periodo);
	}
	
	public boolean verificaExistencia(long id) {
		return this.alocacaoRepository.verificaExistencia(id);
	}
	
	public boolean updateHorario( long id, Horario nova) {
		return this.alocacaoRepository.updateHorario(id, nova);
	}
	
	public boolean updateProfessor(long id, Professor nova) {
		return this.alocacaoRepository.updateProfessor(id, nova);
	}
	
	public boolean updatePeriodo(long id, String nova) {
		return this.alocacaoRepository.updatePeriodo(id, nova);
	}
	
	public boolean updateDisciplina(long id, Disciplina nova) {
		return this.alocacaoRepository.updateDisciplina(id, nova);
	}
	
	public String listaAlocacoes() {
		return this.alocacaoRepository.listarAlocacoes();
	}
}
