package Mod5PA1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class assign14_1 extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the application
    }

    public void start(Stage primaryStage) {
        // Create a pane to hold the images views
        GridPane pane = new GridPane();

        // Place nodes in the pane
        try {
            pane.add(new ImageView(new Image("Mod5PA1/Images/flag1.gif")), 0, 0);
            pane.add(new ImageView(new Image("Mod5PA1/Images/flag2.gif")), 1, 0);
            pane.add(new ImageView(new Image("Mod5PA1/Images/flag6.gif")), 0, 1);
            pane.add(new ImageView(new Image("Mod5PA1/Images/flag7.gif")), 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL or resource not found: " + e.getMessage());
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("assign14.1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
}
