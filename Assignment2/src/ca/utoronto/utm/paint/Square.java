package ca.utoronto.utm.paint;
import javafx.scene.paint.Color;
/**
 * Model a Square. The square inherits from rectangle and has a point representing
 * start/origin vertex of the rectangle, a point representing the upper left vertex 
 * of rectangle,a non-negative integer length of square, and a Color colour of the
 * square.
 * 
 * @author Manahil
 *
 */
public class Square extends Rectangle{
	
	/**
	 * Construct a square with the specified parameters.
	 * Call super constructor in Rectangle
	 * @param start		a point representing origin vertex of rectangle
	 * @param length	a non-negative integer representing length of rectangle
	 */
	public Square(Point start, int length) {
		super(start, length, length); 
	}
	
	/**
	 * Construct a square with the specified parameters.
	 * Call super constructor in Rectangle
	 * @param start		a point representing origin vertex of rectangle
	 * @param length	a non-negative integer representing length of rectangle
	 * @param colour	a color representing the colour of rectangle
	 */
	public Square(Point start, int length, Color colour) {
		super(start, length, length, colour);
	}
}

