package promsys.realGui;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;



public class RemoverDisciplina extends Application{
	Stage window;
	List<Disciplina> lista = new ArrayList<Disciplina>();
	MenuButton menu2;
	TextField nome;
	TextField id;
	private static Pane pane;
	public void start (Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Remover Disciplina");
		pane = FXMLLoader.load(this.getClass().getResource("removerDisciplinaFXML.fxml"));
		TextArea texto = (TextArea) pane.getChildren().get(4);
		menu2 = (MenuButton) pane.getChildren().get(9);
		nome = (TextField) pane.getChildren().get(2);
		id = (TextField) pane.getChildren().get(7);
		adiciona();
		texto.setEditable(false);
		window.setScene(new Scene(pane));
		window.setResizable(false);
		window.show();
	
	}
	
	public void adiciona() {
		List<CheckMenuItem> me = new ArrayList<>();
		if(DisciplinaController.getInstance().retornaListaDisciplina()!=null) { 
			lista = DisciplinaController.getInstance().retornaListaDisciplina();
			for(int i = 0; i < this.lista.size(); i++) {
				me.add(new CheckMenuItem(this.lista.get(i).getNome()));
				final int x = i;
				me.get(i).setOnAction(e -> {
					if(me.get(x).isSelected()) {
						for(int z = 0; z < me.size(); z++) {
							if(!me.get(z).equals(me.get(x))) {
								me.get(z).setSelected(false);
							}
						}
					}
					id.setText(me.get(x).getText());
					nome.setText(String.valueOf(lista.get(x).getId()));
				});
			}
		}
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		menu2.getItems().addAll(array);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}