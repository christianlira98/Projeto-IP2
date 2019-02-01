package promsys.eventosGuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import promsys.dao.PeriodoDAO;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Periodo;

public class AbrirPeriodoController {
	@FXML
	private TextField nome;
	@FXML
	private Button CancelaBotao;
	@FXML
	private Button ConfirmaBotao;
	
	
	public void confirma() {
		ConfirmaBotao.setOnMouseClicked(e -> {
			Periodo p = new Periodo(nome.getText());
			PeriodoDAO.getInstance().cadastrar(p);
			//exemplo
			// na vdd nem sei se esse cara fica no centro. Mas tu entendeu.
			//ScreenManager.getInstance().setaProfessorCenterNull();
		});
		
	
	}
	public void cancela() {
		CancelaBotao.setOnMouseClicked(e -> {
			System.out.print("teste");
		});
	}
	}
	
	
	

