package promsys.dao;

import java.util.ArrayList;
import promsys.negocio.beans.Horario;
//
public class HorarioDAO {
	
	private static HorarioDAO instance;
	private ArrayList<Horario> horarios;
	
	public HorarioDAO getInstance() {
		if(instance == null){
			instance = new HorarioDAO();
		}
		return instance;
	}
	
	private HorarioDAO() {
		this.horarios = new ArrayList<Horario>();
	}
	
	/* Eu presumi que horarios são fixos e não deveriam ser criados toda hora, pra cada objeto que precise de um horário.
	 Então usei o método cadastraHorarios pra cadastrar todos os horários fixos a serem usados(das 8:00 as 23:00hrs), 
	 também não vejo o porquê desses horários poderem ser excluídos, já que são fixos de qualquer maneira. As classes que
	 tem um horário como atributo podem ter a mesma hora, então por quê não fazer com que elas tenha o mesmo objeto do tipo Horário? */
	private Horario criaHorario(int h) {
		Horario hora = new Horario(h);
		return hora;
	}
	
	private void salvaHorario(Horario hora) {
		this.horarios.add(hora);
	}
	
	public void cadastraHorarios() {
		for(int i = 8; i < 24; i++) {
			this.salvaHorario(criaHorario(i) );
		}
	}
	
	public Horario procuraHorario(int h) {
		boolean encontrou = false;
		int j = 0;
		
		if( h > 23 ) {
			j = horarios.size() - 1;
		}
		else if( h < 8 ) {
			j = 0;
		}
		
		else{
			for(int i = 0; i < horarios.size() && !encontrou; i++) {
				
				if( h == horarios.get(i).getHora().getHour() ){
					j = i;
					encontrou = true;
				}
				else{
					encontrou = false;
				}
			}
		}
		return this.horarios.get(j);
	}
}
