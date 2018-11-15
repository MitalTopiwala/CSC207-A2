package ca.utoronto.utm.paint;



public class ShapeManipulatorFactory {
	
	
	
	
	public static ShapeManipulatorStrategy getStrategy(String Mode) {
		
	
		
		ShapeManipulatorStrategy strategy = null;
		if (Mode == "Circle") {
			strategy = new CircleManipulatorStrategy();
		}
			 
		if(Mode == "Rectangle"){
			strategy = new RectangleManipulatorStrategy();
		}
		if(Mode == "Square"){
			
		}
		if(Mode == "Squiggle"){
			strategy = new SquiggleManipulatorStrategy();
			
		}
		
		if(Mode == "Polyline"){
			strategy = new PolylineManipulatorStrategy();
		}
		
		if(Mode == "Eraser") {
			strategy = new EraserManipulatorStrategy();
			System.out.println("factoryyyyyy");
		}
		//change return statement
		//System.out.println("factory             " + strategy);
		return strategy;
		
	}

}
