package Object;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class PrepareBox extends Box{
	
	private PhongMaterial material;
	
	public PrepareBox(int Width, int Height, int Depth) {
		
		super(Width, Height, Depth);
		material = new PhongMaterial();
		setMaterial(material);
	}
	
	public PrepareBox(int Width, int Height, int Depth, Color color) {
		
		super(Width, Height, Depth);
		material = new PhongMaterial();
		material.setDiffuseColor(color);
		setMaterial(material);
	}
	
	public PhongMaterial getMateria() {
		return material;
	}

}
