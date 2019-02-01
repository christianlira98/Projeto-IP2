package promsys.gui;


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

public class CadastroProfessor extends Application {
	List<Disciplina> lista = new ArrayList<Disciplina>();
	MenuButton menu;
	private static Pane pane;
	public void start(Stage primaryStage) throws Exception {
		
		//Essa parte foi para apenas escrever algo no arquivo de disciplinas, para testar.
		//se a parte disciplina aptas da GUI estava certa.
		//Disciplina dis = new Disciplina("Álgebra ", 23);
		//DisciplinaController.getInstance().cadastrarDisciplina(dis);
		//.........................
		primaryStage.setTitle("Cadastro de Professores");
		pane = FXMLLoader.load(this.getClass().getResource("cadastroProfessorFXML.fxml"));
		menu = (MenuButton) pane.getChildren().get(8);
		adiciona();
		primaryStage.setScene(new Scene(pane));
		primaryStage.setResizable(false);
		primaryStage.show();
		
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
		menu.getItems().addAll(array);
	}
	
	public Pane getPane() throws Exception {
		return pane = FXMLLoader.load(this.getClass().getResource("cadastroProfessorFXML.fxml"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}