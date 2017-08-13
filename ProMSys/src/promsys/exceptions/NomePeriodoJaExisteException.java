package promsys.exceptions;

import promsys.negocio.beans.Periodo;

public class NomePeriodoJaExisteException extends Exception {
	
	String semestre;
	
	public NomePeriodoJaExisteException(String deNome) {
		super(String.format("Ja existe um Periodo %s.", deNome));
		semestre = deNome;
	}	
	
	public String getPeriodo() {
		return this.semestre;
	}
}
