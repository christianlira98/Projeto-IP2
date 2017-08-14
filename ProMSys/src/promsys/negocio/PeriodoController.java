package promsys.negocio;

import java.util.List;
import promsys.dao.PeriodoDAO;
import promsys.exceptions.NomePeriodoJaExisteException;
import promsys.exceptions.PeriodoJaExisteException;
import promsys.exceptions.PeriodoNaoExisteException;
import promsys.negocio.beans.Periodo;

public class PeriodoController {
	private PeriodoDAO repositorioPeriodo;
	private static PeriodoController instance;
	
	private PeriodoController() {
		this.repositorioPeriodo = PeriodoDAO.getInstance();
	}
	
	public PeriodoController getInstance() {
		if(instance == null) {
			instance = new PeriodoController();
		}
		return instance;
	}
	
	public void cadastrarSemestre(Periodo sem) throws PeriodoJaExisteException {
		if(sem == null) {
			throw new IllegalArgumentException("Parâmetro Nulo");
		}
		else {
			if(!this.existe(sem)) {
				this.repositorioPeriodo.cadastrar(sem);
				this.repositorioPeriodo.salvarArquivo();
			}
			else {
				throw new PeriodoJaExisteException(sem);
			}
		}
	}
	
	public void atualizarSemestre(long id, String novo) throws NomePeriodoJaExisteException {
		boolean existeNome = false;
		
		for(Periodo periodo : this.listar()) {
			if(periodo.getSemestre().equals(novo)) {
				existeNome = true;
			}
		}
		
		if(existeNome == false) {
			this.repositorioPeriodo.atualizar(id, novo);
			this.repositorioPeriodo.salvarArquivo();
		}
		else if(existeNome == true) {
			throw new NomePeriodoJaExisteException(novo);
		}
	}
	
	public void removerSemestre(Periodo periodo) throws PeriodoNaoExisteException {
		this.repositorioPeriodo.remover(periodo);
		this.repositorioPeriodo.salvarArquivo();
	}
	
	public Periodo procurar(long id) {
		return this.repositorioPeriodo.procurar(id);
	}
	
	public String listarTodosSemestres() {
		return this.listarTodosSemestres();
	}
	
	public boolean existe(Periodo periodo) {
		return this.repositorioPeriodo.existe(periodo);
	}
	
	public List<Periodo> listar() {
		return this.repositorioPeriodo.listar();
	}
}