package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * Handles all mouse event for Circle.
 *
 */
public class CircleManipulatorStrategy implements ShapeManipulatorStrategy{
	
	private Circle circle;

    public CircleManipulatorStrategy() {
	}
    
    /**
	 * Handles event if mouse clicked.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	/**
	 * Handles event if mouse dragged.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
		this.circle.setRadius(radius);
		Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
		this.circle.setCentre(centre);
		ShapeManipulatorContext.modelChanged();		
	}
	
	/**
	 * Handles event if mouse pressed.
	 * @param e		a Mouse event
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point centre = new Point(e.getX(),e.getY());
		circle = new Circle(centre, 0);
		ShapeManipulatorContext.addShape(this.circle);
		
	}

	/**
	 * Handles event if mouse moved.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		this.circle = new Circle(centre, radius);
		
	}

	/**
	 * Handles event if mouse released.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		this.circle = null;
	
	}
	
	/**
	 * Handles event if mouse entered.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Handles event if mouse exited.
	 * @param e		a Mouse event
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


