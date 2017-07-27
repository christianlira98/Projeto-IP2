package promsys.realGui;
import promsys.fachada.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class login extends Application {

	public void start(Stage primaryStage){
		primaryStage.setTitle("DEInfo Alocação");
		GridPane painel = new GridPane();
		painel.setAlignment(Pos.BOTTOM_CENTER);
		painel.setHgap(10);
		painel.setVgap(10);
		painel.setPadding(new Insets(50,50,50,50));
		Scene cena = new Scene(painel, 300, 275);
		primaryStage.setScene(cena);
		
		Text titulo = new Text("Tela de Login");
		titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		painel.add(titulo, 1, 0, 1, 1);
		Label usuario = new Label("Usuário");
		painel.add(usuario, 0, 1);
		TextField novo = new TextField();
		painel.add(novo, 1, 1);
		
		Label password = new Label("Senha");
		painel.add(password, 0, 2);
		
		PasswordField pass = new PasswordField();
		painel.add(pass, 1, 2);
		painel.setGridLinesVisible(false);
		
		Button btn = new Button("Entrar");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		painel.add(hbBtn, 1, 4);
		
		final Text acao = new Text();
		painel.add(acao, 1, 6);
		primaryStage.show();
		
	btn.setOnAction(new EventHandler<ActionEvent>() {
		 
	    
	    public void handle(ActionEvent e) {

	    		acao.setFill(Color.FIREBRICK);
		        acao.setText("Botao Pressionado");
	    	}
	       
	});
}
	
public static void main(String[] args) {
	launch(args);
}

}