package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Professor;
import promsys.realGui.AlertBox;
import promsys.exceptions.*;

public class AlocacaoAtualizarProfessorController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private Button procura;
	@FXML
	private TextField campoNomeProfessor;
	@FXML
	private TextArea espacoProfessor;
	@FXML
	private ChoiceBox<Professor> escolhaProfessor;
	
	private Fachada acesso = Fachada.getInstance();
	private static long idAlocacao;
	
	public static void setId(long id) {
		idAlocacao = id;
	}
	
	public void intialize(long idAlocacao) {
		escolhaProfessor.getItems().addAll(acesso.listarProfessores());
		escolhaProfessor.getSelectionModel().clearSelection();
	}
	
	public void confirma() {
		Professor novo; 
		if(acesso.procurarProf(campoNomeProfessor.getText()) != null) {
			novo = acesso.procurarProf(campoNomeProfessor.getText());
		}
		else {
			novo = escolhaProfessor.getSelectionModel().getSelectedItem();
		}
		try {
			acesso.atualizarProfessorAlocacao(idAlocacao, novo);
			AlertBox.display("Mensagem", "Professor da turma atualizada!");
		}
		catch(ProfessorJaPossuiHorarioException e) {
			campoNomeProfessor.insertText(0, "");
			escolhaProfessor.getSelectionModel().clearSelection();
			AlertBox.display("Erro na atualização", e.getMessage());
		}
		catch(ProfessorDuasMaisDisciplinasException e) {
			campoNomeProfessor.insertText(0, "");
			escolhaProfessor.getSelectionModel().clearSelection();
			AlertBox.display("Erro na atualização", e.getMessage());
		}
	}
	
	public void procurando() {
		procura.setOnMouseClicked(e -> {
			Professor novo = acesso.procurarProf(campoNomeProfessor.getText());
			if(novo != null) {
				espacoProfessor.clear();
				espacoProfessor.insertText(0, novo.toString());
			}
			else {
				espacoProfessor.clear();
				espacoProfessor.insertText(0, "Disciplina não encontrada");
			}
		});
	}
	
	public void mostrarSelecionado() {
		Professor novo = escolhaProfessor.getSelectionModel().getSelectedItem();
		if(novo != null) {
			espacoProfessor.clear();
			espacoProfessor.insertText(0, novo.toString());
		}
	}
	
	public void cancela() {
		cancelaBotao.setOnMouseClicked(e -> {
			campoNomeProfessor.clear();
			escolhaProfessor.getSelectionModel().clearSelection();
			//Volta pra tela anterior
		});
	}
}
