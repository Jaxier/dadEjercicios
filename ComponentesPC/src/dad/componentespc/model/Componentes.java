package dad.componentespc.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Componentes {
	
	private StringProperty marca;
	private StringProperty modelo;
	
	public Componentes() {
		marca = new SimpleStringProperty(this, "marca");
		modelo = new SimpleStringProperty(this, "modelo");
	}
	
	public final StringProperty marcaProperty() {
		return this.marca;
	}
	
	public final String getMarca() {
		return this.marcaProperty().get();
	}
	
	public final void setMarca(final String marca) {
		this.marcaProperty().set(marca);
	}
	
	public final StringProperty modeloProperty() {
		return this.modelo;
	}
	
	public final String getModelo() {
		return this.modeloProperty().get();
	}
	
	public final void setModelo(final String modelo) {
		this.modeloProperty().set(modelo);
	}
	
	
	
	
}
