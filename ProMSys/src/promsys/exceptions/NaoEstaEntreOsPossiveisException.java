package promsys.exceptions;

public class NaoEstaEntreOsPossiveisException extends Exception{
	private long idDis;
	private long idProf;
	public NaoEstaEntreOsPossiveisException(long idProf,long idDis) {
		super("Disciplina de ID: "+idDis+"N�o � uma das poss�veis do professor de id" +idProf);
		this.idDis = idDis;
	}
	
	public long getIdDis() {
		return this.idDis;
	}
	public long getIdProf() {
		return this.idProf;
	}

}
