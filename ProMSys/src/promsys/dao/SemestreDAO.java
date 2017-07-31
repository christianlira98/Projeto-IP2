package promsys.dao;
import promsys.negocio.beans.*;
import java.util.List;
import java.util.ArrayList;

public class SemestreDAO implements ISemestreDAO{
	private static long nextID = 1;
	private static SemestreDAO instance;
	private List<Semestre> semestres;
	
	private SemestreDAO() {
		this.semestres = new ArrayList<>();
	}
	
	public static SemestreDAO getInstance(String nome) {
		if(instance == null) {
			instance = new SemestreDAO();
		}
		return instance;
	}
	
	public void cadastrar(Object sem) {
		if(sem instanceof Semestre) {
			Semestre temp = (Semestre) sem;
			semestres.add(temp);
			semestres.get(semestres.size()-1).setID(nextID);
			++nextID;
		}	
	}
	
	public void remover(long id) {
		for(Semestre sem: semestres) {
			if(sem.getID() == id) {
				semestres.remove(sem);
				break;
			}
		}
	}
	
	public Semestre procurar(long id) {
		Semestre vari = null;
		for(Semestre sem: semestres) {
			if(sem.getID() == id) {
				vari = sem;
			}
		}
		return vari;
	}
	
	public void atualizar(long id, String novo) {
		for(Semestre sem: semestres) {
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
