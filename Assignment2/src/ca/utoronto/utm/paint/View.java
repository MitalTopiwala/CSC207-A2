package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent> {

	private PaintModel model;

	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ToolChooserPanel toolChooserPanel;
	private ColourChooserPanel colourChooserPanel; 



	public View(PaintModel model, Stage stage) {

		this.model = model;
		initUI(stage);
	}

	private void initUI(Stage stage) {

		this.paintPanel = new PaintPanel(this.model, this);  //this.toolChooserPanel);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.toolChooserPanel = new ToolChooserPanel(this);
		this.colourChooserPanel = new ColourChooserPanel(this);
	
	

		
		BorderPane root = new BorderPane();
		
	
		VBox vbox = addVBox();							//VBox is added to BorderPane
		root.setLeft(vbox);
		
	

		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();
	}

	private VBox addVBox() {           //added buttons for shapes and tools to VBox
		VBox vbox = new VBox();
	    //vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
		vbox.getChildren().add(shapeChooserPanel);
		vbox.getChildren().add(toolChooserPanel);
		vbox.getChildren().add(colourChooserPanel);
		return vbox;
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	public ToolChooserPanel getToolChooserPanel() {
		return toolChooserPanel;
	}
	
	public ColourChooserPanel getColourChooserPanel() {  //where is this method
		return colourChooserPanel;
	}

	
	public PaintModel getPaintModel () {
		return model;
	}
	
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(((MenuItem)event.getSource()).getText());
	}
}
