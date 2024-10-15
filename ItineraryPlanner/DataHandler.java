package ItineraryPlanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static final String TRAVELER_FILE = "travelers.txt";
    private static final String ITINERARY_FILE = "itineraries.txt";
    private static final String ITINERARY_DETAIL_FILE = "itinerary_details.txt";
    private static final String DELIMITER = "\\|";

    // Save Traveler
    public static void saveTraveler(Traveler traveler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAVELER_FILE, true))) {
            String line = traveler.getTravelerID() + "|" + traveler.getFirstName() + "|" + traveler.getLastName();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieve Traveler
    public static Traveler getTraveler(String travelerID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(TRAVELER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens[0].equals(travelerID)) {
                    return new TravelPlanner(tokens[0], tokens[1], tokens[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Itinerary> getItinerariesByTravelerID(String travelerID) {
        List<Itinerary> itineraries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ITINERARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens[1].equals(travelerID)) {
                    // tokens[0]: itineraryID
                    // tokens[1]: travelerID
                    // tokens[2]: startDate
                    // tokens[3]: endDate
                    Itinerary itinerary = new Itinerary(tokens[0], tokens[1], tokens[2], tokens[3]);
                    itineraries.add(itinerary);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itineraries;
    }

    public static void updateTraveler(Traveler updatedTraveler) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRAVELER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens[0].equals(updatedTraveler.getTravelerID())) {
                    // Update line with new traveler info
                    line = updatedTraveler.getTravelerID() + "|" + updatedTraveler.getFirstName() + "|"
                            + updatedTraveler.getLastName();
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated data back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAVELER_FILE))) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save Itinerary
    public static void saveItinerary(Itinerary itinerary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ITINERARY_FILE, true))) {
            String line = itinerary.getItineraryID() + "|" + itinerary.getTravelerID() + "|" + itinerary.getStartDate()
                    + "|" + itinerary.getEndDate();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieve Itinerary
    public static Itinerary getItinerary(String itineraryID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ITINERARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens[0].equals(itineraryID)) {
                    return new Itinerary(tokens[0], tokens[1], tokens[2], tokens[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save Itinerary Detail
    public static void saveItineraryDetail(ItineraryDetail detail) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ITINERARY_DETAIL_FILE, true))) {
            String line = detail.getItineraryID() + "|" + detail.getActivityName() + "|" + detail.getStartTime() + "|"
                    + detail.getEndTime() + "|" + detail.getActivityCost();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieve Itinerary Details
    public static List<ItineraryDetail> getItineraryDetails(String itineraryID) {
        List<ItineraryDetail> details = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ITINERARY_DETAIL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens[0].equals(itineraryID)) {
                    double activityCost = Double.parseDouble(tokens[4]);
                    ItineraryDetail detail = new ItineraryDetail(tokens[0], tokens[1], tokens[2], tokens[3],
                            activityCost);
                    details.add(detail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return details;
    }
}
