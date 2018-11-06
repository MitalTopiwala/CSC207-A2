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

	private static final Paint BLACK = null;
	private static final Paint YELLOW = null;
	private static final Paint PURPLE = null;
	private static final Paint GREEN = null;
	private static final Paint BLUE = null;
	private static final Paint RED = null;
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private String colourMode; //modifies input of colour filled 
	private Circle circle; // the circle we are building
	private Rectangle rectangle; // the rectangle we are building
	
	private Canvas canvas;
	
	private Paint currentColour; 
	
	//private ToolChooserPanel tcp;

	public PaintPanel(PaintModel model, View view) {  //ToolChooserPanel tcp {

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: blue");

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = "Circle"; // bad code here?
		this.colourMode = "0"; //no colour selected 
		this.currentColour = currentColour;

		this.model = model;
		this.model.addObserver(this);
		this.view = view;
		//this.tcp = tcp;
		
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
			//////////////////////////////////////////////////////////////////////////
		
			g.fillOval(x, y, radius, radius);
			g.setFill(this.currentColour);
		}
		
		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for (Rectangle r : rectangles) {
			int x = r.getUpperLeft().getX();
			int y = r.getUpperLeft().getY();
			int length = r.getLength();
			int width = r.getWidth();
			g.strokeRect(x, y, width, length);
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
	public void setMode(String mode) { ////////////// add colourMode to parameter?
		this.mode = mode;
	}
	
	public void setColourMode(String colourMode) {
		this.colourMode = colourMode;
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
		
		if (this.colourMode == "1") {
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}
	

	private void mouseDragged(MouseEvent e) {
		if (this.mode == "Squiggle") {
			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
			
		} else if (this.mode == "Circle") {

			int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
			this.circle.setRadius(radius);
			Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
			this.circle.setCentre(centre);
			this.model.addCircle(this.circle);

		} else if (this.mode == "Rectangle") {
			
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
			}	
		
		if (this.colourMode == "1") {
			this.
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}
	
	private void mouseClicked(MouseEvent e) {
				
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			
		}
		
		if (this.colourMode == "1") {
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}

	private void mousePressed(MouseEvent e) {
		if (this.mode == "Squiggle") {
			
		} else if (this.mode == "Circle") {
			// Problematic notion of radius and centre!!
			Point centre = new Point((int) e.getX(), (int) e.getY());
			int radius = 0;
			this.circle = new Circle(centre, radius);

		} else if (this.mode == "Rectangle") {
			Point start = new Point((int) e.getX(), (int) e.getY());
			int length = 0;
			int width = 0;
			this.rectangle = new Rectangle(start, length, width);
		}
		
		if (this.colourMode == "1") {
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}


	private void mouseReleased(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {
			if (this.circle != null) {
				this.currentColour = Color.AQUA; 
				// Problematic notion of radius and centre!!
				int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
				this.circle.setRadius(radius);
				Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
				this.circle.setCentre(centre);
				this.model.addCircle(this.circle);
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
				this.rectangle = null;
				

			}
		}
		
		if (this.colourMode == "1") {
				if (this.mode == "Squiggle") {

				} else if (this.mode == "Circle") {
					if (this.circle != null) {
						this.currentColour = Color.RED; 
						// Problematic notion of radius and centre!!
						int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
						this.circle.setRadius(radius);
						Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
						this.circle.setCentre(centre);
						this.model.addCircle(this.circle);
						this.circle = null;	 
					}
				}	
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}

	private void mouseEntered(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			
		}
		
		if (this.colourMode == "1") {
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
	}

	private void mouseExited(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {
			
		}
		
		if (this.colourMode == "1") {
			
		} else if (this.colourMode == "2") {
			
		} else if (this.colourMode == "3") {
			
		} else if (this.colourMode == "4") {
			
		} else if (this.colourMode == "5") {
			
		}
		
	}
}
