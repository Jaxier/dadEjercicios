package dad.holamundo.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HolaMundoApp extends Application {
	
	public HolaMundoController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HolaMundoView.fxml"));
		VBox root = loader.load();
		controller = loader.getController();
		
		primaryStage.setTitle("Hola Mundo FXML");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
