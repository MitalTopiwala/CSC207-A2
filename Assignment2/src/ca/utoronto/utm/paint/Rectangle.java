package ca.utoronto.utm.paint;

public class Rectangle {
	
	private Point start;
	private int length;
	private int width;
	
	public Rectangle(Point start, int length, int width) {
		this.start = start;
		this.length = length;
		this.width = width;
		
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
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
}
