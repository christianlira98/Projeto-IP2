package promsys.eventosGuiController;

import javafx.fxml.FXML;


import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.realGui.Menu;
import promsys.realGui.ScreenManager;
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
	@FXML
	private Circle botaoX;
	
	public void abreTelaPeriodo() {
		AlocacoesController p = new AlocacoesController();
		p.initialize();
		ScreenManager.getInstance().showAlocacaoMenu();
	}

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

			try {
				ScreenManager.getInstance().showFormScreen();
				//Menu.pane = FXMLLoader.load(Menu.class.getResource("SubmenuDisciplinaFXML.fxml"));
				//Menu.menu.setScene(new Scene(Menu.pane));

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
	public void escureceBola() {
		botaoX.setOnMouseEntered(e -> {
			Color c = (Color) botaoX.getFill();
			botaoX.setFill(c.darker());
		});
	}
	public void clareiaBola() {
		botaoX.setOnMouseExited(e -> {
			Color c = (Color) botaoX.getFill();
			botaoX.setFill(c.brighter());
		});
	}
	public void sair() {
		botaoX.setOnMouseClicked(e -> {
			ScreenManager.getInstance().showLogin();
		});
	}
	public void abreMenuAjustes() {
		botaoAjustes.setOnMouseClicked(e -> {

			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;

			try {
				ScreenManager.getInstance().showAjustesMenu();
				//Menu.pane = FXMLLoader.load(Menu.class.getResource("SubmenuDisciplinaFXML.fxml"));
				//Menu.menu.setScene(new Scene(Menu.pane));

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

			try {

				//Menu.pane = FXMLLoader.load(Menu.class.getResource("SubmenuProfessorFXML.fxml"));
				//Menu.menu.setScene(new Scene(Menu.pane));
				ScreenManager.getInstance().showProfessorMenu();

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
