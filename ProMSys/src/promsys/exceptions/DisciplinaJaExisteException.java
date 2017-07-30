package promsys.exceptions;

public class DisciplinaJaExisteException extends Exception {

	private long id;
	
	public DisciplinaJaExisteException(long id) {
		super("Disciplina de id " + id + "já existe.");
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
}
