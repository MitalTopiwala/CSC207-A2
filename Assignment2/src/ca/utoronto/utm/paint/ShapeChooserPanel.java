package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view

	public ShapeChooserPanel(View view) {

		this.view = view;
		
	
		Circle circ = new Circle(9);
		Rectangle rec = new Rectangle(17, 9);
		Rectangle sq = new Rectangle(9, 9);
		Circle circ2 = new Circle(1);
		Circle circ3 = new Circle(1);
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[]{
		    0.0, 0.0,
		    2.0, 10.0,
		    10.0, 2.0 , 10.0, 8.0});
		Shape[] shapes = {circ, rec, sq, circ2, polyline};


		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline"};

		
		int row = 0;
		ToggleGroup toggleGroup = new ToggleGroup();
		for (int i =0; i < buttonLabels.length; i++) {
			ToggleButton button = new ToggleButton(buttonLabels[i], shapes[i]);		
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
			
			button.setToggleGroup(toggleGroup);
		
		}
		
		toggleGroup.getSelectedToggle();
		
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((ToggleButton) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
