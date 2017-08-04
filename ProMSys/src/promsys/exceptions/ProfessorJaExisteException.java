package promsys.exceptions;

public class ProfessorJaExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9056682545448365004L;
	private long id;
	public ProfessorJaExisteException(long id) {
		super("O professor de id "+id+" Já existe");
		this.id = id;
	}
	public long getId() {
		return this.id;
	}

}
