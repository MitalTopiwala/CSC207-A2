package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
/**
 * 
 * @author Manah
 *
 */
public class Circle extends Shapes implements Draw{
	
	private Point centre;
	private int radius;
	private Point start;
	private Color colour; 
//	private Stroke stroke; 
	
	/**
	 * 
	 * @param centre	a point representing the centre of circle
	 * @param radius	an integer representing the radius of circle
	 * @param colour	an color representing the colour of circle
	 */
	public Circle(Point centre, int radius, Color colour) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		this.colour = colour; 
		//this.stroke = stroke; 
	}
	
	/**
	 * 
	 * @param centre	a point representing the centre of circle
	 * @param radius	an integer representing the radius of circle
	 */
	public Circle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		
	}
	
	/**
	 * 
	 * @return centre 	a point representing the centre of circle
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * 
	 * @param centre	a point representing the new centre of circle
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * 
	 * @return radius 	an integer representing the radius of circle
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * 
	 * @param radius	an integer representing the new radius of circe
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * 
	 * @param start
	 */
	public void setStart(Point start) {
		this.start = start;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point getStart() {
		return start;
	}
	
	/**
	 * 
	 * @return
	 */
	public Color getColour() {
		return this.colour;
  	}
	
	/**
	 * 
	 * @param c		a Color representing the colour of the circle
	 */
	public void setColour(Color c) {
		this.colour = c;
	}
	
	/**
	 * 
	 */
	public void draw(GraphicsContext g) {
		this.basicStroke(g);
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		int radius = this.getRadius();
		g.strokeOval(x, y, radius, radius);
}
	
}
