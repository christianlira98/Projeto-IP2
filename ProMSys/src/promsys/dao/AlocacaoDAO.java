package promsys.dao;
import promsys.negocio.beans.*;
import java.util.ArrayList;
public class AlocacaoDAO {
	private static AlocacaoDAO instance;
	private ArrayList<Alocacao> aloc = new ArrayList<Alocacao>();
	private ArrayList<Alocacao> temporario = null;
	private AlocacaoDAO() {
		
	}
	
	public static AlocacaoDAO getInstance() {
		if(instance == null) {
			instance = new AlocacaoDAO();
		}
		return instance;
	}
	
	public boolean salvaAloc(Object obj) { //Caso alguém crie uma instancia e tente
											// e tente cadastrar a msm, duas vezes. Isso impede!
		boolean vari = false, variTemp = false;
		if(obj instanceof Alocacao) {
			Alocacao temp = (Alocacao) obj;
			for(int i = 0; i < this.aloc.size() && !variTemp; i++) {
				if(temp.getId() == this.aloc.get(i).getId()) {
					variTemp = true;
				}
			}
			if(variTemp == false) {
				this.aloc.add(temp);
				vari = true;
			}
		}
		return vari;
	}
	
	public boolean removeAloc(long id) {
		boolean vari = false;
		if(id >=1) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.remove(i);
					vari = true;
				}
			}
		}
		return vari;
	}
	
public Alocacao lerAlocID(long id) {
		
		boolean encontrou = false;
		int j = 0;
		
		for(int i = 0; i < this.aloc.size() && !encontrou; i++) {
			if(id == this.aloc.get(i).getId() ) {
				j = i;
				encontrou = true;
			}
		}
		
		if(encontrou == true){
			return this.aloc.get(j);
		}
		else{
			return null;
		}
	}
	

	
	public Alocacao[] lerAlocPeriodo(String periodo) {
		Alocacao[] aux = null;
		if(temporario != null) {
			temporario = null;
		}
		if(periodo != null && !this.aloc.isEmpty()) {
			temporario = new ArrayList<Alocacao>();
			for(int i = 0; i < this.aloc.size(); i++) {
				if(this.aloc.get(i).getPeriodo() == periodo ) {
					System.out.print("faztemporario");
					temporario.add(this.aloc.get(i));
				}
			}
		}
		if(temporario != null) {
			System.out.print(this.temporario.size());
			aux = new Alocacao[this.temporario.size()];
			for(int i = 0; i < this.temporario.size();i++) {
				System.out.print("fazaux");
				aux[i] = this.temporario.get(i);
			}
		}
		return aux;
	}
	
	public boolean updateDisciplina(Long id, Disciplina nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setDisciplina(nova);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	
	public boolean updateProfessor(Long id, Professor nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setProfessor(nova);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean updateHorario(Long id, Horario nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setHorario(nova);
					vari = true;
				}
			}
		}
		return vari;
	}
	
	public boolean updatePeriodo(Long id, String nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setPeriodo(nova);
					vari = true;
				}
			}
		}
		return vari;
	}	
	
	public boolean verificaExistencia(long id) {
		boolean vari = false;
		for(int i = 0; i < this.aloc.size() && !vari; i++) {
			if(this.aloc.get(i).getId()==id) {
				vari = true;
			}
		}
		return vari;
	}
	
public String listarAlocacoes() {
		
		String lista = "";
		
		for (int i = 0; i < this.aloc.size(); i++) {
			lista += "**************************************\n" + this.aloc.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
}
