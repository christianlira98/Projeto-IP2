package promsys.negocio.beans;


public class Semestre {
	private String semestre;
	private long ID;
	
	public Semestre(String sem) {
		this.semestre = sem;
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
		if(sem instanceof Semestre && sem!= null) {
			Semestre temp = (Semestre) sem;
			if(temp.getID() == this.getID() && temp.getSemestre().equals(this.getSemestre())) {
				vari = true;
			}
		}
		return vari;
	}
	
	
	
}
