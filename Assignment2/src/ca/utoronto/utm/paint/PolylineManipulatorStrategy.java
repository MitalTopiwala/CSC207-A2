package ca.utoronto.utm.paint;




import javafx.scene.input.MouseEvent;
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy{

	Polyline polyline;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		ShapeManipulatorContext.addShape(this.polyline);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.polyline.delLastPolylinePoint();
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.polyline = new Polyline();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
