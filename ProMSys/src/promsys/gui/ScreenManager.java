package promsys.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import promsys.dao.AlocacaoDAO;


public class ScreenManager {
    
    private static ScreenManager instance;
    private Stage mainStage;

    private BorderPane testPane, formPane, professor, submenuAjustes, subMenuAtualizarAlocacao, alocacao;
    private AnchorPane submenuAlocacao;
    private Pane cadastroProf, removeProf, atualizaProf, procuraProf, alteraDadosProf, alteraMeusDados,
    cadastroDis, removeDis, atualizaDis, procuraDis,
    loginC, abrirPeriodo, redefineSenha, cadastroSer, cadastroAlocacaoOP, cadastroAlocacao, 
    atualizarHora, atualizarProfAloc, atualizarDisAloc;
    
    private Scene testScene;
    private Scene formScene;
    private Scene submenuAjustesCena;
    private Scene professorScene;
    
    private Scene cadastroProfessor, removeProfessor, atualizaProfessor, procuraProfessor, alteraDadosProfCena,
    cadastroDisciplina, removeDisciplina, atualizaDisciplina, procuraDisciplina, loginCena, abrirPeriodoCena, redefineSenhaCena, 
    cadastroServidor,alteraMeusDadosCena, cadastroAlocacaoOPCena, alocacaoScene, submenuAlocacaoCena,
    subMenuAtualizarAlocCena, cadastrarAlocacao, atualizarHoraAlocCena, atualizarProfAlocCena
    , atualizarDisAlocCena;

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
        	atualizarProfAloc = FXMLLoader.load(this.getClass().getResource("telaAtualizarProfessor.fxml"));
        	this.atualizarProfAlocCena = new Scene(atualizarProfAloc);
        	
        	atualizarDisAloc = FXMLLoader.load(this.getClass().getResource("telaAtualizarDisciplina.fxml"));
        	this.atualizarDisAlocCena = new Scene(atualizarDisAloc);
        	
        	atualizarHora = FXMLLoader.load(this.getClass().getResource("telaAtualizarHorario.fxml"));
        	this.atualizarHoraAlocCena = new Scene(atualizarHora);
        	
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
            
            cadastroAlocacaoOP = FXMLLoader.load(this.getClass().getResource("cadastroAlocacao.fxml"));
            cadastroAlocacaoOPCena = new Scene(cadastroAlocacaoOP);
            subMenuAtualizarAlocacao = FXMLLoader.load(this.getClass().getResource("subMenuAtualizarAlocacao.fxml"));
            this.subMenuAtualizarAlocCena = new Scene(subMenuAtualizarAlocacao);
            
            
            
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

        mainStage.setTitle("Alocação Deinfo");



    }
    public void showCadastroServidor() {
    	cadastroSer.setPrefHeight(620);
    	cadastroSer.setPrefWidth(800);
    	this.mainStage.setScene(this.cadastroServidor);
    	this.mainStage.setResizable(false);
        this.mainStage.show();
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
    	this.subMenuAtualizarAlocacao.setCenter(null);
    }
    public void setaSubMenuAtualizarAlocCenterNull() {
    	this.subMenuAtualizarAlocacao.setCenter(null);
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
    
    public void showAtualizarAlocacao() {
        this.mainStage.setScene(this.subMenuAtualizarAlocCena);
        this.mainStage.setTitle("Menu Atualizar alocação");
        this.mainStage.show();
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
    public void shownovaAlocacao() {
    	cadastroAlocacaoOP.setPrefHeight(560);
    	cadastroAlocacaoOP.setPrefWidth(600);
    	this.testPane.setCenter(null);
    	this.testPane.setCenter(cadastroAlocacaoOP);
    	this.testPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    public void showAtualizaAlocDis() {
    	atualizarDisAloc.setPrefHeight(560);
    	atualizarDisAloc.setPrefWidth(600);
    	this.subMenuAtualizarAlocacao.setCenter(null);
    	this.subMenuAtualizarAlocacao.setCenter(atualizarDisAloc);
    	this.subMenuAtualizarAlocacao.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    public void showAtualizaAlocProf() {
    	atualizarProfAloc.setPrefHeight(560);
    	atualizarProfAloc.setPrefWidth(600);
    	this.subMenuAtualizarAlocacao.setCenter(null);
    	this.subMenuAtualizarAlocacao.setCenter(atualizarProfAloc);
    	this.subMenuAtualizarAlocacao.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    public void showAtualizaHora() {
    	this.atualizarHora.setPrefHeight(560);
    	this.atualizarHora.setPrefWidth(600);
    	this.subMenuAtualizarAlocacao.setCenter(null);
    	this.subMenuAtualizarAlocacao.setCenter(this.atualizarHora);
    	this.subMenuAtualizarAlocacao.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
    public void showAlocacaoMenu() {
    	alocacao.setPrefHeight(560);
    	alocacao.setPrefWidth(600);
    	this.testPane.setCenter(null);
    	this.testPane.setCenter(alocacao);
    	this.testPane.setCenterShape(false);
    	this.getMainStage().setResizable(false);
    }
}

