package promsys.exceptions;

public class JaEstaEntreAsAptasException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2967034160221619306L;
	private long id;
	public JaEstaEntreAsAptasException(long idDis) {
		super("A disciplina de id: "+idDis+" Já é uma das disciplinas aptas");
		this.id = idDis;
	}
	
	public long retornaId() {
		return this.id;
	}
}
