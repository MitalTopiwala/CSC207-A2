package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy{

	Squiggle squiggle;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.squiggle.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.squiggle = new Squiggle();
		this.squiggle.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.addShape(this.squiggle);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.squiggle = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
