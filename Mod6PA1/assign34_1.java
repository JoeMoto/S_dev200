package Mod6PA1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class assign34_1 extends Application {
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();
    private Button btnView = new Button("View");
    private Button btnInsert = new Button("Insert");
    private Button btnUpdate = new Button("Update");

    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane and add components
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("ID"), 0, 0);
        gridPane.add(tfId, 1, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(tfLastName, 1, 1);
        gridPane.add(new Label("First Name"), 0, 2);
        gridPane.add(tfFirstName, 1, 2);
        gridPane.add(new Label("MI"), 0, 3);
        gridPane.add(tfMi, 1, 3);
        gridPane.add(new Label("Address"), 0, 4);
        gridPane.add(tfAddress, 1, 4);
        gridPane.add(new Label("City"), 0, 5);
        gridPane.add(tfCity, 1, 5);
        gridPane.add(new Label("State"), 0, 6);
        gridPane.add(tfState, 1, 6);
        gridPane.add(new Label("Telephone"), 0, 7);
        gridPane.add(tfTelephone, 1, 7);
        gridPane.add(new Label("Email"), 0, 8);
        gridPane.add(tfEmail, 1, 8);
        gridPane.add(btnView, 1, 9);
        gridPane.add(btnInsert, 1, 10);
        gridPane.add(btnUpdate, 1, 11);

        // Establish a connection to the database
        connectToDB();

        // Set actions for buttons
        btnView.setOnAction(e -> viewRecord());
        btnInsert.setOnAction(e -> insertRecord());
        btnUpdate.setOnAction(e -> updateRecord());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 450);
        primaryStage.setTitle("Staff Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToDB() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection (update URL, username, password as needed)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/staff", "root", "");
            System.out.println("Database connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewRecord() {
        String id = tfId.getText();
        try {
            String query = "SELECT * FROM Staff WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tfLastName.setText(resultSet.getString("lastName"));
                tfFirstName.setText(resultSet.getString("firstName"));
                tfMi.setText(resultSet.getString("mi"));
                tfAddress.setText(resultSet.getString("address"));
                tfCity.setText(resultSet.getString("city"));
                tfState.setText(resultSet.getString("state"));
                tfTelephone.setText(resultSet.getString("telephone"));
                tfEmail.setText(resultSet.getString("email"));
            } else {
                showAlert("No record found for ID " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRecord() {
        try {
            String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tfId.getText());
            preparedStatement.setString(2, tfLastName.getText());
            preparedStatement.setString(3, tfFirstName.getText());
            preparedStatement.setString(4, tfMi.getText());
            preparedStatement.setString(5, tfAddress.getText());
            preparedStatement.setString(6, tfCity.getText());
            preparedStatement.setString(7, tfState.getText());
            preparedStatement.setString(8, tfTelephone.getText());
            preparedStatement.setString(9, tfEmail.getText());

            int rows = preparedStatement.executeUpdate();
            showAlert(rows + " record(s) inserted.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateRecord() {
        try {
            String query = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, "
                    + "telephone = ?, email = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tfLastName.getText());
            preparedStatement.setString(2, tfFirstName.getText());
            preparedStatement.setString(3, tfMi.getText());
            preparedStatement.setString(4, tfAddress.getText());
            preparedStatement.setString(5, tfCity.getText());
            preparedStatement.setString(6, tfState.getText());
            preparedStatement.setString(7, tfTelephone.getText());
            preparedStatement.setString(8, tfEmail.getText());
            preparedStatement.setString(9, tfId.getText());

            int rows = preparedStatement.executeUpdate();
            showAlert(rows + " record(s) updated.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
