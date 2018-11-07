package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

public interface ShapeManipulatorStrategy {
	
	public void MouseClicked(MouseEvent e);
	public void MouseDragged(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);

}
