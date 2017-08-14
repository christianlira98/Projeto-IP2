package promsys.dao;

import promsys.exceptions.PeriodoNaoExisteException;
import promsys.negocio.beans.*;
import java.util.List;

import java.io.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class PeriodoDAO implements IPeriodoDAO, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6376263980076175022L;
	private static long nextID = 1;
	private static PeriodoDAO instance;
	private List<Periodo> semestres;
	
	private PeriodoDAO() {
		this.semestres = new ArrayList<>();
	}
	
	public static PeriodoDAO getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static PeriodoDAO lerDoArquivo() { // IMPLEMENTAÇÃO INCIAL DE ARQUIVOS, DEVE SER REVISADO!
	    PeriodoDAO instancia = null;

	    File in = new File("Periodos.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instancia = (PeriodoDAO) o;
	    } 
	    catch (Exception e) {
	      instancia = new PeriodoDAO();
	    } 
	    finally {
	      if (ois != null) {
	        try {
	          ois.close();
	        } catch (IOException e) {/* Silent exception */
	        }
	      }
	    }
	    
	    return instancia;
	}
	
	public void salvarArquivo() {	// IMPLEMENTAÇÃO INICIAL DE ARQUIVOS, DEVE SER REVISADO!
	    if (instance == null) {
	      return;
	    }
	    File out = new File("Periodos.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	          /* Silent */}
	      }
	    }
	  }
	
	public void cadastrar(Object sem) {
		if(sem instanceof Periodo) {
			Periodo temp = (Periodo) sem;
			semestres.add(temp);
			semestres.get(semestres.size()-1).setID(nextID);
			++nextID;
		}	
	}
	
	public void remover(Periodo periodo) throws PeriodoNaoExisteException {
		if(this.existe(periodo)) {
			for(Periodo sem: semestres) {
				if(sem.getID() == periodo.getID()) {
					semestres.remove(sem);
					break;
				}
			}
		}
		else {
			throw new PeriodoNaoExisteException(periodo);
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
	
	public List<Periodo> listar() {
		return this.semestres;
	}
	
	public Boolean existe(Periodo periodo) {
		boolean valor = false;
		for(Periodo o : this.semestres) {
			if(o.equals(periodo) ) {
				valor = true;
			}
		}
		return valor;
	}

}
