package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import promsys.exceptions.ServidorJaExisteException;
import promsys.negocio.ServidorController;
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
		boolean auxVari = false;
		String nome = CaixaNome.getText();
		String senha = caixaSenha.getText();
		String pergunt = pergunta.getText();
		String respost = resposta.getText();
		String confirma = caixaSenha1.getText();
		String log = login.getText();
		String vari = "";
		
		if(!senha.equals(confirma) && senha.equals(null) ) {
			labelException.setText("Senhas não Correspondem");
			labelException.setTextFill(Color.RED);
		
			auxVari = true;
		
		}

		if(!auxVari ) {
			labelException.setTextFill(Color.LAVENDER);
			novo = new Servidor(CaixaNome.getText(), login.getText(), 
					caixaSenha.getText(), pergunta.getText(), resposta.getText());
			try {
				ServidorController.getInstance().cadastroServidor(novo);
			} catch (ServidorJaExisteException e1) {
				// TODO Auto-generated catch block
				labelException.setText("Servidor já existe");
				labelException.setTextFill(Color.RED);
			}
		}else {
			labelException.setText("Informações obrigatórias não foram preenchidas");
			labelException.setTextFill(Color.RED);
		}
		});
	}
	public void cancela () {
		//setar cena para login.
	}
	
}
