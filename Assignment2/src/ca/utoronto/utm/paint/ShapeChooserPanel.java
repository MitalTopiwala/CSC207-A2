package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view

	public ShapeChooserPanel(View view) {

		this.view = view;
		
	
		
		

		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };

		int row = 0;
		ToggleGroup toggleGroup = new ToggleGroup();
		for (String label : buttonLabels) {
			ToggleButton button = new ToggleButton(label);		
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
