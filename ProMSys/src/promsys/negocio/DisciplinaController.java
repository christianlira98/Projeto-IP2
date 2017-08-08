package promsys.negocio;

import java.util.List;

import promsys.dao.*;
import promsys.negocio.beans.Disciplina;
import promsys.exceptions.*;

public class DisciplinaController {

	private DisciplinaDAO repositorioDisciplina;
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
	
	public void cadastrarDisciplina(Disciplina d) throws DisciplinaJaExisteException {
		if(d == null) {
			throw new IllegalArgumentException("Parâmetro Nulo");
		}
		else {
			if(d.getId() == 0L) {
				this.repositorioDisciplina.cadastrar(d);
				this.repositorioDisciplina.salvarArquivo();
			}
			else {
				throw new DisciplinaJaExisteException(d.getId());
			}
		}
	}
	
	public Disciplina procurarDisciplina(long id) {
		return this.repositorioDisciplina.procurarDisciplina(id);
	}
	
	public Disciplina procurarNomeDisciplina(String nome) {
		return this.repositorioDisciplina.procurarNomeDisciplina(nome);
	}
	
	public List<Disciplina> retornaListaDisciplina() {
		return this.repositorioDisciplina.getLista();
		
	}
	
	public void atualizarDisciplina(long id, String novoNome) {
		this.repositorioDisciplina.atualizarNomeDisciplina(id, novoNome);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public void atualizarCargaHoraria(long id, double cargaHoraria) {
		this.repositorioDisciplina.atualizarCargaHoraria(id, cargaHoraria);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public void removerDisciplina(long id) throws DisciplinaNaoExisteException {
		this.repositorioDisciplina.removerDisciplina(id);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public void existe(long id) {
		this.repositorioDisciplina.existe(id);
	}
	
	public String listarDisciplinas() {
		return this.repositorioDisciplina.listarDisciplinas();
	}

}
