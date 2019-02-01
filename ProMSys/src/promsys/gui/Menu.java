package promsys.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends Application {

	public static Stage menu;
	public static BorderPane borderpane, pane;
	private static Scene cena;
	private static FXMLLoader loader;
	
	public void start(Stage primaryStage) throws Exception {
		menu = primaryStage;
		
		menu.setTitle("Menu");
		
		
		
		pane = FXMLLoader.load(this.getClass().getResource("menu.fxml"));
		CadastroDisciplina c = new CadastroDisciplina();
		//Pane telaCadastroDisciplinas = c.getPane();
		/*
		telaCadastroDisciplinas.setPrefHeight(540);
		telaCadastroDisciplinas.setPrefWidth(600);
		
		// primeira tela do menu at� agora � a do cadastro de Disciplinas. Ir� ser mudado.
		pane.setCenter(telaCadastroDisciplinas);			
		menu.sizeToScene();
		menu.setScene(new Scene(pane));
		menu.setResizable(false);
		*/

		//trocarCena(telaCadastroDisciplinas);
		menu.setScene(new Scene(pane));
		menu.setResizable(false);
		menu.show();

		//trocarCena(pane, telaCadastroDisciplinas);
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
		public static void main(String[] args) {
		launch(args);
	}
}
