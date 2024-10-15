package ItineraryPlanner;

public class Itinerary {
    private String itineraryID;
    private String travelerID;
    private String startDate;
    private String endDate;

    public Itinerary(String itineraryID, String travelerID, String startDate, String endDate) {
        this.itineraryID = itineraryID;
        this.travelerID = travelerID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters

    public String getItineraryID() {
        return itineraryID;
    }

    public String getTravelerID() {
        return travelerID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setItineraryID(String itineraryID) {
        this.itineraryID = itineraryID;
    }

    public void setTravelerID(String travelerID) {
        this.travelerID = travelerID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
