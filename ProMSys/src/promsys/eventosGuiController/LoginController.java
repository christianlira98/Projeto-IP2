package promsys.eventosGuiController;


import promsys.dao.ServidorDAO;
import promsys.negocio.ServidorController;
import promsys.negocio.beans.*;
import promsys.realGui.ScreenManager;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Button ConfirmaBotao;
	@FXML
	private Button CancelaBotao;
	@FXML
	private TextField CaixaNome;
	@FXML
	private PasswordField caixaSenha;
	@FXML
	private Label alerta;
	@FXML
	private Button esquece;
	
	public void esqueceu() {
		esquece.setOnMouseClicked(e -> {
			ScreenManager.getInstance().showRedefine();
		});
	}
	
	
	public void confirma() {
		String login = CaixaNome.getText();
		String senha = caixaSenha.getText();
		ConfirmaBotao.setOnMouseClicked(e -> {
			List<Servidor> array = new ArrayList<>();
			array = ServidorDAO.getInstance().listar();
			for(Servidor o: array) {
				if(o.getLogin().equals(login) && o.getSenha().equals(senha)) {
					ServidorController.getInstance().fazLogin(login, senha);
					ScreenManager.getInstance().showTestScreen();
					caixaSenha.setText(null);
				}
			}
			alerta.setTextFill(Color.RED);
			if(CaixaNome.getText().length()>0 && caixaSenha.getText()==null) {
				alerta.setTextFill(Color.LAVENDER);
			}
			
			
		});
	}
		
		public void cancela() {
			CancelaBotao.setOnMouseClicked(e -> {
				Stage s = (Stage) CancelaBotao.getScene().getWindow();
				s.close();
			});
	}
	
}
