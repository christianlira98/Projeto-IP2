package promsys.realGui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import promsys.negocio.beans.Alocacao;

public class ScreenManager {
    
    private static ScreenManager instance;
    private Stage mainStage;
    private BorderPane testPane, formPane, professor, alocacao;
    private Pane cadastroProf, removeProf, atualizaProf, procuraProf,
    cadastroDis, removeDis, atualizaDis, procuraDis,
    loginC;
    private Pane cadastroAlocacao, atualizaAlocacao, procuraAlocacao, removeAlocacao;
    private Scene testScene;
    private Scene formScene;
    private Scene professorScene;
    private Scene cadastroProfessor, removeProfessor, atualizaProfessor, procuraProfessor,
    cadastroDisciplina, removeDisciplina, atualizaDisciplina, procuraDisciplina,
    loginCena;
    private Scene cadastrarAlocacao, procurarAlocacao, removerAlocacao, alocacaoScene;
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        } 
        
        return instance; 
    }
    
    private ScreenManager() {
        // Construtor privado para evitar instanciação
        
        try {
        	loginC = FXMLLoader.load(this.getClass().getResource("loginFXML.fxml"));
        	//inicia cena
        	this.loginCena = new Scene(loginC);
        	
        	cadastroProf = FXMLLoader.load(this.getClass().getResource("cadastroProfessorFXML.fxml"));
        	//inicia cena
        	this.cadastroProfessor = new Scene(cadastroProf);
        	
        	removeProf = FXMLLoader.load(this.getClass().getResource("removerProfessorFXML.fxml"));
        	//inicia cena
        	this.removeProfessor = new Scene(removeProf);
        	
        	atualizaProf = FXMLLoader.load(this.getClass().getResource("AtualizarProfessorFXML.fxml"));
        	//inicia cena
        	this.atualizaProfessor = new Scene(atualizaProf);
        	
        	procuraProf = FXMLLoader.load(this.getClass().getResource("procurarProfessorFXML.fxml"));
        	//inicia cena
        	this.procuraProfessor = new Scene(procuraProf);
        	
        	cadastroDis = FXMLLoader.load(this.getClass().getResource("cadastroDisciplinaFXML.fxml"));
        	//inicia cena
        	this.cadastroDisciplina = new Scene(cadastroDis);
        	
        	removeDis = FXMLLoader.load(this.getClass().getResource("removerDisciplinaFXML.fxml"));
        	//inicia cena
        	this.removeDisciplina = new Scene(removeDis);
        	
        	atualizaDis = FXMLLoader.load(this.getClass().getResource("atualizarDisciplinaFXML.fxml"));
        	//inicia cena
        	this.atualizaDisciplina = new Scene(atualizaDis);
        	
        	procuraDis = FXMLLoader.load(this.getClass().getResource("procurarDisciplinaFXML.fxml"));
        	//inicia cena
        	this.procuraDisciplina = new Scene(procuraDis);
        	
            testPane = FXMLLoader.load(this.getClass().getResource(
              "menu.fxml"));
            // inicializando cena
            this.testScene = new Scene(testPane);
            
            formPane = FXMLLoader.load(this.getClass().getResource(
                    "submenuDisciplinaFXML.fxml"));
            // inicializando cena
            this.formScene = new Scene(formPane);
            
            professor = FXMLLoader.load(this.getClass().getResource("submenuProfessorFXML.fxml"));
            this.professorScene = new Scene(professor);
            
            alocacao = FXMLLoader.load(this.getClass().getResource("subMenuAlocacao.fxml"));
            this.alocacaoScene = new Scene(alocacao);
            
            cadastroAlocacao = FXMLLoader.load(this.getClass().getResource("cadastroAlocacao.fxml"));
            this.cadastrarAlocacao = new Scene(cadastroAlocacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
        
        // configurando largura e altura do stage.
        mainStage.setWidth(800);
        mainStage.setHeight(620);

        // configurando título da app
        /**/
        mainStage.setTitle("Transições entre telas");
    }
    public void showLogin() {
    	loginC.setPrefHeight(620);
    	loginC.setPrefWidth(800);
    	this.mainStage.setScene(this.loginCena);
    	this.mainStage.setResizable(false);
        this.mainStage.show();
    }
    
    public void setaDisciplinaCenterNull() {
    	this.formPane.setCenter(null);
    }
    
    public void setaProfessorCenterNull() {
    	this.professor.setCenter(null);
    }
    
    public void setaAlocacaoCenterNull() {
    	this.alocacao.setCenter(null);
    }
    
    public void showCadastroAlocacao() {
    	cadastroAlocacao.setPrefHeight(560);
    	cadastroAlocacao.setPrefWidth(600);
    	this.alocacao.setCenter(cadastroAlocacao);
    	this.alocacao.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showCadastroProf() {
    	cadastroProf.setPrefHeight(560);
    	cadastroProf.setPrefWidth(600);
    	this.professor.setCenter(cadastroProf);
    	this.professor.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showRemoveProf() {
    	removeProf.setPrefHeight(560);
    	removeProf.setPrefWidth(600);
    	this.professor.setCenter(removeProf);
    	this.professor.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showAtualizaProf() {
    	atualizaProf.setPrefHeight(560);
    	atualizaProf.setPrefWidth(600);
    	this.professor.setCenter(atualizaProf);
    	this.professor.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showProcuraProf() {
    	procuraProf.setPrefHeight(560);
    	procuraProf.setPrefWidth(600);
    	this.professor.setCenter(procuraProf);
    	this.professor.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    
    }
    
    public void showCadastroDis() {
    	cadastroDis.setPrefHeight(560);
    	cadastroDis.setPrefWidth(600);
    	this.formPane.setCenter(cadastroDis);
    	this.formPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showRemoveDis() {
    	removeDis.setPrefHeight(560);
    	removeDis.setPrefWidth(600);
    	this.formPane.setCenter(removeDis);
    	this.formPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showAtualizaDis() {
    	atualizaDis.setPrefHeight(560);
    	atualizaDis.setPrefWidth(600);
    	this.formPane.setCenter(atualizaDis);
    	this.formPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showProcuraDis() {
    	procuraDis.setPrefHeight(560);
    	procuraDis.setPrefWidth(600);
    	this.formPane.setCenter(procuraDis);
    	this.formPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    
    }

    
    public void showTestScreen() {
        this.mainStage.setScene(this.testScene);
        this.mainStage.show();
    }
    
    public void showProfessorMenu() {
    	this.mainStage.setScene(this.professorScene);
    	this.mainStage.setTitle("Menu Professor");
    	this.mainStage.show();
    }
    
    public void showFormScreen() {
        this.mainStage.setScene(this.formScene);
        this.mainStage.setTitle("Menu Disciplinas");
        this.mainStage.show();
    }
    
    public void showAlocacaoMenu() {
    	this.mainStage.setScene(this.alocacaoScene);
    	this.mainStage.setTitle("Menu Periodo");
    	this.mainStage.show();
    }
}

