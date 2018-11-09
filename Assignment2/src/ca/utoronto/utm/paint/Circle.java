package ca.utoronto.utm.paint;



import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shapes implements Draw{
	
	private Point centre;
	private int radius;
	private Point start;

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
	
	public void draw(GraphicsContext g) {
	
	}
	
}
