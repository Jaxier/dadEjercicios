package dad.cgi.view;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.cgi.GUI;
import dad.cgi.model.Comando;
import dad.cgi.model.Historial;
import dad.cgi.model.Interprete;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class MainViewController implements Initializable {

	@FXML
    private MenuItem menuItemNuevo, menuItemAbrir,menuItemGuardar,menuItemSalir;

	@FXML
	private TabPane tabPane;
	
    @FXML
    private Tab tabComando;
    
    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TextField textFieldOrden;

    @FXML
    private ListView<String> listViewParametros;

    @FXML
    private ComboBox<Interprete> comboBoxInterprete;

    @FXML
    private Label labelComandoCompleto;

    @FXML
    private CheckBox checkBoxGuardar;
    
    @FXML
    private Button buttonQuitarParametro,buttonAgregarParametro;
    
    @FXML
    private Button buttonEjecutar,buttonGuardar,buttonVaciar,buttonEjecutarHistorial;

    @FXML
    private Tab tabHistorial;

    @FXML
    private TableView<?> tableViewHistorial;

    @FXML
    private TableColumn<?, ?> tableColumnInterprete;

    @FXML
    private TableColumn<?, ?> tableColumnComando;

    @FXML
    private TableColumn<?, ?> tableColumnDescripcion;

    @FXML
    private Button buttonLimpiarHistorial;

    @FXML
    private Tab tabConsola;

    @FXML
    private TextArea textAreaConsola;
	
    // Model
    private Comando comando;
    private Historial historial;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		comando = new Comando();
		historial = new Historial();
		
		/*
		 * Menu
		 * */
		menuItemAbrir.setOnAction(e -> onMenuAbrir(e));
		menuItemSalir.setOnAction(e -> onMenuSalir(e));
		/*
		 * Comando
		 * */
		textFieldDescripcion.textProperty().bind(comando.descripcionProperty());
		textFieldOrden.textProperty().bind(comando.ordenProperty());
		listViewParametros.itemsProperty().bind(comando.parametrosProperty());
		
		labelComandoCompleto.textProperty().bind(comando.asString());
		comboBoxInterprete.getItems().addAll(Interprete.values());
		comando.interpreteProperty().bind(comboBoxInterprete.valueProperty());
		
		buttonQuitarParametro.disableProperty().bind(comando.parametrosProperty().emptyProperty());
		buttonEjecutar.disableProperty().bind(comando.ordenProperty().isEmpty());
		buttonGuardar.disableProperty().bind(comando.ordenProperty().isEmpty());
		
		buttonAgregarParametro.setOnAction(e -> onAgregarNuevoParametro(e));
		buttonQuitarParametro.setOnAction(e -> onQuitarParametro(e));
		
		buttonEjecutar.setOnAction(e -> onEjecutarComando(e));
		buttonGuardar.setOnAction(e -> onGuardarComando(e));
		buttonVaciar.setOnAction(e -> onLimpiar(e));
		
		/*
		 * Historial
		 * */
		//TODO 
//		tableViewHistorial.itemsProperty().bind(historial.comandosProperty());
		
//		tableColumnComando.setCellValueFactory(value -> value.getValue().);
		
	}
	
	private void onMenuSalir(ActionEvent e) {
		GUI.getStage().close();
	}

	private void onMenuAbrir(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		
    	fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("Historial de comandos", "*.histgory"),
    			new ExtensionFilter("Todos los archivos", "*.*"));
    	File fichero = fileChooser.showOpenDialog(GUI.getStage());
    	
    	if (fichero != null) {
			try {
				//TODO
				//Historial.load(fichero);
			} catch (Exception exeption) {
				exeption.printStackTrace();
			}
		}
	}

	private void onLimpiar(ActionEvent e) {
		comando.setDescripcion("");
		comando.setOrden("");
		comando.getParametros().clear();
		textAreaConsola.clear();
	}
	
	private void onGuardarComando(ActionEvent e) {
		//TODO
	}

	private void onEjecutarComando(ActionEvent e) {
		comando.ejecutar();
		String resultado;
		resultado = "Comando: " + comando
				+"\nSalida:  " + comando.getSalida()
				+"\nError:   " + comando.getError()
				+"\nRetorno: " + comando.getValorRetorno();
		textAreaConsola.setText(resultado);
		tabPane.getSelectionModel().select(tabConsola);
	}

	private void onQuitarParametro(ActionEvent e) {
		comando.parametrosProperty().remove(listViewParametros.getSelectionModel().getSelectedIndex());
	}

	private void onAgregarNuevoParametro(ActionEvent e) {
		TextInputDialog alertNuevoParametro = new TextInputDialog();
		alertNuevoParametro.initOwner(GUI.getStage());
		alertNuevoParametro.setHeaderText("Introduce el valor del parámetro.");
		alertNuevoParametro.setContentText("Parámetro:");
		Optional<String> result = alertNuevoParametro.showAndWait();
		if (result.isPresent()){
			comando.getParametros().add(result.get());
		}	
		
	}

}
