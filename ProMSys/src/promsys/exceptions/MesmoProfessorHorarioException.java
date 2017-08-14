package promsys.exceptions;

import promsys.negocio.beans.Alocacao;

//usada durante as alocações
public class MesmoProfessorHorarioException extends Exception {
	
	private static final long serialVersionUID = 4629715378032031584L;
	private Alocacao deHorarioIgual;
	
	public MesmoProfessorHorarioException(Alocacao negada) {
		super(String.format("O professor %s e id %d já possui uma outra disciplina nesse mesmo horário (%s)\n"
				+ ". Um professor não pode ter duas disciplinas em horários iguais.",
				negada.getProfessor().getNome(), negada.getProfessor().getId(), negada.getHorario()) );
		this.deHorarioIgual = negada;
	}
	
	public Alocacao getDeHorarioIgual() {
		return this.deHorarioIgual;
	}
}
