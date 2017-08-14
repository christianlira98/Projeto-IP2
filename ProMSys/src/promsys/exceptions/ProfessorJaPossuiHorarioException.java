package promsys.exceptions;

import promsys.negocio.beans.Horario;
import promsys.negocio.beans.Professor;

public class ProfessorJaPossuiHorarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6534656972690011007L;
	private Professor existente;
	private Horario duplicado;
	
	public ProfessorJaPossuiHorarioException(Professor negado, Horario duplicado) {
		super(String.format("O professor %s já possui uma turma no horário %s",
				negado.getNome(), duplicado) );
		this.existente = negado;
		this.duplicado = duplicado;
	}

	public Professor getExistente() {
		return existente;
	}

	public Horario getDuplicado() {
		return duplicado;
	}
	
	
}
