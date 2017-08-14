package promsys.realGui;




import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.negocio.ProfessorController;
import promsys.negocio.beans.Professor;

public class RemoverProfessorController {
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextField caixaID;
	@FXML
	private TextArea caixaEncontrado;
	@FXML
	private Button procura;
	@FXML
	private Button remove;
	
	public void procurando() {
		procura.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Professor p = ProfessorController.getInstance().procurarProf(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
		});
	}
	
	public void remover() {
		remove.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
			long temp = Long.valueOf(caixaID.getText());
			Professor p = ProfessorController.getInstance().procurarProf(temp);
			try {
				ProfessorController.getInstance().removeProf(p.getId());
			} catch (ProfessorNaoExisteException e1) {
				
				e1.printStackTrace();
			}
				caixaEncontrado.setText("");
				caixaEncontrado.insertText(0, "Professor foi removido!");
			}
		});
	}
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			ProfessorDAO.getInstance().escreveArquivo();
			Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			
			Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
}
