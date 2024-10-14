package Mod5PA3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class assign16_17 extends Application {
    protected Text text = new Text("Show Colors");
    protected Slider slRed = new Slider(0.0, 1.0, 0.0);
    protected Slider slGreen = new Slider(0.0, 1.0, 0.0);
    protected Slider slBlue = new Slider(0.0, 1.0, 0.0);
    protected Slider slOpacity = new Slider(0.0, 1.0, 1.0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create and set up the UI components
        StackPane paneForText = createTextPane();
        GridPane paneForSliders = createSlidersPane();

        // Place nodes in a border pane
        BorderPane pane = new BorderPane();
        pane.setTop(paneForText);
        pane.setCenter(paneForSliders);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("Exercise_16_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** Create a StackPane for the text */
    private StackPane createTextPane() {
        StackPane pane = new StackPane(text);
        pane.setPadding(new Insets(20, 10, 5, 10));
        return pane;
    }

    /** Create a GridPane for the sliders with labels */
    private GridPane createSlidersPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);

        // Add labels and sliders to the pane
        pane.add(new Label("Red"), 0, 0);
        pane.add(slRed, 1, 0);
        pane.add(new Label("Green"), 0, 1);
        pane.add(slGreen, 1, 1);
        pane.add(new Label("Blue"), 0, 2);
        pane.add(slBlue, 1, 2);
        pane.add(new Label("Opacity"), 0, 3);
        pane.add(slOpacity, 1, 3);

        // Set up slider listeners
        slRed.valueProperty().addListener(ov -> setColor());
        slGreen.valueProperty().addListener(ov -> setColor());
        slBlue.valueProperty().addListener(ov -> setColor());
        slOpacity.valueProperty().addListener(ov -> setColor());

        return pane;
    }

    /** Set the text color */
    private void setColor() {
        text.setFill(new Color(slRed.getValue(), slGreen.getValue(),
                slBlue.getValue(), slOpacity.getValue()));
    }
}
