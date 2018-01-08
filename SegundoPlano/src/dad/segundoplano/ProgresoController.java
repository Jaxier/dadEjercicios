package dad.segundoplano;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;

public class ProgresoController implements Initializable {
	
	//Model
	private IntegerProperty progreso = new SimpleIntegerProperty(this, "progreso");
	private StringProperty mensaje = new SimpleStringProperty(this, "mensaje");
	private BooleanProperty ejecutando = new SimpleBooleanProperty(this, "ejecutando");
	
	// View
	
    @FXML
    private ProgressBar progresoBar;
    
    @FXML
    private ProgressIndicator progresoIndicator;
    
    @FXML
    private Label labelMensaje;

    @FXML
    private Button buttonIniciar;

    @FXML
    private Button buttonDetener;
    
    private VBox view;
    
    private Task<Void> tarea;
    
    public ProgresoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgresoView.fxml"));
		loader.setController(this);
		view = loader.load();
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		labelMensaje.textProperty().bind(mensaje);
		
		progresoIndicator.progressProperty().bind(progreso.divide(100.0));
		progresoBar.progressProperty().bind(progreso.divide(100.0));
		
		buttonIniciar.disableProperty().bind(ejecutando);
		buttonDetener.disableProperty().bind(ejecutando.not());
			
		mensaje.set("Detenido");
		progreso.set(0);
		
	}
	
    @FXML
    private void OnActionDetener(ActionEvent event) {
    	tarea.cancel(true);
    }

    @FXML
    private void OnActionIniciar(ActionEvent event) {
    	tarea = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				int MAX = 1000;
//				updateProgress(-1.0, MAX);
				for (int i = 0; i < MAX; i++) {
					updateProgress(i, MAX);
					if (i<300) {
						updateMessage("Cargando lo que tu sabe");
					}else if (i >=300 && i<=750)
						updateMessage("Cargando la trocola");
					else if (i > 750 && i<=900)
//						try {
//							throw new Exception("La junta de la troco no se caliente");
//						} catch (Exception e) {
//							updateProgress(0, 0);
//							updateMessage("Detenido");
//						}
						
						updateMessage("Ya casi estamos");					
					Thread.sleep(10L);
				}
				updateProgress(MAX, MAX);
				updateMessage("Vamanos");
				
				return null;
			}
			@Override
			protected void cancelled() {
				updateProgress(0, 0);
				updateMessage("Cancelado");
				super.cancelled();
			}
    		
		};
		tarea.setOnSucceeded(e -> {
			System.out.println("Termino Bien");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Éxito");
			alert.setHeaderText("La tarea terminó correctamente");
			alert.setContentText(tarea.getMessage());
			alert.showAndWait();
		});
		tarea.setOnFailed(e -> {
			System.out.println("Fallo: "+tarea.getException().getMessage());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fallo");
			alert.setHeaderText("La tarea terminó malllll");
			alert.setContentText(tarea.getException().getMessage());
			alert.showAndWait();
		});
		
		ejecutando.bind(tarea.runningProperty());
		progreso.bind(tarea.progressProperty().multiply(100));
		mensaje.bind(tarea.messageProperty());
		new Thread(tarea).start();		
		
    }

    public VBox getView() {
		return view;

	}

	public final IntegerProperty progresoProperty() {
		return this.progreso;
	}
	

	public final int getProgreso() {
		return this.progresoProperty().get();
	}
	

	public final void setProgreso(final int progreso) {
		this.progresoProperty().set(progreso);
	}
	
    
    
    
}
