package dad.dogs.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DogsApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		DogsController controller = new DogsController();
		
		primaryStage.setTitle("Dogs");
		primaryStage.setScene(new Scene(controller.getView(), 640, 480));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
