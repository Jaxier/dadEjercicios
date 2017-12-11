package dad.cgi.model;

import java.nio.charset.Charset;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.io.IOUtils;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
public class Comando {

	private StringProperty descripcion;
	private StringProperty orden;
	private ListProperty<String> parametros;
	private ObjectProperty<Interprete> interprete;
	private ReadOnlyIntegerWrapper valorRetorno;
	private ReadOnlyStringWrapper salida;
	private ReadOnlyStringWrapper error;

	public Comando() {
		descripcion = new SimpleStringProperty(this, "descripcion");
		orden = new SimpleStringProperty(this, "orden", "");
		parametros = new SimpleListProperty<>(this, "parametros", FXCollections.observableArrayList());
		interprete = new SimpleObjectProperty<>(this, "interprete");
		valorRetorno = new ReadOnlyIntegerWrapper(this, "valorRetorno");
		salida = new ReadOnlyStringWrapper(this, "salida");
		error = new ReadOnlyStringWrapper(this, "error");
	}

	public final StringProperty descripcionProperty() {
		return this.descripcion;
	}

	@XmlAttribute
	public final String getDescripcion() {
		return this.descripcionProperty().get();
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}

	public final StringProperty ordenProperty() {
		return this.orden;
	}

	@XmlElement
	public final String getOrden() {
		return this.ordenProperty().get();
	}

	public final void setOrden(final String orden) {
		this.ordenProperty().set(orden);
	}

	public final ListProperty<String> parametrosProperty() {
		return this.parametros;
	}

	@XmlElement(name = "parametro")
	public final ObservableList<String> getParametros() {
		return this.parametrosProperty().get();
	}

	public final void setParametros(final ObservableList<String> parametros) {
		this.parametrosProperty().set(parametros);
	}

	public final ObjectProperty<Interprete> interpreteProperty() {
		return this.interprete;
	}

	@XmlAttribute
	public final Interprete getInterprete() {
		return this.interpreteProperty().get();
	}

	public final void setInterprete(final Interprete interprete) {
		this.interpreteProperty().set(interprete);
	}

	public final javafx.beans.property.ReadOnlyIntegerProperty valorRetornoProperty() {
		return this.valorRetorno.getReadOnlyProperty();
	}

	@XmlTransient
	public final int getValorRetorno() {
		return this.valorRetornoProperty().get();
	}

	public final javafx.beans.property.ReadOnlyStringProperty salidaProperty() {
		return this.salida.getReadOnlyProperty();
	}

	@XmlTransient
	public final String getSalida() {
		return this.salidaProperty().get();
	}

	public final javafx.beans.property.ReadOnlyStringProperty errorProperty() {
		return this.error.getReadOnlyProperty();
	}

	@XmlTransient
	public final String getError() {
		return this.errorProperty().get();
	}

	public int ejecutar() {
		try {
			String comando = getComandoCompleto();
			String[] comandoDividido = comando.split("[ ]+");
			ProcessBuilder processBuilder = new ProcessBuilder(comandoDividido);
			Process process = processBuilder.start();
			process.getOutputStream().close();
			salida.set(IOUtils.toString(process.getInputStream(), Charset.defaultCharset()).trim());
			error.set(IOUtils.toString(process.getErrorStream(), Charset.defaultCharset()).trim());
			valorRetorno.set(process.exitValue());
		} catch (Exception e) {
			valorRetorno.set(-1);
			e.printStackTrace();
		}
		return getValorRetorno();
	}
	
	private String getComandoCompleto() {
		return getInterprete().getCommand() + " " + toString();		
	}
	
	public StringBinding asString() {
		return Bindings.createStringBinding(() -> toString(), orden, parametros);
	}
	
	@Override
	public String toString() {
		return getOrden() + " " + getParametros().stream().collect(Collectors.joining(" "));
	}
	
	public void vaciar() {
		setDescripcion("");
		setOrden("");
		setInterprete(null);
		getParametros().clear();
	}
	
	public Comando clonar() {
		Comando clon = new Comando();
		clon.setDescripcion(getDescripcion());
		clon.setOrden(getOrden());
		clon.setInterprete(getInterprete());
		clon.getParametros().setAll(getParametros());
		return clon;
	}
	
}
