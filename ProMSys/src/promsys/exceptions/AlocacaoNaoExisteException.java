package promsys.exceptions;

import java.io.Serializable;

public class AlocacaoNaoExisteException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4966239089496988610L;
	private long idNegado;
	
	public AlocacaoNaoExisteException(long id) {
		super(String.format("Não existe a alocacao de id %d já existe", id) );
		this.idNegado = id;
	}
	
	public long getNegada() {
		return this.idNegado;
	}
}
