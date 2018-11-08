package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;



/*Adds shapes to PaintModel. Uses strategy design pattern
   
*/

public class ShapeManipulatorContext implements ShapeManipulatorStrategy{
	
	private static PaintModel model;
	private ShapeManipulatorStrategy strategy;
	

	
	public ShapeManipulatorContext(PaintModel model) {
		ShapeManipulatorContext.model = model;
		this.strategy = null;
		
	}
	static void modelChanged() {
		model.modelChanged();
	}
	
	public static void addShape(Shapes shape) {
		model.addShape(shape);
		
	}
	
	@Override
	public void MouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
