package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;

/**
 * Model a Rectangle. The rectangle has a point representing start/origin 
 * vertex of the rectangle, a point representing the upper left vertex of rectangle,
 * a non-negative integer width of the rectangle, non-negative integer length of
 * rectangle, and a Color colour of the rectangle.
 * 
 * @author Manahil
 *
 */
public class Rectangle extends Shapes implements Draw {
	
	private Point start;
	private int length;
	private int width;
	private Point upperLeft;
	private Color colour;
	
	/**
	 * Construct a Rectangle with the specified paramters 
	 * @param start		a point representing origin vertex of rectangle
	 * @param length	a non-negative integer representing length of rectangle
	 * @param width		a non-negative integer representing width of rectangle
	 * @param colour	a color representing the colour of rectangle
	 */
	public Rectangle(Point start, int length, int width, Color colour) {
		this.start = start;
		this.length = length;
		this.width = width;
		this.upperLeft = new Point(start.getX(), start.getY());
		this.colour = colour;
		
	}
	
	/**
	 * Override
	 * Construct a Rectangle with the specified paramters 
	 * @param start		a point representing origin vertex of rectangle
	 * @param length	a non-negative integer representing length of rectangle
	 * @param width		a non-negative integer representing width of rectangle
	 * @param colour	a color representing the colour of rectangle
	 * @param upperLeft	a point representing upper left vertex of rectangle
	 */
	public Rectangle(Point start, int length, int width) {
		this.start = start;
		this.length = length;
		this.width = width;
		this.upperLeft = new Point(start.getX(), start.getY());
	}
	
	/**
	 * Returns the point representing start/origin vertex of rectangle
	 * @return start Point representing start/origin vertex of rectangle
	 **/
	public Point getStart() {
		return start;
	}
	/**
	 * Set the Point start to a new specified Point start
	 * @param start		Point representing new start/origin vertex of rectangle
	 **/
	public void setStart(Point start) {
		this.start = start;
	}
	
	/**
	 * Returns the point representing upper left vertex of rectangle
	 * @return upperLeft	Point representing upper left vertex of rectangle
	 **/
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	/**
	 * Set the Point upperLeft to a new specified Point upperLeft
	 * @param upperLeft		Point representing new upper left vertex of rectangle
	 **/
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	/**
	 * Returns length the rectangle
	 * @return length		int representing length of rectangle
	 **/
	public int getLength() {
		return length;
	}
	
	/**
	 * Set the int length to a new specified int length
	 * @return length		int representing new length of rectangle
	 **/
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * Returns width the rectangle
	 * @return width		int representing width of rectangle
	 **/
	public int getWidth() {
		return width;
	}
	
	/**
	 * Set the int width to a new specified int width
	 * @return width		int representing new width of rectangle
	 **/
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Returns colour of the rectangle
	 * @return colour		Colour representing colour of rectangle
	 **/
	public Color getColour() {
		return this.colour;
  	}
	
	/**
	 * Set the Color colour to a new specified Color colour
	 * @param colour		Colour representing new colour of rectangle
	 **/
	public void setColour(Color c) {
		this.colour = c;
	}


	@Override
	/**
	 * Implement draw method from Draw interface
	 * Draws the rectangle
	 * @param g 	GraphicsContext	used to issue draw calls to Canvas 
	 **/
	public void draw(GraphicsContext g) {
	
		this.basicStroke(g);
		int x = this.getUpperLeft().getX();
		int y = this.getUpperLeft().getY();
		int length = this.getLength();
		int width = this.getWidth();
		g.strokeRect(x, y, width, length);
		g.fillRect(x, y, width, length);
		g.setFill(this.getColour());
	}

}
