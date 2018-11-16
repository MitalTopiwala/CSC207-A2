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
			
		String[] colourRep = {"black","red","blue","green","purple","yellow"};
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
		ChoiceBox fillOptions = new ChoiceBox();
		fillOptions.getItems().addAll("Empty", "Fill Shape", "Fill Outline");
		fillOptions.setValue("Empty"); //Set default value
//		fillOptions.setItems(FXCollections.observableArrayList("Empty", "Fill Shape", "Fill Outline"));
		this.add(fillOptions, 0, 8);
		fillOptions.setOnAction(this);
		this.fillStatus = fillOptions(fillOptions);
		
	}
	//////////////////////new/////////////////////////
	public String fillOptions(ChoiceBox fillOptions) {
		String selectedOption = (String) fillOptions.getValue();
		if (selectedOption == "Empty") {
			return this.fillStatus = "Empty";
		}else if (selectedOption == "Fill Shape") {
			return this.fillStatus = "Fill Shape";
		}else if (selectedOption == "Fill Outline") {
			return this.fillStatus = "Fill Outline";
		}else {
			return selectedOption;
		}
	}
	
	
	public Color GETCOLOR() {
		//System.out.println("colorchooserpanel    " + ColourChooserPanel.color);
		return ColourChooserPanel.color;
	}
	
	

	
	@Override
	public void handle(ActionEvent event) {
		command = ((ToggleButton) event.getSource()).getText();
		if (command == "red") {
			ColourChooserPanel.color = Color.RED;
		}
		if (command == "black") {
			ColourChooserPanel.color = Color.BLACK;
		}
		if (command == "blue") {
			ColourChooserPanel.color = Color.BLUE;
		}
		if (command == "green") {
			ColourChooserPanel.color = Color.GREEN;
		}
		if (command == "purple") {
			ColourChooserPanel.color = Color.PURPLE;
		}
		if (command == "yellow") {
			ColourChooserPanel.color = Color.YELLOW;
		}
		//System.out.println("blah:" + command);
		this.view.getPaintPanel().setColourMode(ColourChooserPanel.color);
		System.out.println(this.GETCOLOR());
		//System.out.println(command);
		
	}
	
}
