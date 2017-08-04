package promsys.exceptions;

public class DisciplinaNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8801138637403140523L;
	private long id;
	
	public DisciplinaNaoExisteException(long id) {
		super("Disciplina de id " + id + "já existe");
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
}
