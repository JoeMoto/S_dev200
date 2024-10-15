package ItineraryPlanner;

public abstract class Traveler {
    protected String travelerID;
    protected String firstName;
    protected String lastName;

    public Traveler(String travelerID, String firstName, String lastName) {
        this.travelerID = travelerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTravelerID() {
        return travelerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTravelerID(String travelerID) {
        this.travelerID = travelerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
