package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;
/**
 * Handles all mouse event for Squiggle.
 *
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy{

	private Squiggle squiggle;
	
	@Override
	/**
	 * Handles event if mouse clicked.
	 * @param e		a Mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	/**
	 * Handles event if mouse dragged.
	 * Squiggle is continued if mouse dragged.
	 * @param e		a Mouse event
	 */
	public void mouseDragged(MouseEvent e) {
		this.squiggle.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	/**
	 * Handles event if mouse pressed.
	 * Creates a new squiggle if mouse pressed and adds each point to Squiggle. 
	 * Adds Squiggle to list of Shapes.
	 * 
	 * @param e		a Mouse event
	 */
	public void mousePressed(MouseEvent e) {
		this.squiggle = new Squiggle();
		this.squiggle.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.addShape(this.squiggle);
		
	}

	@Override
	/**
	 * Handles event if mouse moved.
	 * @param e		a Mouse event
	 */
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	/**
	 * Handles event if mouse released.
	 * Stops squiggle if mouse is released.
	 * @param e		a Mouse event
	 */
	public void mouseReleased(MouseEvent e) {
		this.squiggle = null;
	}

	@Override
	/**
	 * Handles event if mouse entered.
	 * @param e		a Mouse event
	 */
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	/**
	 * Handles event if mouse exited.
	 * @param e		a Mouse event
	 */
	public void mouseExited(MouseEvent e) {
		
	}
	
}
