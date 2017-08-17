package promsys.eventosGuiController;




import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;
import promsys.realGui.DisciplinasDisponiveis;
import promsys.realGui.ScreenManager;

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
	@FXML
	private MenuButton adicionar;
	
	public void add () {
		adicionar.setOnMouseClicked(e ->{
			if(adicionar.getItems().isEmpty()) {
				adicionar.getItems().addAll(DisciplinasDisponiveis.adiciona());
			}
		});
	}
	
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
			else {

				for(int i = 0; i < adicionar.getItems().size();i++) {
					CheckMenuItem temp;
					temp = (CheckMenuItem) adicionar.getItems().get(i);
					if(temp.isSelected()) {
						Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText());
						caixaEncontrado.insertText(0,p.toString()+"\n*********************\n");
					}
				}
			}
		});
	}
	
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			ScreenManager.getInstance().setaDisciplinaCenterNull();
			//Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			//stage.close();
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
			ScreenManager.getInstance().setaDisciplinaCenterNull();
			//Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			//stage.close();
		});
	}
	
}
