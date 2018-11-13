package ca.utoronto.utm.paint;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes implements Draw{
	
	private Color color;
	private int strokeWidth;
	
	
	public void setStrokeWidth(double d) {
		this.strokeWidth = (int) d;
		
	}
	
	public int getStrokeWidth() {
		return this.strokeWidth;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void basicStroke(GraphicsContext g) {
		g.setLineWidth(strokeWidth);
		g.setStroke(color);
		
	}
	
	

}
