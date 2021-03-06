package promsys.eventosGuiController;
import promsys.controller.DisciplinaController;
import promsys.controller.ProfessorController;
import promsys.exceptions.*;
import promsys.gui.DisciplinasDisponiveis;
import promsys.gui.ScreenManager;
import promsys.negocio.*;
import promsys.negocio.beans.*;

import java.util.List;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventosCadastroProfessorController {
	@FXML
	private Button ConfirmaBotao;
	@FXML
	private Button CancelaBotao;
	@FXML
	private TextField nomeP;
	@FXML
	private TextField senha;
	@FXML
	private TextField login;
	@FXML
	public MenuButton disponiveis;
	
	CheckMenuItem temp = new CheckMenuItem();
	
	List<Disciplina> lista = new ArrayList<Disciplina>();
	public void add () {
		disponiveis.setOnMouseClicked(e ->{
			if(disponiveis.getItems().isEmpty()) {
				disponiveis.getItems().addAll(DisciplinasDisponiveis.adiciona());
			}
		});
	}
	
	public void confirma() {
		ConfirmaBotao.setOnMouseClicked(e -> {
			Professor prof = new Professor(nomeP.getText(), login.getText(), senha.getText());
			for(int i = 0; i < disponiveis.getItems().size(); i++ ) {
				temp = (CheckMenuItem) disponiveis.getItems().get(i);
				if(temp.isSelected()==true) {
					prof.addDisciplinasPossiveis(DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()));			
				}
			}
			try {
				ProfessorController.getInstance().cadastraProf(prof);
			} catch (ProfessorJaExisteException e1) {
				
				e1.printStackTrace();
			}
			
			//Stage stage = (Stage) ConfirmaBotao.getScene().getWindow();
			//stage.close();
			ScreenManager.getInstance().setaProfessorCenterNull();
		});
	}
		public void cancela() {
			CancelaBotao.setOnMouseClicked(e -> {
				/*
				 * 
				 */
				ScreenManager.getInstance().setaProfessorCenterNull();
				//Stage stage = (Stage) CancelaBotao.getScene().getWindow();
				//stage.close();
				
			});
		}
			
		
		
	
	
	

}