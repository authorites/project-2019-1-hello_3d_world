package application;

import Object.SmartGroup;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		HBox root = new HBox();
		
		Box box1 = new Box(100, 50, 20);
		
		SmartGroup group = new SmartGroup();
		group.getChildren().addAll(box1);
		
		root.getChildren().addAll(group);
		
		Camera camera = new PerspectiveCamera();
		
		Scene scene = new Scene(root, 800, 500, true, SceneAntialiasing.BALANCED);
		scene.setFill(Color.SILVER);
		
		scene.setCamera(camera);
		
		primaryStage.setTitle("3d");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
