package promsys.exceptions;

import promsys.negocio.beans.Periodo;

public class PeriodoNaoExisteException extends Exception {
	
	private Periodo periodo;
	
	public PeriodoNaoExisteException(Periodo periodo) {
		super(String.format("O Per�odo %s de id %ld n�o existe", periodo.getSemestre(), periodo.getID()) );
		this.periodo = periodo;
	}
	
	public Periodo getPeriodo() {
		return this.periodo;
	}
}
