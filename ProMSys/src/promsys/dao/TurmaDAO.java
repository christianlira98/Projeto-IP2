package promsys.dao;
import promsys.negocio.beans.*;
import java.util.ArrayList;

public class TurmaDAO {
	private static TurmaDAO instance;
	private ArrayList<Horario> horario = new ArrayList<>(); 
	private ArrayList<Turma> turmas = new ArrayList<>();
	
	private TurmaDAO() {
		this.turmas = new ArrayList<>();
	}
	public static TurmaDAO getInstance() {
		if(instance == null) {
			instance = new TurmaDAO();
		}
		return instance;
	}

	public boolean cadastraTurma(Turma t){
		boolean verifica = false;
		if(turmas != null ) {
			this.turmas.add(t);
			verifica = true;
	}
		return verifica;
	}
	public boolean descadastraTurma(long idTurma){
		boolean verifica = false;
		int c = 0;
		if(idTurma >=1) {
			for(int i = 0; i < this.turmas.size() && c !=-1; i++) {
				if(this.turmas.get(i).getIdTurma() == idTurma) {
					c = -1;
					turmas.remove(i);
					verifica = true;
				}
			}
		}
		return verifica;
	}
	public boolean atualizaTurma(long idTurma, Turma t){
		boolean verifica = false;
		int i =0;
		
		for(i = 0; i < this.turmas.size() ;i++){
			if(this.turmas.get(i).getIdTurma() == idTurma){
				this.turmas.get(i).setProfTurma(t.getProfTurma());
				this.turmas.get(i).setDisciplina(t.getDisciplina());
				this.turmas.get(i).setHorario(t.getHorario());
				this.turmas.get(i).setQtdAlunos(t.getQtdAlunos());
				verifica = true;
			}
		}
		return verifica;
	}


}
