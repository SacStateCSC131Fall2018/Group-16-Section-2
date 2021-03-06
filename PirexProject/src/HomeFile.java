
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui_components.*;
/**  NOTE : JAVA FX needs to be installed
 * 
 * Goto Below Link for steps
 * https://bittlife.com/install-javafx-eclipse/
 * 
 * @author Raj Rathod
 *
 */
public class HomeFile extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Pirex");
		Group root = new Group();


		
		//MenuBar mainBar = new MenuBar();												//Added But I'm not sure if it works -Ly
		//root.getChildren().addN(menuBar);
		Scene scene = new Scene(root, 700, 600, Color.WHITE);// ADD menu ITEMS here or another method call
		
		
		TabPane tabPane = new TabPane();
		BorderPane borderPane = new BorderPane();

		createSearchDocumentTab(tabPane);
		createLoadDocumentTab(tabPane);
		createSummarizeDocumentTab(tabPane);

		// set borderpane widht and height
		configureBorderPane(root, scene, borderPane, tabPane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void configureBorderPane(Group root, Scene scene, BorderPane borderPane, TabPane tabPane) {
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.setCenter(tabPane);
		
		// Menu Controls 
		MenuBar menuBar = createMenuBar();

        borderPane.setTop(menuBar);
		root.getChildren().add(borderPane);
	}

	private MenuBar createMenuBar() {
		MenuBar localMenuBar = new MenuBar();
		
		// --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem f_saveBtn = new MenuItem("Save Query");
        MenuItem f_loadBtn = new MenuItem("load Query");
        MenuItem f_importBtn = new MenuItem("Import");
        MenuItem f_exportBtn = new MenuItem("Export");
        MenuItem f_exitBtn = new MenuItem("Exit");
        menuFile.getItems().addAll(f_saveBtn,f_loadBtn,f_importBtn,f_exportBtn,f_exitBtn);
        
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        MenuItem e_helpBtn = new MenuItem("Help");
        MenuItem e_aboutBtn = new MenuItem("About Pirex");
        menuEdit.getItems().addAll(e_helpBtn,e_aboutBtn);
        
        // --- Menu View
        Menu menuView = new Menu("View");
        
        // --- Menu Options
        Menu menuOptions = new Menu("Options");
        MenuItem o_documentsBtn = new MenuItem("Documents");
        menuOptions.getItems().add(o_documentsBtn);
        
        // All Components are stored in here.
        localMenuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuOptions);
		
        return localMenuBar;
	}
	private void createLoadDocumentTab(TabPane tabPane) {
		//HBox hbox = new HBox();
		//hbox.setAlignment(Pos.BASELINE_LEFT);
		FlowPane flow = new FlowPane();
		
		Tab loadDocTab = new Tab();
		loadDocTab.setText("Load Documents");
		loadDocTab.setClosable(false);
		
		createTextFileLabel(flow);
		TextField textFileInput = createTextFileInput(flow);
		createBrowseButton(flow);
		createTextFileTypeLabel(flow);
		createTextFileTypeComboBox(flow);
		loadDocTab.setContent(flow);
		createTitleLabel(flow);
		createTitleInput(flow);
		createAuthorLabel(flow);
		createAuthorInput(flow);
		createProcessButton(flow);
		createLine(flow);
		createTextBox(flow);
		tabPane.getTabs().add(loadDocTab);

	}

	private void createSummarizeDocumentTab(TabPane tabPane) {
		VBox sumBox = new VBox();
		sumBox.setAlignment(Pos.CENTER);
		Tab summarizeDocTab = new Tab();
		summarizeDocTab.setText("Summarize Documents");
		summarizeDocTab.setClosable(false);
		
		Text someText = new Text("Opus  0:Henry Ford    Slurp Rope     7312 documents\n"
				+ "          /Users/myPc/Programs/java/data/Slurp_Rope.txt\n"
				+ "Opus  1:Karen Fields    Danger Noodle     5212 documents\n"
				+ "          /Users/myPc/Programs/java/data/Danger_Noodle.txt\n"
				+ "Opus  2:Nathaniel Browning    Terror Wire     3542 documents\n"
				+ "          /Users/myPc/Programs/java/data/Terror_Wire.txt\n"
				+ "Opus  2:Sanjay McGriddle    Scary Snek     2168 documents\n"
				+ "          /Users/myPc/Programs/java/data/Scary_Snek.txt\n"
				+ "\n\nIndex Terms 18234\nPostings:       3575189");
		
		ScrollPane sumScrollPane= new ScrollPane(someText);
		sumScrollPane.setMinHeight(550);
		sumScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		sumScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		sumBox.getChildren().add(sumScrollPane);
		summarizeDocTab.setContent(sumBox);
		tabPane.getTabs().add(summarizeDocTab);
		
		
	}

	private void createSearchDocumentTab(TabPane tabPane) {
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		hbox.setAlignment(Pos.CENTER);

		Tab searchDocTab = new Tab();
		searchDocTab.setText("Search for Documents");
		searchDocTab.setClosable(false);
		
		createQueryLabel(hbox);
		TextField queryInput = createQueryInput(hbox);
		hbox.setPadding(new Insets(20));
		createClearButton(hbox, queryInput);
		createTextArea(vbox,hbox);

		searchDocTab.setContent(vbox);
		tabPane.getTabs().add(searchDocTab);
	}

	private void createEmptySpace(HBox hbox) {
		hbox.getChildren().add(new Label(" \n\n\n\n"));
	}
	
	private void createEmptySpace(FlowPane flow) {
		flow.getChildren().add(new Label("\n \n"));
	}

	private void createQueryLabel(HBox hbox) {
		Text text = new Text("Query:");
		hbox.getChildren().add(text);
		createEmptySpace(hbox);
	}

	private TextField createQueryInput(HBox hbox) {
		TextField queryInput = new TextField();
		queryInput.setPrefWidth(500);
		hbox.getChildren().add(queryInput);
		createEmptySpace(hbox);
		return queryInput;
	}

	private void createClearButton(HBox hbox, TextField queryInput) {
		Button clearBtn = new Button();
		clearBtn.setLayoutX(100);
		clearBtn.setLayoutY(80);
		clearBtn.setPrefWidth(100);
		clearBtn.setText("Clear");
		clearBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// System.out.println("Hello World");
				queryInput.clear();
			}
		});

		hbox.getChildren().add(clearBtn);
		
	}
	
	private void createTextFileLabel(FlowPane flow) {
		Text txt = new Text("Text File: ");
		flow.getChildren().add(txt);
	}
	
	private void createTextFileTypeLabel(FlowPane flow) {
		Text txt = new Text("Text File Type:  ");
		flow.getChildren().add(txt);
	}
	
	private TextField createTextFileInput(FlowPane flow) {
		TextField setTextInput = new TextField();
		setTextInput.setPrefWidth(500);
		createEmptySpace(flow);
		flow.getChildren().add(setTextInput);
		return setTextInput;
	}
	
	private void createBrowseButton(FlowPane flow) {
		Button browseButton = new Button();
		browseButton.setLayoutX(120);
		browseButton.setLayoutY(80);
		browseButton.setPrefWidth(100);
		browseButton.setText("Browse");
		flow.getChildren().add(new Label("   "));
		flow.getChildren().add(browseButton);
	}
	
	private void createTextFileTypeComboBox(FlowPane flow) {
		ObservableList<String> options = FXCollections.observableArrayList("Project Gutenberg File");
		final ComboBox comboBox = new ComboBox(options);
		comboBox.setPrefWidth(600);
		createEmptySpace(flow);
		flow.getChildren().add(comboBox);
	}
	
	private void createTitleLabel(FlowPane flow) {
		Text txt = new Text("Title:  ");
		createEmptySpace(flow);
		flow.getChildren().add(txt);
	}
	
	private TextField createTitleInput(FlowPane flow) {
		TextField setTitleInput = new TextField();
		setTitleInput.setPrefWidth(350);
		createEmptySpace(flow);
		flow.getChildren().add(setTitleInput);
		return setTitleInput;
	}
	
	private void createAuthorLabel(FlowPane flow) {
		Text txt = new Text("    Author:  ");
		flow.getChildren().add(txt);
	}
	
	private TextField createAuthorInput(FlowPane flow) {
		TextField setAuthorInput = new TextField();
		setAuthorInput.setPrefWidth(240);
		createEmptySpace(flow);
		flow.getChildren().add(setAuthorInput);
		return setAuthorInput;
	}
	
	private void createProcessButton(FlowPane flow) {
		Button processButton = new Button();
		processButton.setLayoutX(120);
		processButton.setLayoutY(80);
		processButton.setPrefWidth(100);
		processButton.setText("Process");
		createEmptySpace(flow);
		flow.getChildren().add(new Label("   "));
		flow.getChildren().add(processButton);
	}
	
	private void createTextBox(FlowPane flow) {
		TextField txtBox = new TextField();
		txtBox.setPrefWidth(690);
		txtBox.setPrefHeight(400);
		txtBox.setDisable(true);
		createEmptySpace(flow);
		flow.getChildren().add(txtBox);
	}
	
	private void createLine(FlowPane flow) {
		Line hLine = new Line();
		hLine.setStartX(200);
		hLine.setEndX(900);
		createEmptySpace(flow);
		flow.getChildren().add(hLine);
	}

	private void createTextArea(VBox vbox, HBox hbox) {

		TextField topField = new TextField();
		TextField bottomField = new TextField();
		
		topField.setMinHeight(200);
		topField.setEditable(false);
		
		bottomField.setMinHeight(200);
		bottomField.setEditable(false);	
		
		
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().addAll(hbox,topField,bottomField);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setSpacing(30);
		//vbox.getChildren().addAll(hbox,textArea);
	}
	
}

