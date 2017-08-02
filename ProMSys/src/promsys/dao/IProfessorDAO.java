package promsys.dao;

import promsys.negocio.beans.Disciplina;
import promsys.exceptions.*;
import promsys.negocio.beans.Professor;

public interface IProfessorDAO {

	void cadastrar(Object obj);
	
	Professor procurar(long id);
	
	Professor procurarPorNome(String nome);
	
	void atualizarNome(String novoNome, long id) throws ProfessorNaoExisteException;
	
	void addPossivelDisciplina(long id, Disciplina d) throws ProfessorNaoExisteException, DisciplinaNaoExisteException;
	
	void removerPossivelDisciplina(long idProfessor, long idDisciplina) throws NaoEstaEntreOsPossiveisException, ProfessorNaoExisteException;
	
	void remover(long id) throws ProfessorNaoExisteException;
	
	boolean existe(long id);
	
	String listarProfessores();
}
