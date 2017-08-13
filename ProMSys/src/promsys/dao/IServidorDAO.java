package promsys.dao;

import java.util.List;

import promsys.exceptions.ServidorJaExisteException;
import promsys.exceptions.ServidorNaoExisteException;
import promsys.negocio.beans.Servidor;

public interface IServidorDAO {

	ServidorDAO lerArquivo();
	
	void escreveArquivo();
	
	void cadastrar(Servidor admin);
	
	Servidor procurar(long id);
	
	void remover(Servidor admin) throws ServidorNaoExisteException;
	
	void atualizar(Servidor admin);
	
	List<Servidor> listar();

}
