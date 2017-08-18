package promsys.realGui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import promsys.negocio.beans.Alocacao;

public class ScreenManager {
    
    private static ScreenManager instance;
    private Stage mainStage;
<<<<<<< HEAD
    private BorderPane testPane, formPane, professor, submenuAjustes;
    private Pane cadastroProf, removeProf, atualizaProf, procuraProf, alteraDadosProf, alteraMeusDados,
=======
    private BorderPane testPane, formPane, professor, alocacao;
    private Pane cadastroProf, removeProf, atualizaProf, procuraProf,
>>>>>>> refs/remotes/origin/master
    cadastroDis, removeDis, atualizaDis, procuraDis,
    loginC, abrirPeriodo, redefineSenha, cadastroSer;
    private Scene testScene;
    private Scene formScene;
    private Scene submenuAjustesCena;
    private Scene professorScene;
    private Scene cadastroProfessor, removeProfessor, atualizaProfessor, procuraProfessor, alteraDadosProfCena,
    cadastroDisciplina, removeDisciplina, atualizaDisciplina, procuraDisciplina,
<<<<<<< HEAD
    loginCena, abrirPeriodoCena, redefineSenhaCena, cadastroServidor, alteraMeusDadosCena;
=======
    loginCena, abrirPeriodoCena, redefineSenhaCena;
	private Scene alocacaoScene;
	private Pane cadastroAlocacao;
	private Scene cadastrarAlocacao;
>>>>>>> refs/remotes/origin/master
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        } 
        
        return instance; 
    }
    
    private ScreenManager() {
        // Construtor privado para evitar instanciaï¿½ï¿½o
        /*/
         * 
         */
    	//comentario
        try {
        	alteraMeusDados = FXMLLoader.load(this.getClass().getResource("atualizarMeusDadosFXML.fxml"));
        	//inicia cena
        	this.alteraMeusDadosCena = new Scene(alteraMeusDados);
        	
        	alteraDadosProf = FXMLLoader.load(this.getClass().getResource("atualizarDadosProfessorFXML.fxml"));
        	//inicia cena
        	this.alteraDadosProfCena = new Scene(alteraDadosProf);
        	
        	submenuAjustes = FXMLLoader.load(this.getClass().getResource("menuAjustesFXML.fxml"));
        	//inicia cena
        	this.submenuAjustesCena = new Scene(submenuAjustes);
        	
        	cadastroSer = FXMLLoader.load(this.getClass().getResource("cadastroUsersFXML.fxml"));
        	//inicia cena
        	this.cadastroServidor = new Scene(cadastroSer);
        	
        	redefineSenha = FXMLLoader.load(this.getClass().getResource("RedefineSenhaFXML.fxml"));
        	//inicia cena
        	this.redefineSenhaCena = new Scene(redefineSenha);
        	
        	abrirPeriodo = FXMLLoader.load(this.getClass().getResource("abrirPeriodoFXML.fxml"));
        	//inicia cena
        	this.abrirPeriodoCena = new Scene(abrirPeriodo);
        	
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

        // configurando tï¿½tulo da app
        /**/
<<<<<<< HEAD
        mainStage.setTitle("Alocação Deinfo");
=======
        mainStage.setTitle("Transiï¿½ï¿½es entre telas");
>>>>>>> refs/remotes/origin/master
    }
    public void showCadastroServidor() {
    	cadastroSer.setPrefHeight(620);
    	cadastroSer.setPrefWidth(800);
    	this.mainStage.setScene(this.cadastroServidor);
    	this.mainStage.setResizable(false);
        this.mainStage.show();
    }
    
    
    
    
    
    public void showAbrirPeriodo() {
    	abrirPeriodo.setPrefHeight(560);
    	abrirPeriodo.setPrefWidth(600);
    	/*
    	 * 
    	 * Essa parte tu tem que trocar para this.MenuPeriodo q tu fez aï¿½.
    	this.professor.setCenter(abrirPeriodo);
    	this.professor.setCenterShape(false);
    	*/
    	this.getMainStage().setResizable(false);
    }
    
    public void showLogin() {
    	loginC.setPrefHeight(620);
    	loginC.setPrefWidth(800);
    	this.mainStage.setScene(this.loginCena);
    	this.mainStage.setResizable(false);
        this.mainStage.show();
    }
    public void showRedefine() {
    	loginC.setPrefHeight(620);
    	loginC.setPrefWidth(800);
    	this.mainStage.setScene(this.redefineSenhaCena);
    	this.mainStage.setResizable(false);
        this.mainStage.show();
    }
    
    public void showAlteraMeusDados() {
    	alteraMeusDados.setPrefHeight(560);
    	alteraMeusDados.setPrefWidth(600);
    	this.submenuAjustes.setCenter(alteraMeusDados);
    	this.submenuAjustes.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void showAlteraDadosProf() {
    	alteraDadosProf.setPrefHeight(560);
    	alteraDadosProf.setPrefWidth(600);
    	this.submenuAjustes.setCenter(alteraDadosProf);
    	this.submenuAjustes.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    
    public void setaDisciplinaCenterNull() {
    	this.formPane.setCenter(null);
    }
    
    public void setaProfessorCenterNull() {
    	this.professor.setCenter(null);
    }
    public void setaMenuAjustesCenterNull() {
    	this.submenuAjustes.setCenter(null);
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
    public void showAjustesMenu() {
    	this.mainStage.setScene(this.submenuAjustesCena);
    	this.mainStage.setTitle("Menu Ajustes");
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

