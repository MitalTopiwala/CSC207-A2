package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

public abstract class Shapes {
	
	private Color color;
	private int strokeWidth;
	
	
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;	
		
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
	
	
	
}
