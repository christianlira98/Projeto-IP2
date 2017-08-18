package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import promsys.dao.AlocacaoDAO;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Disciplina;
import promsys.realGui.AlertBox;
import promsys.realGui.ScreenManager;

public class AlocacaoAtualizarDisciplinaController {
	@FXML
	private Pane paneDisciplina;
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private Button procura;
	@FXML
	private TextField campoDisciplina;
	@FXML
	private TextArea espacoDisciplina;
	@FXML
	private ChoiceBox<Disciplina> escolhaDisciplinas;
	
	private Fachada acesso = Fachada.getInstance();
	private static long idAlocacao;
	
	public static void setId(long id) {
		idAlocacao = id;
	}
	
	public void intialize(long idAlocacao) {
		escolhaDisciplinas.getItems().addAll(acesso.listaDisciplinas());
		escolhaDisciplinas.getSelectionModel().clearSelection();
	}
	
	public void confirma() {
		Disciplina nova;
		if(acesso.procurarNomeDisciplina(campoDisciplina.getText()) != null) {
			nova = acesso.procurarNomeDisciplina(campoDisciplina.getText());
		}
		else {
			nova = escolhaDisciplinas.getSelectionModel().getSelectedItem(); 
		}
		acesso.atualizarDisciplinaAlocacao(idAlocacao, nova);
		AlocacaoDAO.getInstance().salvarArquivo();
		AlertBox.display("Mensagem", "Disciplina da turma atualizada");
	}
	
	public void procurando() {
		procura.setOnMouseClicked(e -> {
			Disciplina nova = acesso.procurarNomeDisciplina(campoDisciplina.getText());
			if(nova != null) {
				espacoDisciplina.clear();
				espacoDisciplina.insertText(0, nova.toString());
			}
			else {
				espacoDisciplina.clear();
				espacoDisciplina.insertText(0, "Disciplina não encontrada");
			}
		});
	}
	
	public void mostrarSelecionado() {
		Disciplina nova = escolhaDisciplinas.getSelectionModel().getSelectedItem();
		if(nova != null) {
			espacoDisciplina.clear();
			espacoDisciplina.insertText(0, nova.toString());
		}
	}
	
	public void cancela() {
		cancelaBotao.setOnMouseClicked(e -> {
			campoDisciplina.clear();
			escolhaDisciplinas.getSelectionModel().clearSelection();
			ScreenManager.getInstance().setaSubMenuAtualizarAlocCenterNull();
		});
	}
}