package promsys.realGui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RedefineSenha extends Application{
	Stage window;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setResizable(false);
		Pane pane = FXMLLoader.load(this.getClass().getResource("RedefineSenhaFXML.fxml"));
		window.setScene(new Scene(pane));
		window.setTitle("Redefine Senha");
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}