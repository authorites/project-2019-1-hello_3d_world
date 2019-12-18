package Object;

import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Translate;

public class PrepareCamera extends PerspectiveCamera{
	
	public PrepareCamera() {
		
		super(true);
		setNearClip(0.1);
		setFarClip(3000);
		getTransforms().add(new Translate(0, 0, -700));
	}

}
