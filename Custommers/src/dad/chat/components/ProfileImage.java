package dad.chat.components;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ProfileImage extends ImageView {

	private Circle clip = new Circle();
		
	public ProfileImage() {
		super("file:src/images/people.png");
		
		setFitHeight(50);
		setFitWidth(50);
		
		clip.centerXProperty().bind(fitHeightProperty().divide(2));
		clip.centerYProperty().bind(fitWidthProperty().divide(2));
		
		clip.radiusProperty().bind(
        		(fitHeightProperty().divide(2))
        		.add(getFitWidth()/2).divide(2)
        		);
		
		setClip(clip);		
		
	}
	
}
