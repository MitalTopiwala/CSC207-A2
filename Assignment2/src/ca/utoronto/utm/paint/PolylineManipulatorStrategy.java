package ca.utoronto.utm.paint;




import javafx.scene.input.MouseEvent;
/**
 * Handles all mouse event for Polyline.
 *
 */
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy{

	Polyline polyline;
	
	/** 
	 * Handles event if mouse clicked.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		ShapeManipulatorContext.addShape(this.polyline);
		
	}
	/** 
	 * Handles event if mouse dragged.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		this.polyline.delLastPolylinePoint();
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
		
	}
	
	/** 
	 * Handles event if mouse pressed.
	 * @param e		a Mouse event
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
		
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
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
	}
	
	/** 
	 * Handles event if mouse entered.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		this.polyline = new Polyline();
	}
	
	/** 
	 * Handles event if mouse exited.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
