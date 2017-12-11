package dad.agenda.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Identificable {
	private LongProperty id;

	public Identificable() {
		id = new SimpleLongProperty(this, "id");
	}

	public Long getId() {
		return this.idProperty().get();
	}

	public void setId(final Long id) {
		this.idProperty().set(id);
	}

	public LongProperty idProperty() {
		return this.id;
	}

}
