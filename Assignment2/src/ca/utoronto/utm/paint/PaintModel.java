package ca.utoronto.utm.paint;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintModel extends Observable {
	
	int strokeWidth;
	Color color;

	private ArrayList<Point> points = new ArrayList<Point>();
	//bug 5
	//private ArrayList<Squiggle> squiggles = new ArrayList<Squiggle>();
	
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	
	//bug 5
	//private ArrayList<Double> squigglesW = new ArrayList<Double>();
	//
	
	private ArrayList<Double> pointsW = new ArrayList<Double>();
	private ArrayList<Double> circlesW = new ArrayList<Double>();
	private ArrayList<Double> rectanglesW = new ArrayList<Double>();
	
	private Stack<Shapes> shapeStack = new Stack<Shapes>();
	
	
	
	
	private View view;             
	private ToolChooserPanel TCP = new ToolChooserPanel(view);     
	
	/**
	 * Sets shape with the current color and stroke width and
	 * pushes shape to the shapesStack stack .
	 * @param shape	a shape that is newly drawn
	 */
	public void addShape(Shapes shape) {
		
		shape.setColor(color);
		shape.setStrokeWidth(TCP.getLineWidth());
		this.shapeStack.push(shape);
		System.out.println("shape added to stack:" + this.shapeStack);
		modelChanged();
		
	}
	
	public void undo() {

		if(this.shapeStack.size() > 0) {
			Stack<Shapes> shapeStack = new Stack<Shapes>();
			shapeStack.push(this.shapeStack.pop());
			
		}
		
	}
	
	public Stack<Shapes> getStack() {
		return shapeStack;
	}
	
	
//<<<<<<< HEAD

//=======

	//bug 5
	//public void addSquiggle(Squiggle s) {
		//this.squiggles.add(s);
		///this.squigglesW.add(TCP.getLineWidth());
		//this.setChanged();
		//this.notifyObservers();
	//}
	//public ArrayList<Squiggle> getSquiggles() {
		//return squiggles;
	//}

	//public ArrayList<Double> getSquigglesW() {
		//return squigglesW;
	//}
	//
	
	
//>>>>>>> 4e8033da4ad743a0bdee448ed8579dd00c8641a0
	public void modelChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void draw(GraphicsContext g) {
		for(Shapes s : shapeStack) {
			s.draw(g);
		}
	}

	public double getLineThickness() {               
		return TCP.getLineWidth();
	}

	public void addPoint(Point p) {
		this.points.add(p);
		this.pointsW.add(TCP.getLineWidth());
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}

	public ArrayList<Double> getPointsW() {
		return pointsW;
	}
	
	public void addCircle(Circle c) {
		this.circles.add(c);
		this.circlesW.add(TCP.getLineWidth());
		this.setChanged();
		this.notifyObservers();
	}


	public ArrayList<Circle> getCircles() {
		return circles;
	}
	public ArrayList<Double> getCirclesW() {
		return circlesW;
	}
	
	public void addRectangle(Rectangle r) {
		this.rectangles.add(r);
		this.rectanglesW.add(TCP.getLineWidth());
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Rectangle> getRectangles() {
		return rectangles;
	}
	
	public ArrayList<Double> getRectanglesW() {
		return rectanglesW;
	}
	
}
