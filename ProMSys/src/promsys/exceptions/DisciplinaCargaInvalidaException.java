package promsys.exceptions;

public class DisciplinaCargaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4585200439846293234L;
	private double cargaHoraria;
	
	public DisciplinaCargaInvalidaException(double cargaHoraria) {
		super("Carga Horaria menor que 15 horas é inválida.");
		this.cargaHoraria = cargaHoraria;
	}
	
	public double getCargaHoraria() {
		return this.cargaHoraria;
	}
}
