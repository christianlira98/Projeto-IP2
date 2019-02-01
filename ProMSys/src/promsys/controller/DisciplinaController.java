package promsys.controller;

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
	
	public void cadastrarDisciplina(Disciplina d) throws DisciplinaJaExisteException, DisciplinaCargaInvalidaException {
		if(d == null) {
			throw new IllegalArgumentException("Parâmetro Nulo");
		}
		else {
			if(!existe(d.getId()) && !existe(d.getNome()) && 
					d.getCargaHoraria() >= 15) {
				this.repositorioDisciplina.cadastrar(d);
				this.repositorioDisciplina.salvarArquivo();
			}
			else if(d.getCargaHoraria() < 15) {
				throw new DisciplinaCargaInvalidaException(d.getCargaHoraria());
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
		if(!existe(novoNome)) {
			this.repositorioDisciplina.atualizarNomeDisciplina(id, novoNome);
			this.repositorioDisciplina.salvarArquivo();
		}
	}
	
	public void atualizarCargaHoraria(long id, double cargaHoraria) throws DisciplinaCargaInvalidaException {
		if(cargaHoraria >= 15) {
			this.repositorioDisciplina.atualizarCargaHoraria(id, cargaHoraria);
			this.repositorioDisciplina.salvarArquivo();
		}
		else {
			throw new DisciplinaCargaInvalidaException(cargaHoraria);
		}
	}
	
	public void removerDisciplina(long id) throws DisciplinaNaoExisteException {
		this.repositorioDisciplina.removerDisciplina(id);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public boolean existe(long id) {
		return this.repositorioDisciplina.existe(id);
	}
	
	public void atualizarCodigo(long id,String cod) {
		this.repositorioDisciplina.atualizarCodigo(id, cod);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public boolean existe(String nome) {
		return this.repositorioDisciplina.existe(nome);
	}
	
	public String listarDisciplinas() {
		return this.repositorioDisciplina.listarDisciplinas();
	}

}
