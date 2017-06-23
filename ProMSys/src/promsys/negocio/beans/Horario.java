package promsys.negocio.beans;

import java.time.LocalTime;

public class Horario {
	
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	
	public Horario(int hora_inicio, int hora_fim) {
		this.horarioInicio = LocalTime.of(hora_inicio, 0);
		this.horarioFim = LocalTime.of(hora_fim, 0);
	}

	public LocalTime getHorarioInicio() {
		return this.horarioInicio;
	}
	
	public LocalTime getHorarioFim() {
		return this.horarioFim;
	}

	public void setHorarioInicio(int hora, int minutos) {
		this.horarioInicio = LocalTime.of(hora, minutos);
	}
	
	public void setHorarioFim(int hora, int minutos) {
		this.horarioFim = LocalTime.of(hora, minutos);
	}
	
	public boolean equals(Horario outro) {
		
		boolean result = false;
		
		if (outro instanceof Horario && outro != null) {
			if( this.horarioInicio == outro.horarioInicio && this.horarioFim == outro.horarioFim ) {
				result = true;
			}
		}
		return result;
	}
	
	public String toString() {
		String horario = String.format("Início: %s\nFim: %s", this.horarioInicio.toString(), this.horarioFim.toString() );
		return horario;
	}
}
