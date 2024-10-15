package ItineraryPlanner;

public class TravelPlanner extends Traveler {

    public TravelPlanner(String travelerID, String firstName, String lastName) {
        super(travelerID, firstName, lastName);
    }

    public Itinerary createItinerary(String startDate, String endDate) {
        String itineraryID = "ITIN-" + System.currentTimeMillis();
        return new Itinerary(itineraryID, this.travelerID, startDate, endDate);
    }
}
