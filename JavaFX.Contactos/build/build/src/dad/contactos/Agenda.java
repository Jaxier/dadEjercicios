package dad.contactos;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Agenda {
	private ListProperty<Contacto> contactos;

	public Agenda() {
		contactos = new SimpleListProperty<Contacto>(this, "contactos",
				FXCollections.observableArrayList(value -> new Observable[] { 
						value.nombreProperty(),
						value.fechaNacimientoProperty(), 
						value.telefonoProperty() 
					}));
	}

	public ListProperty<Contacto> contactosProperty() {
		return this.contactos;
	}

	public ObservableList<Contacto> getContactos() {
		return this.contactosProperty().get();
	}

	public void setContactos(final ObservableList<Contacto> contactos) {
		this.contactosProperty().set(contactos);
	}

}
