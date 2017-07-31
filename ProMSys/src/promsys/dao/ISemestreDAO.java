package promsys.dao;

import promsys.negocio.beans.Semestre;

public interface ISemestreDAO {
	
	void cadastrar(Object sem);
	
	void remover(long id);
	
	void atualizar(long id, String novo);
	
	Semestre procurar(long id);
}
