package dad.micv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {


    @FXML
    private MenuItem menuItemNuevo;

    @FXML
    private MenuItem menuItemAbrir;

    @FXML
    private MenuItem menuItemGuardar;

    @FXML
    private MenuItem menuItemGuardarComo;

    @FXML
    private MenuItem menuItemSalir;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    private Tab tabPersonal;

    @FXML
    private Tab tabContacto;

    @FXML
    private Tab tabFormacion;

    @FXML
    private Tab tabExperiencia;

    @FXML
    private Tab tabConocimientos;
	
    private BorderPane view;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dad/micv/vista/MainView.fxml"));
		loader.setController(this);
		
		try {
			view = loader.load();
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}		
	}
	
	

}
