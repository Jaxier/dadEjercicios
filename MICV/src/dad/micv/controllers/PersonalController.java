package dad.micv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.micv.model.Personal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {
	
	@FXML
    private GridPane gridPaneView;
	
	@FXML
    private TextField dniTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidosTextField;

    @FXML
    private DatePicker nacimientoDatePicker;

    @FXML
    private TextArea direccionTextArea;

    @FXML
    private TextField codigoPostalTextField;

    @FXML
    private TextField localidadTextField;

    @FXML
    private ComboBox<?> paisComboBox;

    @FXML
    private ListView<?> nacionalidadListView;

    @FXML
    private Button addNacionalidadButton;

    @FXML
    private Button deleteNacionalidadButton;
    
    // Model
    private Personal personalModel;
    
	public PersonalController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dad/micv/vista/PersonalView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		personalModel = new Personal();
		
		personalModel.identificacionProperty().bindBidirectional(dniTextField.textProperty());
		personalModel.nombreProperty().bindBidirectional(nombreTextField.textProperty());
		personalModel.apellidoProperty().bindBidirectional(apellidosTextField.textProperty());
		personalModel.fechaNacimientoProperty().bindBidirectional(nacimientoDatePicker.valueProperty());
		personalModel.direccionProperty().bindBidirectional(direccionTextArea.textProperty());
		personalModel.codigoPostalProperty().bindBidirectional(codigoPostalTextField.textProperty());
		personalModel.localidadProperty().bindBidirectional(localidadTextField.textProperty());
		
		personalModel.paisProperty().bind(paisComboBox.itemsProperty());

	}

	
	
}
