package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Models a Circle. The Circle has a point representing centre of the circle, a
 * non-negative integer representing radius of the circle, Colours colour and colour2,
 * and booleans shapeFilled and shapeOutlined representing if the circle should have a 
 * fill or outline.
 * 
 * @author Manahil
 *
 */
public class Circle extends Shapes implements Draw{
	
	private Point centre;
	private int radius;
	private Point start;
	private Color colour; 
	private Color colour2;


	/**
	 * Construct a Circle with the specified paramters
	 * @param centre	a point representing the centre of  circle
	 * @param radius	a non-negative integer representing radius of circle
	 * @param colour
	 * @param colour2
	 */
	public Circle(Point centre, int radius, Color colour, Color colour2) { //Boolean shapeFilled, Boolean shapeOutlined) {

		this.centre = centre;
		this.radius = radius;
		this.start = centre;
		this.colour = colour; 
		this.colour2 = colour2;
	}

 
	/**
	 * Construct a Circle with the specified paramters
	 * @param centre	a point representing the centre of  circle
	 * @param radius	a non-negative integer representing radius of circle
	 */
	public Circle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
		this.start = centre;	
	}
	
	/**
	 * Returns the point representing the centre of the circle
	 * @return centre	a point representing the centre of the circle
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * Sets centre to a new specified point centre.
	 * @param centre	a point representing the new centre of the circle
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * Returns the integer representing the radius of the circle
	 * @return radius	an integer representing the radius of circle
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Sets radius to a new specified radius.
	 * @param radius	an integer representing the new radius of circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 *  Sets start to a new specified point start.
	 * @return start	a point representing the new start of circle
	 */
	public void setStart(Point start) {
		this.start = start;
	}
	
	/**
	 * 
	 * @return start 	a point representing the start of circle
	 */
	public Point getStart() {
		return start;
	}
	
	/**
	 * Returns colour of the circle
	 * @return colour		Colour representing colour of circle
	 **/
	public Color getColour() {
		return this.colour;
  	}

	public Color getColour2() {
		return this.colour2;
	}

	/**
	 * Set the Color colour to a new specified Color colour
	 * @param colour		Colour representing new colour of circle
	 **/
	public void setColour(Color c) {
		this.colour = c;
	}


	public void setColour2(Color c2) {
		this.colour2 = c2;
	}



	/**
	 * Implement draw method from Draw interface.
	 * Draws the circle.
	 * @param g 	GraphicsContext	used to issue draw calls to Canvas 
	 **/
	@Override
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
	

