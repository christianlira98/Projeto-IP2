package promsys.negocio;

import promsys.dao.*;
import promsys.negocio.beans.Disciplina;
import promsys.exceptions.*;

public class DisciplinaController {

	private IDisciplinaDAO repositorioDisciplina;
	
	public DisciplinaController(IDisciplinaDAO instancia) {
		this.repositorioDisciplina = instancia;
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
