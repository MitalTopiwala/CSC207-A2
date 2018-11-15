package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

public class EraserManipulatorStrategy implements ShapeManipulatorStrategy{

	Eraser eraser;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.eraser.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.eraser = new Eraser();
		this.eraser.addSquigglePoint(new Point ((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.addShape(this.eraser);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.eraser = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}