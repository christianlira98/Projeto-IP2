package promsys.dao;

import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.negocio.beans.Disciplina;

public interface IDisciplinaDAO {
	
	void cadastrar(Disciplina d);
	
	Disciplina procurarDisciplina(long id);
	
	Disciplina procurarNomeDisciplina(String nome);
	
	void atualizarNomeDisciplina(long id, String novoNome);
	
	void removerDisciplina(long id) throws DisciplinaNaoExisteException;
	
	void atualizarCargaHoraria(long id, double novaCargaHoraria);
	
	boolean existe(long id);
	
	String listarDisciplinas();
	
	void salvarArquivo();

}
