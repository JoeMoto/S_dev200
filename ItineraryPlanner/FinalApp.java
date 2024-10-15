/* 
 The Travel Planner is a JavaFX desktop application that enables users to create and manage personalized travel itineraries with full customization. Users start by creating a traveler profile by entering their first and last names, after which the system assigns a unique Traveler ID. They can then create itineraries for the traveler by specifying start and end dates, generating unique Itinerary IDs for each. Within an itinerary, users can add any number of custom activities—such as flights, hotel stays, restaurant reservations, sightseeing tours, or any other events—by providing details like the activity name, start and end times, and cost. All data is stored in structured text files using a delimiter for consistency. The application features input validation and error handling to ensure data integrity. Users can retrieve and update traveler and itinerary information using their respective IDs through the application's intuitive interface. To use the program, launch the application, create a traveler profile, set up an itinerary for the traveler, and then add desired activities to the itinerary; you can also retrieve and modify existing information as needed.
 */

package ItineraryPlanner;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FinalApp extends Application {

    private TravelPlanner currentTraveler;
    private Itinerary currentItinerary;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Travel Planner");

        TabPane tabPane = new TabPane();

        Tab travelerTab = new Tab("Traveler", initTravelerTab());
        Tab itineraryTab = new Tab("Itinerary", initItineraryTab());
        Tab activityTab = new Tab("Activities", initActivityTab());
        Tab retrievalTab = new Tab("Retrieve Data", initRetrievalTab());

        tabPane.getTabs().addAll(travelerTab, itineraryTab, activityTab, retrievalTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox initTravelerTab() {
        VBox travelerBox = new VBox(10);
        travelerBox.setPadding(new Insets(10));

        Label label = new Label("Enter Traveler Information");

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        Button createTravelerButton = new Button("Create Traveler");

        createTravelerButton.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();

            if (firstName.isEmpty() || lastName.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "First Name and Last Name cannot be empty.");
                return;
            }

            String travelerID = "TRV-" + System.currentTimeMillis();
            currentTraveler = new TravelPlanner(travelerID, firstName, lastName);
            DataHandler.saveTraveler(currentTraveler);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Traveler created with ID: " + travelerID);
        });

        travelerBox.getChildren().addAll(label, firstNameField, lastNameField, createTravelerButton);
        return travelerBox;
    }

    private VBox initItineraryTab() {
        VBox itineraryBox = new VBox(10);
        itineraryBox.setPadding(new Insets(10));

        Label label = new Label("Create Itinerary");

        TextField startDateField = new TextField();
        startDateField.setPromptText("Start Date (YYYY-MM-DD)");

        TextField endDateField = new TextField();
        endDateField.setPromptText("End Date (YYYY-MM-DD)");

        Button createItineraryButton = new Button("Create Itinerary");

        createItineraryButton.setOnAction(e -> {
            if (currentTraveler == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please create a traveler first.");
                return;
            }

            String startDate = startDateField.getText();
            String endDate = endDateField.getText();

            if (startDate.isEmpty() || endDate.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Start Date and End Date cannot be empty.");
                return;
            }

            currentItinerary = currentTraveler.createItinerary(startDate, endDate);
            DataHandler.saveItinerary(currentItinerary);

            showAlert(Alert.AlertType.INFORMATION, "Success",
                    "Itinerary created with ID: " + currentItinerary.getItineraryID());
        });

        itineraryBox.getChildren().addAll(label, startDateField, endDateField, createItineraryButton);
        return itineraryBox;
    }

    private VBox initActivityTab() {
        VBox activityBox = new VBox(10);
        activityBox.setPadding(new Insets(10));

        Label label = new Label("Add Activities");

        TextField activityNameField = new TextField();
        activityNameField.setPromptText("Activity Name");

        TextField startTimeField = new TextField();
        startTimeField.setPromptText("Start Time (HH:MM)");

        TextField endTimeField = new TextField();
        endTimeField.setPromptText("End Time (HH:MM)");

        TextField activityCostField = new TextField();
        activityCostField.setPromptText("Activity Cost");

        Button addActivityButton = new Button("Add Activity");

        addActivityButton.setOnAction(e -> {
            if (currentItinerary == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please create an itinerary first.");
                return;
            }

            String activityName = activityNameField.getText();
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            String activityCostStr = activityCostField.getText();

            if (activityName.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || activityCostStr.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "All fields must be filled.");
                return;
            }

            double activityCost;
            try {
                activityCost = Double.parseDouble(activityCostStr);
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Activity Cost must be a valid number.");
                return;
            }

            ItineraryDetail detail = new ItineraryDetail(currentItinerary.getItineraryID(), activityName, startTime,
                    endTime, activityCost);
            DataHandler.saveItineraryDetail(detail);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Activity added to itinerary.");
        });

        activityBox.getChildren().addAll(label, activityNameField, startTimeField, endTimeField, activityCostField,
                addActivityButton);
        return activityBox;
    }

    private VBox initRetrievalTab() {
        VBox retrievalBox = new VBox(10);
        retrievalBox.setPadding(new Insets(10));

        Label label = new Label("Retrieve and Update Traveler and Itinerary Information");

        // Section for Traveler Retrieval
        Label travelerSectionLabel = new Label("Retrieve Traveler");
        TextField travelerIdField = new TextField();
        travelerIdField.setPromptText("Enter Traveler ID");
        Button retrieveTravelerButton = new Button("Retrieve Traveler");
        TextArea travelerInfoArea = new TextArea();
        travelerInfoArea.setEditable(false);
        travelerInfoArea.setPrefHeight(100);

        // Fields for updating traveler information
        Label updateTravelerLabel = new Label("Update Traveler Information");
        TextField newFirstNameField = new TextField();
        newFirstNameField.setPromptText("New First Name");
        TextField newLastNameField = new TextField();
        newLastNameField.setPromptText("New Last Name");
        Button updateTravelerButton = new Button("Update Traveler");

        // Section for Itinerary Retrieval
        Label itinerarySectionLabel = new Label("Retrieve Itinerary");
        TextField itineraryIdField = new TextField();
        itineraryIdField.setPromptText("Enter Itinerary ID");
        Button retrieveItineraryButton = new Button("Retrieve Itinerary");
        TextArea itineraryInfoArea = new TextArea();
        itineraryInfoArea.setEditable(false);
        itineraryInfoArea.setPrefHeight(200);

        // Event Handlers
        retrieveTravelerButton.setOnAction(e -> {
            String travelerID = travelerIdField.getText().trim();
            if (travelerID.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Traveler ID cannot be empty.");
                return;
            }

            Traveler traveler = DataHandler.getTraveler(travelerID);
            if (traveler == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Traveler not found.");
                travelerInfoArea.clear();
                currentTraveler = null; // Ensure currentTraveler is null if not found
            } else {
                currentTraveler = (TravelPlanner) traveler;
                StringBuilder info = new StringBuilder();
                info.append("Traveler ID: ").append(traveler.getTravelerID()).append("\n")
                        .append("First Name: ").append(traveler.getFirstName()).append("\n")
                        .append("Last Name: ").append(traveler.getLastName()).append("\n\n");

                // Retrieve itineraries for this traveler
                List<Itinerary> itineraries = DataHandler.getItinerariesByTravelerID(travelerID);
                if (!itineraries.isEmpty()) {
                    info.append("Itinerary IDs:\n");
                    for (Itinerary itinerary : itineraries) {
                        info.append("").append(itinerary.getItineraryID())
                                .append(" (").append(itinerary.getStartDate()).append(" to ")
                                .append(itinerary.getEndDate()).append(")\n");
                    }
                } else {
                    info.append("No itineraries found for this traveler.\n");
                }

                travelerInfoArea.setText(info.toString());
            }
        });

        updateTravelerButton.setOnAction(e -> {
            if (currentTraveler == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please retrieve a traveler first.");
                return;
            }

            String newFirstName = newFirstNameField.getText().trim();
            String newLastName = newLastNameField.getText().trim();

            if (newFirstName.isEmpty() && newLastName.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "At least one field must be filled to update.");
                return;
            }

            if (!newFirstName.isEmpty()) {
                currentTraveler.setFirstName(newFirstName);
            }
            if (!newLastName.isEmpty()) {
                currentTraveler.setLastName(newLastName);
            }

            DataHandler.updateTraveler(currentTraveler);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Traveler information updated.");

            // Refresh displayed traveler info
            travelerInfoArea.setText("Traveler ID: " + currentTraveler.getTravelerID() + "\n" +
                    "First Name: " + currentTraveler.getFirstName() + "\n" +
                    "Last Name: " + currentTraveler.getLastName());

            // Clear input fields
            newFirstNameField.clear();
            newLastNameField.clear();
        });

        retrieveItineraryButton.setOnAction(e -> {
            String itineraryID = itineraryIdField.getText().trim();
            if (itineraryID.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Itinerary ID cannot be empty.");
                return;
            }

            Itinerary itinerary = DataHandler.getItinerary(itineraryID);
            if (itinerary == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Itinerary not found.");
                itineraryInfoArea.clear();
            } else {
                StringBuilder info = new StringBuilder();
                info.append("Itinerary ID: ").append(itinerary.getItineraryID()).append("\n");
                info.append("Traveler ID: ").append(itinerary.getTravelerID()).append("\n");
                info.append("Start Date: ").append(itinerary.getStartDate()).append("\n");
                info.append("End Date: ").append(itinerary.getEndDate()).append("\n\n");

                // Retrieve and display itinerary details
                List<ItineraryDetail> details = DataHandler.getItineraryDetails(itineraryID);
                double totalCost = 0;
                if (!details.isEmpty()) {
                    info.append("Activities:\n");
                    for (ItineraryDetail detail : details) {
                        info.append("Activity Name: ").append(detail.getActivityName()).append("\n")
                                .append("Start Time: ").append(detail.getStartTime()).append("\n")
                                .append("End Time: ").append(detail.getEndTime()).append("\n")
                                .append("Cost: $").append(detail.getActivityCost()).append("\n\n");
                        totalCost += detail.getActivityCost();
                    }
                    info.append("Total Estimated Cost: $").append(totalCost).append("\n");
                } else {
                    info.append("No activities found for this itinerary.\n");
                }

                itineraryInfoArea.setText(info.toString());
            }
        });

        // Arrange components
        retrievalBox.getChildren().addAll(label,
                travelerSectionLabel, travelerIdField, retrieveTravelerButton, travelerInfoArea,
                updateTravelerLabel, newFirstNameField, newLastNameField, updateTravelerButton,
                itinerarySectionLabel, itineraryIdField, retrieveItineraryButton, itineraryInfoArea);

        return retrievalBox;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
