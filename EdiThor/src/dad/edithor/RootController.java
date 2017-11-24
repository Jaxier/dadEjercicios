package dad.edithor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class RootController implements Initializable {

	private StringProperty contenido = new SimpleStringProperty(this, "contenido");
	
	@FXML
	private BorderPane view;
	
	@FXML
	private TextArea contenidoText;
	
	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RootView.fxml"));
		loader.setController(this);
		loader.load();
	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		contenido.bind(contenidoText.textProperty());
		
	}
		
    @FXML
    void onAbrirButtonAction(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().add(
    			new ExtensionFilter("Fichero de texto", "*.txt"));
    	File fichero = fileChooser.showOpenDialog(null);
    	
    	if (fichero != null) {
			try {
				contenido.set(new String(Files.readAllBytes(fichero.toPath())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

    @FXML
    void onNuevoButtonAction(ActionEvent event) {

    }
    public BorderPane getView() {
		return view;
	}
}
