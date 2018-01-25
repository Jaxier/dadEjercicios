package dad.chat.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class ConversacionModel {

	private StringProperty nombre = new SimpleStringProperty(this, "nombre");
	private StringProperty mensaje = new SimpleStringProperty(this, "mensaje");
	private ObjectProperty<Date> date = new SimpleObjectProperty<>(this, "hora");
	private ObjectProperty<Image> imagen = new SimpleObjectProperty<>(this, "imagen",
			new Image("file:src/dad/resources/people.png"));
	
	public LocalDate toLocalDate() {
		return date.get().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public String getDateHours() {		
		return new SimpleDateFormat("HH:mm").format(getDate()); 
	}
	
	public String getDateDDMMYY() {
		 		
		return new SimpleDateFormat("dd/MM/yyyy").format(getDate());
	}
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}

	public final String getMensaje() {
		return this.mensajeProperty().get();
	}

	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}

	public final ObjectProperty<Date> dateProperty() {
		return this.date;
	}

	public final Date getDate() {
		return this.dateProperty().get();
	}

	public final void setDate(final Date date) {
		this.dateProperty().set(date);
	}

	public final ObjectProperty<Image> imagenProperty() {
		return this.imagen;
	}

	public final Image getImagen() {
		return this.imagenProperty().get();
	}

	public final void setImagen(final Image imagen) {
		this.imagenProperty().set(imagen);
	}

}
