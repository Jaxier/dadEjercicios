package dad.cgi;

import java.io.File;

import dad.cgi.view.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {

	private static Stage primaryStage;
	
	private MainViewController controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
		BorderPane root = loader.load();
		controlador = new MainViewController();
		
		Image ico = new Image("dad/cgi/ui/resources/terminal-icon-32x32.png");
		primaryStage.getIcons().add(ico);
		primaryStage.setTitle("Interfaz Gráfica de Comandos");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
	/*
	 * 
	 * */
	public static Stage getStage() {
		return primaryStage;
	}
	
}
