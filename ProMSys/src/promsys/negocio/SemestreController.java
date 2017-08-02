package promsys.negocio;
import promsys.dao.SemestreDAO;
import promsys.negocio.beans.Periodo;

public class SemestreController {
	private SemestreDAO semestreRepositorio;
	private static SemestreController instance;
	
	
	private SemestreController() {
		
	}
	
	public SemestreController getInstance() {
		if(instance == null) {
			instance = new SemestreController();
		}
		return instance;
	}
	
	public void cadastrarSemestre(Periodo sem) {
		this.semestreRepositorio.cadastrar(sem);
	}
	
	public void atualizarSemestre(long id, String novo) {
		this.semestreRepositorio.atualizar(id, novo);
	}
	
	public void removerSemestre(long id) {
		this.semestreRepositorio.remover(id);
	}
	
	public Periodo procurar(long id) {
		return this.semestreRepositorio.procurar(id);
	}
	public String listarTodosSemestres() {
		return this.listarTodosSemestres();
	}
}
