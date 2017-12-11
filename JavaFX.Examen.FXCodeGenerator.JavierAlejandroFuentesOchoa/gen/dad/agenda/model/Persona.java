package dad.agenda.model;

import java.time.LocalDate;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Persona extends Identificable {
	private StringProperty nombre;
	private StringProperty apellidos;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private ReadOnlyIntegerWrapper edad;
	private ListProperty<Telefono> telefonos;

	public Persona() {
		super();
		nombre = new SimpleStringProperty(this, "nombre");
		apellidos = new SimpleStringProperty(this, "apellidos");
		fechaNacimiento = new SimpleObjectProperty<>(this, "fechaNacimiento");
		edad = new ReadOnlyIntegerWrapper(this, "edad");
		telefonos = new SimpleListProperty<>(this, "telefonos", FXCollections.observableArrayList());
	}

	public String getNombre() {
		return this.nombreProperty().get();
	}

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidosProperty().get();
	}

	public void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}

	public StringProperty apellidosProperty() {
		return this.apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}

	public void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}

	public ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}

	public Integer getEdad() {
		return this.edadProperty().get();
	}

	public ReadOnlyIntegerProperty edadProperty() {
		return this.edad.getReadOnlyProperty();
	}

	public ObservableList<Telefono> getTelefonos() {
		return this.telefonosProperty().get();
	}

	public void setTelefonos(final ObservableList<Telefono> telefonos) {
		this.telefonosProperty().set(telefonos);
	}

	public ListProperty<Telefono> telefonosProperty() {
		return this.telefonos;
	}

}
