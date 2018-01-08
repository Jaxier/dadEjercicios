package dad.css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class APP extends Application {

	public APP() {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Controller control = new Controller();
		
		primaryStage.setScene(new Scene(control.getView()));
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
