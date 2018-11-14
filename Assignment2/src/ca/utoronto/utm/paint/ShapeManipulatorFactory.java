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
			
		}
		
		if(Mode == "Polyline"){
			strategy = new PolylineManipulatorStrategy();
		}
		//change return statement
		//System.out.println("factory             " + strategy);
		return strategy;
		
	}

}
