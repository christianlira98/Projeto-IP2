package promsys.realGui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;

public class AtualizarProfessor extends Application{
	Stage window;
	List<Disciplina> lista = new ArrayList<Disciplina>();
	private static MenuButton menu1;
	MenuButton menu2;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("Atualiza��o de Professor");
		window.setResizable(false);
		Pane pane = FXMLLoader.load(this.getClass().getResource("AtualizarProfessorFXML.fxml"));
		menu1 = (MenuButton)pane.getChildren().get(13);
		menu2 = (MenuButton)pane.getChildren().get(14);
		adiciona();
		window.setScene(new Scene(pane));
		window.show();
	}
	public void adiciona() {
		List<CheckMenuItem> me = new ArrayList<>();
		if(DisciplinaController.getInstance().retornaListaDisciplina()!=null) { 
			lista = DisciplinaController.getInstance().retornaListaDisciplina();
			for(int i = 0; i < this.lista.size(); i++) {
				me.add(new CheckMenuItem(this.lista.get(i).getNome()));
			}
		}
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		menu2.getItems().addAll(array);
	}
	public static void add(List<CheckMenuItem> me) {
		menu1.getItems().removeAll(menu1.getItems());
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		menu1.getItems().addAll(array);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}