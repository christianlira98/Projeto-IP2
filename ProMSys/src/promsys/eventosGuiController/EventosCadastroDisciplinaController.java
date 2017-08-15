package promsys.eventosGuiController;
import promsys.negocio.DisciplinaController;
import promsys.negocio.beans.*;
import promsys.exceptions.DisciplinaCargaInvalidaException;
import promsys.exceptions.DisciplinaJaExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventosCadastroDisciplinaController {
	@FXML
	private Button ConfirmaBotao;
	@FXML
	private Button CancelaBotao;
	@FXML
	private TextField nome;
	@FXML
	private TextField codigo;
	@FXML
	private TextField hora;
	@FXML
	private TextField turma;
	
	
	public void confirma() {
		ConfirmaBotao.setOnMouseClicked(e -> {
			//Implementação Inicial - deve ser revista
			double cargaH = Double.parseDouble(hora.getText());
			Disciplina vari = new Disciplina(nome.getText(), cargaH);
			vari.setCodigoTurma(codigo.getText());
			try {
				DisciplinaController.getInstance().cadastrarDisciplina(vari);
			} catch (DisciplinaJaExisteException e1) {
				e1.printStackTrace();
			} catch (DisciplinaCargaInvalidaException e1) {
				e1.printStackTrace();
			}
			Stage stage = (Stage) ConfirmaBotao.getScene().getWindow();
			stage.close();
		});
	}
		public void cancela() {
			CancelaBotao.setOnMouseClicked(e -> {
				/*
				 * 
				 */
				Stage stage = (Stage) CancelaBotao.getScene().getWindow();
				stage.close();
				
			});
		}
			
		
		
	
	
	

}
