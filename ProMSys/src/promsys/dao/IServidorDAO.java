package promsys.dao;

import promsys.negocio.beans.Servidor;

public interface IServidorDAO {

	void cadastrar(Servidor admin);
	
	Servidor procurar(long id);
	
	void remover(Servidor admin);
	
	void atualizar(Servidor admin);
}
