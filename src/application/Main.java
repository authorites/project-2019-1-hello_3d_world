package application;

import gui.Split;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		Group root = new Group();
		Split layout = new Split(root, primaryStage);
		
		Scene scene = new Scene(layout, 1400, 700, true, SceneAntialiasing.DISABLED);
		scene.setFill(Color.BLACK);
		layout.getAccordion().getColorPicker().setOnAction(event -> {
			layout.getSubScene().setFill(layout.getAccordion().getColorPicker().getValue());              
        });
		
		layout.getSubScene().setCamera(layout.getCamera());
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Hello_3d_World");
		primaryStage.setScene(scene);
		primaryStage.show();
	
}

	public static void main(String[] args) {
		launch(args);
	}
}
