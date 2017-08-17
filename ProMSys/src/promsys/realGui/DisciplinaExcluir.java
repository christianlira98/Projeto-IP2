package promsys.realGui;

import java.util.List;

import javafx.scene.control.CheckMenuItem;

public class DisciplinaExcluir {

	public static CheckMenuItem[] add(List<CheckMenuItem> me) {
		if(AtualizarProfessor.menu1.getItems().isEmpty()==true) {
			AtualizarProfessor.menu1.getItems().clear();
		}
			CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
			return array;
	}
}
