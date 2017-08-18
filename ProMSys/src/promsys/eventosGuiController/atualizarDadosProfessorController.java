package promsys.eventosGuiController;



import promsys.negocio.beans.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.exceptions.NaoEstaEntreOsPossiveisException;
import promsys.exceptions.ProfessorJaExisteNomeException;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.fachada.Fachada;
import promsys.negocio.DisciplinaController;
import promsys.negocio.ProfessorController;
import promsys.negocio.beans.Professor;
import promsys.realGui.DisciplinaExcluir;
import promsys.realGui.DisciplinasDisponiveis;
import promsys.realGui.ScreenManager;

public class atualizarDadosProfessorController {
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
	private TextField CaixaNome;
	@FXML
	private TextField caixaNovoLogin;
	@FXML 
	private PasswordField CaixaNovaSenha, ConfirmaSenha;
	@FXML
	private Label mensagem;

	public void procurando() {
		procura.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			if(!tempo.equals(vari) && Fachada.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Professor p = Fachada.getInstance().procurarProf(temp);
				CaixaNome.setText(p.getNome());
				caixaEncontrado.insertText(0, p.toString());
				
				
			}
			else if(!tempo2.equals(vari) &&Fachada.getInstance().procurarProf(tempo2)!= null) {
				Professor p = Fachada.getInstance().procurarProf(tempo2);
				caixaEncontrado.insertText(0, p.toString());
				caixaID.setText(String.valueOf(p.getId()));
				}
				
			
		});
	}
	
	
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			boolean status = true;
			String tempo2 = CaixaNome.getText();
			String novaS = CaixaNovaSenha.getText();
			String confirmaS = ConfirmaSenha.getText();
			String novoL = caixaNovoLogin.getText();
			if(tempo.length()>0 && Fachada.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				Professor p = Fachada.getInstance().procurarProf(Long.parseLong(tempo));
				if(!novoL.equals(vari)) {
					
					Fachada.getInstance().alteraLoginProf(p.getId(), novoL);
					
				}
				ProfessorDAO.getInstance().escreveArquivo();
				
		}else if(tempo2.length()>0 && Fachada.getInstance().verificarExistencia(Fachada.getInstance()
					.procurarProf(tempo2).getId())) {
				Professor p = Fachada.getInstance().procurarProf(tempo2);
				if(!novoL.equals(vari)) {
						Fachada.getInstance().alteraLoginProf(p.getId(), novoL);
						CaixaNome.setText(novoL);
				}
				ProfessorDAO.getInstance().escreveArquivo();
			}
			if (novaS.equals(confirmaS) && novaS.length()>0 && confirmaS.length()>0) {
				Professor p = Fachada.getInstance().procurarProf(Long.parseLong(tempo));
				Fachada.getInstance().alteraSenhaProf(p.getId(), p.getSenha());
				ProfessorDAO.getInstance().escreveArquivo();
				ScreenManager.getInstance().setaMenuAjustesCenterNull();
				
			}
			if (!novaS.equals(confirmaS) && novaS.length()>0 && confirmaS.length()>0) {
				mensagem.setTextFill(Color.RED);
				status = false;
			}
			if(status) {
				ScreenManager.getInstance().setaMenuAjustesCenterNull();
			}
		});
		
	}

	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			ScreenManager.getInstance().setaMenuAjustesCenterNull();
			//Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			//stage.close();
		});
	}
	
}
