package dad.micv.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	private ObjectProperty<Personal> personal;
	private ObjectProperty<Contacto> contacto;
	private ListProperty<Conocimiento> habilidades;
	private ListProperty<Experencia> experencias;
	private ListProperty<Titulo> formacion;

	public CV() {
		personal = new SimpleObjectProperty<Personal>(this, "personal", new Personal());
		contacto = new SimpleObjectProperty<Contacto>(this, "contacto", new Contacto());
		habilidades = new SimpleListProperty<>(this, "habilidades", FXCollections.observableArrayList());
		experencias = new SimpleListProperty<>(this, "experencias", FXCollections.observableArrayList());
		formacion = new SimpleListProperty<>(this, "formacion", FXCollections.observableArrayList());
	}

	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}

	public final ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}

	public final Contacto getContacto() {
		return this.contactoProperty().get();
	}

	public final void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}

	public final ListProperty<Conocimiento> habilidadesProperty() {
		return this.habilidades;
	}

	public final ObservableList<Conocimiento> getHabilidades() {
		return this.habilidadesProperty().get();
	}

	public final void setHabilidades(final ObservableList<Conocimiento> habilidades) {
		this.habilidadesProperty().set(habilidades);
	}

	public final ListProperty<Experencia> experenciasProperty() {
		return this.experencias;
	}

	public final ObservableList<Experencia> getExperencias() {
		return this.experenciasProperty().get();
	}

	public final void setExperencias(final ObservableList<Experencia> experencias) {
		this.experenciasProperty().set(experencias);
	}

	public final ListProperty<Titulo> formacionProperty() {
		return this.formacion;
	}

	public final ObservableList<Titulo> getFormacion() {
		return this.formacionProperty().get();
	}

	public final void setFormacion(final ObservableList<Titulo> formacion) {
		this.formacionProperty().set(formacion);
	}

}
