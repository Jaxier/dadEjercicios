package dad.cgi.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement
@XmlType
public class Historial {

	private ListProperty<Comando> comandos;

	public Historial() {
		comandos = new SimpleListProperty<>(this, "comandos", FXCollections.observableArrayList());
	}

	public final ListProperty<Comando> comandosProperty() {
		return this.comandos;
	}

	@XmlElement(name = "comando")
	public final ObservableList<Comando> getComandos() {
		return this.comandosProperty().get();
	}

	public final void setComandos(final ObservableList<Comando> comandos) {
		this.comandosProperty().set(comandos);
	}
	
	public void save(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Historial.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this, file);
	}

	public static Historial load(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Historial.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (Historial) unmarshaller.unmarshal(file);
	}

}
