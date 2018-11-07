package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

public class CircleManipulatorStrategy implements ShapeManipulatorStrategy{
	
	private Circle circle;

	@Override
	public void MouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int radius = 2*(int) Math.sqrt(Math.pow(Math.abs((int) this.circle.getStart().getX() - (int) e.getX()), 2)+ Math.pow(Math.abs((int) this.circle.getStart().getY() - (int) e.getY()), 2));
		this.circle.setRadius(radius);
		Point centre = new Point((int) this.circle.getStart().getX() - (radius/2), (int) this.circle.getStart().getY()- (radius/2));
		this.circle.setCentre(centre);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point centre = new Point(e.getX(),e.getY());
		circle = new Circle(centre, 0);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		this.circle = new Circle(centre, radius);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
