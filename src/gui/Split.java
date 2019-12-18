package gui;

import Object.PrepareBox;
import Object.PrepareCamera;
import Object.PrepareCylinder;
import Object.PrepareSphere;
import Object.SmartGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import logic.Controller3d;
import logic.Displayer3d;
import logic.Xform;

public class Split extends SplitPane {

	private SubScene subScene;
	private Editor accordion;
	private SmartGroup cam ,group;
	private PrepareCamera camera;
	private Pane pane;
	private int n = 0;
	private Color color = Color.GRAY;
	private Boolean haveBackGround = false;
	private Boolean isVisible = true;
	
	Boolean check = true;
	final Xform world = new Xform();
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
	private static final double AXIS_LENGTH = 250.0;
	final Xform axisGroup = new Xform();

	public Split(Group root, Stage primaryStage) {
		
	
		pane = new Pane();
		buildAxes();
		group = new SmartGroup();
		cam = new SmartGroup();
		camera = new PrepareCamera();
		accordion = new Editor();
		
		VBox vBox = new VBox(accordion);
		
		setOrientation(Orientation.HORIZONTAL);
		getItems().add(subScene = new SubScene(root, 1200, 700, true, SceneAntialiasing.DISABLED));
		getItems().add(vBox);
	
		subScene.setFill(accordion.getColorPicker().getValue());
		
		root.getChildren().addAll(world, group);
		
		cam.getChildren().add(camera);
		
		PrepareBox box = new PrepareBox(110, 110, 110, Color.GRAY);
		group.getChildren().add(box);
		addControllerTab("Box" + Integer.toString(n), new Displayer3d().scale(box), new Displayer3d().translation(box), 
				new Displayer3d(box.rotateProperty()), Controller3d.translation(box, 600, -600),
				Controller3d.rotation(box, 360), Controller3d.rotationAxis(box, 1), 
				Controller3d.scale(box, 30, 0));
		
		group.rotateByX(20);
		group.rotateByY(30);
		
		accordion.getColorPickerObject().setOnAction(event -> {
			color = accordion.getColorPickerObject().getValue();              
        });
		
		accordion.getBoxButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PrepareBox box = new PrepareBox(110, 110, 110, color);
				group.getChildren().add(box);
				n += 1;
				if(accordion.getCheckBox1().isSelected()) {
					box.getMateria().setDiffuseMap(new Image(ClassLoader.getSystemResource("earth-d.jpg").toString()));
				}
				if(accordion.getCheckBox2().isSelected()) {
					box.getMateria().setSelfIlluminationMap(new Image(ClassLoader.getSystemResource("earth-l.jpg").toString()));
				}
				if(accordion.getCheckBox3().isSelected()) {
					box.getMateria().setSpecularMap(new Image(ClassLoader.getSystemResource("earth-s.jpg").toString()));
				}
				if(accordion.getCheckBox4().isSelected()) {
					box.getMateria().setBumpMap(new Image(ClassLoader.getSystemResource("earth-n.jpg").toString()));
				}
				addControllerTab("Box" + Integer.toString(n), new Displayer3d().scale(box), new Displayer3d().translation(box), 
				new Displayer3d(box.rotateProperty()), Controller3d.translation(box, 600, -600),
				Controller3d.rotation(box, 360), Controller3d.rotationAxis(box, 1), 
				Controller3d.scale(box, 10, -10));
			}
		});
		
		accordion.getSphereButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PrepareSphere Sphere = new PrepareSphere(100, color);
				group.getChildren().add(Sphere);
				n += 1;
				if(accordion.getCheckBox1().isSelected()) {
					Sphere.getMateria().setDiffuseMap(new Image(ClassLoader.getSystemResource("earth-d.jpg").toString()));
				}
				if(accordion.getCheckBox2().isSelected()) {
					Sphere.getMateria().setSelfIlluminationMap(new Image(ClassLoader.getSystemResource("earth-l.jpg").toString()));
				}
				if(accordion.getCheckBox3().isSelected()) {
					Sphere.getMateria().setSpecularMap(new Image(ClassLoader.getSystemResource("earth-s.jpg").toString()));
				}
				if(accordion.getCheckBox4().isSelected()) {
					Sphere.getMateria().setBumpMap(new Image(ClassLoader.getSystemResource("earth-n.jpg").toString()));
				}
				addControllerTab("Sphere" + Integer.toString(n), new Displayer3d().scale(Sphere), new Displayer3d().translation(Sphere), 
				new Displayer3d(Sphere.rotateProperty()), Controller3d.translation(Sphere, 600, -600),
				Controller3d.rotation(Sphere, 360), Controller3d.rotationAxis(Sphere, 1), 
				Controller3d.scale(Sphere, 5, -5));
			}
		});
		
		accordion.getCylinderButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PrepareCylinder Cylinder = new PrepareCylinder(50, 100, color);
				group.getChildren().add(Cylinder);
				if(accordion.getCheckBox1().isSelected()) {
					Cylinder.getMateria().setDiffuseMap(new Image(ClassLoader.getSystemResource("earth-d.jpg").toString()));
				}
				if(accordion.getCheckBox2().isSelected()) {
					Cylinder.getMateria().setSelfIlluminationMap(new Image(ClassLoader.getSystemResource("earth-l.jpg").toString()));
				}
				if(accordion.getCheckBox3().isSelected()) {
					Cylinder.getMateria().setSpecularMap(new Image(ClassLoader.getSystemResource("earth-s.jpg").toString()));
				}
				if(accordion.getCheckBox4().isSelected()) {
					Cylinder.getMateria().setBumpMap(new Image(ClassLoader.getSystemResource("earth-n.jpg").toString()));
				}
				addControllerTab("Cylinder" + Integer.toString(n), new Displayer3d().scale(Cylinder), new Displayer3d().translation(Cylinder), 
				new Displayer3d(Cylinder.rotateProperty()), Controller3d.translation(Cylinder, 600, -600),
				Controller3d.rotation(Cylinder, 360), Controller3d.rotationAxis(Cylinder, 1), 
				Controller3d.scale(Cylinder, 5, -5));
			}
		});
		
		accordion.gethideVisibleButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			if(isVisible) {
				axisGroup.setVisible(!isVisible);
				isVisible = false;
			} else {
				axisGroup.setVisible(!isVisible);
				isVisible = true;
			}
			}
		});
		
		accordion.getaddBackButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!haveBackGround) {
					pane.getChildren().add(prepareImageView());
					root.getChildren().addAll(pane);
					haveBackGround = true;
				}
			}
		});
		
		accordion.getremoveBackButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (haveBackGround) {
					root.getChildren().remove(pane);
					haveBackGround = false;
				}
			}
		});
		
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
				case W:
					cam.rotateByX(-1);
					break;
				case S:
					cam.rotateByX(1);
					break;
				case Q:
					cam.translateZ(10);
					break;
				case E:
					cam.translateZ(-10);
					break;
				case A:
					cam.rotateByY(1);
					break;
				case D:
					cam.rotateByY(-1);
					break;	
				case NUMPAD2:
					cam.front();
					break;	
				case NUMPAD5:
					cam.sideX(90);
					break;	
				case NUMPAD4:
					cam.sideY(-90);
					break;
				case NUMPAD6:
					cam.sideY(90);
					break;
				case NUMPAD8:
					cam.sideY(180);
					break;
				case NUMPAD1:
					cam.sideX(-90);
					break;
			}
			
		});
		
		subScene.setOnMouseClicked(event -> {
			Node clicked = event.getPickResult().getIntersectedNode();
			group.getChildren().remove(clicked);
		});
		
	}

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
	
	 public ImageView prepareImageView() {
		 	String image_path = ClassLoader.getSystemResource("galaxy.jpg").toString();
		 	Image image = new Image(image_path);
		 	ImageView imageView = new ImageView(image);
		    imageView.setPreserveRatio(true);
		    imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 800));
		    return imageView;
	 }

	protected void addControllerTab(String name, Node... children){
			Tab t = new Tab(name);
			VBox vbox = new VBox(children);
			vbox.setPadding(new Insets(5));
			vbox.setSpacing(5);
			t.setContent(vbox);
			accordion.getObjectControllers().getTabs().add(t);
		}
	
	public Pane getPane() {
		return pane;
	}
	
	public PrepareCamera getCamera() {
		return camera;
	}

	public SmartGroup getGroup() {
		return group;
	}
	
	public SubScene getSubScene() {
		return subScene;
	}

	public Editor getAccordion() {
		return accordion;
	}
	
	
	
}
