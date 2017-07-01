package promsys.negocio.beans;

import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {
	
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	private ArrayList<String> diasDaSemana = new ArrayList<String>();
	
	public Horario(int hora_inicio, int hora_fim, String diaSemana) {
		this.horarioInicio = LocalTime.of(hora_inicio, 0);
		this.horarioFim = LocalTime.of(hora_fim, 0);
		this.diasDaSemana.add(diaSemana);
	}

	public LocalTime getHorarioInicio() {
		return this.horarioInicio;
	}
	
	public LocalTime getHorarioFim() {
		return this.horarioFim;
	}
	
	public ArrayList<String> getDiaDaSemana() {
		return this.diasDaSemana;
	}

	public void setHorarioInicio(int hora, int minutos) {
		this.horarioInicio = LocalTime.of(hora, minutos);
	}
	
	public void setHorarioFim(int hora, int minutos) {
		this.horarioFim = LocalTime.of(hora, minutos);
	}
	
	public void addDiaDaSemana(String novoDia) {
		this.diasDaSemana.add(novoDia);
	}
	
	public void limparDias() {
		this.diasDaSemana.clear();
	}
	
	public boolean equals(Horario outro) {
		
		boolean result = false;
		
		if (outro instanceof Horario && outro != null) {
			if( this.horarioInicio == outro.horarioInicio && this.horarioFim == outro.horarioFim && this.diasDaSemana.equals(outro.getDiaDaSemana()) ) {
				result = true;
			}
		}
		return result;
	}
	
	public String toString() {
		String horario = String.format("Início: %s\n"
				+ "Fim: %s\n"
				+ "Dias da semana: %s", this.horarioInicio.toString(), this.horarioFim.toString(), this.diasDaSemana.toString() );
		return horario;
	}
}
