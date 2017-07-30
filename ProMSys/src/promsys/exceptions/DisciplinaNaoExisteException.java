package promsys.exceptions;

public class DisciplinaNaoExisteException extends Exception {

	private long id;
	
	public DisciplinaNaoExisteException(long id) {
		super("Disciplina de id " + id + "j� existe");
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
}
