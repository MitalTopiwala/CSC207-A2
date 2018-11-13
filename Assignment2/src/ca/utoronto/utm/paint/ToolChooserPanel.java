package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class ToolChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view; // So we can talk to our parent or other components of the view
	private Slider slider;
	//private Canvas canvas;
	static double value;
	
	

	public ToolChooserPanel(View view) {
		
		this.view = view;
		slider = new Slider(1, 10, 1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		this.add(slider, 0, 6);
		Label label = new Label();
		this.add(label, 0, 7);
		value = 1;
		slider.valueProperty().addListener(e->{
			value = slider.getValue();
			String str = String.format("%.1f", value);
			label.setText("line width=" + str);	
			
		});	
	
}
	
	public double getLineWidth() {
		System.out.println(value);
		return value;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
