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
import promsys.exceptions.AlocacaoJaExisteException;
import promsys.exceptions.MesmoProfessorHorarioException;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Alocacao;
import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Horario;
import promsys.negocio.beans.Professor;
import promsys.realGui.AlertBox;

public class CadastroAlocacaoController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextField caixaDisciplina;
	@FXML
	private TextField nomeProfessor;
	@FXML
	private TextArea espacoProfessor;
	@FXML
	private Button Procura;
	@FXML
	private TextArea espacoDisciplina;
	@FXML
	private ChoiceBox<Integer> escolhaHora;
	@FXML
	private ChoiceBox<String> escolhaDia;
	
	private Fachada acesso = Fachada.getInstance();
	
	public CadastroAlocacaoController() {
		ObservableList<Integer> horarios = FXCollections.observableArrayList();
		for(int i = 8; i < 22; i++) {
			if(i%2 == 0) {
				horarios.add(i);
			}
		}
		ObservableList<String> dias = FXCollections.observableArrayList();
		dias.add("Segunda e Quarta");
		dias.add("Terça e Quinta");
		dias.add("Quarta e Sexta");
		escolhaHora.setItems(horarios);
		escolhaDia.setItems(dias);
	}
	
	public void procuraProfessor() {
		if(nomeProfessor.getText().length() > 0) {
			Professor p = acesso.procurarProf(nomeProfessor.getText());
			
			if(p != null) {
				espacoProfessor.insertText(0, p.toString());
			}
		}
	}
	
	public void procuraDisciplina() {
		if(caixaDisciplina.getText().length() > 0) {
			Disciplina d = acesso.procurarNomeDisciplina(caixaDisciplina.getText());
			
			if(d != null) {
				espacoDisciplina.insertText(0, d.toString());
			}
		}
	}
	
	public void confirma() {
		if(nomeProfessor.getText().length() > 0
				&& caixaDisciplina.getText().length() > 0) {
			Professor p = acesso.procurarProf(nomeProfessor.getText());
			Disciplina d = acesso.procurarNomeDisciplina(caixaDisciplina.getText());
			Horario horario = null;
			int horaInicio = escolhaHora.getSelectionModel().getSelectedItem();
			List<DiasEnum> dias = new ArrayList<>();
			if(escolhaDia.getSelectionModel().getSelectedItem().equals("Segunda e Quarta") ) {
				dias.add(DiasEnum.SEGUNDA);
				dias.add(DiasEnum.QUARTA);
				horario = new Horario(horaInicio, horaInicio+2, dias);
			}
			else if(escolhaDia.getSelectionModel().getSelectedItem().equals("Terça e Quinta") ) {
				dias.add(DiasEnum.TERÇA);
				dias.add(DiasEnum.QUINTA);
				horario = new Horario(horaInicio, horaInicio+2, dias);
			}
			else if(escolhaDia.getSelectionModel().getSelectedItem().equals("Quarta e Sexta") ) {
				dias.add(DiasEnum.TERÇA);
				dias.add(DiasEnum.QUINTA);
				horario = new Horario(horaInicio, horaInicio+2, dias);
			}
			if(p != null && d != null) {
				try{
					Alocacao nova = new Alocacao(p, d, horario);
					acesso.cadastrarAlocacao(nova);
				}
				catch(MesmoProfessorHorarioException m) {
					AlertBox.display("Erro durante nova turma", m.getMessage());
				}
				catch(AlocacaoJaExisteException a) {
					AlertBox.display("Erro durante nova turma", a.getMessage());
				}
			}
		}
		else {
			AlertBox.display("Aviso", "Você deve preencher os campos para tentar criar uma nova turma!");
		}
	}
	
	public void cancela() {
		if(nomeProfessor.getText().length() >= 0 && caixaDisciplina.getText().length() >= 0 
				&& escolhaDia.getSelectionModel().getSelectedItem().length() == 0) {
			nomeProfessor.clear();
			caixaDisciplina.clear();
		}		
	}
}