package Object;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class SmartGroup extends Group {
		
		private Rotate r;
		private Transform t = new Rotate();
		
		public void rotateByX(int ang) {
			r = new Rotate(ang, Rotate.X_AXIS);
			t = r.createConcatenation(r);
//			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		public void rotateByY(int ang) {
			r = new Rotate(ang, Rotate.Y_AXIS);
			t = r.createConcatenation(r);
//			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
}