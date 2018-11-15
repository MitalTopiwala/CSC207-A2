package ca.utoronto.utm.paint;
import java.awt.Stroke;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes implements Draw{
	
	private Color colour;
	private Stroke stroke;
	private int strokeWidth;
	
	public void setStrokeWidth(double d) {
		this.strokeWidth = (int) d;
	}
	
	public int getStrokeWidth() {
		return this.strokeWidth;
	}
	
	public void setColor(Color color) {
		this.colour = color;
	}
	
	public void setStroke(Stroke stroke) {
		this.stroke = stroke; 
	}
	
	public Color getColor() {
		return this.colour;
	}
	
	public void basicStroke(GraphicsContext g) {
		g.setLineWidth(strokeWidth);
		g.setStroke(colour);
		//g.setFill(colour);
		
	}
	
	

}
