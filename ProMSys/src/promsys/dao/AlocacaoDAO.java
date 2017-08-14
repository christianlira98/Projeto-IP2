package promsys.dao;
import promsys.exceptions.AlocacaoNaoExisteException;
import promsys.negocio.beans.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
public class AlocacaoDAO implements IAlocacaoDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2409610592120285089L;
	private static AlocacaoDAO instance;
	private List<Alocacao> aloc;
	
	private AlocacaoDAO() {
		this.aloc = new ArrayList<Alocacao>();
	}
	
	public static AlocacaoDAO getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static AlocacaoDAO lerDoArquivo() { // IMPLEMENTAÇÃO INCIAL DE ARQUIVOS, DEVE SER REVISADO!
	    AlocacaoDAO instancia = null;

	    File in = new File("Alocacoes.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instancia = (AlocacaoDAO) o;
	    } 
	    catch (Exception e) {
	      instancia = new AlocacaoDAO();
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
	    File out = new File("Alocacoes.dat");
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
	
	public void cadastrar(Alocacao obj) { //Caso alguém crie uma instancia e tente
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
		this.aloc.add(obj);
	}
	
	public void remover(long id) throws AlocacaoNaoExisteException {
		boolean vari = false;
		if(this.existe(id)) {
			if(id >=1) {
				for(int i = 0; i < this.aloc.size() && !vari; i++) {
					if(this.aloc.get(i).getId() == id) {
						this.aloc.remove(i);
						vari = true;
					}
				}
			}
		}
		else {
			throw new AlocacaoNaoExisteException(id);
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
	
	public boolean existe(long id) {
		boolean vari = false;
		for(int i = 0; i < this.aloc.size() && !vari; i++) {
			if(this.aloc.get(i).getId()==id) {
				vari = true;
			}
		}
		return vari;
	}
	
	public boolean existe(Alocacao a) {
		boolean valor = false;
		for(Alocacao alocacao : this.listar()) {
			if(alocacao.equals(a)) {
				valor = true;
			}
		}
		return valor;
	}
	
	public List<Alocacao> listar() {
		return this.aloc;
	}
	
	public String listarTodasAlocacoes() {
		
		String lista = "";
		
		for (int i = 0; i < this.aloc.size(); i++) {
			lista += "**************************************\n" + this.aloc.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
}
