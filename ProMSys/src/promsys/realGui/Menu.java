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
	private static Scene cena;
	private static FXMLLoader loader;
	
	public void start(Stage primaryStage) throws Exception {
		menu = primaryStage;
		
		menu.setTitle("Menu");
<<<<<<< HEAD
		
		pane = FXMLLoader.load(this.getClass().getResource("menu.fxml"));
		
		
=======
		loader = new FXMLLoader(this.getClass().getResource("menu.fxml"));
		pane = (BorderPane) loader.load();
>>>>>>> branch 'master' of https://github.com/omniplatypus/Projeto-IP2.git
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
<<<<<<< HEAD
		//trocarCena(telaCadastroDisciplinas);
		menu.setScene(new Scene(pane));
		menu.setResizable(false);
=======
		trocarCena(pane, telaCadastroDisciplinas);
>>>>>>> branch 'master' of https://github.com/omniplatypus/Projeto-IP2.git
		menu.show();
	}
	
	public static void trocarCena(BorderPane novoPane, Pane novaCena) throws IOException {
		pane = novoPane;
		novaCena.setPrefHeight(560);
		novaCena.setPrefWidth(600);
		pane.setCenter(novaCena);
		menu.setScene(new Scene(pane));
		menu.setResizable(false);		
	}
		public static void main(String[] args) {
		launch(args);
	}
}
