package ca.utoronto.utm.paint;




import javafx.scene.input.MouseEvent;
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy{

	Polyline polyline;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.polyline.addPolylinePoint(new Point((int) e.getX(), (int) e.getY()));
		ShapeManipulatorContext.modelChanged();

		ShapeManipulatorContext.addShape(this.polyline);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.polyline = new Polyline();
		System.out.println("Asked to make new shape polyline");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
