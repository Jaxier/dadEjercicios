package dad.dogs.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DogsView extends VBox {

	private ComboBox<String> breedsCombo;
	private ImageView dogImage;
	private Button refreshButton;
	
	public DogsView() {
		breedsCombo = new ComboBox<>();
		
		dogImage = new ImageView();
		dogImage.setFitWidth(320);
		dogImage.setFitHeight(200);
		dogImage.setPreserveRatio(true);
		
		refreshButton = new Button("Volver a cargar");
		
		setSpacing(5);
		setAlignment(Pos.CENTER);
		getChildren().addAll(breedsCombo, dogImage, refreshButton);
		
	}

	public ComboBox<String> getBreedsCombo() {
		return breedsCombo;
	}

	public ImageView getDogImage() {
		return dogImage;
	}

	public Button getRefreshButton() {
		return refreshButton;
	}
	
}
