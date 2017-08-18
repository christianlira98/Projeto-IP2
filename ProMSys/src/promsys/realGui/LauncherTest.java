package promsys.realGui;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;

public class LauncherTest extends Application{
	
	public void start (Stage primaryStage) {   
		ScreenManager.getInstance().setMainStage(primaryStage);
		File file = new File("servidor.dat");
		if(!file.exists()) {
			ScreenManager.getInstance().showCadastroServidor();
		}
		else {
			ScreenManager.getInstance().showLogin();
		}
    }

    public static void main(String[] args) {
       launch(args);
    }
}
