package promsys.exceptions;

public class ServidorNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834549136892132433L;
	private long id;
	
	public ServidorNaoExisteException(long id) {
		super("O servidor de id: "+ id +" não existe.");
		this.id = id;
	}
	public long getId() {
		return this.id;
	}
}
