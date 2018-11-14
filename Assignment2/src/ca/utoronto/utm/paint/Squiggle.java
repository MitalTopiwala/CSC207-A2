package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;


public class Squiggle extends Shapes implements Draw{
	private ArrayList<Point> squigglePoints;
	private Color colour;
	
	public Squiggle(Color colour) {
		this.squigglePoints = new ArrayList<Point>();
		this.colour = colour;
	}
	
	public Squiggle() {
		this.squigglePoints = new ArrayList<Point>();
	}
	
	public void addSquigglePoint(Point point) {
		this.squigglePoints.add(point);
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
		for (int i = 0; i < this.squigglePoints.size() - 1; i++) {
			Point p1 = this.squigglePoints.get(i);
			Point p2 = this.squigglePoints.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		g.setFill(this.getColour());
		
	}
}
