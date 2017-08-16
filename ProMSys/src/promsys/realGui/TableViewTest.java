package promsys.realGui;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import promsys.Enum.DiasEnum;
import promsys.fachada.Fachada;
import promsys.negocio.beans.Alocacao;
import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Horario;
import promsys.negocio.beans.Professor;

public class TableViewTest extends Application {
	
	private Stage principal;
	private TableView<Alocacao> tabelaHorario;
	private Fachada acesso = Fachada.getInstance();

	@Override
	public void start(Stage arg0) throws Exception {
		principal = arg0;
		
//		TableColumn stateColumn = new TableColumn("State");
//			  stateColumn.setCellValueFactory(new Callback, ObservableValue>() {
//			     @Override
//			     public ObservableValue call(
//			       CellDataFeatures c) {
//			      return new SimpleStringProperty(c.getValue().getCity()
//			        .getState().getName());
//			     }
//			    });
		
		//Name column
//        TableColumn<Disciplina, String> disciplinaColumn = new TableColumn<>("Disciplina");
//        disciplinaColumn.setMinWidth(100);
//        disciplinaColumn.setCellValueFactory(celldata -> {
//        	StringProperty s = new SimpleStringProperty(celldata.getValue().getNome());
//        	return s;
//        });

        TableColumn<Alocacao, String> horaColumn = new TableColumn<>("Hora");
        horaColumn.setMinWidth(100);
        horaColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getHorario().getHorarioInicio().toString());
        	return s;
        });
        
        //Price column
        TableColumn<Alocacao, String> diaColumn = new TableColumn<>("Dia");
        diaColumn.setMinWidth(100);
        diaColumn.setCellValueFactory(celldata -> {
        	List<DiasEnum> d = celldata.getValue().getHorario().getDiaDaSemana();
        	String r = "";
        	for(DiasEnum dias : d) {
        		r += dias.getNomeDia() + "-";
        	}
        	StringProperty s = new SimpleStringProperty(r);
        	return s;
        });

        TableColumn<Alocacao, String> professorColumn = new TableColumn<>("Professor");
        professorColumn.setMinWidth(100);
        professorColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getProfessor().getNome());
        	return s;
        });
        
        TableColumn<Alocacao, String> disciplinaColumn = new TableColumn<>("Disciplina");
        disciplinaColumn.setMinWidth(100);
        disciplinaColumn.setCellValueFactory(celldata -> {
        	StringProperty s = new SimpleStringProperty(celldata.getValue().getDisciplina().getNome());
        	return s;
        });
//        
        ObservableList<Alocacao> alocacoes = FXCollections.observableArrayList();
		
        VBox pane = new VBox();
      
        for(Disciplina d : acesso.listaDisciplinas() ) {
        	for(Professor p : acesso.listarProfessores() ) {
        		DiasEnum[] array = new DiasEnum[2];
        		array[0] = DiasEnum.DOMINGO;
        		array[1] = DiasEnum.QUARTA;
        		Horario h = new Horario(11, 12, array);
        		Alocacao a = new Alocacao(p, d, h);
        		alocacoes.add(a);
        	}
        }
        
        tabelaHorario = new TableView<>();
        tabelaHorario.setItems(alocacoes);
		tabelaHorario.getColumns().addAll(horaColumn, diaColumn, disciplinaColumn, professorColumn); 
		pane.getChildren().addAll(tabelaHorario);
		Scene cena = new Scene(pane);
		principal.setScene(cena);
		principal.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
