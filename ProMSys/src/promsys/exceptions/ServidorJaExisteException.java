package promsys.exceptions;

public class ServidorJaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	public ServidorJaExisteException(long id) {
		super("O servidor de id "+id+" já existe.");
		this.id = id;
	}
	public long getId() {
		return this.id;
	}
}
