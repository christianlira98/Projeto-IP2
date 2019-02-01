package promsys.eventosGuiController;



import promsys.negocio.beans.*;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.controller.DisciplinaController;
import promsys.controller.ProfessorController;
import promsys.dao.DisciplinaDAO;
import promsys.exceptions.DisciplinaCargaInvalidaException;
import promsys.fachada.Fachada;
import promsys.gui.DisciplinaExcluir;
import promsys.gui.DisciplinasDisponiveis;
import promsys.gui.ScreenManager;

public class AtualizarDisciplinaController {
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
	private TextField caixaNovoNome;
	@FXML
	private TextField NovoCodigo;
	@FXML
	private TextField NovaCarga;
	@FXML
	private MenuButton Excluir;
	@FXML
	private MenuButton adicionar;
	
	private Fachada acesso = Fachada.getInstance();
	
	public void add () {
		adicionar.setOnMouseClicked(e ->{
			if(adicionar.getItems().isEmpty()) {
				adicionar.getItems().addAll(DisciplinasDisponiveis.adiciona());
			}
		});
	}
	
	
	
	public void procurando() {
		procura.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			long id = -1;
			try {
				id = Long.parseLong(tempo);
			}
			catch(NumberFormatException n) {
				caixaID.insertText(0, "Entre com apenas números nesse campo!");
			}
			if(!tempo.equals(vari) && acesso.existeDisciplina(id)) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Disciplina p = acesso.procurarDisciplina(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
			else if(!tempo2.equals(vari) && acesso.procurarNomeDisciplina(tempo2)!=null) {
				Disciplina p = acesso.procurarNomeDisciplina(tempo2);
				caixaEncontrado.insertText(0, p.toString());
				
			}else {
			
				for(int i = 0; i < adicionar.getItems().size();i++) {
					caixaEncontrado.setText("");
					CheckMenuItem temp;
					temp = (CheckMenuItem) adicionar.getItems().get(i);
					if(temp.isSelected()) {
						Disciplina p = acesso.procurarNomeDisciplina(temp.getText());
						if(p != null) {
							caixaEncontrado.insertText(0,p.toString()+"\n*********************\n");
							caixaID.setText(String.valueOf(p.getId()));
							CaixaNome.setText(p.getNome());
							break;
						}	
					}
				}
			}
		});
	}
	
	
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			String novoN = caixaNovoNome.getText();
			String novoCodigo = NovoCodigo.getText();
			double novaCarga = 0;
			if(NovaCarga.getText().equals(vari)) {
				novaCarga = 0;
			}else {
				
				try { 
					novaCarga = Double.parseDouble(NovaCarga.getText());
				}
				catch(NumberFormatException n) {
					NovaCarga.insertText(0, "Entre apenas com números nesse campo!");
				}
			}
			long id = -1;
			try {
				id  = Long.parseLong(tempo);
			}
			catch(NumberFormatException n) {
				caixaID.insertText(0, "Entre apenas com números nesse campo!");
			}
			if(!tempo.equals(vari) && acesso.verificarExistencia(id)) {
				if(!novoN.equals(vari)) {
						acesso.atualizarDisciplina(id, novoN);
						CaixaNome.setText(novoN);
				}
				if(novaCarga !=0) {
					
						try {
							acesso.atualizarCargaHoraria(id, novaCarga);
						} catch (NumberFormatException e1) {
							caixaEncontrado.setText("Insira um valor válido");
						} catch (DisciplinaCargaInvalidaException e1) {
							caixaEncontrado.setText("Carga horária inválida");
						}
				if(!novoCodigo.equals(vari)) {
					acesso.atualizarCodigo(acesso.procurarDisciplina(Long.parseLong(tempo)).getId(), novoCodigo);
				}
					
				}

				
			}else if(!tempo2.equals(vari) && acesso.procurarNomeDisciplina(tempo2)!=null) {
				Disciplina p = acesso.procurarNomeDisciplina(tempo2);
				if(!novoN.equals(vari)) {
					acesso.atualizarDisciplina(p.getId(), novoN);
					CaixaNome.setText(novoN);
				}
				if(novaCarga !=0) {
					
					try {
						acesso.atualizarCargaHoraria(p.getId(), novaCarga);
					} catch (NumberFormatException e1) {
						caixaEncontrado.setText("Insira um valor válido");
					} catch (DisciplinaCargaInvalidaException e1) {
						caixaEncontrado.setText("Carga horária inválida");
					}
					
				if(!novoCodigo.equals(vari)) {
				acesso.atualizarCodigo(p.getId(), novoCodigo);
			}
				
			}
					
			}
			//Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			//stage.close();
			ScreenManager.getInstance().setaDisciplinaCenterNull();
		});
	}

	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			
			//ScreenManager.getInstance().showFormScreen();
			ScreenManager.getInstance().setaDisciplinaCenterNull();
			//Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			//stage.close();
		});
	}
	
}
