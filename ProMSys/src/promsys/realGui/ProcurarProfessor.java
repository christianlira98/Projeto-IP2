package promsys.realGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class ProcurarProfessor extends Application{
	Stage window;
	Pane layout;
	private static Pane pane;
	public void start (Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Procurar Professor");
		pane = FXMLLoader.load(this.getClass().getResource("procurarProfessorFXML.fxml"));
		TextArea texto = (TextArea) pane.getChildren().get(4);
		texto.setEditable(false);
		window.setScene(new Scene(pane));
		window.setResizable(false);
		window.show();
	
	}
	
	public Pane getPane() throws Exception {
		return layout = FXMLLoader.load(this.getClass().getResource("procurarProfessorFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}