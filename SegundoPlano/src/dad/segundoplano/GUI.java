package dad.segundoplano;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	private ProgresoController control;
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		GUI.primaryStage = primaryStage;
		control = new ProgresoController();
		
		primaryStage.titleProperty().bind(
				Bindings.concat("Segundo plano - ").concat(control.progresoProperty()).concat("%")
				);
		
//		primaryStage.setTitle("Progreso");
		primaryStage.setScene(new Scene(control.getView()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
