package promsys.gui;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class atualizarDadosProfessor extends Application{
	Stage window;
	Pane layout;
	public static Pane pane;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("Atualização de Professor");
		window.setResizable(false);
		pane = FXMLLoader.load(this.getClass().getResource("atualizarDadosProfessorFXML.fxml"));
		window.setScene(new Scene(pane));
		window.show();
	}

	public Pane getPane() throws Exception {
		return layout = FXMLLoader.load(this.getClass().getResource("atualizarDadosProfessorFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
