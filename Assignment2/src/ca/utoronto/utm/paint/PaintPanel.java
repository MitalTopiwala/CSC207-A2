package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.applet.Applet;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private String colourMode ="0"; //modifies input of colour filled 
	private String fillMode = "NoFill"; 
	
	private Circle circle; // the circle we are building
	private Rectangle rectangle; // the rectangle we are building
	private Polyline polyline;// the polyline we are building
	
	private Canvas canvas;
	
	private Color currentColour; 
	
	

	public PaintPanel(PaintModel model, View view) {  

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: blue");

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = "Circle"; // bad code here?
		this.colourMode = "0"; //no colour selected 
		this.currentColour = currentColour;
		this.fillMode = fillMode; 

		this.model = model;
		this.model.addObserver(this);
		this.view = view;
		
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setStroke(Color.WHITE);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;


		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}

		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for (Circle c : circles) {
			int x = c.getCentre().getX();
			int y = c.getCentre().getY();
			int radius = c.getRadius();
			g.strokeOval(x, y, radius, radius);	
			//this.model.getFillStatus(); //create a method to get Fill status?
			g.fillOval(x, y, radius, radius);  //comment these two lines to check if statement
			g.setFill(c.getColour());
			
			if (this.model.getFillStatus() == "Empty") { 
				g.fillOval(x, y, radius, radius);
				g.setFill(Color.TRANSPARENT);
				System.out.println(this.model.getFillStatus());//////////////////
			}else if (this.model.getFillStatus() == "Fill Shape") {
				g.setFill(c.getColour());
				g.fillOval(x, y, radius, radius);
			}else if (this.model.getFillStatus() == "Fill Outline") { //use stroke
				g.fillOval(x, y, radius, radius);
				g.setFill(c.getColour());
			}
			
		}
		
		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : rectangles) {
			int x = r.getUpperLeft().getX();
			int y = r.getUpperLeft().getY();
			int length = r.getLength();
			int width = r.getWidth();
			g.strokeRect(x, y, width, length);
			g.fillRect(x, y, width, length);
			g.setFill(r.getColour());
		}
		
		// Draw Polyline
		ArrayList<Polyline> polylines = this.model.getPolylines();
		for (Polyline pl: polylines) {
			for (int i = 0; i < pl.size() - 1; i++) {
				Point p1 = pl.get(i);
				Point p2 = pl.get(i + 1);
				g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) { 
		this.mode = mode;
	}
	
	public void setColourMode(String colourMode) {
		this.colourMode = colourMode;
	}
	
	public void setFillMode(String fillMode) {
		this.fillMode = fillMode; 
	}

	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			mouseExited(event);
		}
	}

	private void mouseMoved(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
		
		}
		

	}
	

	private void mouseDragged(MouseEvent e) {
		if (this.mode == "Squiggle") {         //fix squiggle bug
		
			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
			
		} 
		else if (this.mode == "Circle") {

			int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
			this.circle.setRadius(radius);
			Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
			this.circle.setCentre(centre);
			this.circle.setColour(this.currentColour);////////////////////////////
			this.model.addCircle(this.circle);

		} else if (this.mode == "Rectangle") {
			
			int width = Math.abs((int) this.rectangle.getStart().getX() - (int) e.getX());
			int length = Math.abs((int) this.rectangle.getStart().getY() - (int) e.getY());
			this.rectangle.setLength(length);
			this.rectangle.setWidth(width);
			this.rectangle.setColour(this.currentColour);
			int x = this.rectangle.getStart().getX(); //////////////////////
			int y = this.rectangle.getStart().getY();
			if ((int) this.rectangle.getStart().getX() > (int) e.getX()){
				x = (int) e.getX();		
			}
			if ((int) this.rectangle.getStart().getY() > (int) e.getY()) {
				y = (int) e.getY();
			}
			this.rectangle.setUpperLeft(new Point(x, y));
			
			
			this.model.addRectangle(this.rectangle);
			}
		else if (this.mode == "Polyline") {	
			}
			
	}
	
	private void mouseClicked(MouseEvent e) {
				
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			
		}
	}

	private void mousePressed(MouseEvent e) {
		if (this.mode == "Squiggle") {
			
		} else if (this.mode == "Circle") {
			// Problematic notion of radius and centre!!
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			this.circle = new Circle(centre, radius, this.currentColour); 

		} else if (this.mode == "Rectangle") {
			Point start = new Point((int) e.getX(), (int) e.getY());
			int length = 0;
			int width = 0;
			this.rectangle = new Rectangle(start, length, width);
		} else if (this.mode == "Polyline") {
			this.polyline.add(new Point((int) e.getX(), (int) e.getY()));
			this.model.addPolyline(this.polyline);
		}
		
		if (this.colourMode == "0") {
			this.currentColour = Color.BLACK;
		} else if (this.colourMode == "1") {
			this.currentColour = Color.RED;
		} else if (this.colourMode == "2") {
			this.currentColour = Color.BLUE;
		} else if (this.colourMode == "3") {
			this.currentColour = Color.GREEN;
		} else if (this.colourMode == "4") {
			this.currentColour = Color.PURPLE;
		} else if (this.colourMode == "5") {
			this.currentColour = Color.YELLOW;			
		}
		
//		if (this.fillMode == "NotFill") { 
//			this.currentColour = Color.TRANSPARENT;
//		}else if (this.fillMode == "Fill"){
//		
//			if (this.colourMode == "0") {
//				this.currentColour = Color.BLACK;
//			} else if (this.colourMode == "1") {
//				this.currentColour = Color.RED;
//			} else if (this.colourMode == "2") {
//				this.currentColour = Color.BLUE;
//			} else if (this.colourMode == "3") {
//				this.currentColour = Color.GREEN;
//			} else if (this.colourMode == "4") {
//				this.currentColour = Color.PURPLE;
//			} else if (this.colourMode == "5") {
//				this.currentColour = Color.YELLOW;			
//			}
//		}
//		
//		System.out.println(this.fillMode);
	}


	private void mouseReleased(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
			if (this.circle != null) {
				// Problematic notion of radius and centre!!
				int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
				this.circle.setRadius(radius);
				Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
				this.circle.setCentre(centre);
				
				
				this.model.addCircle(this.circle);
				this.model.addShape(circle);
				this.circle = null;	 
			}
			
		} else if (this.mode == "Rectangle") {
			if (this.rectangle != null) {
				int width = Math.abs((int) this.rectangle.getStart().getX() - (int) e.getX());
				int length = Math.abs((int) this.rectangle.getStart().getY() - (int) e.getY());
				this.rectangle.setLength(length);
				this.rectangle.setWidth(width);
				int x = this.rectangle.getStart().getX();
				int y = this.rectangle.getStart().getY();
				if ((int) this.rectangle.getStart().getX() > (int) e.getX()){
					x = (int) e.getX();		
				}
				if ((int) this.rectangle.getStart().getY() > (int) e.getY()) {
					y = (int) e.getY();
				}
				this.rectangle.setUpperLeft(new Point(x, y));
				
				
				this.model.addRectangle(this.rectangle);
				
				this.model.addShape(rectangle);
				
				this.rectangle = null;
			} else if (this.mode == "Polyline") {
				
			}
		}

	}


	private void mouseEntered(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			this.polyline = new Polyline();
		}
	}
	
	private void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			
		}
		
		
	}
		

	
	}

