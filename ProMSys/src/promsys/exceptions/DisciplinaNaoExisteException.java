package promsys.exceptions;

import promsys.negocio.beans.Disciplina;

public class DisciplinaNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8801138637403140523L;
	private long id;
	
	public DisciplinaNaoExisteException(long id) {
		super("Disciplina de id " + id + "não existe");
		this.id = id;
	}
	
	public DisciplinaNaoExisteException(Disciplina negada) {
		super("A Disciplina não existe");
	}
	
	public long getId() {
		return this.id;
	}
}
