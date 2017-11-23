package dad.holamundo.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HolaMundoController implements Initializable {
	
	//MODEL
	private  StringProperty nombre = new SimpleStringProperty(this, "nombre");
	private  StringProperty saludo = new SimpleStringProperty(this, "saludo");
	
	//VIEW	
	@FXML
	private TextField nombreText;
	
	@FXML
	private Button saludarButton;
	
	@FXML
	private Label saludoLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nombre.bind(nombreText.textProperty());		
		saludoLabel.textProperty().bind(saludo);
	}
	
	@FXML
	private void onSaludarButtonAction(ActionEvent e) {
		saludo.set("¡Hola " + nombre.get() + "!");
	}
	
	@FXML
	private void onDespedirButtonAction(ActionEvent e) {
		saludo.set("¡Adios " + nombre.get() + "!");
	}
}
