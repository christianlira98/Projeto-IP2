package promsys.Enum;

public enum DiasEnum {
	SEGUNDA("Segunda-feira"),
	TER�A("Ter�a-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("S�bado"),
	DOMINGO("Domingo");
	
	private String nome;
	
	DiasEnum (String nome) {
		this.nome = nome;
	}
	
	public String getNomeDia() {
		return this.nome;
	}
}
