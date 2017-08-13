package promsys.exceptions;

import promsys.negocio.beans.Alocacao;

//usada durante as aloca��es
public class MesmoProfessorHorarioException extends Exception {
	
	private static final long serialVersionUID = 4629715378032031584L;
	private Alocacao deHorarioIgual;
	
	public MesmoProfessorHorarioException(Alocacao negada) {
		super(String.format("O professor %s e id %d j� possui uma outra disciplina nesse mesmo hor�rio (%s)\n"
				+ ". Um professor n�o pode ter duas disciplinas em hor�rios iguais.",
				negada.getProfessor().getNome(), negada.getProfessor().getId(), negada.getHorario()) );
		this.deHorarioIgual = negada;
	}
	
	public Alocacao getDeHorarioIgual() {
		return this.deHorarioIgual;
	}
}
