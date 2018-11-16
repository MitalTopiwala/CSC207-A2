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
	public Boolean fillStatus;
	static Color color;
	static String command;

	@SuppressWarnings("unchecked")
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
			button.setMinWidth(100);
			button.setStyle(buttonColours[i]);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
			button.setToggleGroup(toggleGroup);
		
		}
		
		toggleGroup.getSelectedToggle();
		
		String[] style = {"Fill", "Outline"};
		
		ToggleGroup toggleGroup1 = new ToggleGroup();
		for(int i = 0; i < style.length; i++) {
			ToggleButton fillOption = new ToggleButton(style[i]);
			this.add(fillOption, 0, row);
			row ++;
			fillOption.setOnAction(this);
		}
		
		
		
		
		
	}	
		
	/*	@SuppressWarnings("rawtypes")
		ChoiceBox fillOptions = new ChoiceBox();
		fillOptions.getItems().addAll("Fill", "Outline");
		fillOptions.setValue("Outline"); //Set default value

		this.add(fillOptions, 0, 7);
		fillOptions.setOnAction(this);
		this.fillStatus = fillOptions(fillOptions);
		
	}
	
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
	*/
	
	public Color GETCOLOR() {
		//System.out.println("colorchooserpanel    " + ColourChooserPanel.color);
		return ColourChooserPanel.color;
	}
	
	public Boolean getStatus() {
		return this.fillStatus;
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
		
		if(command == "Fill") {
			this.fillStatus = true;
		}
		if(command == "Outline") {
			this.fillStatus = false;
		}
	
		
		this.view.getPaintPanel().setColourMode(ColourChooserPanel.color);
		System.out.println(this.GETCOLOR());
		
		this.view.getPaintPanel().setStatus(this.fillStatus);
	}
	
}
