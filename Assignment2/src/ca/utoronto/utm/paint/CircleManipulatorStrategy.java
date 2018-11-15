
package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

public class CircleManipulatorStrategy implements ShapeManipulatorStrategy{
	
	private Circle circle;
	

    public CircleManipulatorStrategy() {
		
	}
    
    
    public int circleRadius(MouseEvent e) {
    	int x = (int) (this.circle.getCentre().getX()-e.getX());
		int y = (int) (this.circle.getCentre().getY()-e.getY());
		return (int) Math.pow(x*x + y*y, .5);
    	
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int radius = circleRadius(e);
		this.circle.setRadius(radius);
		ShapeManipulatorContext.modelChanged();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point centre = new Point(e.getX(), e.getY());
		this.circle=new Circle(centre, 0);
		ShapeManipulatorContext.addShape(this.circle);
		
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
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

}

