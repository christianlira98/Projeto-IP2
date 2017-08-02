package promsys.exceptions;

public class ProfessorNaoExisteException extends Exception{
	private long id;
	
	public ProfessorNaoExisteException(long id) {
		super("O professor de id "+id +"N�o existe");
		this.id = id;
	}
	
	public long  getId() {
		return this.id;
	}

}
