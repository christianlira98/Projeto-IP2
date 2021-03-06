package promsys.eventosGuiController;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import promsys.Enum.DiasEnum;
import promsys.fachada.Fachada;
import promsys.gui.AlertBox;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Alocacao;

public class submenuAtualizarController {
	@FXML
	private TableView<Alocacao> tabelaAlocacoes;
	@FXML
	private TableColumn<Alocacao, String> horaColumn;
	@FXML
	private TableColumn<Alocacao, String> diaColumn;
	@FXML
	private TableColumn<Alocacao, String> disciplinaColumn;
	@FXML
	private TableColumn<Alocacao, String> professorColumn;
	@FXML
	private TableColumn<Alocacao, String> codTurmaColumn;
	@FXML
	private Rectangle botaoHorario;
	@FXML
	private Rectangle botaoDisciplina;
	@FXML
	private Rectangle botaoProfessor;
	@FXML
	private Circle bola2;
	
	private ObservableList<Alocacao> tab = FXCollections.observableArrayList();
	private Fachada acesso = Fachada.getInstance();
	
	public submenuAtualizarController() {
		for(Alocacao a : acesso.listarAlocacoes()) {
			tab.add(a);
		}
	}
	
	@FXML
	public void initialize() {
		
		horaColumn = new TableColumn<>("Hora");
        horaColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getHorario().getHorarioInicio().toString());
        	return s;
        });
        
        diaColumn = new TableColumn<>("Dia");
        diaColumn.setCellValueFactory(celldata -> {
        	List<DiasEnum> d = celldata.getValue().getHorario().getDiaDaSemana();
        	String r = "";
        	for(DiasEnum dias : d) {
        		r += dias.getNomeDia() + "-";
        	}
        	StringProperty s = new SimpleStringProperty(r);
        	return s;
        });

        professorColumn = new TableColumn<>("Professor");
        professorColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getProfessor().getNome());
        	return s;
        });
        
        disciplinaColumn = new TableColumn<>("Disciplina");
        disciplinaColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getDisciplina().getNome());
        	return s;
        });
        
        tabelaAlocacoes = new TableView<>();
        tabelaAlocacoes.setItems(tab);
		tabelaAlocacoes.getColumns().addAll(horaColumn, diaColumn, disciplinaColumn, professorColumn);
	}
	
	
	public void abreTelaHorario() {
		Alocacao a = tabelaAlocacoes.getSelectionModel().getSelectedItem();
		if(a != null) {
			AlocacaoAtualizarHorarioController.setId(a.getId());
			ScreenManager.getInstance().showAtualizaHora();
		}else {
			AlertBox.display("Aviso", "Voc� deve escolher uma das turmas na tabela");
		}
		
	}
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
			try {
				
				ScreenManager.getInstance().showTestScreen();
				ScreenManager.getInstance().getMainStage().setTitle("Menu Principal");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void abreTelaProfessor() {
		Alocacao a = tabelaAlocacoes.getSelectionModel().getSelectedItem();
		if(a != null) {
			AlocacaoAtualizarProfessorController.setId(a.getId());
			ScreenManager.getInstance().showAtualizaAlocProf();
		}else {
			AlertBox.display("Aviso", "Voc� deve escolher uma das turmas na tabela");
		}
		
	}
	public void abreTelaDisciplina() {
		Alocacao a = tabelaAlocacoes.getSelectionModel().getSelectedItem();
		if(a != null) {
			AlocacaoAtualizarDisciplinaController.setId(a.getId());
			ScreenManager.getInstance().showAtualizaAlocDis();
		}else {
			AlertBox.display("Aviso", "Voc� deve escolher uma das turmas na tabela");
		}
		
	}
}
