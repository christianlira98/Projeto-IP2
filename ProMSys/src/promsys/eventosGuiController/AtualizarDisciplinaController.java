package promsys.eventosGuiController;



import promsys.negocio.beans.*;
import promsys.realGui.DisciplinaExcluir;
import promsys.realGui.DisciplinasDisponiveis;
import promsys.realGui.ScreenManager;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.dao.DisciplinaDAO;
import promsys.exceptions.DisciplinaCargaInvalidaException;
import promsys.negocio.DisciplinaController;
import promsys.negocio.ProfessorController;

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
			if(!tempo.equals(vari) && DisciplinaController.getInstance().existe(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Disciplina p = DisciplinaController.getInstance().procurarDisciplina(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
			else if(!tempo2.equals(vari) && DisciplinaController.getInstance().
					procurarNomeDisciplina(tempo2)!=null) {
				Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(tempo2);
				caixaEncontrado.insertText(0, p.toString());
				
			}else {
			
				for(int i = 0; i < adicionar.getItems().size();i++) {
					caixaEncontrado.setText("");
					CheckMenuItem temp;
					temp = (CheckMenuItem) adicionar.getItems().get(i);
					if(temp.isSelected()) {
						Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText());
						caixaEncontrado.insertText(0,p.toString()+"\n*********************\n");
						caixaID.setText(String.valueOf(p.getId()));
						CaixaNome.setText(p.getNome());
						break;
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
			double novaCarga;
			if(NovaCarga.getText().equals(vari)) {
				novaCarga = 0;
			}else {
				novaCarga = Double.parseDouble(NovaCarga.getText());
			}
			
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				if(!novoN.equals(vari)) {
						DisciplinaController.getInstance().atualizarDisciplina(Long.parseLong(tempo), novoN);
						CaixaNome.setText(novoN);
				}
				if(novaCarga !=0) {
					
						try {
							DisciplinaController.getInstance().atualizarCargaHoraria(Long.parseLong(tempo), novaCarga);
						} catch (NumberFormatException e1) {
							caixaEncontrado.setText("Insira um valor válido");
						} catch (DisciplinaCargaInvalidaException e1) {
							caixaEncontrado.setText("Carga horária inválida");
						}
				if(!novoCodigo.equals(vari)) {
					DisciplinaController.getInstance().atualizarCodigo(DisciplinaController.getInstance()
							.procurarDisciplina(Long.parseLong(tempo)).getId(), novoCodigo);
				}
					
				}

				DisciplinaDAO.getInstance().salvarArquivo();
				
			}else if(!tempo2.equals(vari) && DisciplinaController.getInstance().
					procurarNomeDisciplina(tempo2)!=null) {
				Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(tempo2);
				if(!novoN.equals(vari)) {
					DisciplinaController.getInstance().atualizarDisciplina(p.getId(), novoN);
					CaixaNome.setText(novoN);
				}
				if(novaCarga !=0) {
					
					try {
						DisciplinaController.getInstance().atualizarCargaHoraria(p.getId(), novaCarga);
					} catch (NumberFormatException e1) {
						caixaEncontrado.setText("Insira um valor válido");
					} catch (DisciplinaCargaInvalidaException e1) {
						caixaEncontrado.setText("Carga horária inválida");
					}
					
				if(!novoCodigo.equals(vari)) {
				DisciplinaController.getInstance().atualizarCodigo(p.getId(), novoCodigo);
			}
				
			}
					
				DisciplinaDAO.getInstance().salvarArquivo();
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
