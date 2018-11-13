package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	
	Rectangle rectangle;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int width = Math.abs((int) this.rectangle.getStart().getX() - (int) e.getX());
		int length = Math.abs((int) this.rectangle.getStart().getY() - (int) e.getY());
		this.rectangle.setLength(length);
		this.rectangle.setWidth(width);
		int x = this.rectangle.getStart().getX();
		int y = this.rectangle.getStart().getY();
		if ((int) this.rectangle.getStart().getX() > (int) e.getX()){
			x = (int) e.getX();		
		}
		if ((int) this.rectangle.getStart().getY() > (int) e.getY()) {
			y = (int) e.getY();
		}
		this.rectangle.setUpperLeft(new Point(x, y));
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY());
		int length = 0;
		int width = 0;
		rectangle = new Rectangle(start, length, width);
		ShapeManipulatorContext.addShape(this.rectangle);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.rectangle = null;		
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
