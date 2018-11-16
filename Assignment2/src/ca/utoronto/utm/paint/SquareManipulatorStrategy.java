package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;

public class SquareManipulatorStrategy extends RectangleManipulatorStrategy{
	private Square square;
	
	public void mouseDragged(MouseEvent e) {
		int length = Math.abs((int) this.square.getStart().getX() - (int) e.getX());
		this.square.setWidth(length);
		this.square.setLength(length);
		int x = this.square.getStart().getX();
		int y = this.square.getStart().getY();
		if ((int) this.square.getStart().getX() > (int) e.getX()){
			x = (int) e.getX();		
		}
		if ((int) this.square.getStart().getY() > (int) e.getY()) {
			y = (int) e.getY();
		}
		this.square.setUpperLeft(new Point(x, y));
		ShapeManipulatorContext.modelChanged();
	}
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY());
		int length = 0;
		square = new Square(start, length);
		ShapeManipulatorContext.addShape(this.square);
		
	}

}
