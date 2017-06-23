package promsys.negocio;

import promsys.dao.*;
import promsys.negocio.beans.*;

public class HorarioController {
	
	private static HorarioController instance;
	private HorarioDAO horarioRepository;
	
	private HorarioController() {
		this.horarioRepository = HorarioDAO.getInstance();
	}
	
	public HorarioController getInstance() {
		if (instance == null) {
			instance = new HorarioController();
		}
		return instance;
	}
	//CRUD
	public void criarHorarios() {
		this.horarioRepository.cadastraHorarios();
	}
	
	public Horario procurarHorario(int h) {
		return this.horarioRepository.procuraHorario(h);
	}
	
	public String listarHorarios() {
		return this.horarioRepository.listaHorarios();
	}
}