package promsys.realGui;

import javafx.application.Application;
import javafx.stage.Stage;

public class LauncherTest extends Application{
	
	public void start (Stage primaryStage) {   
		ScreenManager.getInstance().setMainStage(primaryStage);
        ScreenManager.getInstance().showLogin();
    }

    public static void main(String[] args) {
       launch(args);
    }
}
