package dad.dogs.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dad.dogs.restapi.client.DogsService;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class DogsController implements Initializable {

	// modelo
	private DogsModel model;
	
	// vista
	private DogsView view;
	
	// lógica de negocio
	private DogsService service;
	
	public DogsController() {
		model = new DogsModel();
		view = new DogsView();
		service = new DogsService();
		initialize(null, null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.selectedBreedProperty().bind(view.getBreedsCombo().getSelectionModel().selectedItemProperty());
		model.selectedBreedProperty().addListener((o, ov, nv) -> refreshImage());
		view.getRefreshButton().setOnAction(e -> refreshImage());
		loadBreeds();
		view.getBreedsCombo().getSelectionModel().selectFirst();
		
		view.getDogImage().imageProperty().bind(model.imageProperty());
	}
	
	private void loadBreeds() {
//		model.getBreeds().setAll(service.getBreeds());
		Task<List<String>> task = new Task<List<String>>() {
			@Override
			protected List<String> call() throws Exception {
				
				return service.getBreeds();
			}
		};
		task.setOnSucceeded(e -> {			
			List<String> breeds = (List) e.getSource().getValue();
			model.getBreeds().setAll(breeds);
			view.getBreedsCombo().itemsProperty().bind(model.breedsProperty());
		});
		
		task.setOnFailed(e -> {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error al cargar las razas de perros.");
			alert.setContentText(e.getSource().getException().getMessage());
		});
		new Thread(task).start();
		
	}

	private void refreshImage() {
		String breed = model.getSelectedBreed();
		Task<URL> task = new Task<URL>() {
			@Override
			protected URL call() throws Exception {
				return service.getRandomImage(breed);
			}
		};
		
		task.setOnSucceeded(e -> {
			URL url = (URL) e.getSource().getValue();
			model.setImage(new Image(url.toExternalForm()));
		});
		task.setOnFailed(e -> {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error al cargar las razas de perros."+breed);
			alert.setContentText(e.getSource().getException().getMessage());
		});
		
		task.stateProperty().addListener((o,ov,nv) -> {
			System.out.println(nv);
		});
		view.getRefreshButton().disableProperty().bind(
				task.runningProperty());
		
		new Thread(task).start();
		
	}
	
	public DogsView getView() {
		return view;
	}

}



