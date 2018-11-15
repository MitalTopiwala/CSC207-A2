package ca.utoronto.utm.paint;



import java.util.Observable;
import java.util.Stack;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintModel extends Observable {
	
	int strokeWidth;
	Color color;

	/*private ArrayList<Point> points = new ArrayList<Point>();
	
	private ArrayList<Polyline> polylines = new ArrayList<Polyline>();

	private ArrayList<Double> pointsW = new ArrayList<Double>();

	private ArrayList<Double> polylinesW = new ArrayList<Double>();*/
	
	private Stack<Shapes> shapeStack = new Stack<Shapes>();
	private Stack <Stack<Shapes>> deletedShapes = new Stack <Stack<Shapes>>();
	
	private View view;             
	private ToolChooserPanel TCP = new ToolChooserPanel(view);     
	private ColourChooserPanel CCP = new ColourChooserPanel(view);
	
	/**
	 * Sets shape with the current color and stroke width and
	 * pushes shape to the shapesStack stack .
	 * @param shape	a shape that is newly drawn
	 */
	public void addShape(Shapes shape) {
		
		shape.setColor(CCP.GETCOLOR());
		
		System.out.println("paintmodel" + CCP.GETCOLOR());
		
		shape.setStrokeWidth(TCP.getLineWidth());
		this.shapeStack.push(shape);
		System.out.println("shape added to stack:" + this.shapeStack);
		modelChanged();
		
	}
	
	/**
	 * Removes the last drawn shape shape from the canvas
	 */
	
	public void undo() {

		if(this.shapeStack.size() > 0) {
			Stack<Shapes> shapeStack = new Stack<Shapes>();
			shapeStack.push(this.shapeStack.pop());
			this.deletedShapes.push(shapeStack);
			
		}
		
	}
	
	/**
	 * Adds the shape back to the canvas that was removed using undo option
	 */
	
	public void redo () {
		if(this.deletedShapes.size()>0) {
			Stack<Shapes> shapeStack = this.deletedShapes.pop();
			while(shapeStack.size() != 0) {
				this.shapeStack.push(shapeStack.pop());
			}				
		}
		
	}
	
	public Stack<Shapes> getShapeStack() {
		return this.shapeStack;
	}
	
	public Stack<Stack<Shapes>> getDeletedShapes(){
		return this.deletedShapes;
	}
	
	public void modelChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void draw(GraphicsContext g) {
		for(Shapes s : this.shapeStack) {
			s.draw(g);
		}
	}

	public double getLineThickness() {               
		return TCP.getLineWidth();
	}
	
}

	/*public void addPoint(Point p) {
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
	
	
	
	public void addPolyline(Polyline p) {
		this.polylines.add(p);
		this.polylinesW.add(TCP.getLineWidth());
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Polyline> getPolylines() {
		return polylines;
	}
	
	public ArrayList<Double> getPolylinesW() {
		return polylinesW;
	}*/
	
