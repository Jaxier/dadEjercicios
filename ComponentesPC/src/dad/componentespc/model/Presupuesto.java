package dad.componentespc.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Presupuesto {
	private StringProperty cliente;
	private ListProperty<Equipo> equipos;

	public Presupuesto() {
		cliente = new SimpleStringProperty(this, "cliente");
		equipos = new SimpleListProperty<>(this, "equipos", FXCollections.observableArrayList());
	}

	public final StringProperty clienteProperty() {
		return this.cliente;
	}

	public final String getCliente() {
		return this.clienteProperty().get();
	}

	public final void setCliente(final String cliente) {
		this.clienteProperty().set(cliente);
	}

	public final ListProperty<Equipo> equiposProperty() {
		return this.equipos;
	}

	public final ObservableList<Equipo> getEquipos() {
		return this.equiposProperty().get();
	}

	public final void setEquipos(final ObservableList<Equipo> equipos) {
		this.equiposProperty().set(equipos);
	}

}
