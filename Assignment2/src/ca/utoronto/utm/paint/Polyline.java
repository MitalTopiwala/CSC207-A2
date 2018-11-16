package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 * Models a Polyline. The Polyline has an arraylist of points representing the points
 * of polyline, and a Color colour of the Polyline.
 * @author Manahil
 *
 */
public class Polyline extends Shapes implements Draw{
	private ArrayList<Point> polylinePoints;
	private Color colour;
	
	/**
	 * Construct a new polyline as a new (empty) arraylist of points with 
	 * a specified colour.
	 * @param colour
	 */
	public Polyline(Color colour) {
		this.polylinePoints = new ArrayList<Point>();
		this.colour = colour;
	}
	
	/**
	 * Construct a new polyline as a new (empty) arraylist of points.
	 */
	public Polyline() {
		this.polylinePoints = new ArrayList<Point>();
	}
	
	/**
	 * Adds a new point to polylinePoints.
	 * @param point		a point to be added to polylinePoints
	 */
	public void addPolylinePoint(Point point) {
		this.polylinePoints.add(point);
	}
	
	/**
	 * Deletes last point of polylinePoints.
	 * @param point		a new point
	 */
	public void delLastPolylinePoint() {
		this.polylinePoints.remove(polylinePoints.size() -1 );
	}
	
	/**
	 * Returns colour of the polyline
	 * @return colour		Colour representing colour of polyline
	 **/
	public Color getColour() {
		return this.colour;
  	}
	
	/**
	 * Set the Color colour to a new specified Color colour
	 * @param c		a Color representing new colour of polyline
	 **/
	public void setColour(Color c) {
		this.colour = c;
	}
	@Override
	/**
	 * Implement draw method from Draw interface
	 * Draws the polyline
	 * @param g 	GraphicsContext	used to issue draw calls to Canvas 
	 **/
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
