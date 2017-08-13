package promsys.exceptions;

import promsys.negocio.beans.Alocacao;

public class AlocacaoJaExisteException extends Exception {
	
	private Alocacao existente;
	
	public AlocacaoJaExisteException(Alocacao negada) {
		super("Esse alocacao j� existe");
		this.existente = negada;
	}
	
	public Alocacao getExistente() {
		return this.existente;
	}
}
