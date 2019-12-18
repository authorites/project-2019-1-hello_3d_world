package gui;

import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Editor extends Accordion {
	

	private TabPane objectControllers;
	private ColorPicker colorPicker;
	private ColorPicker colorPickerObject;
	private CheckBox checkBox1;
	private CheckBox checkBox2;
	private CheckBox checkBox3;
	private CheckBox checkBox4;

	private Button BoxButton;
	private Button CylinderButton;
	private Button SphereButton;
	private Button addBackButton;
	private Button removeBackButton;
	private Button hideVisibleButton;
	
	public Editor() {
		
		BoxButton = new Button("Add Box");
		SphereButton = new Button("Add Sphere");
		CylinderButton = new Button("Add Cylinder");
		addBackButton = new Button("Add BackGround");
		removeBackButton = new Button("Remove BackGround");
		hideVisibleButton = new Button("Hide \\ Visible");
		checkBox1 = new CheckBox("Diffuse");
		checkBox2 = new CheckBox("SelfIllumination");
		checkBox3 = new CheckBox("Specular");
		checkBox4 = new CheckBox("Bump");
		objectControllers = new TabPane();
		VBox vBox1 = new VBox();
		vBox1.setSpacing(5);
		vBox1.getChildren().addAll(colorPickerObject = new ColorPicker(), checkBox1, checkBox2, checkBox3, checkBox4
				, BoxButton, SphereButton, CylinderButton);
		colorPickerObject.setValue(Color.GRAY);
		TitledPane pane1 = new TitledPane("Add Object" , vBox1);
	    VBox vBox2 = new VBox(colorPicker = new ColorPicker());
	    vBox2.setSpacing(5);
	    vBox2.getChildren().addAll(addBackButton, removeBackButton, hideVisibleButton);
	    
	    TitledPane pane2 = new TitledPane("Manage Background"  ,vBox2);
	    colorPicker.setValue(Color.DARKGRAY);

	    TitledPane pane3 = new TitledPane("Manage Object", objectControllers);
	    getPanes().addAll(pane1, pane2, pane3);
	    
	}

	public ColorPicker getColorPickerObject() {
		return colorPickerObject;
	}

	public TabPane getObjectControllers() {
		return objectControllers;
	}

	public Button getBoxButton() {
		return BoxButton;
	}
	
	public Button getSphereButton() {
		return SphereButton;
	}
	
	public Button getCylinderButton() {
		return CylinderButton;
	}
	
	public Button gethideVisibleButton() {
		return hideVisibleButton;
	}
	
	public Button getaddBackButton() {
		return addBackButton;
	}
	
	public Button getremoveBackButton() {
		return removeBackButton;
	}

	public ColorPicker getColorPicker() {
		return colorPicker;
	}

	public CheckBox getCheckBox1() {
		return checkBox1;
	}
	
	public CheckBox getCheckBox2() {
		return checkBox2;
	}
	
	public CheckBox getCheckBox3() {
		return checkBox3;
	}
	
	public CheckBox getCheckBox4() {
		return checkBox4;
	}
	
	
}
