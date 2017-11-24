package dad.componentespc.model;

import java.time.LocalDate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Equipo {
	
	private StringProperty id;
	private ObjectProperty<LocalDate> fechaEnsamblado;
	private ObjectProperty<Componentes> masCaro;
	private ListProperty<Componentes> componentes;

	public Equipo() {

		id = new SimpleStringProperty(this, "id");
		fechaEnsamblado = new SimpleObjectProperty<>(this, "fechaEnsamblado");
		masCaro = new SimpleObjectProperty<>(this, "masCaro");
		componentes = new SimpleListProperty<>(this, "componentes", FXCollections.observableArrayList());

	}

	public final StringProperty idProperty() {
		return this.id;
	}

	public final String getId() {
		return this.idProperty().get();
	}

	public final void setId(final String id) {
		this.idProperty().set(id);
	}

	public final ObjectProperty<LocalDate> fechaEnsambladoProperty() {
		return this.fechaEnsamblado;
	}

	public final LocalDate getFechaEnsamblado() {
		return this.fechaEnsambladoProperty().get();
	}

	public final void setFechaEnsamblado(final LocalDate fechaEnsamblado) {
		this.fechaEnsambladoProperty().set(fechaEnsamblado);
	}

	public final ObjectProperty<Componentes> masCaroProperty() {
		return this.masCaro;
	}

	public final Componentes getMasCaro() {
		return this.masCaroProperty().get();
	}

	public final void setMasCaro(final Componentes masCaro) {
		this.masCaroProperty().set(masCaro);
	}

	public final ListProperty<Componentes> componentesProperty() {
		return this.componentes;
	}

	public final ObservableList<Componentes> getComponentes() {
		return this.componentesProperty().get();
	}

	public final void setComponentes(final ObservableList<Componentes> componentes) {
		this.componentesProperty().set(componentes);
	}

}
