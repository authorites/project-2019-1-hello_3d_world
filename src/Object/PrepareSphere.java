package Object;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class PrepareSphere extends Sphere{
	
	private PhongMaterial material;
	
	public PrepareSphere(int Diameter) {
		super(Diameter);
		material = new PhongMaterial();
		setMaterial(material);
	}
	
	public PrepareSphere(int Diameter, Color color) {
		
		super(Diameter);
		material = new PhongMaterial();
		material.setDiffuseColor(color);
		setMaterial(material);
	}

	public PhongMaterial getMateria() {
		return material;
	}
	

}
