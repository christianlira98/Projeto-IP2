package promsys.realGui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;

public class AtualizarDisciplina extends Application{
	Stage window;
	List<Disciplina> lista = new ArrayList<Disciplina>();
	MenuButton menu2;
	TextField nome;
	TextField id;
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("Atualização de Professor");
		window.setResizable(false);
		Pane pane = FXMLLoader.load(this.getClass().getResource("atualizarDisciplinaFXML.fxml"));
		menu2 = (MenuButton)pane.getChildren().get(10);
		id = (TextField)pane.getChildren().get(2);
		nome = (TextField)pane.getChildren().get(6);
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
				final int x = i;
				me.get(i).setOnAction(e -> {
					if(me.get(x).isSelected()) {
						for(int z = 0; z < me.size(); z++) {
							if(!me.get(z).equals(me.get(x))) {
								me.get(z).setSelected(false);
							}
						}
					}
					nome.setText(me.get(x).getText());
					id.setText(String.valueOf(lista.get(x).getId()));
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
