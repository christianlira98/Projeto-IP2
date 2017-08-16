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
	Pane layout;
	List<Disciplina> lista = new ArrayList<Disciplina>();
	private static MenuButton menu1;
	MenuButton menu2;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("Atualização de Professor");
		window.setResizable(false);
		Pane pane = FXMLLoader.load(this.getClass().getResource("AtualizarProfessorFXML.fxml"));
		menu1 = (MenuButton)pane.getChildren().get(10);
		menu2 = (MenuButton)pane.getChildren().get(11);
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
		if(me.size()>0) {
			menu1.getItems().removeAll(menu1.getItems());
		}
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		menu1.getItems().addAll(array);
	}
	public Pane getPane() throws Exception {
		return layout = FXMLLoader.load(this.getClass().getResource("AtualizarProfessorFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
