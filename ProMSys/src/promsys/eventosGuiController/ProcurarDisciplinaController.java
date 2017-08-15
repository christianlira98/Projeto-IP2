package promsys.eventosGuiController;




import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;

public class ProcurarDisciplinaController {
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
			if(!tempo.equals(vari) && DisciplinaController.getInstance().existe(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Disciplina p = DisciplinaController.getInstance().procurarDisciplina(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
			else if(!tempo2.equals(vari) && DisciplinaController.getInstance().
					procurarNomeDisciplina(tempo2)!=null) {
				caixaEncontrado.setText("");
				Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(tempo2);
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
			List<Disciplina> temp = new ArrayList<>();
			temp = DisciplinaController.getInstance().retornaListaDisciplina();
			for(Disciplina o: temp) {
				caixaEncontrado.insertText(0,o.toString()+"\n*********************\n");
				
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
