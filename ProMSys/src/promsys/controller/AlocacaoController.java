package promsys.controller;
import promsys.negocio.beans.*;

import java.time.LocalTime;
import java.util.List;
import promsys.dao.*;
import promsys.exceptions.AlocacaoJaExisteException;
import promsys.exceptions.AlocacaoNaoExisteException;
import promsys.exceptions.MesmoProfessorHorarioException;
import promsys.exceptions.ProfessorDuasMaisDisciplinasException;
import promsys.exceptions.ProfessorJaPossuiHorarioException;

public class AlocacaoController {
	
	/*
	 * private DisciplinaDAO repositorioDisciplina;
	private static DisciplinaController instancia;
	
	private DisciplinaController() {
		this.repositorioDisciplina = DisciplinaDAO.getInstance();
	}
	
	public static DisciplinaController getInstance() {
		if(instancia == null) {
			instancia = new DisciplinaController();
		}
		return instancia;
	}
	 */ /* IMPORTANTE
	 * Deve ser decidido a forma de se chamar um controller; se é atravéz do padrão Singleton, 
	 * ou a criação de uma instancia na fachada. 
	 * Apenas uma delas é a maneira correta de se fazer? Ambas maneiras estão certas?
	 */
	
	private AlocacaoDAO repositorioAlocacao;
	private static AlocacaoController instancia;
	
	private AlocacaoController() {
		this.repositorioAlocacao = AlocacaoDAO.getInstance();
	}
	
	public static AlocacaoController getInstance() {
		if(instancia == null)
			instancia = new AlocacaoController();
		return instancia;
	}
	
	public void cadastrar(Object obj) throws MesmoProfessorHorarioException, AlocacaoJaExisteException {
		if(obj == null || !(obj instanceof Alocacao)) {
			throw new IllegalArgumentException("Parâmetro Nulo");
		}
		else if(obj instanceof Alocacao) {
			Alocacao a = (Alocacao) obj;
			if(!existe(a)) {
				boolean existeMesmoProfessorHorario = false;
				
				for(Alocacao alocacao : this.listar()) {
					if(alocacao.getProfessor().equals(a.getProfessor()) && alocacao.getHorario().equals(a.getHorario())) {
						existeMesmoProfessorHorario = true;
					}
				}
				
				if(existeMesmoProfessorHorario == false) {
					this.repositorioAlocacao.cadastrar(a);
					this.repositorioAlocacao.salvarArquivo();
				}
				
				else if(existeMesmoProfessorHorario == true) {
					throw new MesmoProfessorHorarioException(a);
				}
			}
			else {
				throw new AlocacaoJaExisteException(a);
			}
			
		}
	}
	
	public void remover(long id) throws AlocacaoNaoExisteException {
		this.repositorioAlocacao.remover(id);
	}
	
	public Alocacao lerPorID(long id) {
		return this.repositorioAlocacao.procurar(id);
	}
	
	public boolean verificaExistencia(long id) {
		return this.repositorioAlocacao.existe(id);
	}
	
	public void atualizarHorario(long id, Horario novo) throws MesmoProfessorHorarioException {
		if(novo == null) {
			throw new IllegalArgumentException("Horário Nulo");
		}
		
		else if(novo.getHorarioInicio().isAfter(LocalTime.of(7, 59)) ) { // as aulas começam no min as 8:00
			Alocacao paraAtualizar = this.lerPorID(id);
			if(paraAtualizar != null) {
				
				boolean temMesmoHorario = false;
				
				for(Alocacao alocacao : this.listar()) {
					if(alocacao.getProfessor().equals(paraAtualizar.getProfessor()) ) {
						if(alocacao.getHorario().equals(paraAtualizar.getHorario()) )
								temMesmoHorario = true;
					}
				}
				
				if(temMesmoHorario == true) {
					throw new MesmoProfessorHorarioException(paraAtualizar);
				}
				else if(temMesmoHorario == false) {
					this.repositorioAlocacao.atualizarHorario(id, novo);
					this.repositorioAlocacao.salvarArquivo();
				}
			}
		}
	}
	
	public void atualizarProfessor(long id, Professor novo) throws ProfessorDuasMaisDisciplinasException, ProfessorJaPossuiHorarioException {
		if(novo == null) {
			throw new IllegalArgumentException("Professor nulo");
		}
		
		Alocacao paraAtualizar = this.lerPorID(id);
		if(paraAtualizar != null) {
			
			int turmasDoProfessor = 0;
			boolean possuiTurmaMesmoHorario = false;
			
			for(Alocacao alocacao : this.listar()) {
				if(alocacao.getProfessor().equals(novo)) {
					turmasDoProfessor++;
					if(alocacao.getId() != paraAtualizar.getId() && alocacao.getHorario().equals(paraAtualizar.getHorario()) ) {
						possuiTurmaMesmoHorario = true;
					}
				}
			}
			
			if(turmasDoProfessor < 2 && !possuiTurmaMesmoHorario) {
				this.repositorioAlocacao.atualizarProfessor(id, novo);
				this.repositorioAlocacao.salvarArquivo();
			}
			
			else if(turmasDoProfessor == 2) {
				throw new ProfessorDuasMaisDisciplinasException(novo);
			}
			else if(possuiTurmaMesmoHorario) {
				throw new ProfessorJaPossuiHorarioException(novo, paraAtualizar.getHorario());
			}
		}
		
	}
	
	public void atualizarDisciplina(long id, Disciplina nova) {
		this.repositorioAlocacao.atualizarDisciplina(id, nova);
		this.repositorioAlocacao.salvarArquivo();
	}
	
	public String listarTodasAlocacoes() {
		return this.repositorioAlocacao.listarTodasAlocacoes();
	}
	
	public List<Alocacao> listar() {
		return this.repositorioAlocacao.listar();
	}
	
	public boolean existe(Alocacao a) {
		return this.repositorioAlocacao.existe(a);
	}
}