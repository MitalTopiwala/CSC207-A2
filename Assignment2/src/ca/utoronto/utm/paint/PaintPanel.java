
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



class PaintPanel extends StackPane implements Observer,EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view


	
	private Canvas canvas;
	
	public Color currentColor; 
	
	private ShapeManipulatorContext context;
	
	private ShapeChooserPanel scp;
	
	private ToolChooserPanel tcp;
	
	
	
	
	
	

	public PaintPanel(PaintModel model, View view) {  

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);


		this.model = model;
		this.model.addObserver(this);
		this.view = view;
		this.context = new ShapeManipulatorContext(model); 
		this.scp = new ShapeChooserPanel(view);
	
		
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setStroke(Color.BLACK);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;
		this.model.draw(g);

	}
		// Draw Lines
//		ArrayList<Point> points = this.model.getPoints();
//		for (int i = 0; i < points.size() - 1; i++) {
//			Point p1 = points.get(i);
//			Point p2 = points.get(i + 1);
//			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
//		}
//

//		
//		// Draw Polyline
//		ArrayList<Polyline> polylines = this.model.getPolylines();
//		for (Polyline pl: polylines) {
//			for (int i = 0; i < pl.size() - 1; i++) {
//				Point p1 = pl.get(i);
//				Point p2 = pl.get(i + 1);
//				g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
//			}
//		}
//	}
//
//	@Override
//	public void update(Observable o, Object arg) {
//		// Not exactly how MVC works, but similar.
//		this.repaint();
//	}
//
//	/**
//	 * Controller aspect of this
//	 */
//	public void setMode(String mode) { 
//		this.mode = mode;
//	}
//	
//	public void setColourMode(String colourMode) {
//		this.colourMode = colourMode;
//	}
//

//
//	private void mouseMoved(MouseEvent e) {
//		if (this.mode == "Squiggle") {
//
//		} else if (this.mode == "Circle") {
//
//		} else if (this.mode == "Rectangle") {
//		
//		}
//		
//
//	}
//	
//
//	private void mouseDragged(MouseEvent e) {
//		if (this.mode == "Squiggle") {         //fix squiggle bug
//		
//			this.model.addPoint(new Point((int) e.getX(), (int) e.getY()));
//			
//		} 
//		else if (this.mode == "Circle") {
//
//			int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
//			this.circle.setRadius(radius);
//			Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
//			this.circle.setCentre(centre);
//			this.circle.setColour(this.currentColour);////////////////////////////
//			this.model.addCircle(this.circle);
//
//		} else if (this.mode == "Rectangle") {
//			
//			int width = Math.abs((int) this.rectangle.getStart().getX() - (int) e.getX());
//			int length = Math.abs((int) this.rectangle.getStart().getY() - (int) e.getY());
//			this.rectangle.setLength(length);
//			this.rectangle.setWidth(width);
//			this.rectangle.setColour(this.currentColour);
//			int x = this.rectangle.getStart().getX(); //////////////////////
//			int y = this.rectangle.getStart().getY();
//			if ((int) this.rectangle.getStart().getX() > (int) e.getX()){
//				x = (int) e.getX();		
//			}
//			if ((int) this.rectangle.getStart().getY() > (int) e.getY()) {
//				y = (int) e.getY();
//			}
//			this.rectangle.setUpperLeft(new Point(x, y));
//			
//			
//			this.model.addRectangle(this.rectangle);
//			}
//		else if (this.mode == "Polyline") {	
//			}
//			
//	}
//	
//	private void mouseClicked(MouseEvent e) {
//				
//		if (this.mode == "Squiggle") {
//
//		} else if (this.mode == "Circle") {
//
//		} else if (this.mode == "Rectangle") {
//			
//		}
//	}
//
//	private void mousePressed(MouseEvent e) {
//		if (this.mode == "Squiggle") {
//			
//		} else if (this.mode == "Circle") {
//			// Problematic notion of radius and centre!!
//			Point centre = new Point((int) e.getX(), (int) e.getY());
//			int radius = 0;
//			this.circle = new Circle(centre, radius, this.currentColour); 
//
//		} else if (this.mode == "Rectangle") {
//			Point start = new Point((int) e.getX(), (int) e.getY());
//			int length = 0;
//			int width = 0;
//			this.rectangle = new Rectangle(start, length, width);
//		} else if (this.mode == "Polyline") {
//			this.polyline.add(new Point((int) e.getX(), (int) e.getY()));
//			this.model.addPolyline(this.polyline);
//		}
//		
//		if (this.colourMode == "0") {
//			this.currentColour = Color.BLACK;
//		} else if (this.colourMode == "1") {
//			this.currentColour = Color.RED;
//		} else if (this.colourMode == "2") {
//			this.currentColour = Color.BLUE;
//		} else if (this.colourMode == "3") {
//			this.currentColour = Color.GREEN;
//		} else if (this.colourMode == "4") {
//			this.currentColour = Color.PURPLE;
//		} else if (this.colourMode == "5") {
//			this.currentColour = Color.YELLOW;			
//		}
//	}
//
//
//	private void mouseReleased(MouseEvent e) {
//		if (this.mode == "Squiggle") {
//
//		} else if (this.mode == "Circle") {
//			if (this.circle != null) {
//				// Problematic notion of radius and centre!!
//				int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
//				this.circle.setRadius(radius);
//				Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
//				this.circle.setCentre(centre);
//				
//				
//				this.model.addCircle(this.circle);
//				this.model.addShape(circle);
//				this.circle = null;	 
//			}
//			
//		} else if (this.mode == "Rectangle") {
//			if (this.rectangle != null) {
//				int width = Math.abs((int) this.rectangle.getStart().getX() - (int) e.getX());
//				int length = Math.abs((int) this.rectangle.getStart().getY() - (int) e.getY());
//				this.rectangle.setLength(length);
//				this.rectangle.setWidth(width);
//				int x = this.rectangle.getStart().getX();
//				int y = this.rectangle.getStart().getY();
//				if ((int) this.rectangle.getStart().getX() > (int) e.getX()){
//					x = (int) e.getX();		
//				}
//				if ((int) this.rectangle.getStart().getY() > (int) e.getY()) {
//					y = (int) e.getY();
//				}
//				this.rectangle.setUpperLeft(new Point(x, y));
//				
//				
//				this.model.addRectangle(this.rectangle);
//				
//				this.model.addShape(rectangle);
//				
//				this.rectangle = null;
//			} else if (this.mode == "Polyline") {
//				
//			}
//		}
//
//	}
//
//
//	private void mouseEntered(MouseEvent e) {
//		if (this.mode == "Squiggle") {
//
//		} else if (this.mode == "Circle") {
//
//		} else if (this.mode == "Rectangle") {
//			this.polyline = new Polyline();
//		}
//	}
//	
//	private void mouseExited(MouseEvent e) {
//		if (this.mode == "Squiggle") {
//
//		} else if (this.mode == "Circle") {
//
//		} else if (this.mode == "Rectangle") {
//			
//		}
//		
//		
//	}
//		


	public void update(Observable o, Object arg) {
		this.repaint();		
	}
	
	
	public void mouseMoved(MouseEvent e) {
		this.context.mouseMoved(e);
	}

	public void mouseDragged(MouseEvent e) {
		this.context.mouseDragged(e);
	}

	public void mouseClicked(MouseEvent e) {
		this.context.mouseClicked(e);
	}
	

	public void mousePressed(MouseEvent e) {
		this.context.mousePressed(e);
	}


	public void mouseReleased(MouseEvent e) {
		this.context.mouseReleased(e);
	}


	public void mouseEntered(MouseEvent e) {
		this.context.mouseEntered(e);
	}


	public void mouseExited(MouseEvent e) {
		this.context.mouseExited(e);
	}

	
	public void setMode(String mode) {
		String Mode = this.scp.getMode();
		ShapeManipulatorStrategy strategy = ShapeManipulatorFactory.getStrategy(Mode);
		this.view.getPaintModel().modelChanged();
		this.context.newStrategy(strategy);
		
	}
	
	public void setEraserMode(String mode) {
		
		System.out.println("pp  " + this.tcp.getEraserMode());
		String Mode = this.tcp.getEraserMode();
		ShapeManipulatorStrategy strategy = ShapeManipulatorFactory.getStrategy(Mode);
		this.view.getPaintModel().modelChanged();
		this.context.newStrategy(strategy);
		
	}
	
	public void setColourMode(Color color) {
		this.currentColor = color;
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
}

