package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import javafx.scene.paint.Color;

public class PaintModel extends Observable {
	
	Color color;
	private int strokeWidth;

	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	
	private ArrayList<Double> pointsW = new ArrayList<Double>();
	private ArrayList<Double> circlesW = new ArrayList<Double>();
	private ArrayList<Double> rectanglesW = new ArrayList<Double>();
	
	private Stack<Shapes> draw = new Stack<Shapes>();
	
	private View view;             
	private ToolChooserPanel TCP = new ToolChooserPanel(view);   
	
	
	
	public void addshape(Shapes shape) {
		
		shape.setColor(this.color);
		shape.setStrokeWidth(this.strokeWidth);
		this.draw.add(shape);
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
