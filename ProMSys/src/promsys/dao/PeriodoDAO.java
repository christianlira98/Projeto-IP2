            package promsys.dao;
import promsys.negocio.beans.*;
import java.util.List;
import java.util.ArrayList;

public class PeriodoDAO implements IPeriodoDAO{
	private static long nextID = 1;
	private static PeriodoDAO instance;
	private List<Periodo> semestres;
	
	private PeriodoDAO() {
		this.semestres = new ArrayList<>();
	}
	
	public static PeriodoDAO getInstance(String nome) {
		if(instance == null) {
			instance = new PeriodoDAO();
		}
		return instance;
	}
	
	public void cadastrar(Object sem) {
		if(sem instanceof Periodo) {
			Periodo temp = (Periodo) sem;
			semestres.add(temp);
			semestres.get(semestres.size()-1).setID(nextID);
			++nextID;
		}	
	}
	
	public void remover(long id) {
		for(Periodo sem: semestres) {
			if(sem.getID() == id) {
				semestres.remove(sem);
				break;
			}
		}
	}
	
	public Periodo procurar(long id) {
		Periodo vari = null;
		for(Periodo sem: semestres) {
			if(sem.getID() == id) {
				vari = sem;
			}
		}
		return vari;
	}
	
	public void atualizar(long id, String novo) {
		for(Periodo sem: semestres) {
			if(sem.getID() == id) {
				sem.setSemestre(novo);
			}
		}
	}
	
public String listarSemestres() {
		
		String lista = "";
		
		for (int i = 0; i < this.semestres.size(); i++) {
			lista += "**************************************\n" + this.semestres.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
	

}
