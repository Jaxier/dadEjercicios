package dad.chat;

import java.time.LocalDate;
import java.util.Date;

import dad.chat.components.ConversacionView;
import dad.chat.components.ListaConversacion;
import dad.chat.models.ConversacionModel;
import dad.chat.models.HoraObservable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test extends Application{
	
	public static HoraObservable horaApp = new HoraObservable();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Date date = new Date();
		
		System.out.println();
		ListaConversacion listaConversacion = new ListaConversacion();
		Date fecha = new Date();
		
		ConversacionModel cm1 = new ConversacionModel();
		cm1.setNombre("Juan");
		cm1.setMensaje("Hola juanito este es un mensaje largo");
		cm1.setDate(fecha);
		
		listaConversacion.getListaConversacion().add(cm1);
		
		ConversacionModel cm2 = new ConversacionModel();
		cm2.setNombre("Pepe");
		cm2.setMensaje("Hola juanito este es un mensaje largo");
		cm2.setDate(new Date());
		
		cm1.setImagen(new Image("file:src/dad/resources/people.png"));
		listaConversacion.getListaConversacion().add(cm2);
		
		ConversacionView cv = new ConversacionView();
		HBox prueba = new HBox();
		ImageView imagen = new ImageView(new Image("file:src/dad/resources/people.png"));
		prueba.getChildren().add(imagen);
		primaryStage.setScene(new Scene(listaConversacion));
		primaryStage.setOnCloseRequest(e->{
			
		});
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		horaApp.start();
		launch(args);
		
	}
	public static HoraObservable getHoraApp() {
		return horaApp;
	}
	
}
