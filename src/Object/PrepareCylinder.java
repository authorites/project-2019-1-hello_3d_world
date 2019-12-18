package Object;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

public class PrepareCylinder extends Cylinder{
	
	private PhongMaterial material;
	
	public PrepareCylinder(int Diameter, int Height) {
		super(Diameter, Height);
		material = new PhongMaterial();
		setMaterial(material);
	}
	
	public PrepareCylinder(int Diameter,  int Height, Color color) {
		
		super(Diameter, Height);
		material = new PhongMaterial();
		material.setDiffuseColor(color);
		setMaterial(material);
	}
	
	public PhongMaterial getMateria() {
		return material;
	}

}
