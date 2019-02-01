package promsys.eventosGuiController;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import promsys.Enum.DiasEnum;
import promsys.dao.AlocacaoDAO;
import promsys.exceptions.AlocacaoJaExisteException;
import promsys.exceptions.MesmoProfessorHorarioException;
import promsys.fachada.Fachada;
import promsys.gui.AlertBox;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Alocacao;
import promsys.negocio.beans.Horario;

public class AlocacaoAtualizarHorarioController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextArea espacoTurma;
	@FXML
	private TextArea espacoDisciplina;
	@FXML
	private ChoiceBox<Integer> escolhaHora;
	@FXML
	private ChoiceBox<String> escolhaDia;
	
	private Fachada fachada = Fachada.getInstance();
	private static long idAlocacao;
	
	public static void setId(long id) {
		idAlocacao = id;
	}
	
	public void initialize() {
		ObservableList<Integer> horarios = FXCollections.observableArrayList();
		for(int i = 8; i < 22; i++) {
			if(i%2 == 0) {
				horarios.add(i);
			}
		Alocacao a = fachada.lerAlocacoPorID(idAlocacao);
		if(a!= null) {
			espacoTurma.insertText(0, a.toString());
		}
		}
		ObservableList<String> dias = FXCollections.observableArrayList();
		dias.add("Segunda e Quarta");
		dias.add("Terça e Quinta");
		dias.add("Quarta e Sexta");
		escolhaHora.setItems(horarios);
		escolhaDia.setItems(dias);
	}
	
	public void confirma() {
		Horario novoHorario = null;
		int horaInicio = escolhaHora.getSelectionModel().getSelectedItem();
		List<DiasEnum> dias = new ArrayList<>();
		if(escolhaDia.getSelectionModel().getSelectedItem().equals("Segunda e Quarta") ) {
			dias.add(DiasEnum.SEGUNDA);
			dias.add(DiasEnum.QUARTA);
			novoHorario = new Horario(horaInicio, horaInicio+2, dias);
		}
		else if(escolhaDia.getSelectionModel().getSelectedItem().equals("Terça e Quinta") ) {
			dias.add(DiasEnum.TERÇA);
			dias.add(DiasEnum.QUINTA);
			novoHorario = new Horario(horaInicio, horaInicio+2, dias);
		}
		else if(escolhaDia.getSelectionModel().getSelectedItem().equals("Quarta e Sexta") ) {
			dias.add(DiasEnum.TERÇA);
			dias.add(DiasEnum.QUINTA);
			novoHorario = new Horario(horaInicio, horaInicio+2, dias);
		}
		try{
			fachada.atualizarHorarioAlocacao(idAlocacao, novoHorario);
			AlocacaoDAO.getInstance().salvarArquivo();
			ScreenManager.getInstance().showAtualizarAlocacao();
		}
		catch(MesmoProfessorHorarioException m) {
			AlertBox.display("Erro durante nova turma", m.getMessage());
		}
	}
	
	public void cancela() {
		cancelaBotao.setOnMouseClicked(e -> {
			ScreenManager.getInstance().setaSubMenuAtualizarAlocCenterNull();
		});
	}
}
