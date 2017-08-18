package promsys.eventosGuiController;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import promsys.dao.ServidorDAO;
import promsys.exceptions.ServidorNaoExisteException;
import promsys.fachada.Fachada;
import promsys.negocio.ServidorController;
import promsys.negocio.beans.Servidor;
import promsys.realGui.ScreenManager;

public class RedefineSenhaController {
	@FXML
	private TextField CaixaNome;
	@FXML
	private TextField caixaLogin;
	@FXML
	private TextField pergunta;
	@FXML
	private TextField resposta;
	@FXML
	private Button procura;
	@FXML
	private Button confirmaResposta;
	@FXML
	private Button CancelaBotao;
	@FXML
	private Button ConfirmaBotao;
	@FXML
	private TextField redefine;
	@FXML
	private Label mensagem;
	
	private Servidor p;
	public void procurar() {
		procura.setOnMouseClicked(e-> {
		List<Servidor> s = new ArrayList<>();
		s = ServidorController.getInstance().listar();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).getNome().equals(CaixaNome.getText()) &&
					s.get(i).getLogin().equals(caixaLogin.getText())) {
				
				pergunta.setText(s.get(i).getPergunta());
				redefine.setEditable(false);
				try {
					p = Fachada.getInstance().procuraServidor(s.get(i).getID());
				} catch (ServidorNaoExisteException e1) {
					// TODO Auto-generated catch block
					mensagem.setText("Servidor não existe");
					mensagem.setTextFill(Color.RED);
				}
			}else {
				mensagem.setText("Nenhum servidor com esses dados encontrado");
				mensagem.setTextFill(Color.RED);
			}
		}
		});
	}
	
	public void confirmaResp() {
		confirmaResposta.setOnMouseClicked(e -> {
			if(resposta.getText().equals(p.getResposta())) {
				redefine.setEditable(true);
			}else {
				mensagem.setText("Resposta incorreta");
				mensagem.setTextFill(Color.RED);
				
			}
		});
	}
	
	
	public void confirma() {
		ConfirmaBotao.setOnMouseClicked(e -> {
			ServidorController.getInstance().alteraSenha(p.getID(), redefine.getText());
			ServidorDAO.getInstance().escreveArquivo();
			ScreenManager.getInstance().showLogin();
			
		});
	}
	
	public void cancela() {
		CancelaBotao.setOnMouseClicked(e -> {
			ScreenManager.getInstance().showLogin();
		});
		
	}
	
	
	
}
