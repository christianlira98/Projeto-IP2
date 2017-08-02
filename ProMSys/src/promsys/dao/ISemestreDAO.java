package promsys.dao;

import promsys.negocio.beans.Periodo;

public interface ISemestreDAO {
	
	void cadastrar(Object sem);
	
	void remover(long id);
	
	void atualizar(long id, String novo);
	
	Periodo procurar(long id);
}
