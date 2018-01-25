package dad.contactos;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contacto {
	private StringProperty nombre;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private LongProperty telefono;

	public Contacto() {
		nombre = new SimpleStringProperty(this, "nombre");
		fechaNacimiento = new SimpleObjectProperty<LocalDate>(this, "fechaNacimiento");
		telefono = new SimpleLongProperty(this, "telefono");
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}

	public String getNombre() {
		return this.nombreProperty().get();
	}

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}

	public void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}

	public LongProperty telefonoProperty() {
		return this.telefono;
	}

	public long getTelefono() {
		return this.telefonoProperty().get();
	}

	public void setTelefono(final long telefono) {
		this.telefonoProperty().set(telefono);
	}
	
	@Override
	public String toString() {
		return getNombre();
	}

}
