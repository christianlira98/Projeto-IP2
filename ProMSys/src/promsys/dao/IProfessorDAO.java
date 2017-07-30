package promsys.dao;

import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Professor;

public interface IProfessorDAO {

	void cadastrar(Object obj);
	
	Professor procurar(long id);
	
	Professor procurarPorNome(String nome);
	
	void atualizarNome(String novoNome, long id);
	
	void addPossivelDisciplina(long id, Disciplina d);
	
	void removerPossivelDisciplina(long idProfessor, long idDisciplina);
	
	void remover(long id);
	
	boolean existe(long id);
	
	String listarProfessores();
}
