package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;



/*Adds shapes to PaintModel. Uses strategy design pattern
   
*/

public class ShapeManipulatorContext implements ShapeManipulatorStrategy{
	
	static PaintModel model;
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
	public void mouseClicked(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseClicked(e);		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseDragged(e);	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mousePressed(e);	
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseMoved(e);	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseReleased(e);	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseEntered(e);	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (this.strategy!= null)
			this.strategy.mouseExited(e);	
		
	}
	
	

}
