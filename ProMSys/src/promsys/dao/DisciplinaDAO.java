package promsys.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.negocio.beans.*;

public class DisciplinaDAO implements IDisciplinaDAO, Serializable{
	
	private static DisciplinaDAO instance;
	private ArrayList<Disciplina> disciplinas;
	private static long nextId = 1;
	
	private DisciplinaDAO() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public static IDisciplinaDAO getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static DisciplinaDAO lerDoArquivo() { // IMPLEMENTAÇÃO INCIAL DE ARQUIVOS, DEVE SER REVISADO!
	    DisciplinaDAO instancia = null;

	    File in = new File("Disciplinas.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instancia = (DisciplinaDAO) o;
	    } 
	    catch (Exception e) {
	      instancia = new DisciplinaDAO();
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
	    File out = new File("Disciplinas.dat");
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
	
	public void cadastrar(Disciplina  d) {
		d.setId(nextId);
		nextId++;
		this.disciplinas.add(d);
	}
	
	public Disciplina procurarNomeDisciplina(String nome) {
		boolean encontrou = false;
		Disciplina encontrada = null;
		int count = 0;
		
		for(int i = 1; i<this.disciplinas.size() && !encontrou; i++) {
			if(nome == this.disciplinas.get(i).getNome() ) {
				encontrou = true;
				encontrada = this.disciplinas.get(i);
			}
			else{
				count++;
			}
		}
		
		if(count == this.disciplinas.size()) {
			encontrada = null;
		}
		
		return encontrada;
	}
	
	public Disciplina procurarDisciplina(long id) {
		
		boolean encontrou = false;
		int j = 0;
		
		for(int i = 0; i < this.disciplinas.size() && !encontrou; i++) {
			if(id == this.disciplinas.get(i).getId() ) {
				j = i;
				encontrou = true;
			}
		}
		
		if(encontrou == true){
			return this.disciplinas.get(j);
		}
		else{
			return null;
		}
	}
	
	public void atualizarNomeDisciplina(long id, String novoNome) {
		
		if (this.procurarDisciplina(id) != null) {
			this.procurarDisciplina(id).setNome(novoNome);
		}
	}
	
	public void removerDisciplina(long id) throws DisciplinaNaoExisteException {
		
		if (this.procurarDisciplina(id) != null) {
			Disciplina d = this.procurarDisciplina(id);
			this.disciplinas.remove(d);
		}
	}
	
	public void atualizarCargaHoraria(long id,double novaCargaHoraria) {
		
		if(this.procurarDisciplina(id) != null){
			Disciplina d = this.procurarDisciplina(id);
			d.setCargaHoraria(novaCargaHoraria);
		}
	}
	
	public boolean existe(long id) {
		boolean valor = false;
		
		for (Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				valor = true;
			}
		}
		
		return valor;
	}
	
	public String listarDisciplinas() {
		
		String lista = "";
		
		for (int i = 0; i < this.disciplinas.size(); i++) {
			lista += "**************************************\n" + this.disciplinas.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
}
