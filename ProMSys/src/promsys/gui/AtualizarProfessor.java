package promsys.gui;

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
import promsys.controller.DisciplinaController;
import promsys.negocio.beans.Disciplina;

public class AtualizarProfessor extends Application{
	Stage window;
	static Pane layout;
	public static Pane pane;
	private List<Disciplina> lista = new ArrayList<Disciplina>();
	public static MenuButton menu1;
	public static MenuButton menu2;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("Atualização de Professor");
		window.setResizable(false);
		pane = FXMLLoader.load(this.getClass().getResource("AtualizarProfessorFXML.fxml"));
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
		if(array.length>0) {
			menu2.getItems().addAll(array);
		}
	}
	public static void add(List<CheckMenuItem> me) {
		if(menu1.getItems().isEmpty()==true) {
			menu1.getItems().clear();
		}
			CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
			menu1.getItems().addAll(array);
		
		
	}
	public static Pane getPane() throws Exception {
		return layout = FXMLLoader.load(AtualizarProfessor.class.getResource("AtualizarProfessorFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
