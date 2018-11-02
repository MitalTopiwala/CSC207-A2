package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;

public class ToolChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view;
	
	
	public ToolChooserPanel(View view) {
		
		this.view = view;
		

		Slider slider = new Slider(0, 10, 1);
		slider.setShowTickLabels(true);
	    slider.setShowTickMarks(true);
	    
	    String[] buttonLabels = { "outline", "paint"};
	    int row = 5;
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
	

