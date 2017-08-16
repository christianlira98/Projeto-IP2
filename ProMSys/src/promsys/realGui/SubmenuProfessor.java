package promsys.realGui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SubmenuProfessor extends Application {

	private static Stage menu;
	Pane layout;
	private static BorderPane pane;
	
	public void start(Stage primaryStage) throws Exception {
		menu = primaryStage;
		
		menu.setTitle("Menu Disciplina");
		
		BorderPane borderpane = FXMLLoader.load(this.getClass().getResource("submenuProfessorFXML.fxml"));
		
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
		return pane = FXMLLoader.load(this.getClass().getResource("submenuProfessorFXML.fxml"));
	}
		public static void main(String[] args) {
		launch(args);
	}
}