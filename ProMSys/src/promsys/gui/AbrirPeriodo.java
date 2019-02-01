package promsys.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AbrirPeriodo extends Application {
	Stage window;
	Pane pane;
	public void start(Stage primaryStage) throws Exception {
		pane = FXMLLoader.load(this.getClass().getResource("abrirPeriodoFXML.fxml"));
		window = primaryStage;
		window.setResizable(false);
		window.setScene(new Scene(pane));
		window.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
