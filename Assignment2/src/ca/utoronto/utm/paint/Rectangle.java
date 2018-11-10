package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shapes {
	
	private Point start;
	private int length;
	private int width;
	private Point upperLeft;
	
	public Rectangle(Point start, int length, int width) {
		this.start = start;
		this.length = length;
		this.width = width;
		this.upperLeft = new Point(start.getX(), start.getY());
		
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void draw(GraphicsContext g) {
		// TODO Auto-generated method stub
		
	}
}
