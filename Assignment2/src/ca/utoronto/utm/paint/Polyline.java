package ca.utoronto.utm.paint;

import java.util.ArrayList;
//import javafx.scene.canvas.GraphicsContext;


//extends shape commented out
public class Polyline extends ArrayList<Point>{
	private ArrayList<Point> polylinePoints;
	
	public Polyline() {
		this.polylinePoints = new ArrayList<Point>();
	}
	
	public void addPolylinePoint(Point point) {
		this.polylinePoints.add(point);
	}
	//@Override
	//public void draw(GraphicsContext g) {
		// TODO Auto-generated method stub	
	//}
}
