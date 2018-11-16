package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shapes implements Draw{
	
	private Point centre;
	private int radius;
	private Point start;
	private Color colour; 
	private Color colour2;
 

	public Circle(Point centre, int radius, Color colour, Color colour2) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		this.colour = colour; 
		this.colour2 = colour2;
	}
	
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
	
	public Color getColour2() {
		return this.colour2;
	}
	
	public void setColour(Color c) {
		this.colour = c;
	}
	
	public void setColour2(Color c2) {
		this.colour2 = c2;
	}
	
	
	public void draw(GraphicsContext g) {
		this.basicStroke(g);
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		int radius = this.getRadius();
		
		g.strokeOval(x, y, radius, radius);
		g.fillOval(x, y, radius, radius);
		g.setFill(this.getColour());
		
		if (this.getShapeFilled()) {
			g.fillOval(x, y, radius, radius);
			g.setFill(this.getColour());
		}else if (this.getShapeOutlined()) {
			g.strokeOval(x, y, radius, radius);
			g.setFill(this.getColour2());
		}else {
			g.strokeOval(x, y, radius, radius);		
		}
	}
	
}
