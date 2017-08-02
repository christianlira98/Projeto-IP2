package promsys.dao;
import promsys.negocio.beans.*;
import promsys.exceptions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProfessorDAO implements IProfessorDAO, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfessorDAO instance;
	private List<Professor> prof;
	//private List<String> temp = null;
	
	private static ProfessorDAO lerArquivo() {
		ProfessorDAO instance = null;
		File in = new File("Professores.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instance = (ProfessorDAO) o;
		}catch(Exception e) {
			instance = new ProfessorDAO();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {
					
				}
			}
		}
		return instance;
	}
	
	public void escreveArquivo() {
		if(instance == null) {
			return;
		}
		File out = new File("Professores.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oo = null;
		
		try {
			fos = new FileOutputStream(out);
			oo = new ObjectOutputStream(fos);
			oo.writeObject(instance);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(oo != null) {
				try {
					oo.close();
				}catch(IOException e ) {
					
				}
			}
		}
		
	}
	
	
	
	
	private ProfessorDAO() {
		this.prof = new ArrayList<Professor>();
	}	
	public static ProfessorDAO getInstance() {
		if(instance == null) {
			instance = new ProfessorDAO();
		}
		return instance;
	}
	
	public Professor procurarPorNome(String nome) {
		Professor aux = null; // antes era String
		/*if(temp != null) {
			temp = null;
		}*/
		if(nome != null) {
			for(int i = 0; i < this.prof.size(); i++) {
				if(this.prof.get(i).getNome() == nome) {
					aux = this.prof.get(i);
					//temp.add(this.prof.get(i).toString());
				}
			}
		}/*
		if(temp!=null) {
			aux = new String[this.temp.size()];
			for(int i = 0; i < this.temp.size();i++) {
				aux[i] = this.temp.get(i);
			}
		}*/
		return aux;
	}
	
	public void cadastrar(Object obj) {
		 boolean variTemp = false;
		if(obj instanceof Professor && obj!=null) {
			Professor prof = (Professor) obj;
			for(int i = 0; i < this.prof.size() && !variTemp; i++) {
				if(prof.getId() == this.prof.get(i).getId()) {
					variTemp = true;
				}
			}
			if(variTemp == false) {
			this.prof.add(prof);
			}
		}
	}
	
	public void remover(long id) throws ProfessorNaoExisteException{
		boolean vari = false;
		if(id >=1) {
			for(int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == id) {
					prof.remove(i);
					vari = true;
				}
			}
			if(vari == false) {
				throw new ProfessorNaoExisteException(id);
			}
		}
	}
	
	public Professor procurar (long id) {
		Professor novo = null;
		if(id>=1) {
			for (int i = 0; i  < this.prof.size() && novo == null;i++) {
				if(this.prof.get(i).getId() == id) {
					novo = this.prof.get(i);
				}
			}
		}
		return novo;
	}
	
	public void atualizarNome (String nome, long id) throws ProfessorNaoExisteException {
		String vari = null;
		if(nome !=null && id >= 1) {
			for(int i = 0; i < this.prof.size() && vari == null; i++) {
				if(this.prof.get(i).getId() == id) {
					this.prof.get(i).setNome(nome);
					vari = this.prof.get(i).toString();
				}
			}
		}if(vari == null) {
			throw new ProfessorNaoExisteException(id);
		}
	}
	
	public void addPossivelDisciplina(long idprof, Disciplina disciplina) throws ProfessorNaoExisteException, DisciplinaNaoExisteException{
		boolean vari = false;
		boolean variDis = false;
		if(idprof >= 0 && disciplina != null) {
			for( int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idprof) {
					variDis = this.prof.get(i).addDisciplinasPossiveis(disciplina);
					vari = true;
				}
			}
		}if(vari == false) {
			throw new ProfessorNaoExisteException(idprof);
		}
		else if(!variDis) {
			throw new DisciplinaNaoExisteException(disciplina.getId());
		}
	}
	
	
	public void removerPossivelDisciplina(long idProf, long idDisciplina) throws NaoEstaEntreOsPossiveisException, ProfessorNaoExisteException{
		boolean vari = false;
		if(idProf >= 1 && idDisciplina >= 1) {
			for(int i = 0; i < this.prof.size() && !vari; i++) {
				if(this.prof.get(i).getId() == idProf) {
					this.prof.get(i).removeDisciplinaPossivel(idDisciplina);
					vari = true;
				}
			}
		}if(vari == false){
			throw new ProfessorNaoExisteException(idProf);
		}
	}
	
	/*
	private long retornaIndice(long id) {
		long tempIndice = -1;
		for(int i = 0; i < this.prof.size(); i++) {
			if(this.prof.get(i).getId() == id) {
				tempIndice = i;
			}
		}
		return tempIndice;
	}
	*/
	
	public boolean existe(long id) {
		boolean vari = false;
		for(int i = 0; i < this.prof.size() && !vari; i++) {
			if(this.prof.get(i).getId()==id) {
				vari = true;
			}
		}
		return vari;
	}
	
	public String listarProfessores() {
		
		String lista = "";
		
		for (int i = 0; i < this.prof.size(); i++) {
			lista += "**************************************\n" + this.prof.get(i).toString() + "\n";
		}
		
		return lista.toString();
	}
	
	
}