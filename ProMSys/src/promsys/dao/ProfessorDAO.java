package promsys.dao;
import promsys.negocio.beans.*;
import promsys.exceptions.*;

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
import java.util.List;
import java.util.ArrayList;

public class ProfessorDAO implements IProfessorDAO, Serializable{
	
	private static final long serialVersionUID = 2722612252827269882L;
	private static ProfessorDAO instance;
	private List<Professor> prof;
	private static long nextId = 1;
	
	public static void leituraNextId () throws IOException {
		String linha = null;
		File arquivo = new File("IdProfessor.dat");
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
		File arquivo = new File("IdProfessor.dat");
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(String.valueOf(getNextId()));
		bw.close();
		fw.close();
	}
	
	private static ProfessorDAO lerArquivo() {
		ProfessorDAO instancia = null;
		File in = new File("Professores.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instancia = (ProfessorDAO) o;
			leituraNextId();
		}catch(Exception e) {
			instancia = new ProfessorDAO();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {/* Silent exception */
					
				}
			}
		}
	
		return instancia;
	}
	
	public void escreveArquivo() {
		if(instance == null) {
			return;
		}
		File out = new File("Professores.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
			escreveNextId();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(oos != null) {
				try {
					oos.close();
				}catch(IOException e ) {/* Silent exception */
					
				}
			}
		}
		
	}
	
	private ProfessorDAO() {
		this.prof = new ArrayList<Professor>();
	}
	
	public static long getNextId() {
		return nextId;
	}
	
	public static ProfessorDAO getInstance() {
		if(instance == null) {
			instance = lerArquivo();
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
				if(this.prof.get(i).getNome().equals(nome)) {
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
	
	public void cadastrar(Professor professor) {
		professor.setId(nextId);
		++nextId;
		this.prof.add(professor);
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
		else {
			throw new ProfessorNaoExisteException(id);
		}
	}
	
	public Professor procurar (long id) {
		boolean encontrou = false;
		int j = 0;
		
		for(int i = 0; i < this.prof.size() && !encontrou; i++) {
			if(id == this.prof.get(i).getId() ) {
				j = i;
				encontrou = true;
			}
		}
		
		if(encontrou == true){
			return this.prof.get(j);
		}
		else{
			return null;
		}
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
	
	public List<Professor> lista() {
		return this.prof;
	}
	
	public boolean estaEntreAptasDis(long idP, long idDis) {
		boolean vari = false;
		for(Professor professor: prof) {
			if(professor.getId() == idP) {
				vari = professor.estaEntreDisAptas(idDis);
				break;
			}
		}
		return vari;
	}
}




