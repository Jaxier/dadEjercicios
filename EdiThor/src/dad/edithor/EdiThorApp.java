package dad.edithor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EdiThorApp extends Application {

	private static Stage primaryStage;
	
	private RootController controlador;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		EdiThorApp.primaryStage = primaryStage;
		
		
		controlador = new RootController();
		
		
		
		primaryStage.setTitle("EdiThor");
		primaryStage.setScene(new Scene(controlador.getView(),500,600));
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

 
	
}
