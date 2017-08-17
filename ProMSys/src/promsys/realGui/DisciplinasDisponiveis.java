package promsys.realGui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckMenuItem;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.Disciplina;

public class DisciplinasDisponiveis {
	private static List<Disciplina> lista = new ArrayList<Disciplina>();
	
	public static CheckMenuItem[] adiciona() {
		List<CheckMenuItem> me = new ArrayList<>();
		if(DisciplinaController.getInstance().retornaListaDisciplina()!=null) { 
			lista = DisciplinaController.getInstance().retornaListaDisciplina();
			for(int i = 0; i < lista.size(); i++) {
				me.add(new CheckMenuItem(lista.get(i).getNome()));
			}
		}
		CheckMenuItem[] array = me.toArray(new CheckMenuItem[me.size()]);
		return array;
	}
}
/*
if(array.length>0) {
	menu2.getItems().addAll(array);
}
*/
