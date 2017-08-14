package promsys.realGui;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class EventosMenuController {
	@FXML
	private ToggleButton botaoPeriodo;
	@FXML
	private ToggleButton botaoDisciplinas;
	@FXML
	private ToggleButton botaoProfessores;
	
	public void abreTelaDisciplinas() {
		botaoDisciplinas.setOnMouseClicked(e -> {
			CadastroDisciplina c = new CadastroDisciplina();
			Pane telaCadastroDisciplinas;
			try {
				telaCadastroDisciplinas = c.getPane();
				Menu.trocarCena(telaCadastroDisciplinas);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void abreTelaProfessores() {
		botaoProfessores.setOnMouseClicked(e -> {
			CadastroProfessor c = new CadastroProfessor();
			Pane telaCadastroProfessores;
			try {
				telaCadastroProfessores = c.getPane();
				Menu.trocarCena(telaCadastroProfessores);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
}
