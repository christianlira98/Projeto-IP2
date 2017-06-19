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
	
	/* Eu presumi que horarios s�o fixos e n�o deveriam ser criados toda hora, pra cada objeto que precise de um hor�rio.
	 Ent�o usei o m�todo cadastraHorarios pra cadastrar todos os hor�rios fixos a serem usados(das 8:00 as 23:00hrs), 
	 tamb�m n�o vejo o porqu� desses hor�rios poderem ser exclu�dos, j� que s�o fixos de qualquer maneira. As classes que
	 tem um hor�rio como atributo podem ter a mesma hora, ent�o por qu� n�o fazer com que elas tenha o mesmo objeto do tipo Hor�rio? */
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
