package promsys.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroUser extends Application{
	public void start(Stage window) throws Exception{
		Pane pane = FXMLLoader.load(this.getClass().getResource("cadastroUsersFXML.fxml"));
		window.setTitle("Cadastro de Usuário");
		window.setResizable(false);
		window.setScene(new Scene(pane));
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
