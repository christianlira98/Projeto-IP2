package promsys.realGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroDisciplina extends Application {
	
	private static Pane pane;
	
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Cadastro de Disciplinas");
		
		pane = FXMLLoader.load(this.getClass().getResource("cadastroDisciplinaFXML.fxml"));
		primaryStage.sizeToScene();
		primaryStage.setScene(new Scene(pane));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public Pane getPane() throws Exception {
		return pane = FXMLLoader.load(this.getClass().getResource("cadastroDisciplinaFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
