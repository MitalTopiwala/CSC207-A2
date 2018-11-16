package ca.utoronto.utm.paint;



import javafx.scene.input.MouseEvent;

/**
 * Handles all mouse events for Rectangle.
 * @author 
 *
 */
public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	
	private Rectangle rectangle;
	
	/**
	 * Handles event if mouse clicked.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	/**
	 * Handles event if mouse dragged.
	 * Makes rectangle if mouse dragged and modfies it as mouse is dragged.
	 * Shows rectangle feedback.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
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
		ShapeManipulatorContext.modelChanged();
	}
	
	/** 
	 * Handles event if mouse pressed.
	 * @param e		a Mouse event
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY());
		int length = 0;
		int width = 0;
		rectangle = new Rectangle(start, length, width);
		ShapeManipulatorContext.addShape(this.rectangle);
		
	}
	/** 
	 * Handles event if mouse moved.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	/** 
	 * Handles event if mouse released.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		this.rectangle = null;		
	}

	/** 
	 * Handles event if mouse entered.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/** 
	 * Handles event if mouse exited.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}

