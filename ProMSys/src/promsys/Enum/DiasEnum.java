package promsys.Enum;

public enum DiasEnum {
	SEGUNDA("Segunda-feira"),
	TERÇA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sábado"),
	DOMINGO("Domingo");
	
	private String nome;
	
	DiasEnum (String nome) {
		this.nome = nome;
	}
	
	public String getNomeDia() {
		return this.nome;
	}
}
