package dad.componentespc.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DiscoDuro extends Componentes {
	
	private DoubleProperty capacidad;
	private BooleanProperty sdd;
	private IntegerProperty velocidad;
	private ObjectProperty<Puerto> puerto;
		
	public DiscoDuro() {
		super();
		capacidad = new SimpleDoubleProperty(this,"capacidad");
		this.sdd = new SimpleBooleanProperty(this,"sdd");
		this.velocidad = new SimpleIntegerProperty(this, "velocidad");
		this.puerto = new SimpleObjectProperty<>(this, "puerto");
	}

	public final DoubleProperty capacidadProperty() {
		return this.capacidad;
	}
	
	public final double getCapacidad() {
		return this.capacidadProperty().get();
	}
	
	public final void setCapacidad(final double capacidad) {
		this.capacidadProperty().set(capacidad);
	}
	
	public final BooleanProperty sddProperty() {
		return this.sdd;
	}
	
	public final boolean isSdd() {
		return this.sddProperty().get();
	}
	
	public final void setSdd(final boolean sdd) {
		this.sddProperty().set(sdd);
	}
	
	public final IntegerProperty velocidadProperty() {
		return this.velocidad;
	}
	
	public final int getVelocidad() {
		return this.velocidadProperty().get();
	}
	
	public final void setVelocidad(final int velocidad) {
		this.velocidadProperty().set(velocidad);
	}
	
	public final ObjectProperty<Puerto> puertoProperty() {
		return this.puerto;
	}
	
	public final Puerto getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final Puerto puerto) {
		this.puertoProperty().set(puerto);
	}
	
	
	
	
}
