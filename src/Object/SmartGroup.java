package Object;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class SmartGroup extends Group {
		
		private Rotate r;
		private Transform t = new Rotate();
			
		public void translateZ(int ang) {
			t = t.createConcatenation(new Translate(0, 0, ang));
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
			
		}
		
		public void rotateByX(int ang) {
			r = new Rotate(ang, Rotate.X_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		public void rotateByY(int ang) {
			r = new Rotate(ang, Rotate.Y_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		public void front() {
			r = new Rotate(0, Rotate.X_AXIS);
			t = r.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		public void sideX(int ang) {
			front();
			r = new Rotate(ang, Rotate.X_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		public void sideY(int ang) {
			front();
			r = new Rotate(ang, Rotate.Y_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
}