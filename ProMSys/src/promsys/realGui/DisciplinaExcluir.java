package promsys.realGui;

import java.util.List;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;

public class DisciplinaExcluir {

	public static void add(List<CheckMenuItem> me, MenuButton b) {
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		if(b.getItems().size()>0) {
			b.getItems().clear();
		}
		
			b.getItems().addAll(array);

		

	}
}
