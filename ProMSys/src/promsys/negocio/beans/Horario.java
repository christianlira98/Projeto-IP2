package promsys.negocio.beans;
import java.util.List;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import promsys.Enum.*;
public class Horario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8254761103621270774L;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	private List<DiasEnum> diasDaSemana = new ArrayList<>();
	
	public Horario(int hora_inicio, int hora_fim, List<DiasEnum> dia) {
		this.horarioInicio = LocalTime.of(hora_inicio, 0);
		this.horarioFim = LocalTime.of(hora_fim, 0);
		this.diasDaSemana = dia;
	}

	public LocalTime getHorarioInicio() {
		return this.horarioInicio;
	}
	
	public LocalTime getHorarioFim() {
		return this.horarioFim;
	}
	
	public List<DiasEnum> getDiaDaSemana() {
		return this.diasDaSemana;
	}

	public void setHorarioInicio(int hora, int minutos) {
		this.horarioInicio = LocalTime.of(hora, minutos);
	}
	
	public void setHorarioFim(int hora, int minutos) {
		this.horarioFim = LocalTime.of(hora, minutos);
	}
	
	public void addDiaDaSemana(DiasEnum novoDia) {
		this.diasDaSemana.add(novoDia);
	}
	
	public void limparDias() {
		this.diasDaSemana.clear();
	}
	
	public boolean equals(Horario outro) {
		
		boolean result = false;
		
		if (outro instanceof Horario && outro != null) {
			if( this.horarioInicio == outro.getHorarioInicio()&& this.horarioFim == outro.getHorarioFim() && this.diasDaSemana.equals(outro.getDiaDaSemana()) ) {
				result = true;
			}
		}
		return result;
	}
	
	public String toString() {
		String vari = "";
		for(int i = 0; i < diasDaSemana.size();i++) {
			
			if(i == 1 && diasDaSemana.size()==2) {
				vari += diasDaSemana.get(i).getNomeDia() + ";";
			}
			else if(i == 0 && diasDaSemana.size()==2) {
				vari += diasDaSemana.get(i).getNomeDia() + ", ";
			}
			else if(i == 0 && diasDaSemana.size()==1) {
				vari += diasDaSemana.get(i).getNomeDia() + ";";
			}
		}
		String horario = String.format("Início: %s\n"
				+ "Fim: %s\n"
				+ "Dias da semana: %s", this.horarioInicio.toString(), this.horarioFim.toString(), vari);
		return horario;
	}
}
