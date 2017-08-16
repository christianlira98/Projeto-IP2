package promsys.eventosGuiController;

import javafx.fxml.FXML;


import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.realGui.Menu;
import promsys.realGui.SubmenuDisciplina;
import promsys.realGui.SubmenuProfessor;

public class EventosMenuController {
	@FXML
	private Rectangle botaoPeriodo;
	@FXML
	private Label labelPeriodo;
	@FXML
	private Rectangle botaoDisciplinas;
	@FXML
	private Label labelDisciplinas;
	@FXML
	private Rectangle botaoProfessores;
	@FXML
	private Label labelProfessores;
	@FXML
	private Rectangle botaoAjustes;
	
	public void escureceP() {
		botaoPeriodo.setOnMouseEntered(e -> {
			Color c = (Color) botaoPeriodo.getFill();
			botaoPeriodo.setFill(c.darker());
		});
	}
	
	public void clareaP() {
		botaoPeriodo.setOnMouseExited(e -> {
			Color c = (Color) botaoPeriodo.getFill();
			botaoPeriodo.setFill(c.brighter());
		});
	}
	
	public void abreTelaDisciplinas() {
		botaoDisciplinas.setOnMouseClicked(e -> {

			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			Stage stage = (Stage) botaoDisciplinas.getScene().getWindow();
			SubmenuDisciplina var = new SubmenuDisciplina();
			

			try {

				stage.setScene(new Scene(var.getPane()));

				Pane telaCadastroDisciplinas = FXMLLoader.load(this.getClass().getResource("/promsys/realGui/cadastroDisciplinaFXML.fxml"));
				BorderPane novoPane = (BorderPane) FXMLLoader.load(this.getClass().getResource("/promsys/realGui/menu.fxml"));
				Menu.trocarCena(novoPane, telaCadastroDisciplinas);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	public void escureceD() {
		botaoDisciplinas.setOnMouseEntered(e -> {
			Color c = (Color) botaoDisciplinas.getFill();
			botaoDisciplinas.setFill(c.darker());
		});
	}

	public void clareaD() {
		botaoDisciplinas.setOnMouseExited(e -> {
			Color c = (Color) botaoDisciplinas.getFill();
			botaoDisciplinas.setFill(c.brighter());
		});
	}
	
	public void abreTelaProfessores() {
		botaoProfessores.setOnMouseClicked(e -> {

			Stage stage = (Stage) botaoProfessores.getScene().getWindow();
			SubmenuProfessor var = new SubmenuProfessor();
			


			try {

				stage.setScene(new Scene(var.getPane()));

				Pane telaCadastroProfessores = FXMLLoader.load(this.getClass().getResource("/promsys/realGui/cadastroProfessorFXML.fxml"));
				BorderPane novoPane = (BorderPane) FXMLLoader.load(this.getClass().getResource("/promsys/realGui/menu.fxml"));
				Menu.trocarCena(novoPane, telaCadastroProfessores);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void escurecePf() {
		botaoProfessores.setOnMouseEntered(e -> {
			Color c = (Color) botaoProfessores.getFill();
			botaoProfessores.setFill(c.darker());
		});
	}
	
	public void clareaPf() {
		botaoProfessores.setOnMouseExited(e -> {
			Color c = (Color) botaoProfessores.getFill();
			botaoProfessores.setFill(c.brighter());
		});
	}
	
	public void escureceA() {
		botaoAjustes.setOnMouseEntered(e -> {
			Color c = (Color) botaoAjustes.getFill();
			botaoAjustes.setFill(c.darker());
		});
	}
	
	public void clareaA() {
		botaoAjustes.setOnMouseExited(e -> {
			Color c = (Color) botaoAjustes.getFill();
			botaoAjustes.setFill(c.brighter());
		});
	}
	
}
