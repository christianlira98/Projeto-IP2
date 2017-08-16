package promsys.eventosGuiController;

import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import promsys.Enum.DiasEnum;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Alocacao;
import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Horario;
import promsys.negocio.beans.Professor;

public class TabelaAlocacoesController {
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
	
	private ObservableList<Alocacao> tab = FXCollections.observableArrayList();
	private Fachada acesso = Fachada.getInstance();
	
	public TabelaAlocacoesController() {
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
	
	
	
}
