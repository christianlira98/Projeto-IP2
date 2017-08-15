package promsys.realGui;




import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.negocio.ProfessorController;
import promsys.negocio.beans.Professor;

public class ProcurarProfessorController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextField caixaID;
	@FXML
	private TextArea caixaEncontrado;
	@FXML
	private Button procura;
	@FXML
	private TextField CaixaNome;
	@FXML
	private Button ListaTodos;
	
	public void procurando() {
		procura.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Professor p = ProfessorController.getInstance().procurarProf(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
			else if(!tempo2.equals(vari)) {
				Professor p = ProfessorController.getInstance().procurarPorNome(tempo2);
				caixaEncontrado.insertText(0, p.toString());
			}
		});
	}
	
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			stage.close();
		});
	}
	public void listaTodos() {
		ListaTodos.setOnAction(e -> {
			caixaID.setText("");
			CaixaNome.setText("");
			caixaEncontrado.setText("");
			List<Professor> temp = new ArrayList<>();
			temp = ProfessorController.getInstance().lista();
			for(Professor o: temp) {
				caixaEncontrado.insertText(0,o.toString()+"*********************\n");
				
			}
		});
	}
	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			
			Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
}
