package promsys.exceptions;

public class ProfessorJaExisteNomeException extends Exception {
	
	private String nome;
	
	public ProfessorJaExisteNomeException(String nome) {
		super("O nome do professor do professor não pode ser atualizado porque já existe um professor de nome" + nome);
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
