package promsys.exceptions;

public class ProfessorJaExisteNomeException extends Exception {
	
	private String nome;
	
	public ProfessorJaExisteNomeException(String nome) {
		super("O nome do professor do professor n�o pode ser atualizado porque j� existe um professor de nome" + nome);
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
