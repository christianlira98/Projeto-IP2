package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import promsys.controller.ServidorController;
import promsys.exceptions.ServidorJaExisteException;
import promsys.fachada.Fachada;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Servidor;

public class CadastroUserController {
	@FXML
	private Button CancelaBotao;
	@FXML
	private Button ConfirmaBotao;
	@FXML
	private TextField CaixaNome;
	@FXML
	private TextField login;
	@FXML
	private PasswordField caixaSenha;
	@FXML
	private PasswordField caixaSenha1;
	@FXML
	private TextField pergunta;
	@FXML
	private TextField resposta;
	@FXML
	private Label labelException;
	
	public void confirma() {
		ConfirmaBotao.setOnMouseClicked(e->{
		Servidor novo;
		String nome = CaixaNome.getText();
		String senha = caixaSenha.getText();
		String pergunt = pergunta.getText();
		String respost = resposta.getText();
		String confirma = caixaSenha1.getText();
		String log = login.getText();
			
		if(!senha.equals(confirma)) {
			labelException.setText("Senhas n�o Correspondem");
			labelException.setTextFill(Color.RED);
		}
		else if(nome.length()>0 && senha.length()>0 && pergunt.length()>0 && respost.length()>0
				&&confirma.length()>0 && log.length()>0) {
			labelException.setTextFill(Color.LAVENDER);
			novo = new Servidor(CaixaNome.getText(), login.getText(), 
					caixaSenha.getText(), pergunta.getText(), resposta.getText());
			try {
				Fachada.getInstance().cadastroServidor(novo);
			} catch (ServidorJaExisteException e1) {
				// TODO Auto-generated catch block
				labelException.setText("Servidor j� existe");
				labelException.setTextFill(Color.RED);
			}
			ScreenManager.getInstance().showLogin();
		}else {
			labelException.setText("Informa��es obrigat�rias n�o foram preenchidas");
			labelException.setTextFill(Color.RED);
		}
		});
	}
	public void cancela () {
		CancelaBotao.setOnMouseClicked(e -> {
			Stage stage = (Stage) CancelaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
}
