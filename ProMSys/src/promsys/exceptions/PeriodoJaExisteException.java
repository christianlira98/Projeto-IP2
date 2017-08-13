package promsys.exceptions;

import promsys.negocio.beans.Periodo;

public class PeriodoJaExisteException extends Exception {

	private Periodo existente;
	
	public PeriodoJaExisteException(Periodo negado) {
		super(String.format("Periodo %s já existe", negado.getSemestre() ));
		this.existente = negado;
	}
	
	public Periodo getExistente() {
		return this.existente;
	}
}
