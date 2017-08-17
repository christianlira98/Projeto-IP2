package promsys.eventosGuiController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.realGui.AtualizarProfessor;
import promsys.realGui.CadastroProfessor;
import promsys.realGui.DisciplinasDisponiveis;
import promsys.realGui.Menu;
import promsys.realGui.ProcurarProfessor;
import promsys.realGui.RemoverProfessor;
import promsys.realGui.ScreenManager;
import promsys.realGui.SubmenuDisciplina;
import promsys.realGui.SubmenuProfessor;

public class submenuProfessorController {
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
			//Stage stage = (Stage) bola2.getScene().getWindow();
			//RemoverDisciplina var = new RemoverDisciplina();
			
			try {
				///SubmenuDisciplina.pane = FXMLLoader.load(Menu.class.getResource("menu.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuDisciplina.pane.setCenter(var.getPane());
				//SubmenuDisciplina.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuDisciplina.pane));
				//stage.setTitle("Menu");
				//stage.setResizable(false);
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
			RemoverProfessor var = new RemoverProfessor();
			
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showRemoveProf();
				
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
			
			
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//Pane p = FXMLLoader.load(AtualizarProfessor.class.getResource("AtualizarProfessorFXML.fxml"));
				//AtualizarProfessor var = new AtualizarProfessor();
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				
				//AtualizarProfessor.menu2 = (MenuButton) var.getPane().getChildren().get(11);
				//AtualizarProfessor.menu1 = (MenuButton) var.getPane().getChildren().get(10);
				//AtualizarProfessor.menu2.getItems().addAll(DisciplinasDisponiveis.adiciona());
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//AtualizarProfessor.pane = FXMLLoader.load(AtualizarProfessor.class.getResource("AtualizarProfessorFXML.fxml"));
				//AtualizarProfessor.menu2 = (MenuButton) AtualizarProfessor.pane.getChildren().get(11);
				//AtualizarProfessor.adiciona();
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showAtualizaProf();
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
			ProcurarProfessor var = new ProcurarProfessor();
			
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showProcuraProf();
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
			CadastroProfessor var = new CadastroProfessor();
			try {
				//SubmenuProfessor.pane = FXMLLoader.load(SubmenuProfessor.class.getResource("submenuProfessorFXML.fxml"));
				//var.getPane().setPrefHeight(560);
				//var.getPane().setPrefWidth(600);
				//SubmenuProfessor.pane.setCenter(var.getPane());
				//SubmenuProfessor.pane.setCenterShape(false);
				//stage.setScene(new Scene(SubmenuProfessor.pane));
				//stage.setTitle("Menu Professor");
				//stage.setResizable(false);
				ScreenManager.getInstance().showCadastroProf();
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
