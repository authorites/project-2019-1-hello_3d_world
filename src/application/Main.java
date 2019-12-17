package application;


import Object.SmartGroup;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import logic.Controller3d;
import logic.Xform;

public class Main extends Application {
	
	private TabPane objectControllers;
	private SubScene subScene;
	private SubScene subScene1;
	private Pane pane;
	private ColorPicker colorPicker;
	private double anchorX, anchorY;
	private double anchorAngleX = 0;
	private double anchorAngleY = 0;
	private final DoubleProperty angleX = new SimpleDoubleProperty(0);
	private final DoubleProperty angleY = new SimpleDoubleProperty(0);
	Boolean check = true;
	final Xform world = new Xform();
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
	private static final double AXIS_LENGTH = 250.0;
	final Xform axisGroup = new Xform();

	private void buildAxes() {
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
 
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);
 
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);
 
        final Box xAxis = new Box(AXIS_LENGTH, 1, 1);
        final Box yAxis = new Box(1, AXIS_LENGTH, 1);
        final Box zAxis = new Box(1, 1, AXIS_LENGTH);
        
        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);
 
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        axisGroup.setVisible(true);
        world.getChildren().addAll(axisGroup);
    }
	
	@Override
	public void start(Stage primaryStage) {
		
		pane = new Pane();
		buildAxes();
		SmartGroup group = new SmartGroup();
		Group root = new Group();
		
		Box box1 = new Box(50, 150, 100);
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(Color.AQUA);
		box1.setMaterial(material);
		
		Box box2 = new Box(50, 150, 100);
		box2.setMaterial(material);
		
		
		Camera camera = new PerspectiveCamera(true);
		
		camera.setNearClip(0.1);
		camera.setFarClip(3000);
		
		box2.setTranslateX(100);
		box2.setTranslateY(0);
		
//		camera.setTranslateX(0);
//		camera.setTranslateY(0);
//		camera.setTranslateZ(-700);	
		camera.getTransforms().add(new Translate(0, 0, -700));
		
		
		group.getChildren().addAll(box1, box2);	
//		pane.getChildren().add(prepareImageView());
//		pane.setTranslateZ(100);
		pane.getTransforms().add(new Translate(0, 0, 500));
		root.getChildren().addAll(world, pane, group);
//		
		SplitPane layout = new SplitPane();
		
		 Accordion accordion = new Accordion();
	     objectControllers = new TabPane();
	     TitledPane pane1 = new TitledPane("Boats" , new Label("Show all boats available"));
	     TitledPane pane2 = new TitledPane("Cars"  ,colorPicker = new ColorPicker());
	     TitledPane pane3 = new TitledPane("Planes", objectControllers);
//		pane.setStyle("-fx-background-color: black;");
		 accordion.getPanes().add(pane1);
	        accordion.getPanes().add(pane2);
	        accordion.getPanes().add(pane3);

	        VBox vBox = new VBox(accordion);
		layout.setOrientation(Orientation.HORIZONTAL);
		layout.getItems().add(subScene = new SubScene(root, 1200, 700, true, SceneAntialiasing.DISABLED));
		layout.getItems().add(vBox);
		subScene.setFill(colorPicker.getValue());
//		
		Scene scene = new Scene(layout, 1400, 700, true, SceneAntialiasing.DISABLED);
		
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));

		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));
		addControllerTab("box", Controller3d.translation(group, 200), Controller3d.rotation(group, 300));

		subScene.setOnMouseClicked(event -> {
			Node clicked = event.getPickResult().getIntersectedNode();
//			initMouseControl(clicked, subScene);
		});
		
		colorPicker.setOnAction(event -> {
            	subScene.setFill(colorPicker.getValue());               
        });
		
		subScene.setCamera(camera);
		
		initMouseControl(group, subScene);
		
		primaryStage.setTitle("3d");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
				case W:
					camera.setRotationAxis(Rotate.X_AXIS);
					camera.setRotate(camera.getRotate() - 1);
					break;
				case S:
//					Box box = prepareBox(Color.RED, 100, 20);
//					group.getChildren().add(box);
//					box.setTranslateZ(n);
//					n += 10;
					camera.setRotationAxis(Rotate.X_AXIS);
					camera.setRotate(camera.getRotate() + 1);
					break;
				case Q:
					camera.setRotationAxis(Rotate.Y_AXIS);
					camera.setRotate(camera.getRotate() + 1);
					break;
				case E:
					camera.setRotationAxis(Rotate.Y_AXIS);
					camera.setRotate(camera.getRotate() - 1);
					break;
				case A:
					
					camera.setRotationAxis(Rotate.Y_AXIS);
					camera.setRotate(camera.getRotate() + 1);
					break;
				case D:
					camera.setRotationAxis(Rotate.Y_AXIS);
					camera.setRotate(camera.getRotate() - 1);
					break;	
			}
			
	});
	}
	
	protected void addControllerTab(String name, Node... children){
		Tab t = new Tab(name);
		t.setContent(new VBox(children));
		objectControllers.getTabs().add(t);
	}
	
	class SmartGroup extends Group {
		
		Rotate r;
		Transform t = new Rotate();
		
		void rotateByX(int ang) {
			r = new Rotate(ang, Rotate.X_AXIS);
			t = r.createConcatenation(r);
//			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
		
		void rotateByY(int ang) {
			r = new Rotate(ang, Rotate.Y_AXIS);
			t = r.createConcatenation(r);
//			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
	}
	
	 private ImageView prepareImageView() {
		 	String image_path = ClassLoader.getSystemResource("galaxy.jpg").toString();
		 	Image image = new Image(image_path);
		 	ImageView imageView = new ImageView(image);
//		 	ImageView imageView = new ImageView;
//		    Image image = new Image(Main.class.getResourceAsStream("galaxy.jpg"));
//		    ImageView imageView = new ImageView(image);
		    imageView.setPreserveRatio(true);
		    imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 800));
		    return imageView;
		  }
	
private void initMouseControl(Node clicked, SubScene scene) {
		
		Rotate xRotate;
		Rotate yRotate;
		
		clicked.getTransforms().addAll(
				xRotate = new Rotate(0, Rotate.X_AXIS), 
				yRotate = new Rotate(0, Rotate.Y_AXIS)
		);
		
		xRotate.angleProperty().bind(angleX);
		yRotate.angleProperty().bind(angleY);
		
		clicked.setOnMousePressed(event -> {
			anchorX = event.getSceneX();
			anchorY = event.getSceneY();
			anchorAngleX = angleX.get();
			anchorAngleY = angleY.get();
		});
		
		clicked.setOnMouseDragged(event -> {
			angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
			angleY.set(anchorAngleY - (anchorX - event.getSceneX()));
		});
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
