package dad.dogs.ui;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class DogsModel {
	private ListProperty<String> breeds;
	private StringProperty selectedBreed;
	private ObjectProperty<Image> image;

	public DogsModel() {
		breeds = new SimpleListProperty<>(this, "breeds", FXCollections.observableArrayList());
		selectedBreed = new SimpleStringProperty(this, "selectedBreed");
		image = new SimpleObjectProperty<>(this, "image");
	}

	public ListProperty<String> breedsProperty() {
		return this.breeds;
	}
	

	public ObservableList<String> getBreeds() {
		return this.breedsProperty().get();
	}
	

	public void setBreeds(final ObservableList<String> breeds) {
		this.breedsProperty().set(breeds);
	}
	

	public StringProperty selectedBreedProperty() {
		return this.selectedBreed;
	}
	

	public String getSelectedBreed() {
		return this.selectedBreedProperty().get();
	}
	

	public void setSelectedBreed(final String selectedBreed) {
		this.selectedBreedProperty().set(selectedBreed);
	}
	

	public ObjectProperty<Image> imageProperty() {
		return this.image;
	}
	

	public Image getImage() {
		return this.imageProperty().get();
	}
	

	public void setImage(final Image image) {
		this.imageProperty().set(image);
	}
	
	
	
}
