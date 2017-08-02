package promsys.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Periodo {
	private String semestre;
	private List<Alocacao> alocacoes; 
	private long ID;
	
	public Periodo(String sem) {
		this.semestre = sem;
		this.alocacoes = new ArrayList<>();
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public long getID() {
		return ID;
	}
	
	public void setID(long id) {
		this.ID = id;
	}

	public String toString() {
		String text = String.format( "Semestre: "+getSemestre()+ 
				"\nID: "+getID());
		
		return text;
	}
	
	public boolean equals(Object sem) {
		boolean vari = false;
		if(sem instanceof Periodo && sem!= null) {
			Periodo temp = (Periodo) sem;
			if(temp.getID() == this.getID() && temp.getSemestre().equals(this.getSemestre())) {
				vari = true;
			}
		}
		return vari;
	}
	
	public List<Alocacao> getAlocacoes() {
		return this.alocacoes;
	}
	
}
