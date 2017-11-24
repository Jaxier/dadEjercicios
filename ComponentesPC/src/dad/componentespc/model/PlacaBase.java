package dad.componentespc.model;

import javafx.beans.property.StringProperty;

public class PlacaBase extends Componentes {
	
	private StringProperty socket;

	public final StringProperty socketProperty() {
		return this.socket;
	}
	

	public final String getSocket() {
		return this.socketProperty().get();
	}
	

	public final void setSocket(final String socket) {
		this.socketProperty().set(socket);
	}
	
	
	
	
}
