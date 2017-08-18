package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import promsys.dao.ServidorDAO;
import promsys.exceptions.ServidorJaExisteException;
import promsys.fachada.Fachada;
import promsys.negocio.ServidorController;
import promsys.negocio.beans.Servidor;
import promsys.realGui.ScreenManager;

public class atualizarMeusDadosController {
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
		boolean vari = true;
		String nome = CaixaNome.getText();
		String senha = caixaSenha.getText();
		String pergunt = pergunta.getText();
		String respost = resposta.getText();
		String confirma = caixaSenha1.getText();
		String log = login.getText();
			
		if(!senha.equals(confirma)) {
			labelException.setText("Senhas não Correspondem");
			labelException.setTextFill(Color.RED);
		}
		if(nome.length()>0) {
			Fachada.getInstance().atualizaNome(1, nome);
		}
		if(senha.length()>0 && senha.equals(confirma)) {
			Fachada.getInstance().atualizaSenha(1, senha);
		}
		if(log.length()>0 ) {
			Fachada.getInstance().atualizaLogin(1, log);;
		}
		if(respost.length()>0 && pergunt.length()>0) {
			Fachada.getInstance().atualizaPergunta(1, pergunt);
			Fachada.getInstance().atualizaResposta(1, respost);
		}
		if((respost.length()>0 && pergunt.length()<=0) || 
				(respost.length()<=0 && pergunt.length()>0)) {
			labelException.setText("Ambos, pergunta e resposta devem estar preenchidos");
			labelException.setTextFill(Color.RED);
			vari = false;
		}
		if((senha.length()>0 && confirma.length()<=0 && senha.equals(confirma)) || 
				(senha.length()<=0 && confirma.length()>0 && senha.equals(confirma))) {
			labelException.setText("A senha deve ser confirmada!");
			labelException.setTextFill(Color.RED);
			vari = false;
		}
		if(!senha.equals(confirma)) {
			labelException.setText("As senhas não correspondem");
			labelException.setTextFill(Color.RED);
			vari = false;
		}
		if(vari) {
			ScreenManager.getInstance().setaMenuAjustesCenterNull();
		}
		
		});
	}
	public void cancela () {
		CancelaBotao.setOnMouseClicked(e -> {
			ScreenManager.getInstance().setaMenuAjustesCenterNull();
		});
	}
	
}