package promsys.dao;
import promsys.negocio.beans.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlocacaoDAO implements IAlocacaoDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2409610592120285089L;
	private static AlocacaoDAO instance;
	private Periodo referencia;
	private List<Alocacao> aloc;
	
	private AlocacaoDAO() {
		this.aloc = new ArrayList<Alocacao>();
	}
	
	public static AlocacaoDAO getInstance() {
		if(instance == null) {
			instance = new AlocacaoDAO();
		}
		return instance;
	}
	
	public void cadastrar(Object obj) { //Caso alguém crie uma instancia e tente
											// e tente cadastrar a msm, duas vezes. Isso impede!
		boolean variTemp = false;
		if(obj instanceof Alocacao) {
			Alocacao temp = (Alocacao) obj;
			for(int i = 0; i < this.aloc.size() && !variTemp; i++) {
				if(temp.getId() == this.aloc.get(i).getId()) {
					variTemp = true;
				}
			}
			if(variTemp == false) {
				this.aloc.add(temp);
			}
		}
	}
	
	public void referenciaParaPeriodo(String peri) {
		if(peri == null) {
			return;
		}
		List<Alocacao> aux = new ArrayList<>();
		for(int i = 0; i < this.aloc.size(); i++) {
			if(this.aloc.get(i).getPeriodo().equals(peri)) {
				aux.add(this.aloc.get(i));
			}
		}
		referencia.getReferencia(aux);// Não sei se funciona, mas só quando
		//testarmos dá pra saber.
	}
	
	public void remover(long id) {
		boolean vari = false;
		if(id >=1) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.remove(i);
					vari = true;
				}
			}
		}
	}
	
public Alocacao procurar(long id) {
		
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
	

	
	public List<Alocacao> retornaAlocacoesPeriodo(String periodo) {
		List<Alocacao> temporario = null;
		
		if(periodo != null && !this.aloc.isEmpty()) {
			temporario = new ArrayList<Alocacao>();
			for(int i = 0; i < this.aloc.size(); i++) {
				if(this.aloc.get(i).getPeriodo().equals(periodo)) {
					temporario.add(this.aloc.get(i));
				}
			}
		}

		return temporario;
	}
	
	public void atualizarDisciplina(long id, Disciplina nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setDisciplina(nova);
					vari = true;
				}
			}
		}
	}
	
	
	public void atualizarProfessor(long id, Professor nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setProfessor(nova);
					vari = true;
				}
			}
		}
	}
	
	public void atualizarHorario(long id, Horario nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setHorario(nova);
					vari = true;
				}
			}
		}
	}
	
	public void atualizarPeriodo(long id, String nova) {
		boolean vari = false;
		if(id >=1 && nova!= null) {
			for(int i = 0; i < this.aloc.size() && !vari; i++) {
				if(this.aloc.get(i).getId() == id) {
					this.aloc.get(i).setPeriodo(nova);
					vari = true;
				}
			}
		}
		
	}	
	
	public boolean existe(long id) {
		boolean vari = false;
		for(int i = 0; i < this.aloc.size() && !vari; i++) {
			if(this.aloc.get(i).getId()==id) {
				vari = true;
			}
		}
		return vari;
	}
	
public String listarTodasAlocacoes() {
		
		String lista = "";
		
		for (int i = 0; i < this.aloc.size(); i++) {
			lista += "**************************************\n" + this.aloc.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
}
