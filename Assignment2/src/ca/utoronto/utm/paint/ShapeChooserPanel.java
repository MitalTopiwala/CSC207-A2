package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view;// So we can talk to our parent or other components of the view
	
	static String command;//the name of the  shape ToggleButton that is currently selected
	
	/**
	* Creates five ToggleButton's with icons of shapes as their label.
	* @param view 
	*/
	public ShapeChooserPanel(View view) {

		this.view = view;
		
	
		Circle circ = new Circle(9);
		Rectangle rec = new Rectangle(17, 9);
		Rectangle sq = new Rectangle(9, 9);
		CubicCurve cubic = new CubicCurve();
		cubic.setStartX(0.0f);
		cubic.setStartY(50.0f);
		cubic.setControlX1(10.0f);
		cubic.setControlY1(0.0f);
		cubic.setControlX2(20.0f);
		cubic.setControlY2(100.0f);
		cubic.setEndX(30.0f);
		cubic.setEndY(50.0f);
		cubic.setFill(null);
		cubic.setStroke(Color.BLACK);
		
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[]{
		    0.0, 0.0,
		    2.0, 10.0,
		    10.0, 2.0 , 10.0, 8.0});
		Shape[] shapes = {circ, rec, sq, cubic, polyline};


		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline"};

		
		int row = 0;
		ToggleGroup toggleGroup = new ToggleGroup();
		for (int i =0; i < buttonLabels.length; i++) {
			ToggleButton button = new ToggleButton(buttonLabels[i], shapes[i]);	
			button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
			
			button.setToggleGroup(toggleGroup);
		
		}
		
		toggleGroup.getSelectedToggle();
		
		
	}
	
	/**
	 * Returns the mode.
	 * @return command
	 */
	public String getMode() {
		return command;
	}
	
	/**
	 *  Communicates which button is selected to the PaintPanel.
	 *  @param event the action that occurred/the button that was selected
	 */
	@Override
	public void handle(ActionEvent event) {
		command = ((ToggleButton) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
		//System.out.println(this.getMode(event));
		
	}
}