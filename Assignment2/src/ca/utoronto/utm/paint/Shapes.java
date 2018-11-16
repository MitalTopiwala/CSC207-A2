package ca.utoronto.utm.paint;
import java.awt.Stroke;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes implements Draw{
	
	private Color colour;
	private Stroke stroke;
	private int strokeWidth;
	private Boolean shapeFilled = false;
	private Boolean shapeOutlined = false;
	
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
	
	public void setShapeOutlined (Boolean x) {
		this.shapeOutlined = x;
	}
	
	public void setShapeFilled (Boolean x) {
		this.shapeFilled = x;
	}
	
	public boolean getShapeOutlined() {
		return this.shapeOutlined;
	}
	
	public boolean getShapeFilled() {
		return this.shapeFilled;
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
