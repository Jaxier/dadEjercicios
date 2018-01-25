package dad.chat.components;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.chat.models.ConversacionModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ConversacionView extends HBox implements Initializable {

	private ObjectProperty<ConversacionModel> conversacion = new SimpleObjectProperty<>(this, "contacto");

	@FXML
	private HBox conversacionHBox;

	@FXML
	private ProfileImage profileImage;

	@FXML
	private Label nombreLabel;

	@FXML
	private Label mensajeLabel;

	@FXML
	private Label horaLabel;

	public ConversacionView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ConversacionView.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		this.conversacion.addListener((object, oldValue, newValue) -> {
			if (newValue != null) {
				
				profileImage.imageProperty().bind(newValue.imagenProperty());
				nombreLabel.textProperty().bind(newValue.nombreProperty());
				mensajeLabel.textProperty().bind(Bindings.format("%.15s %s", newValue.mensajeProperty(), "..."));

				horaLabel.textProperty().bind(Bindings.createStringBinding(()->{
					if (newValue.toLocalDate().compareTo(LocalDate.now()) <0) {
						return newValue.getDateDDMMYY();
					} else {
						return newValue.getDateHours();
					}
				}));
			}
		});

	}
	
	public HBox getConversacionHBox() {
		return conversacionHBox;
	}
	
	public final ObjectProperty<ConversacionModel> conversacionProperty() {
		return this.conversacion;
	}
	
	public final ConversacionModel getConversacion() {
		return this.conversacionProperty().get();
	}
	
	public final void setConversacion(final ConversacionModel conversacion) {
		this.conversacionProperty().set(conversacion);
	}

}
