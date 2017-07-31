package promsys.negocio;
import promsys.negocio.beans.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
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
