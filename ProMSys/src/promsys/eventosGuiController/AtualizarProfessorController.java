package promsys.eventosGuiController;



import promsys.negocio.beans.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckMenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.exceptions.NaoEstaEntreOsPossiveisException;
import promsys.exceptions.ProfessorJaExisteNomeException;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.negocio.DisciplinaController;
import promsys.negocio.ProfessorController;
import promsys.negocio.beans.Professor;
import promsys.realGui.AtualizarProfessor;
import promsys.realGui.DisciplinaExcluir;
import promsys.realGui.DisciplinasDisponiveis;

public class AtualizarProfessorController {
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
	
	public void addExcluir(List<CheckMenuItem> me) {
		Excluir.setOnMouseClicked(e ->{
			if(Excluir.getItems().isEmpty()) {
				Excluir.getItems().addAll(DisciplinaExcluir.add(me));
			}
		});
	}
	public void procurando() {
		procura.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				caixaEncontrado.setText("");
				long temp = Long.valueOf(caixaID.getText());
				Professor p = ProfessorController.getInstance().procurarProf(temp);
				caixaEncontrado.insertText(0, p.toString());
				
				List<Professor> prof = new ArrayList<>();
				prof = ProfessorController.getInstance().lista();
				List<Disciplina> d = new ArrayList<>();
				for(int i = 0; i < prof.size(); i++) {
					if(prof.get(i).getId() == Long.parseLong(tempo)) {
						d = prof.get(i).getDisciplinasPossiveis();
					}
				}
				
				
				List<CheckMenuItem> me = new ArrayList<>();
				for(Disciplina v: d) {
					me.add(new CheckMenuItem (v.getNome()));
				}
				this.addExcluir(me);
			}
			else if(!tempo2.equals(vari) && ProfessorController.getInstance().procurarPorNome(tempo2)!= null) {
				Professor p = ProfessorController.getInstance().procurarPorNome(tempo2);
				caixaEncontrado.insertText(0, p.toString());
				List<Professor> prof = new ArrayList<>();
				prof = ProfessorController.getInstance().lista();
				List<Disciplina> d = new ArrayList<>();
				for(int i = 0; i < prof.size(); i++) {
					if(prof.get(i).getId() == p.getId()) {
						d = prof.get(i).getDisciplinasPossiveis();
					}
				}
				
				
				List<CheckMenuItem> me = new ArrayList<>();
				for(Disciplina v: d) {
					me.add(new CheckMenuItem (v.getNome()));
				}
				this.addExcluir(me);
			}
		});
	}
	
	
	
	public void confirma() {
		confirmaBotao.setOnAction(e -> {
			String tempo = caixaID.getText();
			String vari = "";
			String tempo2 = CaixaNome.getText();
			String novoN = caixaNovoNome.getText();
			CheckMenuItem temp;
			if(!tempo.equals(vari) && ProfessorController.getInstance().verificarExistencia(
					Long.parseLong(tempo))) {
				if(!novoN.equals(vari)) {
					try {
						ProfessorController.getInstance().updateNomeProfessor(novoN, Long.parseLong(tempo));
						CaixaNome.setText(novoN);
					} catch (NumberFormatException e1) {
						caixaEncontrado.setText("Não foi possível atualizar o nome do professor");
					} catch (ProfessorNaoExisteException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Professor Não Existe!");
					} catch (ProfessorJaExisteNomeException e1) {
						caixaEncontrado.setText("Professor já existe");
					}
				}
				
				for(int i = 0; i < Excluir.getItems().size(); i++) {
					temp = (CheckMenuItem) Excluir.getItems().get(i);
					if(temp.isSelected()==true && ProfessorController.getInstance().estaEntreDisAptas(Long.parseLong(tempo),
							DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
					
					try {
						ProfessorController.getInstance().removeDisciplinaPossivel(Long.parseLong(tempo)
							, DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Não foi possível atualizar o nome do professor");
					} catch (ProfessorNaoExisteException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Professor Não Existe!");
					} catch (NaoEstaEntreOsPossiveisException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Essa disciplina nao está entre as possíveis");
					}
					}
				}
				
				for(int i = 0; i < adicionar.getItems().size(); i++ ) {
					temp = (CheckMenuItem) adicionar.getItems().get(i);
					if(temp.isSelected()==true && !ProfessorController.getInstance().estaEntreDisAptas(Long.parseLong(tempo),
							DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
						try {
							ProfessorController.getInstance().addPossivelDisciplina(Long.parseLong(tempo),
									DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Erro Desconhecido");
						} catch (ProfessorNaoExisteException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Professor não existe");
						} catch (DisciplinaNaoExisteException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Essa disciplina não existe");
						}			
					}
				}
				ProfessorDAO.getInstance().escreveArquivo();
				
			}else if(!tempo2.equals(vari)&& ProfessorController.getInstance().verificarExistencia(
					ProfessorController.getInstance().procurarPorNome(tempo2).getId())) {
				Professor p = ProfessorController.getInstance().procurarPorNome(tempo2);
				if(!novoN.equals(vari)) {
					try {
						ProfessorController.getInstance().updateNomeProfessor(novoN, p.getId());
						CaixaNome.setText(novoN);
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Não foi possível atualizar o nome do professor");
					} catch (ProfessorNaoExisteException e1) {
						// TODO Auto-generated catch block
						caixaEncontrado.setText("Professor Não Existe!");
					} catch (ProfessorJaExisteNomeException e1) {
						caixaEncontrado.setText("Professor já existe");
					}
					
				}
					for(int i = 0; i < Excluir.getItems().size(); i++) {
						temp = (CheckMenuItem) Excluir.getItems().get(i);
						if(temp.isSelected()==true && ProfessorController.getInstance().estaEntreDisAptas(ProfessorController.getInstance().procurarPorNome(CaixaNome.getText()).getId(),
								DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId()))
								{
						
						try {
							
							ProfessorController.getInstance().removeDisciplinaPossivel(ProfessorController.getInstance().procurarPorNome(CaixaNome.getText()).getId()
								, DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId());
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Não foi possível atualizar o nome do professor");
						} catch (ProfessorNaoExisteException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Professor Não Existe!");
						} catch (NaoEstaEntreOsPossiveisException e1) {
							// TODO Auto-generated catch block
							caixaEncontrado.setText("Essa disciplina nao está entre as possíveis");
						}
						}
					}
					
					for(int i = 0; i < adicionar.getItems().size(); i++ ) {
						temp = (CheckMenuItem) adicionar.getItems().get(i);
						if(temp.isSelected()==true && !ProfessorController.getInstance().estaEntreDisAptas(ProfessorController.getInstance().procurarPorNome(CaixaNome.getText()).getId(),
								DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
							try {
								ProfessorController.getInstance().addPossivelDisciplina(ProfessorController.getInstance().procurarPorNome(CaixaNome.getText()).getId(),
										DisciplinaController.getInstance().procurarNomeDisciplina(temp.getText()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								caixaEncontrado.setText("Erro Desconhecido");
							} catch (ProfessorNaoExisteException e1) {
								// TODO Auto-generated catch block
								caixaEncontrado.setText("Professor não existe");
							} catch (DisciplinaNaoExisteException e1) {
								// TODO Auto-generated catch block
								caixaEncontrado.setText("Essa disciplina não existe");
							}			
						}
			}
				ProfessorDAO.getInstance().escreveArquivo();
			}
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
