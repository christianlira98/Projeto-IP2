package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import promsys.exceptions.ServidorJaExisteException;
import promsys.fachada.Fachada;
import promsys.gui.AlertBox;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Servidor;
public class CadastroServidorController {
	@FXML
	private Pane servidorCadastro;
	@FXML
	private TextField nome;
	@FXML
	private TextField login;
	@FXML
	private TextField senha;
	@FXML
	private Button cancelaBotao;
	@FXML
	private Button confirmaBotao;
	@FXML
	private TextField pergunta;
	@FXML
	private TextField resposta;
	
	private Fachada acesso;
	
	public void confirma() throws ServidorJaExisteException {
		
		String n = nome.getText();
		String log = login.getText();
		String pass = senha.getText();
		String ques = pergunta.getText();
		String ans = resposta.getText();
	
		if(n.length() > 1 && log.length() > 6 && pass.length() > 6 && ques.length() > 1 && ans.length() > 1) {
			Servidor novo = new Servidor(n, log, pass, ques, ans);
			try {
				acesso.cadastroServidor(novo);
			}
			catch(ServidorJaExisteException e) {
				AlertBox.display("Erro no Cadastro", e.getMessage());
			}
		}
		else if(n.length() <= 1) {
			 nome.insertText(0, "Nome Inválido!");
		}
		else if(log.length() < 6) {
			login.insertText(0, "Login Invalido!");
		}
		else if(pass.length() < 6) {
			senha.insertText(0, "Senha Inválida");
		}
		else if(ques.length() <= 1) {
			pergunta.insertText(0, "Pergunta Inválida");
		}
		else if(ans.length() < 6) {
			resposta.insertText(0, "Resposta Inválida");
		}
	}
	
	public void cancela() {
		cancelaBotao.setOnMouseClicked(e->{
			//ScreenManager.getInstance().showProfessorMenu();	
		});

	}
}
