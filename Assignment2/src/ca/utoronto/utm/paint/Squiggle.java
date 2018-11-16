package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;

/**
 * Model a Squiggle. The Squigle has an arraylist of points representing the points
 * of Squiggle, and a Color colour of the Squiggle.
 * 
 * @author Manahil
 *
 */
public class Squiggle extends Shapes implements Draw{
	private ArrayList<Point> squigglePoints;
	private Color colour;
	
	/**
	 * Construct a squiggle as a new empty arraylist of points, with specified Color
	 * colour.
	 * @param colour
	 */
	public Squiggle(Color colour) {
		this.squigglePoints = new ArrayList<Point>();
		this.colour = colour;
	}
	
	/**
	 * Construct a squiggle with a new empty arraylist of points.
	 */
	public Squiggle() {
		this.squigglePoints = new ArrayList<Point>();
	}
	
	/**
	 * Add a new point to arraylist squigglePoints
	 * @param point		a new Point
	 */
	public void addSquigglePoint(Point point) {
		this.squigglePoints.add(point);
	}
	
	/**
	 * Returns the color representing the color of squiggle
	 * @return colour 	a color representing the color of the squiggle
	 */
	public Color getColour() {
		return this.colour;
  	}
	
	/**
	 * Sets the Color colour to a new specified color 
	 * @param colour 	a Color representing the new colour of squiggle
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}
	@Override
	/**
	 * Implement draw method from Draw interface
	 * Draws the squiggle
	 * @param g 	a GraphicsContext	used to issue draw calls to Canvas 
	 **/
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
