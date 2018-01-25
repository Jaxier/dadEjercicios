package dad.contactos;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactosApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Contacto c1 = new Contacto();
		c1.setNombre("Perico");
		c1.setFechaNacimiento(LocalDate.of(1998, 4, 25));
		c1.setTelefono(922102030L);

		Contacto c2 = new Contacto();
		c2.setNombre("Juancho");
		c2.setFechaNacimiento(LocalDate.of(1987, 7, 3));
		c2.setTelefono(666777111L);

		Agenda agenda = new Agenda();
		agenda.getContactos().addAll(c1, c2);
		
		ContactosController contactosController = new ContactosController();
		contactosController.bind(agenda);
		
		primaryStage.setTitle("Contactos");
		primaryStage.setScene(new Scene(contactosController.getView(), 640, 480));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
