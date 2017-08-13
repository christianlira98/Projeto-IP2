package promsys.exceptions;
import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Professor;

public class ProfessorDuasMaisDisciplinasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987917184363238613L;
	private Disciplina d;
	
	public ProfessorDuasMaisDisciplinasException(Professor p, Disciplina d) {
		super("Um professor não pode ministrar mais de duas disciplinas."
				+ "\nProfessor: " + p.getNome() + "Disciplina/CodTurma: " + d.getNome() + "/" + d.getCodigoTurma());
		this.d = d;
	}
	
	public ProfessorDuasMaisDisciplinasException(Professor p) {
		super("Um professor não pode ministrar mais de duas disciplinas."
				+ "\nProfessor: " + p.getNome());
	}
	
	public Disciplina getDisciplina() {
		return this.d;
	}
}