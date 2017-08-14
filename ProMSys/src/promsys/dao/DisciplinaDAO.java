package promsys.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.negocio.beans.*;
import java.util.List;
public class DisciplinaDAO implements IDisciplinaDAO, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -338246939820102312L;
	private static DisciplinaDAO instance;
	private List<Disciplina> disciplinas;
	private static long nextId = 1;
	
	private DisciplinaDAO() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public static DisciplinaDAO getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	public static void leituraNextId () throws IOException {
		String linha = null;
		File arquivo = new File("IdDisciplina.dat");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		while( br.ready() ){
			linha = br.readLine();
		}
		nextId = Long.parseLong(linha);
		br.close();
		fr.close();
	}
	
	public void escreveNextId () throws IOException {
		File arquivo = new File("IdDisciplina.dat");
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(String.valueOf(nextId));
		bw.close();
		fw.close();
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
	      leituraNextId();
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
	      escreveNextId();
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
		
		for(int i = 0; i<this.disciplinas.size() && !encontrou; i++) {
			if(nome.equals(this.disciplinas.get(i).getNome()) ) {
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
		boolean vari = false;
		if (this.procurarDisciplina(id) != null) {
			Disciplina d = this.procurarDisciplina(id);
			if(d!=null) {
				this.disciplinas.remove(d);
				vari = true;
			}
		}
		if(vari == false) {
			throw new DisciplinaNaoExisteException(id);
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
	
	public boolean existe(String nome) {
		boolean valor = false;
		for (Disciplina disciplina : disciplinas) {
			if(disciplina.getNome().equals(nome)) {
				valor = true;
			}
		}
		return valor;
	}
	
	public List<Disciplina> getLista(){
		if(this.disciplinas == null) {
			return null;
		}
		return this.disciplinas;	
	}
	
	public String listarDisciplinas() {
		
		String lista = "";
		
		for (int i = 0; i < this.disciplinas.size(); i++) {
			lista += "**************************************\n" + this.disciplinas.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
}
