package promsys.eventosGuiController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.gui.AtualizarDisciplina;
import promsys.gui.CadastroDisciplina;
import promsys.gui.CadastroProfessor;
import promsys.gui.Menu;
import promsys.gui.ProcurarDisciplina;
import promsys.gui.RemoverDisciplina;
import promsys.gui.ScreenManager;
import promsys.gui.SubmenuDisciplina;
import promsys.gui.SubmenuProfessor;

public class submenuDisciplinaController {
	@FXML
	private Rectangle botaoCadastrar;
	@FXML
	private Rectangle botaoProcurar;
	@FXML
	private Rectangle botaoAtualizar;
	@FXML
	private Rectangle botaoRemover;
	@FXML
	private Circle bola2;
	@FXML
	private ImageView imagem;
	
	public void escureceBola() {
		bola2.setOnMouseEntered(e -> {
			Color c = (Color) bola2.getFill();
			bola2.setFill(c.darker());
		});
	}
	public void clareiaBola() {
		bola2.setOnMouseExited(e -> {
			Color c = (Color) bola2.getFill();
			bola2.setFill(c.brighter());
		});
	}
	public void bola() {
		bola2.setOnMouseClicked(e -> {
			//RemoverDisciplina var = new RemoverDisciplina();
			
			try {
				///SubmenuDisciplina.pane = FXMLLoader.load(Menu.class.getResource("menu.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				///stage.setScene(new Scene(SubmenuDisciplina.pane));
				///stage.setTitle("Menu");
				///stage.setResizable(false);
				ScreenManager.getInstance().showTestScreen();
				ScreenManager.getInstance().getMainStage().setTitle("Menu Principal");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void escureceCadastro() {
		botaoCadastrar.setOnMouseEntered(e -> {
			Color c = (Color) botaoCadastrar.getFill();
			botaoCadastrar.setFill(c.darker());
		});
	}
	
	public void clareaCadastro() {
		botaoCadastrar.setOnMouseExited(e -> {
			Color c = (Color) botaoCadastrar.getFill();
			botaoCadastrar.setFill(c.brighter());
		});
	}
	
	public void remover() {
		botaoRemover.setOnMouseClicked(e -> {
			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			Stage stage = (Stage) botaoRemover.getScene().getWindow();
			RemoverDisciplina var = new RemoverDisciplina();
			
			try {
				//SubmenuDisciplina.pane = FXMLLoader.load(SubmenuDisciplina.class.getResource("submenuDisciplinaFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu Disciplina");
				//stage.setResizable(false);
				ScreenManager.getInstance().showRemoveDis();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	public void atualizar() {
		botaoAtualizar.setOnMouseClicked(e -> {
			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			Stage stage = (Stage) botaoAtualizar.getScene().getWindow();
			AtualizarDisciplina var = new AtualizarDisciplina();
			
			try {
				//SubmenuDisciplina.pane = FXMLLoader.load(SubmenuDisciplina.class.getResource("submenuDisciplinaFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu Disciplina");
				//stage.setResizable(false);
				ScreenManager.getInstance().showAtualizaDis();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
	public void procurar() {
		botaoProcurar.setOnMouseClicked(e -> {
			//CadastroDisciplina c = new CadastroDisciplina();
			//Pane telaCadastroDisciplinas;
			Stage stage = (Stage) botaoProcurar.getScene().getWindow();
			ProcurarDisciplina var = new ProcurarDisciplina();
			
			try {
				//SubmenuDisciplina.pane = FXMLLoader.load(SubmenuDisciplina.class.getResource("submenuDisciplinaFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu Disciplina");
				//stage.setResizable(false);
				ScreenManager.getInstance().showProcuraDis();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
	public void escureceAtualizar() {
		botaoAtualizar.setOnMouseEntered(e -> {
			Color c = (Color) botaoAtualizar.getFill();
			botaoAtualizar.setFill(c.darker());
		});
	}

	public void clareaAtualizar() {
		botaoAtualizar.setOnMouseExited(e -> {
			Color c = (Color) botaoAtualizar.getFill();
			botaoAtualizar.setFill(c.brighter());
		});
	}
	
	public void cadastrar() throws IOException {
		botaoCadastrar.setOnMouseClicked(e -> {
			Stage stage = (Stage) botaoCadastrar.getScene().getWindow();
			CadastroDisciplina var = new CadastroDisciplina();
			try {
				//SubmenuDisciplina.pane = FXMLLoader.load(SubmenuDisciplina.class.getResource("submenuDisciplinaFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu Disciplina");
				//stage.setResizable(false);
				ScreenManager.getInstance().showCadastroDis();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void escureceRemover() {
		botaoRemover.setOnMouseEntered(e -> {
			Color c = (Color) botaoRemover.getFill();
			botaoRemover.setFill(c.darker());
		});
	}
	
	public void clareaRemover() {
		botaoRemover.setOnMouseExited(e -> {
			Color c = (Color) botaoRemover.getFill();
			botaoRemover.setFill(c.brighter());
		});
	}
	
	public void escureceProcurar() {
		botaoProcurar.setOnMouseEntered(e -> {
			Color c = (Color) botaoProcurar.getFill();
			botaoProcurar.setFill(c.darker());
		});
	}
	
	public void clareaProcurar() {
		botaoProcurar.setOnMouseExited(e -> {
			Color c = (Color) botaoProcurar.getFill();
			botaoProcurar.setFill(c.brighter());
		});
	}
	
}
