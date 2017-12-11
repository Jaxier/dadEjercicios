package dad.agenda.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono extends Identificable {
	private StringProperty numero;

	public Telefono() {
		super();
		numero = new SimpleStringProperty(this, "numero");
	}

	public String getNumero() {
		return this.numeroProperty().get();
	}

	public void setNumero(final String numero) {
		this.numeroProperty().set(numero);
	}

	public StringProperty numeroProperty() {
		return this.numero;
	}

}
