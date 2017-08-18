package promsys.eventosGuiController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.realGui.CadastroProfessor;
import promsys.realGui.ProcurarProfessor;
import promsys.realGui.RemoverProfessor;
import promsys.realGui.ScreenManager;

public class menuAjustesController {
	@FXML
	private Rectangle botaoProf;
	@FXML
	private Rectangle botaoDados;
	@FXML
	private Circle bola2;
	@FXML
	private ImageView imagem;
	
	public void escureceBola() {
		bola2.setOnMouseEntered(e -> {
			Color c = (Color) bola2.getFill();
			bola2.setFill(c.darker());
		});
	}
	public void clareiaBola() {
		bola2.setOnMouseExited(e -> {
			Color c = (Color) bola2.getFill();
			bola2.setFill(c.brighter());
		});
	}
	public void bola() {
		bola2.setOnMouseClicked(e -> {
			//Stage stage = (Stage) bola2.getScene().getWindow();
			//RemoverDisciplina var = new RemoverDisciplina();
			
			try {
				///SubmenuDisciplina.pane = FXMLLoader.load(Menu.class.getResource("menu.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu");
				//stage.setResizable(false);
				ScreenManager.getInstance().showTestScreen();
				ScreenManager.getInstance().getMainStage().setTitle("Menu Principal");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void escureceDados() {
		botaoDados.setOnMouseEntered(e -> {
			Color c = (Color) botaoDados.getFill();
			botaoDados.setFill(c.darker());
		});
	}
	
	public void clareiaDados() {
		botaoDados.setOnMouseExited(e -> {
			Color c = (Color) botaoDados.getFill();
			botaoDados.setFill(c.brighter());
		});
	}
	
	public void dados() {
		botaoDados.setOnMouseClicked(e -> {
			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			//Stage stage = (Stage) botaoRemover.getScene().getWindow();
			//RemoverProfessor var = new RemoverProfessor();
			
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showAlteraMeusDados();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	public void atualizarProf() {
		botaoProf.setOnMouseClicked(e -> {
			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			//Stage stage = (Stage) botaoAtualizar.getScene().getWindow();
			
			
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//Pane p = FXMLLoader.load(AtualizarProfessor.class.getResource("AtualizarProfessorFXML.fxml"));
				//AtualizarProfessor var = new AtualizarProfessor();
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				
				//AtualizarProfessor.menu2 = (MenuButton) var.getPane().getChildren().get(11);
				//AtualizarProfessor.menu1 = (MenuButton) var.getPane().getChildren().get(10);
				//AtualizarProfessor.menu2.getItems().addAll(DisciplinasDisponiveis.adiciona());
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//AtualizarProfessor.pane = FXMLLoader.load(AtualizarProfessor.class.getResource("AtualizarProfessorFXML.fxml"));
				//AtualizarProfessor.menu2 = (MenuButton) AtualizarProfessor.pane.getChildren().get(11);
				//AtualizarProfessor.adiciona();
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showAlteraDadosProf();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
	
	public void escureceAtualizar() {
		botaoProf.setOnMouseEntered(e -> {
			Color c = (Color) botaoProf.getFill();
			botaoProf.setFill(c.darker());
		});
	}

	public void clareiaAtualizar() {
		botaoProf.setOnMouseExited(e -> {
			Color c = (Color) botaoProf.getFill();
			botaoProf.setFill(c.brighter());
		});
	}
	
	
	
	
}
