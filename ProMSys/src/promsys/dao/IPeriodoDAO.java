package promsys.dao;

import promsys.exceptions.PeriodoNaoExisteException;
import promsys.negocio.beans.Periodo;

public interface IPeriodoDAO {
	
	void cadastrar(Object sem);
	
	void remover(Periodo p) throws PeriodoNaoExisteException;
	
	void atualizar(long id, String novo);
	
	Periodo procurar(long id);
}
