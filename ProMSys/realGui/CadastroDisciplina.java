package promsys.realGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroDisciplina extends Application {
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Cadastro de Disciplinas");
		
		Pane pane = FXMLLoader.load(this.getClass().getResource("cadastroDisciplinaFXML.fxml"));
		primaryStage.sizeToScene();
		primaryStage.setScene(new Scene(pane));
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
