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
		String vari = "";
		if(CaixaNome.getText().equals(vari) || caixaSenha.getText().equals(vari) || pergunta.getText().equals(vari) ||
				resposta.getText().equals(vari) || caixaSenha1.getText().equals(vari)|| login.getText().equals(vari)) {
			do {
				labelException.setText("Informações obrigatórias não foram preenchidas");
			labelException.setTextFill(Color.RED);
			auxVari = true;
			}while(auxVari == true);
		}
		labelException.setTextFill(Color.LAVENDER);
	
			
		if(!auxVari && caixaSenha.getText().equals(caixaSenha1.getText())) {
			
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
			labelException.setText("Senhas não Correspondem");
			labelException.setTextFill(Color.RED);
		}
		});
	}
	public void cancela () {
		//setar cena para login.
	}
	
}
