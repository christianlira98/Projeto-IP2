package promsys.exceptions;

import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Professor;

public class ProfessorDuasMaisDisciplinasException extends Exception {

	private Disciplina d;
	
	public ProfessorDuasMaisDisciplinasException(Professor p, Disciplina d) {
		super("Um professor não pode ter mais de duas disciplinas aptas."
				+ "\nProfessor: " + p.getNome() + "Disciplina/CodTurma: " + d.getNome() + "/" + d.getCodigoTurma());
		this.d = d;
	}
	
	public Disciplina getDisciplina() {
		return this.d;
	}
}
