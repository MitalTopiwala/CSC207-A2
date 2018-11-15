package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shapes implements Draw{
	
	private Point centre;
	private int radius;
	private Point start;
	private Color colour; 
//	private Stroke stroke; 

	/*public Circle(Point centre, int radius, Color colour) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		this.colour = colour; 
//		this.stroke = stroke; 
	}*/
	
	public Circle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setStart(Point start) {
		this.start = start;
	}
	
	public Point getStart() {
		return start;
	}

	public Color getColour() {
		return this.colour;
  	}
	
	public void setColour(Color c) {
		this.colour = c;
	}
	
	public void draw(GraphicsContext g) {
		this.basicStroke(g);
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		int radius = this.getRadius();
		g.strokeOval(x, y, radius, radius);	
		//g.fillOval(x, y, radius, radius);
		//g.setFill(this.getColour());
}
	
}
