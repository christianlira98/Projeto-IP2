package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
<<<<<<< HEAD:ProMSys/src/promsys/realGui/EventosMenuController.java
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
=======
import promsys.realGui.CadastroDisciplina;
import promsys.realGui.CadastroProfessor;
import promsys.realGui.Menu;
>>>>>>> master:ProMSys/src/promsys/eventosGuiController/EventosMenuController.java

public class EventosMenuController {
	@FXML
	private Rectangle botaoPeriodo;
	@FXML
	private Label labelPeriodo;
	@FXML
	private Rectangle botaoDisciplinas;
	@FXML
	private Label labelDisciplinas;
	@FXML
	private Rectangle botaoProfessores;
	@FXML
	private Label labelProfessores;
	@FXML
	private Rectangle botaoAjustes;
	
	public void escureceP() {
		botaoPeriodo.setOnMouseEntered(e -> {
			Color c = (Color) botaoPeriodo.getFill();
			botaoPeriodo.setFill(c.darker());
		});
	}
	
	public void clareaP() {
		botaoPeriodo.setOnMouseExited(e -> {
			Color c = (Color) botaoPeriodo.getFill();
			botaoPeriodo.setFill(c.brighter());
		});
	}
	
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

	public void escureceD() {
		botaoDisciplinas.setOnMouseEntered(e -> {
			Color c = (Color) botaoDisciplinas.getFill();
			botaoDisciplinas.setFill(c.darker());
		});
	}

	public void clareaD() {
		botaoDisciplinas.setOnMouseExited(e -> {
			Color c = (Color) botaoDisciplinas.getFill();
			botaoDisciplinas.setFill(c.brighter());
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
	
	public void escurecePf() {
		botaoProfessores.setOnMouseEntered(e -> {
			Color c = (Color) botaoProfessores.getFill();
			botaoProfessores.setFill(c.darker());
		});
	}
	
	public void clareaPf() {
		botaoProfessores.setOnMouseExited(e -> {
			Color c = (Color) botaoProfessores.getFill();
			botaoProfessores.setFill(c.brighter());
		});
	}
	
	public void escureceA() {
		botaoAjustes.setOnMouseEntered(e -> {
			Color c = (Color) botaoAjustes.getFill();
			botaoAjustes.setFill(c.darker());
		});
	}
	
	public void clareaA() {
		botaoAjustes.setOnMouseExited(e -> {
			Color c = (Color) botaoAjustes.getFill();
			botaoAjustes.setFill(c.brighter());
		});
	}
	
}
