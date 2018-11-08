package ca.utoronto.utm.paint;
import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
	
public class ColourChooserPanel extends GridPane implements EventHandler<ActionEvent> {
		
	private View view; 

	public ColourChooserPanel(View view) {

		this.view = view;
			
		String[] colourRep = {"0","1","2","3","4","5"};
        String[] buttonColours = {"-fx-base: black;", "-fx-base: red;", "-fx-base: blue;","-fx-base: green;",
        		"-fx-base: purple;","-fx-base: yellow;"};
		
		int row = 9;
		ToggleGroup toggleGroup = new ToggleGroup();
		for (int i =0; i < buttonColours.length; i++) {
			ToggleButton button = new ToggleButton(colourRep[i]);		
			button.setMinWidth(30);
			button.setStyle(buttonColours[i]);
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
		//System.out.println("blah:" + command);
		this.view.getPaintPanel().setColourMode(command);
		System.out.println(command);
	}
	
}
