package promsys.eventosGuiController;




import java.util.List;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.negocio.DisciplinaController;
import promsys.negocio.ProfessorController;
import promsys.negocio.beans.Disciplina;
import promsys.negocio.beans.Professor;
import promsys.realGui.DisciplinaExcluir;
import promsys.realGui.DisciplinasDisponiveis;

public class RemoverDisciplinaController {
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
	private Button remove;
	@FXML
	private TextField CaixaNome;
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
				caixaEncontrado.setText(null);
				long temp = Long.valueOf(caixaID.getText());
				Disciplina p = DisciplinaController.getInstance().procurarDisciplina(temp);
				caixaEncontrado.insertText(0, p.toString());
			}
			else if(!tempo2.equals(vari) && DisciplinaController.getInstance().
					procurarNomeDisciplina(tempo2)!=null) {
				caixaEncontrado.setText(null);
				Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(tempo2);
				caixaEncontrado.insertText(0, p.toString());
			}
			else {
			
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
	
	public void remover() {
		remove.setOnAction(e -> {
			List<Professor> temporaria = new ArrayList<>();;
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			if(!tempo.equals(vari) && DisciplinaController.getInstance().existe(
					Long.parseLong(tempo))) {
			long temp = Long.valueOf(caixaID.getText());
			Disciplina p = DisciplinaController.getInstance().procurarDisciplina(temp);
			
				try {
					temporaria = ProfessorController.getInstance().lista();
					for(Professor prof: temporaria) {
						if(prof.estaEntreDisAptas(p.getId())) {
							prof.removeDisciplinaPossivel(p.getId());
						}
					}
					DisciplinaController.getInstance().removerDisciplina(p.getId());
				} catch (DisciplinaNaoExisteException e1) {
					caixaEncontrado.insertText(0, "Erro: N�o foi poss�vel remover...!");
				}				
			 
		}
			else if(!tempo2.equals(vari)) {
				Disciplina p = DisciplinaController.getInstance().procurarNomeDisciplina(tempo2);
				try {
					temporaria = ProfessorController.getInstance().lista();
					for(Professor prof: temporaria) {
						if(prof.estaEntreDisAptas(p.getId())) {
							prof.removeDisciplinaPossivel(p.getId());
						}
					}
					DisciplinaController.getInstance().removerDisciplina(p.getId());
				}catch(DisciplinaNaoExisteException e2) {
					caixaEncontrado.insertText(0, "Erro: N�o foi poss�vel remover...!");
				}
				caixaEncontrado.insertText(0, p.toString());
			}
				caixaEncontrado.setText("");
				caixaEncontrado.insertText(0, "Disciplina foi removida!");
			
		});
	}
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			ProfessorDAO.getInstance().escreveArquivo();
			Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			
			Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			stage.close();
		});
	}
	
}
