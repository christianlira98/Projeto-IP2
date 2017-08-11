package promsys.exceptions;

public class NaoEstaEntreOsPossiveisException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1031051602434273197L;
	private long idDis;
	private long idProf;
	public NaoEstaEntreOsPossiveisException(long idProf,long idDis) {
		super("Disciplina de ID: "+idDis+"Não é uma das disciplinas aptas do professor de id" +idProf);
		this.idDis = idDis;
	}
	
	public long getIdDis() {
		return this.idDis;
	}
	public long getIdProf() {
		return this.idProf;
	}

}