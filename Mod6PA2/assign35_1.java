package Mod6PA2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class assign35_1 extends Application {
    private TextField dbUrlField = new TextField("jdbc:mysql://localhost:3306/records");
    private TextField userField = new TextField("root");
    private PasswordField passwordField = new PasswordField();
    private Button connectButton = new Button("Connect to Database");
    private Button insertWithoutBatchButton = new Button("Insert Without Batch");
    private Button insertWithBatchButton = new Button("Insert With Batch");
    private Label statusLabel = new Label("Status: Not Connected");
    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(
                new Label("Database URL:"), dbUrlField,
                new Label("Username:"), userField,
                new Label("Password:"), passwordField,
                connectButton, insertWithoutBatchButton, insertWithBatchButton, statusLabel);

        insertWithoutBatchButton.setDisable(true);
        insertWithBatchButton.setDisable(true);

        connectButton.setOnAction(e -> connectToDatabase());
        insertWithoutBatchButton.setOnAction(e -> insertRecords(false));
        insertWithBatchButton.setOnAction(e -> insertRecords(true));

        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setTitle("Batch Update Performance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToDatabase() {
        try {
            String url = dbUrlField.getText();
            String user = userField.getText();
            String password = passwordField.getText();

            connection = DriverManager.getConnection(url, user, password);
            statusLabel.setText("Status: Connected");
            insertWithoutBatchButton.setDisable(false);
            insertWithBatchButton.setDisable(false);
        } catch (SQLException ex) {
            statusLabel.setText("Status: Connection Failed");
            ex.printStackTrace();
        }
    }

    private void insertRecords(boolean useBatch) {
        String insertSQL = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
        Random random = new Random();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                statement.setDouble(1, random.nextDouble());
                statement.setDouble(2, random.nextDouble());
                statement.setDouble(3, random.nextDouble());

                if (useBatch) {
                    statement.addBatch();
                    // Execute in batches of 100 to avoid memory overflow
                    if (i % 100 == 0) {
                        statement.executeBatch();
                    }
                } else {
                    statement.executeUpdate();
                }
            }

            // If using batch, execute remaining batches
            if (useBatch) {
                statement.executeBatch();
            }

            long endTime = System.currentTimeMillis();
            statusLabel.setText(
                    "Time taken (" + (useBatch ? "with" : "without") + " batch): " + (endTime - startTime) + " ms");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            statusLabel.setText("Error during insertion");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
