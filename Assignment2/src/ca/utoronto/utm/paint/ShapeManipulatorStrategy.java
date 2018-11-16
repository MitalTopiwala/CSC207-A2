package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

public interface ShapeManipulatorStrategy {
	
	/**
	 * Handles event if mouse clicked.
	 * @param e		a Mouse event
	 */
	public void mouseClicked(MouseEvent e);
	
	/**
	 * Handles event if mouse dragged.
	 * @param e		a Mouse event
	 */
	public void mouseDragged(MouseEvent e);
	
	/**
	 * Handles event if mouse pressed.
	 * @param e		a Mouse event
	 */
	public void mousePressed(MouseEvent e);
	
	/**
	 * Handles event if mouse moved.
	 * @param e		a Mouse event
	 */
	public void mouseMoved(MouseEvent e);
	
	/**
	 * Handles event if mouse released.
	 * @param e		a Mouse event
	 */
	public void mouseReleased(MouseEvent e);
	
	/**
	 * Handles event if mouse entered.
	 * @param e		a Mouse event
	 */
	public void mouseEntered(MouseEvent e);
	
	/**
	 * Handles event if mouse exited.
	 * @param e		a Mouse event
	 */
	public void mouseExited(MouseEvent e);

}
