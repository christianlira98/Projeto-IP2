package promsys.negocio;
import java.nio.channels.NetworkChannel;

import javafx.scene.input.DataFormat;
import promsys.dao.PeriodoDAO;
import promsys.negocio.beans.Periodo;

public class PeriodoController {
	private PeriodoDAO repositorioPeriodo;
	private static PeriodoController instance;
	
	
	private PeriodoController() {
		
	}
	
	public PeriodoController getInstance() {
		if(instance == null) {
			instance = new PeriodoController();
		}
		return instance;
	}
	
	public void cadastrarSemestre(Periodo sem) {
		this.repositorioPeriodo.cadastrar(sem);
	}
	
	public void atualizarSemestre(long id, String novo) {
		this.repositorioPeriodo.atualizar(id, novo);
	}
	
	public void removerSemestre(long id) {
		this.repositorioPeriodo.remover(id);
	}
	
	public Periodo procurar(long id) {
		return this.repositorioPeriodo.procurar(id);
	}
	public String listarTodosSemestres() {
		return this.listarTodosSemestres();
	}
}
