package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;

public class ShapeManipulatorFactory {
	
	
	
	
	public static ShapeManipulatorStrategy getStrategy(String Mode) {
		
	
		
		ShapeManipulatorStrategy strategy = null;
		if (Mode == "Circle") {
			strategy = new CircleManipulatorStrategy();
		}
			 
		if(Mode == Rectangle.class.getName()){
			strategy = new RectangleManipulatorStrategy();
		}
		if(Mode == "Square"){
			
		}

		
		if(Mode == "Polyline"){
			
		}
		//change return statement
		System.out.println("factory             " + strategy);
		return strategy;
		
	}

}
