package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Eraser extends Squiggle{
	
	public void draw(GraphicsContext g) {
		
		System.out.println("jdfskdfasdasda");
		
		this.setColor(Color.WHITE);
		this.basicStroke(g);
		
		for (int i = 0; i < this.squigglePoints.size() - 1; i++) {
			Point p1 = this.squigglePoints.get(i);
			Point p2 = this.squigglePoints.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		//g.setFill(this.getColour());
		
	}
	}

