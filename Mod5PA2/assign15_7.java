package Mod5PA2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class assign15_7 extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the application
    }

    public void start(Stage primaryStage) {

        // Create a Stack pane
        StackPane pane = new StackPane();

        // Create a circle and set its properties
        Circle circle = new Circle(50, Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        // Create and register the handler
        pane.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        pane.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 120, 120);
        primaryStage.setTitle("assign15.7"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
}
