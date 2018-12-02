
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

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
		Scene scene = new Scene(root, 700, 600, Color.WHITE);
		
		MenuBar menu = new MenuBar();
		// ADD menu ITEMS here or another method call

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
		root.getChildren().add(borderPane);
	}

	private void createLoadDocumentTab(TabPane tabPane) {
		Tab loadDocTab = new Tab();
		loadDocTab.setText("Load Documents");
		loadDocTab.setClosable(false);
		tabPane.getTabs().add(loadDocTab);

	}

	private void createSummarizeDocumentTab(TabPane tabPane) {
		Tab summarizeDocTab = new Tab();
		summarizeDocTab.setText("Summarize Documents");
		summarizeDocTab.setClosable(false);
		tabPane.getTabs().add(summarizeDocTab);

	}

	private void createSearchDocumentTab(TabPane tabPane) {
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.BASELINE_LEFT);

		Tab searchDocTab = new Tab();
		searchDocTab.setText("Search for Documents");
		searchDocTab.setClosable(false);
		
		//createEmptySpace(hbox);
		createQueryLabel(hbox);
		TextField queryInput = createQueryInput(hbox);
		createClearButton(hbox, queryInput);
		//createTextArea(hbox);

		searchDocTab.setContent(hbox);
		tabPane.getTabs().add(searchDocTab);
	}

	private void createEmptySpace(HBox hbox) {
		hbox.getChildren().add(new Label(" \n\n\n\n"));
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

	@SuppressWarnings("unused")
	private void createTextArea(HBox hbox) {
		TextArea textArea = new TextArea();
        textArea.setPrefRowCount(10);
        textArea.setPrefColumnCount(100);
        textArea.setWrapText(true);
        textArea.setPrefWidth(150);
        hbox.getChildren().add(textArea);
	}

}

