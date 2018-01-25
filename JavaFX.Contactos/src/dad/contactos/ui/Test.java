package dad.contactos.ui;

import java.io.File;
import java.time.LocalDate;

import dad.contactos.ui.model.Agenda;
import dad.contactos.ui.model.Contacto;
import dad.contactos.ui.model.Telefono;
import dad.contactos.ui.model.TipoTelefono;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Test extends Application {
		
	@Override
	public void start(Stage primaryStage) throws Exception {

		Contacto c1 = new Contacto();
		c1.setNombre("Chuck");
		c1.setApellidos("Norris");
		c1.setFechaNacimiento(LocalDate.of(1956, 3, 25));
		c1.setFoto(new Image("https://upload.wikimedia.org/wikipedia/commons/3/30/Chuck_Norris_May_2015.jpg"));
		c1.getTelefonos().add(new Telefono("922102030", TipoTelefono.CASA));
		c1.getTelefonos().add(new Telefono("666777888", TipoTelefono.FAX));
		
		Agenda agenda = new Agenda();
		agenda.getContactos().addAll(c1);
		agenda.save(new File("contactos.xml"));
		
		Platform.exit();
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
