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
import promsys.controller.DisciplinaController;
import promsys.controller.ProfessorController;
import promsys.dao.ProfessorDAO;
import promsys.exceptions.DisciplinaNaoExisteException;
import promsys.exceptions.NaoEstaEntreOsPossiveisException;
import promsys.exceptions.ProfessorJaExisteNomeException;
import promsys.exceptions.ProfessorNaoExisteException;
import promsys.fachada.Fachada;
import promsys.gui.AtualizarProfessor;
import promsys.gui.DisciplinaExcluir;
import promsys.gui.DisciplinasDisponiveis;
import promsys.gui.ScreenManager;
import promsys.negocio.beans.Professor;

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
				System.out.println("teste");
				//Excluir.getItems().addAll(DisciplinaExcluir.add(me));
			
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
				Professor p = Fachada.getInstance().procurarProf(temp);
				caixaEncontrado.insertText(0, p.toString());
				
				List<Professor> prof = new ArrayList<>();
				prof = Fachada.getInstance().listarProfessores();
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
				DisciplinaExcluir.add(me, Excluir);
				//this.addExcluir(me);
			}
			else if(!tempo2.equals(vari) && ProfessorController.getInstance().procurarPorNome(tempo2)!= null) {
				Professor p = Fachada.getInstance().procurarProf(tempo2);
				caixaEncontrado.insertText(0, p.toString());
				List<Professor> prof = new ArrayList<>();
				prof = Fachada.getInstance().listarProfessores();
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
				DisciplinaExcluir.add(me, Excluir);
				//this.addExcluir(me);
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
						Fachada.getInstance().atualizarNomeProfessor(novoN, Long.parseLong(tempo));
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
							Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
							
					
					try {
						Fachada.getInstance().removeDisciplinaPossivel(Long.parseLong(tempo),
							Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId());
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
					if(temp.isSelected()==true && !Fachada.getInstance().estaEntreDisciplinasAptas(Long.parseLong(tempo),
							Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
						try {
							Fachada.getInstance().addPossivelDisciplina(Long.parseLong(tempo),
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
				
			}else if(!tempo2.equals(vari)&& Fachada.getInstance().verificarExistencia(Fachada.getInstance()
					.procurarProf(tempo2).getId())) {
				Professor p = Fachada.getInstance().procurarProf(tempo2);
				if(!novoN.equals(vari)) {
					try {
						Fachada.getInstance().atualizarNomeProfessor(novoN, p.getId());
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
						if(temp.isSelected()==true && Fachada.getInstance().estaEntreDisciplinasAptas(Fachada.getInstance().procurarProf(CaixaNome.getText()).getId(),
								Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId()))			
								{
						
						try {
							Fachada.getInstance().removeDisciplinaPossivel(Fachada.getInstance().procurarProf(CaixaNome.getText()).getId(), 
									Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId());
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
						if(temp.isSelected()==true && !Fachada.getInstance().estaEntreDisciplinasAptas(Fachada.getInstance().procurarProf(CaixaNome.getText()).getId(), 
								Fachada.getInstance().procurarNomeDisciplina(temp.getText()).getId())) {
							try {
								Fachada.getInstance().addPossivelDisciplina(Fachada.getInstance().procurarProf(CaixaNome.getText()).getId(),
										Fachada.getInstance().procurarNomeDisciplina(temp.getText()));
								
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
			ScreenManager.getInstance().setaProfessorCenterNull();
			//Stage stage = (Stage) confirmaBotao.getScene().getWindow();
			//stage.close();
		});
	}

	
	public void cancela() {
		cancelaBotao.setOnAction(e -> {
			ScreenManager.getInstance().setaProfessorCenterNull();
			//Stage stage = (Stage) cancelaBotao.getScene().getWindow();
			//stage.close();
		});
	}
	
}
