package promsys.realGui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class RemoverProfessor extends Application{
	Stage window;
	private static Pane pane;
	public void start (Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Remover Professor");
		pane = FXMLLoader.load(this.getClass().getResource("removerProfessorFXML.fxml"));
		TextArea texto = (TextArea) pane.getChildren().get(7);
		texto.setEditable(false);
		window.setScene(new Scene(pane));
		window.setResizable(false);
		window.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}