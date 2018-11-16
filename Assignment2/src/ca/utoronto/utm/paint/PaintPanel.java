package ca.utoronto.utm.paint;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
	
	/**
	 * Constructs a PaintPanel using information from model and view.
	 * @param model the current PaintModel
	 * @param view the current View
	 */
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
	
	/**
	 * Repaints the Paint application to match current model.
	 */
	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setStroke(Color.BLACK);
		this.model.draw(g);

	}
	
<<<<<<< HEAD
	/**
	 * Initiates the repaint of the Paint application.
	 */
=======

>>>>>>> ce68a29aebe67a8362580537d522fd87a1ad8aba
	public void update(Observable o, Object arg) {
		this.repaint();		
	}
	
<<<<<<< HEAD
	/**
	 * Creates a ShapeManipualatorStrategy based on mode.
	 * @param mode the name of the shape button selected
	 */
=======
	
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


	
>>>>>>> ce68a29aebe67a8362580537d522fd87a1ad8aba
	public void setMode(String mode) {
		String Mode = this.scp.getMode();
		ShapeManipulatorStrategy strategy = ShapeManipulatorFactory.getStrategy(Mode);
		this.view.getPaintModel().modelChanged();
		this.context.newStrategy(strategy);
		
	}
	
	/**
	 * Sets currentColour instance variable to new specified color.
	 * @param color new current color
	 */
	public void setColourMode(Color color) {
		this.currentColor = color;
	}
	
	/**
	 * A mouse event handler that calls the appropriate shape strategy.
	 * @param event the MouseEvent that occurred
	 */
	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
			//this.context.mouseDragged(event);
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
