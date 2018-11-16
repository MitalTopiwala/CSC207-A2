package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

	
public class ColourChooserPanel extends GridPane implements EventHandler<ActionEvent> {
		
	private View view;
	//private JFrame colourFrame; 
	public String fillStatus;
	static Color color;
	static String command;

	public ColourChooserPanel(View view) {

		this.view = view;
			
		String[] colourRep = {"1","2","3","4","5","6"};
        String[] buttonColours = {"-fx-base: black;", "-fx-base: red;", "-fx-base: blue;","-fx-base: green;",
        		"-fx-base: purple;","-fx-base: yellow;"};
		
		int row = 9;
		ToggleGroup toggleGroup = new ToggleGroup();
		for (int i =0; i < buttonColours.length; i++) {
			ToggleButton button = new ToggleButton(colourRep[i]);	
			button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			button.setMinWidth(10);
			button.setStyle(buttonColours[i]);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
			button.setToggleGroup(toggleGroup);
		}
		
		toggleGroup.getSelectedToggle();
		////////////////////new/////////////////////////////////
		ChoiceBox fillChoice = new ChoiceBox();
		fillChoice.getItems().addAll("Fill Shape", "Fill Outline");
		fillChoice.setValue("Fill Outline"); //Set default value
		this.add(fillChoice, 0, 8);
		fillChoice.setOnAction(this);
		this.fillStatus = fillOptions(fillChoice);
		
	}
	
	
	public String fillOptions(ChoiceBox fillOptions) {
		String selectedOption = (String) fillOptions.getValue();
		if (selectedOption == "Fill Shape") {
			return this.fillStatus = "Fill Shape";
		}else if (selectedOption == "Fill Outline") {
			return this.fillStatus = "Fill Outline";
		}else {
			return selectedOption;
		}
	}
	
	
	public Color GETCOLOR() {
		return ColourChooserPanel.color;
	}

	
	@Override
	public void handle(ActionEvent event) {
		command = ((ToggleButton) event.getSource()).getText();
		if (command == "1") {
			ColourChooserPanel.color = Color.BLACK;
		}
		if (command == "2") {
			ColourChooserPanel.color = Color.RED;
		}
		if (command == "3") {
			ColourChooserPanel.color = Color.BLUE;
		}
		if (command == "4") {
			ColourChooserPanel.color = Color.GREEN;
		}
		if (command == "5") {
			ColourChooserPanel.color = Color.PURPLE;
		}
		if (command == "6") {
			ColourChooserPanel.color = Color.YELLOW;
		}
		
		//System.out.println("blah:" + command);
		this.view.getPaintPanel().setColourMode(ColourChooserPanel.color);
		System.out.println(this.GETCOLOR());
		//System.out.println(command);
		
	}
	
}
