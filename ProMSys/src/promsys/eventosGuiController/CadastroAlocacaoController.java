package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import promsys.Enum.DiasEnum;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Horario;
import promsys.negocio.beans.Professor;

public class CadastroAlocacaoController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextField caixaProfessor;
	@FXML
	private TextField nomeProfessor;
	@FXML
	private TextArea espacoProfessor;
	@FXML
	private Button Procura;
	@FXML
	private TextArea espacoDisciplina;
	@FXML
	private ChoiceBox<Horario> escolhaHora;
	@FXML
	private ChoiceBox<DiasEnum> escolhaDia;
	
	private Fachada acesso = Fachada.getInstance();
	
	public void procuraProfessor() {
		if(caixaProfessor.getText().length() > 0) {
			Professor p = acesso.procurarProf(caixaProfessor.getText());
			
			if(p != null) {
				espacoProfessor.insertText(0, p.toString());
			}
		}
	}
}