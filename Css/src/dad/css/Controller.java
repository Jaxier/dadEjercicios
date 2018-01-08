package dad.css;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

	
	//Model
	private StringProperty nombre = new SimpleStringProperty(this, "nombre");
	private StringProperty saludo = new SimpleStringProperty(this, "saludo");
	
	//View
	
    @FXML
    private TextField nombreText;

    @FXML
    private Button saludarButton;

    @FXML
    private Button despedirButton;

    @FXML
    private Label saludoLabel;

    @FXML
    private Button salirButton;
	
    
    private VBox view;
    
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HolaMundo.fxml"));
		loader.setController(this);
		view = loader.load();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nombre.bind(nombreText.textProperty());
		
		saludoLabel.textProperty().bind(saludo);
				
	}
	
    @FXML
    private void DespedirOnAction(ActionEvent event) {
    	saludo.set("Adios " + nombre.get());
    }

    @FXML
    private void SalirOnAction(ActionEvent event) {
    	
    }

    @FXML
    private void SaludarOnAction(ActionEvent event) {
    	saludo.set("Hola " + nombre.get());
    }


	public VBox getView() {
		return view;
	}
    

}
