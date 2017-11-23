package dad.calculadorafxml.main;

import dad.calculadorafxml.mvc.Calculadora;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {
	
	private Calculadora controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		String patch = "/dad/calculadorafxml/mvc/CalculadoraFXMLView.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(patch));
		VBox root = loader.load();
		controller = loader.getController();
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}