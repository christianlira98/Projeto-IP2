package promsys.negocio.beans;

import java.time.LocalDateTime;

public class Horario {
	
	private LocalDateTime hora;
	
	public Horario(int hora) {
		
		this.hora = LocalDateTime.now().withHour(hora);
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = LocalDateTime.now().withHour(hora);
	}
	
	public boolean equals(Horario outro) {
		return this.hora.equals(outro);
	}
	
	public String toString() {
		String hora = String.format("%d:%d", this.hora.getHour(), this.hora.getMinute() );
		return hora;
	}
}
