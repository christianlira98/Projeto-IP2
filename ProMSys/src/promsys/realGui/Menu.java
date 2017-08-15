package promsys.realGui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends Application {

	private static Stage menu;
	private static BorderPane pane;
	
	public void start(Stage primaryStage) throws Exception {
		menu = primaryStage;
		
		menu.setTitle("Menu");
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("menu.fxml"));
		
		pane = (BorderPane) loader.load();
		
		CadastroDisciplina c = new CadastroDisciplina();
		Pane telaCadastroDisciplinas = c.getPane();
		/*
		telaCadastroDisciplinas.setPrefHeight(540);
		telaCadastroDisciplinas.setPrefWidth(600);
		
		// primeira tela do menu até agora é a do cadastro de Disciplinas. Irá ser mudado.
		pane.setCenter(telaCadastroDisciplinas);			
		menu.sizeToScene();
		menu.setScene(new Scene(pane));
		menu.setResizable(false);
		*/
		trocarCena(telaCadastroDisciplinas);
		menu.show();
	}
	
	public static void trocarCena(Pane novaCena) throws IOException {
		novaCena.setPrefHeight(540);
		novaCena.setPrefWidth(600);
		pane.setCenter(novaCena);
		menu.setScene(new Scene(pane));
		menu.setResizable(false);		 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
