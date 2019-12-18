package logic;

import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Controller3d extends VBox {
	
	private Slider xs;
	private Slider ys;
	private Slider zs;

	public Controller3d(String title, Property<Number> x, Property<Number> y, Property<Number> z, double max, double min){
		xs = new Slider();
		xs.setMax(max);
		xs.setMin(min);
		xs.setValue(x.getValue().doubleValue());
		x.bindBidirectional(xs.valueProperty());
		
		ys = new Slider();
		ys.setMax(max);
		ys.setMin(min);
		ys.setValue(y.getValue().doubleValue());
		y.bindBidirectional(ys.valueProperty());
	
		zs = new Slider();
		zs.setMax(max);
		zs.setMin(min);
		zs.setValue(z.getValue().doubleValue());
		z.bindBidirectional(zs.valueProperty());
		
		getChildren().addAll(
			new Label(title),
			xs,ys,zs
		);
	}
	
	public Controller3d(String title, double max, Callback<double[], Object> apply){
		this(title,max);
		InvalidationListener l = (o) -> apply.call(new double[]{
				xs.getValue(), ys.getValue(), zs.getValue()
		});
		xs.valueProperty().addListener(l);
		ys.valueProperty().addListener(l);
		zs.valueProperty().addListener(l);
	}
	
	private Controller3d(String title, double max){
		xs = new Slider();
		xs.setMax(max);
		
		ys = new Slider();
		ys.setMax(max);
	
		zs = new Slider();
		zs.setMax(max);
		
		getChildren().addAll(
			new Label(title),
			xs,ys,zs
		);
	}
	
	public static Controller3d translation(Node n, double limit, double min){
		return new Controller3d("Coordinates", n.translateXProperty(), n.translateYProperty(), n.translateZProperty(), limit , min);
	}
	
	public static Controller3d scale(Node n, double limit, double min){
		return new Controller3d("Scale", n.scaleXProperty(), n.scaleYProperty(), n.scaleZProperty(), limit, min);
	}

	public static Controller3d rotationAxis(Node n, double limit) {
		Controller3d c = new Controller3d("Rotation axis", limit,
			(d) -> {
				n.setRotationAxis(new Point3D(d[0],d[1],d[2]));
				return null;
			}
		);
		return c;
	}

	public static VBox rotation(Node n, double limit) {
		VBox c = new VBox();
		c.getChildren().add(new Label("Rotation"));
		
		Slider s = new Slider();
		s.setMax(limit);
		s.valueProperty().bindBidirectional(n.rotateProperty());
		c.getChildren().add(s);
		
		return c;
	}
	
}
