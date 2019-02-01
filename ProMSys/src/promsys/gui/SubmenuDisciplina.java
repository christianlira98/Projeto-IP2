package promsys.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SubmenuDisciplina extends Application {

	private static Stage menu;
	Pane layout;
	public static BorderPane pane, borderpane;
	
	public void start(Stage primaryStage) throws Exception {
		menu = primaryStage;
		
		menu.setTitle("Menu Disciplina");
		
		pane = FXMLLoader.load(this.getClass().getResource("submenuDisciplinaFXML.fxml"));
		
		//pane = (BorderPane) loader.load();
		CadastroDisciplina c = new CadastroDisciplina();
		//Pane telaCadastroDisciplinas = c.getPane();
		/*
		telaCadastroDisciplinas.setPrefHeight(540);
		telaCadastroDisciplinas.setPrefWidth(600);
		
		// primeira tela do menu até agora é a do cadastro de Disciplinas. Irá ser mudado.
		pane.setCenter(telaCadastroDisciplinas);			
		menu.sizeToScene();
		menu.setScene(new Scene(pane));
		menu.setResizable(false);
		*/
		//trocarCena(telaCadastroDisciplinas);
		menu.setScene(new Scene(borderpane));
		menu.setResizable(false);
		menu.show();
	}
	
	public static void trocarCena(Pane novaCena) throws IOException {
		novaCena.setPrefHeight(560);
		novaCena.setPrefWidth(600);
		pane.setCenter(novaCena);
		pane.setCenterShape(false);
		menu.setScene(new Scene(pane));
		menu.setResizable(false);		 
	}

	public Pane getPane() throws Exception {
		return pane = FXMLLoader.load(this.getClass().getResource("submenuDisciplinaFXML.fxml"));
	}
		public static void main(String[] args) {
		launch(args);
	}
}
