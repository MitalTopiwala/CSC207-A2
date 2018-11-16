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
	

	/**
	 * Initiates the repaint of the Paint application.
	 */

	public void update(Observable o, Object arg) {
		this.repaint();		
	}


	/**
	 * Creates a ShapeManipualatorStrategy based on mode.
	 * @param mode the name of the shape button selected
	 */


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
			this.context.mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.context.mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			this.context.mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			this.context.mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			this.context.mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			this.context.mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			this.context.mouseExited(event);
		}
	}
}
