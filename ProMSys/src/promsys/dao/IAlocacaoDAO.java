package promsys.dao;

import java.util.List;

import promsys.exceptions.AlocacaoNaoExisteException;
import promsys.negocio.beans.*;

public interface IAlocacaoDAO {
		
	void cadastrar(Alocacao obj);
	
	Alocacao procurar(long id);
	
	void atualizarDisciplina(long id, Disciplina nova);
	
	void atualizarProfessor(long id, Professor novo);
	
	void atualizarHorario(long id, Horario novo);
	
	void atualizarPeriodo(long id, String novo);
	
	void remover(long id) throws AlocacaoNaoExisteException;
	
	boolean existe(long id);
	
	List<Alocacao> retornaAlocacoesPeriodo(String periodo);
	
	String listarTodasAlocacoes();
}
