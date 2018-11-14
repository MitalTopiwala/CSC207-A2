package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
//import javafx.scene.canvas.GraphicsContext;


//extends shape commented out
public class Polyline extends Shapes implements Draw{
	private ArrayList<Point> polylinePoints;
	private Color colour;
	
	public Polyline(Color colour) {
		this.polylinePoints = new ArrayList<Point>();
		this.colour = colour;
	}
	
	public Polyline() {
		this.polylinePoints = new ArrayList<Point>();
		System.out.println("New Polyline Made");
	}
	
	public void addPolylinePoint(Point point) {
		this.polylinePoints.add(point);
	}
	
	public Color getColour() {
		return this.colour;
  	}
	
	public void setColour(Color c) {
		this.colour = c;
	}
	@Override
	public void draw(GraphicsContext g) {
		this.basicStroke(g);
		for (int i = 0; i < this.polylinePoints.size() - 1; i++) {
			Point p1 = this.polylinePoints.get(i);
			Point p2 = this.polylinePoints.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		g.setFill(this.getColour());
		
		
	}
}
